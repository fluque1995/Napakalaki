/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Clase principal del juego Napakalaki. Gestiona la ejecución del juego, manteniendo
 * la información relativa a los jugadores y al progreso del mismo.
 * @author Francisco Luque y Antonio Moya
 */
public class Napakalaki {

    ////////////////////////////////////////////////////////////////////////////
    //                                                                        //
    //                                Instance                                //
    //                                                                        //    
    ////////////////////////////////////////////////////////////////////////////
    
    private static Napakalaki instance = null;
    
    ////////////////////////////////////////////////////////////////////////////
    //                                                                        //
    //                               Attributes                               //
    //                                                                        //    
    ////////////////////////////////////////////////////////////////////////////
    
    private Monster currentMonster;
    private ArrayList<Player> players;
    private Player currentPlayer;
    private int currentPlayerIndex = -1;
    
    ////////////////////////////////////////////////////////////////////////////
    //                                                                        //
    //                     Constructor and instance getter                    //
    //                                                                        //    
    ////////////////////////////////////////////////////////////////////////////
    
    private Napakalaki(){}
    
    /**
     * Getter de la instancia del juego. Esta clase es una clase singleton, así
     * que no se permite la creación de objetos mediante el constructor. Se permite
     * la obtención de la instancia creada usando este método. Si la instancia no
     * existe, el método la crea y la devuelve, si no, devuelve la ya existente.
     * @return Instancia del juego
     */
    public static Napakalaki getInstance(){
        if (instance == null){
            instance = new Napakalaki();
        }
        
        return instance;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    //                                                                        //
    //                             Private methods                            //
    //                                                                        //    
    ////////////////////////////////////////////////////////////////////////////
    
    /**
     * Método que inicializa los jugadores a partir del array que contiene los 
     * nombres
     * @param names Array con los nombres de los jugadores
     */
    private void initPlayers(ArrayList<String> names){
        
        this.players = new ArrayList();
        for (String name: names){
            this.players.add(new Player(name));
        }
    }
    
    /**
     * Método que pasa el turno al siguiente jugador
     * @return El siguiente jugador
     */
    private Player nextPlayer(){
        if (this.currentPlayerIndex == -1){
            Random rnd = new Random();
            this.currentPlayerIndex = rnd.nextInt(this.players.size());
        } 
        else 
        {
            this.currentPlayerIndex = (this.currentPlayerIndex + 1) % this.players.size();
        }
        currentPlayer = this.players.get(this.currentPlayerIndex);
        
        return currentPlayer;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    //                                                                        //
    //                             Public methods                             //
    //                                                                        //    
    ////////////////////////////////////////////////////////////////////////////
    
    /**
     * Simula el combate entre el monstruo y el jugador actual. Obtiene el resultado
     * del combate dependiendo del estado del monstruo actual y el jugador actual,
     * de acuerdo con las reglas del juego
     * @return Resultado del combate
     */
    public CombatResult combat(){
        CombatResult result = this.currentPlayer.combat(currentMonster);
        CardDealer dealer = CardDealer.getInstance();
        if(result == CombatResult.LOSEANDCONVERT){
            Cultist c = dealer.nextCultist();
            CultistPlayer cultistPlayer = new CultistPlayer(this.currentPlayer, c);
            this.currentPlayer = cultistPlayer;
            this.players.set(currentPlayerIndex, currentPlayer);
        }
        return result;
    }
    
    /**
     * Hace que el jugador se descarte de un tesoro visible elegido por él.
     * @param treasure Tesoro del que se descarta
     */
    
    public void discardVisibleTreasure(Treasure treasure){
        this.currentPlayer.discardVisibleTreasure(treasure);
    }
    
    /**
     * Hace que el jugador se descarte de un tesoro oculto elegido por él.
     * @param treasure Tesoro del que se descarta
     */
    
    public void discardHiddenTreasure(Treasure treasure){
        this.currentPlayer.discardHiddenTreasure(treasure);
    }
    
    /**
     * Método que cambia un tesoro oculto en visible.
     * @param treasure Tesoro que se hace visible
     * @return Devuelve un booleano diciendo si es posible o no.
     * @see Player#makeTreasureVisible(Model.Treasure)  
     */
    
    public boolean makeTreasureVisible(Treasure treasure){
        boolean canI = this.canMakeVisibleTreasure(treasure);
        if(canI){
            this.currentPlayer.makeTreasureVisible(treasure);
        }
        return canI;
    }
    
    /**
     * Método que compra niveles dados a partir de ciertos elementos visible y ocultos dados.
     * @param visibleTreasures Tesoros visibles que pones en venta para comprar niveles
     * @param hiddenTreasures Tesoros ocultos que pones en venta para comprar niveles
     * @return Booleano que dice si es posible comprar niveles.
     * @see Player#buyLevels(java.util.ArrayList, java.util.ArrayList)   
     */
    
    public boolean buyLevels(ArrayList<Treasure> visibleTreasures, ArrayList<Treasure> hiddenTreasures){
        return currentPlayer.buyLevels(visibleTreasures, hiddenTreasures);
    }
    
    /**
     * Inicializa el juego. Establece los jugadores a partir de array de nombres
     * que se pasa como argumento, inicializa los mazos de cartas y decide los 
     * turnos de juego.
     * @param players Array de nombres de los jugadores que van a participar en
     * el juego.
     */
    public void initGame(ArrayList<String> players){
        CardDealer dealer = CardDealer.getInstance();
        dealer.initCards();
        this.initPlayers(players);
        this.nextTurn();
    }
    
    /**
     * Getter para el jugador que tiene el turno.
     * @return Objeto de la clase {@link Player} que representa al jugador en cuestión
     */
    public Player getCurrentPlayer(){
        return this.currentPlayer;
    }
    
    /**
     * Getter para el monstruo actual.
     * @return Objeto de la clase {@link Monster} que representa a dicho monstruo
     */
    public Monster getCurrentMonster(){
        return this.currentMonster;
    }
    
    /**
     * Método que indice si es posible hacer un tesoro visible
     * @param treasure Tesoro que se quiere hacer visible
     * @return Devuelve un booleano diciendo si es posible o no.
     * @see Player#canMakeTreasureVisible(Model.Treasure)   
     */
    
    public boolean canMakeVisibleTreasure(Treasure treasure){
        return this.currentPlayer.canMakeTreasureVisible(treasure);
    }
    
    /**
     * Getter de los tesoros visibles del jugador.
     * @return Devuelve los tesoros visibles del jugador
     */
   
    public ArrayList<Treasure> getVisibleTreasures(){
        return this.currentPlayer.getVisibleTreasures();
    }
    
    /**
     * Getter de los tesoros ocultos del jugador.
     * @return Devuelve los tesoros ocultos del jugador
     */
    
    public ArrayList<Treasure> getHiddenTreasures(){
        return this.currentPlayer.getHiddenTreasures();
    }
    
    /**
     * Método que pasa el turno de jugador, y pasa de monstruo.
     * @return Boolean diciendo si es posible pasar el turno.
     */
    
    public boolean nextTurn(){
        boolean siguiente = this.nextTurnAllowed();
        if(siguiente){
            CardDealer dealer = CardDealer.getInstance();
            this.nextPlayer();
            this.currentMonster = dealer.nextMonster();
            if(currentPlayer.isDead()){
                currentPlayer.initTreasures();
            }
            
        }
        
        return siguiente;
    }
    
    /**
     * Método que establece si el jugador que está jugando en ese momento tiene
     * permitido terminar su turno. Esto significa que esté en un estado válido
     * para terminar su turno. Utiliza como apoyo el método validState() de la 
     * clase {@link Player}
     * @return True si se puede terminar el turno y false en caso contrario
     * @see Player#validState() 
     */
    public boolean nextTurnAllowed(){
        return this.currentPlayer == null || this.currentPlayer.validState();
    }
    
    /**
     * Método que establece si se termina el juego, de acuerdo con el resultado
     * del último combate. Dirá si con el resultado del último combate el jugador
     * actual gana el juego, de acuerdo con las reglas del juego
     * @param result Resultado del último combate, que determinará si el juego 
     * termina
     * @return True si termina el juego, false en caso contrario 
     */
    public boolean endOfGame(CombatResult result){
        return result == CombatResult.WINANDWINGAME;
    }
    
}