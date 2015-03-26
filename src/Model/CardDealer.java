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
public class CardDealer {
    
    private static CardDealer instance = null;
    ArrayList<Treasure> unusedTreasures, usedTreasures;
    ArrayList<Monster> unusedMonsters, usedMonsters;
    
    private CardDealer(){}
    
    void shuffleTreasures(){
        
    }
    
    void shuffleMonsters(){
        
    }
    
    CardDealer getInstance(){
        if(instance == null){
            instance = new CardDealer();
        }
        return instance;
    }
    
    Treasure nextTreasure(){
        
    }
    
    Monster nextMonster(){
        
    }
    
    void giveTreasureBack(Treasure treasure){
        
    }
    
    void giveMonsterBack(Monster monster){
        
    }
    
    void initCards(){
        
    }
    
    void initTreasureCardDeck(){
        
    }
    
    void initMonsterCardDeck(){
        
        /**
         * Initialization of monsters array
         */
        
        ArrayList<Monster> monsters = new ArrayList();
        
        Prize prize = new Prize(2,1);      
        BadConsequence badConsequence = new BadConsequence("Pierdes tu armadura visible y otra oculta",
                        0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                        new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        monsters.add(new Monster("3 Byakhees de bonanza", 8, prize, badConsequence));

        prize = new Prize(1,1);
        badConsequence = new BadConsequence("Embobados con el lindo primigenio, "
                        + "te descartas de tu casco visible", 0,
                        new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        monsters.add(new Monster("Chibithulhu", 2, prize, badConsequence));
        
        prize = new Prize(1,1);
        badConsequence = new BadConsequence("El primordial bostezo contagioso. "
                        + "Pierdes el calzado visible", 0, 
                        new ArrayList(Arrays.asList(TreasureKind.SHOE)), new ArrayList());
        monsters.add(new Monster("El sopor de Dunwich", 2, prize, badConsequence));
        
        prize = new Prize(4,1);
        badConsequence = new BadConsequence("Te atrapan para llevarte de fiesta y "
                        + "te dejan caer en mitad del vuelo. Descarta una mano visible y "
                        + "1 mano oculta", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                        new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        monsters.add(new Monster("Ángeles de la noche ibicenca", 14, prize, badConsequence));
        
        prize = new Prize(3,1);
        badConsequence = new BadConsequence("Pierdes todos tus tesoros visibles",
                        0, 5, 0);
        monsters.add(new Monster("El gorrón en el umbral", 10, prize, badConsequence));
        
        prize = new Prize(2,1);
        badConsequence = new BadConsequence("Pierdes la armadura visible", 0, 
                        new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                        new ArrayList());
        monsters.add(new Monster("H.P. Munchcraft", 6, prize, badConsequence));
        
        prize = new Prize(1,1);
        badConsequence = new BadConsequence("Sientes bichos bajo la ropa. "
                        + "Descarta la armadura visible", 0, 
                        new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                        new ArrayList());
        monsters.add(new Monster("Bichgooth", 2, prize, badConsequence));
        
        prize = new Prize(4,2);
        badConsequence = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles",
                        5, 3, 0);
        monsters.add(new Monster("El rey de rosa", 13, prize, badConsequence));
        
        prize = new Prize(1,1);
        badConsequence = new BadConsequence("Toses los pulmones y pierdes 2 niveles",
                        2, 0, 0);
        monsters.add(new Monster("La que redacta en las tinieblas", 2, prize, badConsequence));
        
        prize = new Prize(2,1);
        badConsequence = new BadConsequence("Estos mostruos resultan bastante "
                        + "superficiales y te aburren mortalmente. Estas muerto", true);
        monsters.add(new Monster("Los hondos", 8, prize, badConsequence));
        
        prize = new Prize(2,1);
        badConsequence = new BadConsequence("Pierdes dos niveles y dos tesoros "
                        + "ocultos.", 2, 0, 2);
        monsters.add(new Monster("Semillas Cthulhu", 4, prize, badConsequence));
        
        prize = new Prize(2,1);
        badConsequence = new BadConsequence("Te intentas escaquear. Pierdes una"
                        + " mano visible", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                        new ArrayList());
        monsters.add(new Monster("Dameargo", 1, prize, badConsequence));
        
        prize = new Prize(1,1);
        badConsequence = new BadConsequence("Da mucho asquito. Pierdes 3 niveles",
                        3, 0, 0);
        monsters.add(new Monster("Pollipólipo volante", 3, prize, badConsequence));
        
        prize = new Prize(3,1);
        badConsequence = new BadConsequence("No le hace gracia que pronuncien mal "
                        + "su nombre. Estás muerto", true);
        monsters.add(new Monster("Yskhtihyssg-Goth", 12, prize, badConsequence));
        
        prize = new Prize(4,1);
        badConsequence = new BadConsequence("La familia te atrapa. Estás muerto", true);
        monsters.add(new Monster("Familia feliz", 1, prize, badConsequence));
        
        prize = new Prize(2,1);
        badConsequence = new BadConsequence("La quinta directiva primaria te obliga"
                        + " a perder dos niveles y un tesoro de dos manos visible", 
                        2, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)),
                        new ArrayList());
        monsters.add(new Monster("Roboggoth", 8, prize, badConsequence));
        
        prize = new Prize(1,1);
        badConsequence = new BadConsequence("Te asusta en la noche. Pierdes un"
                        + " casco visible", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)),
                        new ArrayList());
        monsters.add(new Monster("El espia", 5, prize, badConsequence));
        
        prize = new Prize(1,1);
        badConsequence = new BadConsequence("Menudo susto te llevas. Pierdes 2"
                        + " niveles y 5 tesoros visibles", 2, 5, 0);
        monsters.add(new Monster("El lenguas", 20, prize, badConsequence));
        
        badConsequence = new BadConsequence("Te faltan manos para tanta cabeza. "
                        + "Pierdes 3 niveles y tus tesoros visibles de las manos",
                        3, new ArrayList(Arrays.asList(TreasureKind.ONEHAND, TreasureKind.BOTHHANDS)),
                        new ArrayList());
        prize = new Prize(1,1);
        monsters.add(new Monster("Bicéfalo", 20, prize, badConsequence));
    }
}
