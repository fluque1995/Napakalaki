/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author paco
 */
public class Test {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ////////////////////////////////////////////////////////////////////////
       Prize prize = new Prize(2,1);      
       BadConsequence badConsequence = new BadConsequence("Pierdes tu armadura visible y otra oculta",
                        0, 0, 0);
       
       
       Treasure t = new Treasure("¡Sí mi amo!", 0, 4, 7, TreasureKind.ARMOR);
       
       System.out.println(badConsequence.toString());
       
       badConsequence.substractVisibleTreasure(t);
       
       System.out.println(badConsequence.toString());
    }
    
}
