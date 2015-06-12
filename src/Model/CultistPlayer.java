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
     * @return 
     */
    @Override
    protected boolean shouldConvert(){
        return false;
    }
    
    /**
     * Método que devuelve el nivel de combate del monstruo que se pasa como 
     * argumento. Este método es necesario
     * @param m
     * @return 
     */
    @Override
    public int getOponentLevel(Monster m){
        return m.getSpecialValue();
    }
    
    public static int getTotalCultistPlayers(){
        return totalCultistPlayers;
    }
    
    @Override
    protected float computeGoldCoinsValue(ArrayList<Treasure> treasure){
        return 2*super.computeGoldCoinsValue(treasure);
    }
    
    @Override
    public String toString(){
        String printable = "Nombre: " + this.getName() + "\nEres un cultist player; Info:\n ; Nivel " + Integer.toString(this.getLevel()) + 
                "; CombatLevel: " + Integer.toString(this.getCombatLevel());
        
        /*if(this.pendingBadConsequence.isEmpty() == false && this.pendingBadConsequence != null){
            printable += pendingBadConsequence.toString();
        }*/
        
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
    
    public int getBonusLevel(){
        return this.myCultistCard.getBasicValue();
    }
    
    public boolean isCultist(){
        return true;
    }
    
}
