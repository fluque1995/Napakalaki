/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author paco
 */
public class Napakalaki {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<TreasureKind> visibleTreasures = 
                new ArrayList<>();
        
        visibleTreasures.add(TreasureKind.ARMOR);
        visibleTreasures.add(TreasureKind.HELMET);
        
        ArrayList<TreasureKind> hiddenTreasures = 
                new ArrayList<>();
        
        hiddenTreasures.add(TreasureKind.ONEHAND);
        hiddenTreasures.add(TreasureKind.BOTHHANDS);
        
        Prize prize = new Prize(2, 1);
        
        
        BadConsequence badConsequence = 
                new BadConsequence("Ta foshao hermano", 2, visibleTreasures, hiddenTreasures);
        
        Monster daMonsta = new Monster("Papichulo", 10, prize, badConsequence);
        
        System.out.println(daMonsta.toString());
    }
    
}
