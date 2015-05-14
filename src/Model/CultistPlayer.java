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
    
}
