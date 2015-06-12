/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author antonio
 */

/**
 * Interfaz de la carta. Varias clases del juego representan cartas. Esta interfaz
 * especifica los métodos que deben implementar todas las cartas del juego. Dichas
 * cartas tendrán además asociadas otras funcionalidades propias, que por tanto
 * no deben aparecer aquí
 * @author paco
 */
public interface Card {
    
    /**
     * Método que devuelve el valor básico de la carta
     * @return Valor básico
     */
    public int getBasicValue();
    
    /**
     * Método que devuelve el valor especial de la carta. En general, será el 
     * valor básico de dicha carta, modificado por otro valor que dependerá de 
     * las condiciones de interacción entre las cartas en un determinado punto
     * del juego.
     * @return Valor especial de la carta.
     */
    public int getSpecialValue();
}
