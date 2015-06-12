/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 * Clase que representa al jugador sectario del juego. Cada instancia de esta 
 * clase representa a un jugador de tipo sectario. Los jugadores se convierten
 * en jugadores sectarios si, tras pelearse contra un monstruo, pierden el combate,
 * les toca cumplir el mal rollo, y sacan un 6 en la siguiente tirada del dado.
 * Convertirse en sectarios les produce una mejora de su nivel, así como un 
 * cambio en el nivel del monstruo contra el que se pelean.
 * @author antonio
 */
public class CultistPlayer extends Player {
    private static int totalCultistPlayers = 0;
    private Cultist myCultistCard;
    
    /**
     * Constructor por parámetros de jugador sectario
     * @param p Jugador que se convierte en sectario
     * @param c Carta de sectario que se asocia al jugador
     */
    public CultistPlayer(Player p, Cultist c){
        super(p);
        this.myCultistCard = c;
        totalCultistPlayers = this.getTotalCultistPlayers();
        totalCultistPlayers++;
    }
    
    /**
     * Nivel de combate del jugador sectario. Este nivel se calcula con el nivel
     * de combate del jugador más el valor especial de la carta de sectario 
     * asociada a este jugador.
     * @return Nivel de combate del jugador sectario
     */
    @Override
    public int getCombatLevel(){
        return super.getCombatLevel() + this.myCultistCard.getSpecialValue();
    }
    
    /**
     * Método que devuelve si dicho jugador debe convertirse en sectario. Devuelve
     * siempre false, ya que como el jugador ya es secatrio no puede volver a 
     * convertirse
     * @return false, ya que el jugador no puede convertirse de nuevo en sectario
     */
    @Override
    protected boolean shouldConvert(){
        return false;
    }
    
    /**
     * Método que devuelve el nivel de combate del monstruo que se pasa como 
     * argumento. Este método es necesario ya que el nivel de combate del monstruo
     * varía cuando combate contra un sectario
     * @param m Monstruo al que se le quiere calcular el nivel
     * @return Nivel de combate del monstruo
     */
    @Override
    public int getOponentLevel(Monster m){
        return m.getSpecialValue();
    }
    
    /**
     * Método que devuelve el número total de jugadores de tipo sectario que hay
     * en el momento en la partida.
     * @return Dicho número
     */
    public static int getTotalCultistPlayers(){
        return totalCultistPlayers;
    }
    
    /**
     * Método que calcula el número de niveles que se pueden comprar dada una 
     * determinada lista de tesoros. Sobrescribe al método de la clase {@link Player},
     * ya que para los jugadores sectarios, los niveles cuestan 500 monedas en 
     * vez de las 1000 que les cuestan a los jugadores normales.
     * @param treasures Lista de tesoros con la que se quieren comprar los niveles
     * @return Número de niveles que se pueden comprar
     */
    @Override
    protected float computeGoldCoinsValue(ArrayList<Treasure> treasures){
        return 2*super.computeGoldCoinsValue(treasures);
    }
    
    /**
     * Método que devuelve en un string toda la información relativa al jugador
     * sectario. Dicho String contiene el nombre del jugador, su nivel, el nivel
     * de combate, los tesoros que el jugador lleva equipados y el mal rollo 
     * pendiente que tiene por cumplir
     * @return String con la información especificada
     */
    @Override
    public String toString(){
        String printable = "Nombre: " + this.getName() + "\nEres un cultist player; Info:\n ; Nivel " + Integer.toString(this.getLevel()) + 
                "; CombatLevel: " + Integer.toString(this.getCombatLevel());
        
        if(this.getVisibleTreasures().isEmpty() == false){
            printable += "\nTesoros visibles:\n\t\t ";
            for(Treasure t: this.getVisibleTreasures()){
                printable += t.toString();
            }
        }
        
        if(this.getHiddenTreasures().isEmpty() == false){
            printable += "\nTesoros ocultos:\n\t\t ";
            for(Treasure t: this.getHiddenTreasures()){
                printable += t.toString();
            }
        }
        
        if(this.getPendingBadConsequence() == null || this.getPendingBadConsequence().isEmpty()){
            printable += "\n No tienes mal rollo pendiente ";
        }
        else{
            printable += "\n Mal rollo: " + this.getPendingBadConsequence().toString();
        }
        
        return printable;
                
    }
    
    /**
     * Método que devuelve el valor de bonus que recibe el jugador por ser sectario.
     * Este valor se extrae a partir del valor básico de la carta de sectario que
     * el jugador tiene asociado
     * @return Valor básico de dicha carta
     */
    public int getBonusLevel(){
        return this.myCultistCard.getBasicValue();
    }
    
    /**
     * Método que comprueba si el jugador es sectario
     * @return True, ya que el jugador ya lo es
     */
    public boolean isCultist(){
        return true;
    }
    
}
