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
    
    private void initPlayers(ArrayList<String> names){
        
        this.players = new ArrayList();
        for (String name: names){
            this.players.add(new Player(name));
        }
    }
    
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
        
    }
    
    public void discardVisibleTreasure(Treasure treasure){
        
    }
    
    public void discardHiddenTreasures(Treasure treasure){
        
    }
    
    public boolean makeTreasureVisible(Treasure treasure){
        
    }
    
    public boolean buyLevels(ArrayList<Treasure> visibleTreasures, ArrayList<Treasure> hiddenTreasures){
        
    }
    
    /**
     * Inicializa el juego. Establece los jugadores a partir de array de nombres
     * que se pasa como argumento, inicializa los mazos de cartas y decide los 
     * turnos de juego.
     * @param players Array de nombres de los jugadores que van a participar en
     * el juego.
     */
    public void initGame(ArrayList<String> players){
        
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
    
    public boolean canMakeVisibleTreasure(Treasure treasure){
        
    }
    
    public ArrayList<Treasure> getVisibleTreasures(){
        
    }
    
    public ArrayList<Treasure> getHiddenTreasures(){
        
    }
    
    public boolean nextTurn(){
        
    }
    
    /**
     * Método que establece si el jugador que está jugando en ese momento tiene
     * permitido terminar su turno. Esto significa que esté en un estado válido
     * para terminar su turno. Utiliza como apoyo el método validState() de la 
     * clase {@link Player}
     * @return True si se puede terminar el turno y false en caso contrario
     * @see Player#validState() 
     */
    public boolean newtTurnAllowed(){
        return this.currentPlayer.validState();
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