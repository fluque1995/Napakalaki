/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author paco
 */
public class Napakalaki {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /**
         * Creación del array de monstruos
         */
        
        ArrayList<Monster> monstruos = new ArrayList();
        
        BadConsequence badConsequence = new BadConsequence("Pierdes tu armadura visible y otra oculta",
                        0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                        new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        Prize prize = new Prize(2,1);
        monstruos.add(new Monster("3 Byakhees de bonanza", 8, prize, badConsequence));

        badConsequence = new BadConsequence("Embobados con el lindo primigenio, "
                + "te descartas de tu casco visible", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)),
                        new ArrayList());
        prize = new Prize(1,1);
        monstruos.add(new Monster("Chibithulhu", 2, prize, badConsequence));
        
        
        /**
        ArrayList<TreasureKind> visibleTreasures = 
                new ArrayList();
        
        visibleTreasures.add(TreasureKind.ARMOR);
        visibleTreasures.add(TreasureKind.HELMET);
        
        ArrayList<TreasureKind> hiddenTreasures = 
                new ArrayList();
        
        hiddenTreasures.add(TreasureKind.ONEHAND);
        hiddenTreasures.add(TreasureKind.BOTHHANDS);
        
        Prize prize = new Prize(2, 1);
        
        
        BadConsequence badConsequence = 
                new BadConsequence("Ta foshao hermano", 2, visibleTreasures, hiddenTreasures);
        
        Monster daMonsta = new Monster("Papichulo", 10, prize, badConsequence);
        
        System.out.println(daMonsta.toString());
    */
    }
    
}
