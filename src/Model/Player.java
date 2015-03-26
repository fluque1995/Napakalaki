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
        
    }
    
    void incrementLevels(int levels){
        this.level += levels;
    }
    
    void decrementLevels(int levels){
        this.level -= levels;
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
        
    }
    
    boolean canIBuyLevels(int levels){
        
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
        
    }
    
    boolean initTreasures(){
        
    }
    
    boolean isDead(){
        return this.dead;
    }
    
    boolean hasVisibleTreasures(){
        
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
