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

    boolean dead;
    String name;
    int level;
    
    static final int MAXHIDDENTREASURES = 4;
    
    ArrayList<Treasure> hiddenTreasures;
    ArrayList<Treasure> visibleTreasures;
    BadConsequence pendingBadConsequence;

    void bringToLive(){
        this.dead = false;
    }
    
    void incrementLevels(int levels){
        this.level += levels;
        if (this.level > 10){
            this.level = 10;
        }
    }
    
    void decrementLevels(int levels){
        this.level -= levels;
        if (this.level < 1){
            this.level = 1;
        }
    }
    
    void setPendingBadConsequence(BadConsequence badConsequence){
        this.pendingBadConsequence = badConsequence;
    }
    
    void die(){
        this.dead = true;
    }
    
    void discardNecklaceIfVisible(){
        
    }
    
    void dieIfNoTreasures(){
        if(this.hiddenTreasures.isEmpty() && this.visibleTreasures.isEmpty()){
            this.dead = true;
        }
    }
    
    boolean canIBuyLevels(int levels){
        return (this.level + levels < 10);
    }
    
    protected float computeGoldCoinsValue(ArrayList<Treasure> treasures){
        
    }
    
    void applyPrize(Prize prize){
        
    }
    
    CombatResult combat(Monster monster){
        
    }
    
    void applyBadConsequence(BadConsequence badConsequence){
        
    }
    
    boolean makeVisibleTreasure(Treasure treasure){
        
    }
    
    boolean canMakeTreasureVisible(Treasure treasure){
        
    }
    
    void DiscardVisibleTreasure(Treasure treasure){
        
    }
    
    void DiscardHiddenTreasure(Treasure treasure){
        
    }
    
    boolean buyLevels(ArrayList<Treasure> hiddenTreasures, ArrayList<Treasure> visibleTreasures){
        
    }
    
    int getCombatLevel(){
        
    }
    
    boolean validState(){
        return this.pendingBadConsequence == null &&
                this.hiddenTreasures.size() <= MAXHIDDENTREASURES;
    }
    
    boolean initTreasures(){
        
    }
    
    boolean isDead(){
        return this.dead;
    }
    
    boolean hasVisibleTreasures(){
        return not this.visibleTreasures.isEmpty();
    }
    
    Player(String name){
        this.name = name;
    }
    
    ArrayList<Treasure> getVisibleTreasures(){
        return this.visibleTreasures;
    }
    
    ArrayList<Treasure> getHiddenTreasures(){
        return this.hiddenTreasures;
    }
}
