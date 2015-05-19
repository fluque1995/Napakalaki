/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author antonio
 */
public class CultistPlayer extends Player {
    private static int totalCultistPlayers = 0;
    private Cultist myCultistCard;
    
    
    public CultistPlayer(Player p, Cultist c){
        super(p);
        this.myCultistCard = c;
        totalCultistPlayers = this.getTotalCultistPlayers();
        totalCultistPlayers++;
    }
    
    @Override
    public int getCombatLevel(){
        return super.getCombatLevel() + this.myCultistCard.getSpecialValue();
    }
    
    @Override
    protected boolean shouldConvert(){
        return false;
    }
    
    @Override
    protected int getOponentLevel(Monster m){
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
        String printable = "Nombre: " + this.getName() + "Soy un cultist player; Info:\n ; Nivel " + Integer.toString(this.getLevel()) + 
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
    
}
