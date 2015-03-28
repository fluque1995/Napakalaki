/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author paco
 */
public class Player {

    private boolean dead;
    private String name;
    private int level;
    
    private static final int MAXHIDDENTREASURES = 4;
    
    private ArrayList<Treasure> hiddenTreasures;
    private ArrayList<Treasure> visibleTreasures;
    private BadConsequence pendingBadConsequence;

    private void bringToLive(){
        this.dead = false;
    }
    
    private void incrementLevels(int levels){
        this.level += levels;
        if (this.level > 10){
            this.level = 10;
        }
    }
    
    private void decrementLevels(int levels){
        this.level -= levels;
        if (this.level < 1){
            this.level = 1;
        }
    }
    
    private void setPendingBadConsequence(BadConsequence badConsequence){
        this.pendingBadConsequence = badConsequence;
    }
    
    private void die(){
        this.dead = true;
    }
    
    private void discardNecklaceIfVisible(){
        
    }
    
    private void dieIfNoTreasures(){
        if(this.hiddenTreasures.isEmpty() && this.visibleTreasures.isEmpty()){
            this.dead = true;
        }
    }
    
    private boolean canIBuyLevels(int levels){
        return (this.level + levels < 10);
    }
    
    protected float computeGoldCoinsValue(ArrayList<Treasure> treasures){
        
    }
    
    public void applyPrize(Prize prize){
        
    }
    
    public CombatResult combat(Monster monster){
        
    }
    
    public void applyBadConsequence(BadConsequence badConsequence){
        
    }
    
    public boolean makeVisibleTreasure(Treasure treasure){
        
    }
    
    public boolean canMakeTreasureVisible(Treasure treasure){
        
    }
    
    public void DiscardVisibleTreasure(Treasure treasure){
        
    }
    
    public void DiscardHiddenTreasure(Treasure treasure){
        
    }
    
    public boolean buyLevels(ArrayList<Treasure> hiddenTreasures, ArrayList<Treasure> visibleTreasures){
        
    }
    
    public int getCombatLevel(){
        
    }
    
    public boolean validState(){
        return this.pendingBadConsequence == null &&
                this.hiddenTreasures.size() <= MAXHIDDENTREASURES;
    }
    
    public boolean initTreasures(){
        
    }
    
    public boolean isDead(){
        return this.dead;
    }
    
    public boolean hasVisibleTreasures(){
        return !this.visibleTreasures.isEmpty();
    }
    
    public Player(String name){
        this.name = name;
        this.level = 1;
        this.dead = true;
    }
    
    public ArrayList<Treasure> getVisibleTreasures(){
        return this.visibleTreasures;
    }
    
    public ArrayList<Treasure> getHiddenTreasures(){
        return this.hiddenTreasures;
    }
}
