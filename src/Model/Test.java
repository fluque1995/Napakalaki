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
       BadConsequence badConsequence = new BadConsequence("Pierdes tu armadura visible y otra oculta",
                        0, new ArrayList(Arrays.asList(TreasureKind.ARMOR, TreasureKind.ARMOR, TreasureKind.ARMOR)),
                        new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
      
       
      ArrayList<Treasure> unusedTreasures = new ArrayList();
      ArrayList<Treasure> usedTreasures = new ArrayList();
      
      unusedTreasures.add(new Treasure("¡Sí mi amo!", 0, 4, 7, TreasureKind.HELMET));
      unusedTreasures.add(new Treasure("Botas de investigación", 600, 3, 4, TreasureKind.SHOE));
      unusedTreasures.add(new Treasure("Capucha de Cthulhu", 500, 3, 5, TreasureKind.HELMET));   
      unusedTreasures.add(new Treasure("A prueba de babas", 400, 2, 5, TreasureKind.ARMOR));   
      unusedTreasures.add(new Treasure("Botas de lluvia ácida", 800, 1, 1, TreasureKind.SHOE));   
      unusedTreasures.add(new Treasure("Casco minero", 400, 2, 4, TreasureKind.HELMET));   
      unusedTreasures.add(new Treasure("Ametralladora Thompson", 600, 4, 8, TreasureKind.BOTHHANDS));   
      unusedTreasures.add(new Treasure("Camiseta de la UGR", 100, 1, 7, TreasureKind.ARMOR));   
      
      
      usedTreasures.add(new Treasure("¡Sí mi amo!", 0, 4, 7, TreasureKind.HELMET));
      usedTreasures.add(new Treasure("Botas de investigación", 600, 3, 4, TreasureKind.SHOE));
      
      
       System.out.println(badConsequence.toString());
       
       badConsequence = badConsequence.adjustToFitTreasureLists(unusedTreasures, usedTreasures);
       
       System.out.println(badConsequence.toString());
    }
    
}
