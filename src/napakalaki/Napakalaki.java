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
         * Initialization of monsters array
         */
        
        ArrayList<Monster> monsters = new ArrayList();
        
        BadConsequence badConsequence = new BadConsequence("Pierdes tu armadura visible y otra oculta",
                        0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                        new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        Prize prize = new Prize(2,1);
        monsters.add(new Monster("3 Byakhees de bonanza", 8, prize, badConsequence));

        badConsequence = new BadConsequence("Embobados con el lindo primigenio, "
                        + "te descartas de tu casco visible", 0,
                        new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        prize = new Prize(1,1);
        monsters.add(new Monster("Chibithulhu", 2, prize, badConsequence));
        
        badConsequence = new BadConsequence("El primordial bostezo contagioso. "
                        + "Pierdes el calzado visible", 0, 
                        new ArrayList(Arrays.asList(TreasureKind.SHOE)), new ArrayList());
        prize = new Prize(1,1);
        monsters.add(new Monster("El sopor de Dunwich", 2, prize, badConsequence));
        
        badConsequence = new BadConsequence("Te atrapan para llevarte de fiesta y "
                        + "te dejan caer en mitad del vuelo. Descarta una mano visible y "
                        + "1 mano oculta", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                        new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(4,1);
        monsters.add(new Monster("Ángeles de la noche ibicenca", 14, prize, badConsequence));
        
        badConsequence = new BadConsequence("Pierdes todos tus tesoros visibles",
                        0, 5, 0);
        prize = new Prize(3,1);
        monsters.add(new Monster("El gorrón en el umbral", 10, prize, badConsequence));
        
        badConsequence = new BadConsequence("Pierdes la armadura visible", 0, 
                        new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                        new ArrayList());
        prize = new Prize(2,1);
        monsters.add(new Monster("H.P. Munchcraft", 6, prize, badConsequence));
        
        badConsequence = new BadConsequence("Sientes bichos bajo la ropa. "
                        + "Descarta la armadura visible", 0, 
                        new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                        new ArrayList());
        prize = new Prize(1,1);
        monsters.add(new Monster("Bichgooth", 2, prize, badConsequence));
        
        badConsequence = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles",
                        5, 3, 0);
        prize = new Prize(4,2);
        monsters.add(new Monster("El rey de rosa", 13, prize, badConsequence));
        
        badConsequence = new BadConsequence("Toses los pulmones y pierdes 2 niveles",
                        2, 0, 0);
        prize = new Prize(1,1);
        monsters.add(new Monster("La que redacta en las tinieblas", 2, prize, badConsequence));
        
        badConsequence = new BadConsequence("Estos mostruos resultan bastante "
                        + "superficiales y te aburren mortalmente. Estas muerto", true);
        prize = new Prize(2,1);
        monsters.add(new Monster("Los hondos", 8, prize, badConsequence));
        
        badConsequence = new BadConsequence("Pierdes dos niveles y dos tesoros "
                        + "ocultos.", 2, 0, 2);
        prize = new Prize(2,1);
        monsters.add(new Monster("Semillas Cthulhu", 4, prize, badConsequence));
        
        badConsequence = new BadConsequence("Te intentas escaquear. Pierdes una"
                        + " mano visible", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                        new ArrayList());
        prize = new Prize(2,1);
        monsters.add(new Monster("Dameargo", 1, prize, badConsequence));
        
        badConsequence = new BadConsequence("Da mucho asquito. Pierdes 3 niveles",
                        3, 0, 0);
        prize = new Prize(1,1);
        monsters.add(new Monster("Pollipólipo volante", 3, prize, badConsequence));
        
        badConsequence = new BadConsequence("No le hace gracia que pronuncien mal "
                        + "su nombre. Estás muerto", true);
        prize = new Prize(3,1);
        monsters.add(new Monster("Yskhtihyssg-Goth", 12, prize, badConsequence));
        
        badConsequence = new BadConsequence("La familia te atrapa. Estás muerto", true);
        prize = new Prize(4,1);
        monsters.add(new Monster("Familia feliz", 1, prize, badConsequence));
        
        badConsequence = new BadConsequence("La quinta directiva primaria te obliga"
                        + " a perder dos niveles y un tesoro de dos manos visible", 
                        2, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)),
                        new ArrayList());
        prize = new Prize(2,1);
        monsters.add(new Monster("Roboggoth", 8, prize, badConsequence));
        
        badConsequence = new BadConsequence("Te asusta en la noche. Pierdes un"
                        + " casco visible", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)),
                        new ArrayList());
        prize = new Prize(1,1);
        monsters.add(new Monster("El espia", 5, prize, badConsequence));
        
        badConsequence = new BadConsequence("Menudo susto te llevas. Pierdes 2"
                        + " niveles y 5 tesoros visibles", 2, 5, 0);
        prize = new Prize(1,1);
        monsters.add(new Monster("El lenguas", 20, prize, badConsequence));
        
        badConsequence = new BadConsequence("Te faltan manos para tanta cabeza. "
                        + "Pierdes 3 niveles y tus tesoros visibles de las manos",
                        0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND, TreasureKind.BOTHHANDS)),
                        new ArrayList());
        prize = new Prize(1,1);
        monsters.add(new Monster("Bicéfalo", 20, prize, badConsequence));
        
        /*
        * Creating consults for some parameters.
        */
        
        System.out.println("Monstruos con nivel mayor que 10");
        for (Monster m : monsters){
            if (m.getCombatLevel() > 10){
               System.out.println(m.toString());
            }
        }
        
        System.out.println("Monstruos cuyo mal rollo implica sólo pérdida de niveles");
        for (Monster m: monsters){
            if (m.getBadConsequence().getNVisibleTreasures() == 0 && m.getBadConsequence().getNHiddenTreasures() == 0){
                System.out.println(m.toString());
            }
        }
        
        System.out.println("Monstruos que te aumentan más de un nivel");
        for (Monster m: monsters){
            if (m.getPrize().getLevels() > 1){
                System.out.println(m.toString());
            }
        }
        
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
