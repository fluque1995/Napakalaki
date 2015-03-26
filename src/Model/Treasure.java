/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author paco
 */
public class Treasure {
    
    String name;
    int goldCoins;
    int minBonus;
    int maxBonus;
    TreasureKind type;
    
    Treasure(String name, int goldCoins, int maxBonus, int minBonus, TreasureKind type){
        this.name = name;
        this.goldCoins = goldCoins;
        this.minBonus = minBonus;
        this.maxBonus = maxBonus;
        this.type = type;
    }
    
    String getName(){
        return this.name;
    }
    
    int getGoldCoins(){
        return this.goldCoins;
    }
    
    int getMinBonus(){
        return this.minBonus;
    }
    
    int getMaxBonus(){
        return this.maxBonus;
    }
    
    TreasureKind getType(){
        return this.type;
    }
}
