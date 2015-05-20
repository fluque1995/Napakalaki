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
public class ExamenPadre {
    public void run(){
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
        System.out.println(p1.toString());
        
        BadConsequence badConsequence = new SpecificBadConsequence("Pierdes una mano visible",
                        0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                        new ArrayList());
        Prize prize = new Prize(3,1);
        Monster monstruo = new Monster("El mal indecible", 10, -2, badConsequence, prize);
        System.out.println(monstruo.toString());
        
        //t.add(new Treasure("poeso", 10,2,7,TreasureKind.ARMOR));
       /* t.add(new Treasure("¡Sí mi amo!", 0, 4, 7, TreasureKind.HELMET));
        t.add(new Treasure("Botas de investigación", 600, 3, 4, TreasureKind.SHOE));
        t.add(new Treasure("Capucha de Cthulhu", 500, 3, 5, TreasureKind.HELMET));
        */
       /* ArrayList<Treasure> t= new ArrayList();
        t.addAll(hidden);*/
        ArrayList<Treasure> t = (ArrayList<Treasure>)hidden.clone();
        p1.buyLevels(new ArrayList(), t);
        System.out.println(p1.toString());
        
        int nivel = p1.getOponentLevel(monstruo);
        String numero = Integer.toString(nivel);
        System.out.println(numero);
       
    }
}
