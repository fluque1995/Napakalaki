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
public class Test {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ////////////////////////////////////////////////////////////////////////
        //                         Testing card dealer                        //
        ////////////////////////////////////////////////////////////////////////
        
        System.out.println("Inicializando el mazo de cartas...");
        
        CardDealer cardDealer = CardDealer.getInstance();
        
        System.out.println("Cartas en el mazo de cartas de monstruos:\n");

        cardDealer.printMonsters();
        
        System.out.println("\nCartas en el mazo de cartas de tesoros:\n");
        
        cardDealer.printTreasures();

        ////////////////////////////////////////////////////////////////////////
        //                            Testing dice                            //
        ////////////////////////////////////////////////////////////////////////
        
        System.out.println("Cinco tiradas del dado:");
        
        Dice dice = Dice.getInstance();
        for (int i = 0; i < 5; ++i){
            System.out.println(dice.nextNumber());
        }
        
    }
    
}
