/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * Clase que representa los tesoros del juego. Cada instancia de esta clase representa una 
 * carta de tesoro de las que aparecen en el juego, y que es equipable por los jugadores
 * para mejorar su nivel en partida (bonus).
 * <P>
 * Cada tesoro se compone de una serie de atributos:
 * <P>
 * 1.- Nombre del tesoro <P>
 * 2.- Monedas de oro que cuesta <P>
 * 3.- Bonus mínimo que te otorga <P>
 * 4.- Bonus máximo que te otorga <P>
 * 5.- Tipo de tesoro. No se pueden llevar equipados dos tesoros del mismo tipo.
 * El tipo de tesoros posibles se encuentra en el enumerado {@link TreasureKind}
 */
public class Treasure implements Card{
    
    private String name;
    private int goldCoins;
    private int minBonus;
    private int maxBonus;
    private TreasureKind type;
    
    /**
     * Constructor por parámetros de la clase Treasure
     * @param name Nombre del objeto
     * @param goldCoins Monedas de oro que cuesta
     * @param maxBonus Máximo bonus que otorga
     * @param minBonus Mínimo bonus que otorga
     * @param type Tipo de tesoro. Viene especificado en {@link TreasureKind}
     */
    public Treasure(String name, int goldCoins, int minBonus, int maxBonus, TreasureKind type){
        this.name = name;
        this.goldCoins = goldCoins;
        this.minBonus = minBonus;
        this.maxBonus = maxBonus;
        this.type = type;
    }
    
    /**
     * Getter para el nombre del tesoro
     * @return String con el nombre de dicho tesoro
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Getter para el precio del tesoro
     * @return Devuelve el precio en monedas de oro del tesoro
     */
    public int getGoldCoins(){
        return this.goldCoins;
    }
    
    /**
     * Getter para el bonus mínimo que aporta el tesoro. Dicho bonus representa
     * el aumento de niveles que otorga el objeto cuando se produce un combate
     * contra un monstruo. El bonus que se recibe es el mínimo o el máximo dependiendo
     * de si se tiene equipado un objeto de tipo {@link TreasureKind#NECKLACE}
     * @return Entero que representa el bonus
     */
    public int getMinBonus(){
        return this.minBonus;
    }
    
    /**
     * Getter para el bonus máximo que aporta el tesoro.  Dicho bonus representa
     * el aumento de niveles que otorga el objeto cuando se produce un combate
     * contra un monstruo. El bonus que se recibe es el mínimo o el máximo dependiendo
     * de si se tiene equipado un objeto de tipo {@link TreasureKind#NECKLACE}
     * @return Entero que representa el bonus
     */
    public int getMaxBonus(){
        return this.maxBonus;
    }
    
    /**
     * Getter para el tipo de tesoro que representa dicha carta. Los posibles tipos
     * de tesoros que aparecen en el juego vienen especificados en {@link TreasureKind}
     * @return 
     */
    public TreasureKind getType(){
        return this.type;
    }
    
    /**
     * Método que devuelve en un string toda la información relativa al tesoro.
     * Se usa para trazar errores.
     */
    public String toString(){
        return "Nombre: " + this.name + ", precio: " + Integer.toString(goldCoins) +
                ", bonus mínimo: " + Integer.toString(minBonus) + ", bonus "
                + "máximo: " + Integer.toString(maxBonus) + ", tipo: " + type.name() + "\n";
    }
    
    @Override
    public int getBasicValue(){
        return this.getMinBonus();
    }
    
    @Override
    public int getSpecialValue(){
        return this.getMaxBonus();
    }
    
    
    
}
