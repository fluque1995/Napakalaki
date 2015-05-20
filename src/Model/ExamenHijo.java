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
 * @author antonio
 */
public class ExamenHijo extends ExamenPadre {
    @Override
    public void run(){
        Cultist c = new Cultist("Sectario", 3);
        Player p1 = new Player("moya");
        ArrayList<Treasure> visible = new ArrayList();
        ArrayList<Treasure> hidden = new ArrayList();
        visible.add(new Treasure("¡Sí mi amo!", 0, 4, 7, TreasureKind.HELMET));
        visible.add(new Treasure("Botas de investigación", 600, 3, 4, TreasureKind.SHOE));
        visible.add(new Treasure("Capucha de Cthulhu", 500, 3, 5, TreasureKind.ONEHAND));
        hidden.add(new Treasure("¡Sí mi amo!", 0, 4, 7, TreasureKind.HELMET));
        hidden.add(new Treasure("Botas de investigación", 600, 3, 4, TreasureKind.SHOE));
        hidden.add(new Treasure("Capucha de Cthulhu", 500, 3, 5, TreasureKind.HELMET));
        p1.setVisibleTreasures(visible);
        p1.setHiddenTreasures(hidden);
        //System.out.println(p1.toString());
        Player p2 = new CultistPlayer(p1,c);        
        System.out.println(p2.toString());
        
        BadConsequence badConsequence = new SpecificBadConsequence("Pierdes una mano visible",
                        0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND, TreasureKind.NECKLACE)),
                        new ArrayList());
        Prize prize = new Prize(3,1);
        Monster monstruo = new Monster("El mal indecible", 10, -2, badConsequence, prize);
        System.out.println(monstruo.toString());
        
        /*ArrayList<Treasure> t = (ArrayList<Treasure>)hidden.clone();
        p2.buyLevels(new ArrayList(), t);
        System.out.println(p2.toString());
        */
        int nivel = p2.getOponentLevel(monstruo);
        String numero = Integer.toString(nivel);
        System.out.println(numero);
        
        BadConsequence badConsequence1 = new NumberBadConsequence("Pierdes tus tesoros visibles jajaja", 0, 5, 0);
        BadConsequence badConsequence2 = new KillingBadConsequence("Hoy no es tu día de suerte. Mueres.");
        System.out.println(badConsequence.toString());
        System.out.println(badConsequence1.toString());
        System.out.println(badConsequence2.toString());
        
        ArrayList<Treasure> t1 = (ArrayList<Treasure>)hidden.clone();
        ArrayList<Treasure> t2 = (ArrayList<Treasure>)visible.clone();
        
        badConsequence.substractHiddenTreasure(t1.get(2));
        badConsequence.substractVisibleTreasure(t2.get(2));
        badConsequence1.substractHiddenTreasure(t1.get(2));
        badConsequence1.substractVisibleTreasure(t2.get(1));
        badConsequence2.substractHiddenTreasure(t1.get(2));
        badConsequence2.substractVisibleTreasure(t2.get(1));
        System.out.println(badConsequence.toString());
        System.out.println(badConsequence1.toString());
        System.out.println(badConsequence2.toString());
        
        BadConsequence hola = badConsequence.adjustToFitTreasureLists(t2, t1);
        BadConsequence hola2 = badConsequence1.adjustToFitTreasureLists(t2, t1);
        BadConsequence hola3 = badConsequence2.adjustToFitTreasureLists(t2, t1);
        System.out.println(hola.toString());
        System.out.println(hola2.toString());
        System.out.println(hola3.toString());
        
        
    }
}
