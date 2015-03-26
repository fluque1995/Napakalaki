/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Random;

/**
 *
 * @author paco
 */
public class Dice {
    
    private static Dice instance = null;
    Random rnd;
    
    private Dice(){
        rnd = new Random();
    }
    
    public static Dice getInstance() {
        if(instance == null){
            instance = new Dice();
        }
        return instance;
    }
    
    int nextNumber(){
        return rnd.nextInt(6) + 1;
    }
}
