/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * Enumerado que contiene la información relativa respecto a los tipos de tesoros
 * que existen en el juego. Sirve para controlar el tipo de tesoro que representa
 * una carta de tipo {@link Treasure} de las que aparecen en el juego. El jugador
 * no puede tener equipada al mismo tiempo más de una carta del mismo tipo, a no ser 
 * que sean del tipo {@link TreasureKind#ONEHAND}, en cuyo caso puede tener dos.
 */
public enum TreasureKind {
    /**
     * Objeto de tipo armadura
     */
    ARMOR,
    /**
     * Objeto de tipo arma de una mano
     */
    ONEHAND,
    /**
     * Objeto de tipo arma de dos manos
     */
    BOTHHANDS,
    /**
     * Objeto de tipo casco
     */
    HELMET,
    /**
     * Objeto de tipo botas
     */
    SHOE,
    /**
     * Objeto de tipo collar. Es un tipo especial de objeto que determina si el
     * tesoro aporta el bonus máximo o el mínimo. Si el jugador tiene equipado un
     * objeto de tipo collar, recibirá el bonus más alto. Si no, será el más bajo
     * el que tenga efecto.
     * @see Treasure#getMaxBonus()
     * @see Treasure#getMinBonus()
     */
    NECKLACE;
}
