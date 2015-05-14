/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * Enumerado que contiene información relativa al resultado de un combate. Sirve
 * para conocer el resultado de un combate entre un {@link Player} y un {@link Monster},
 * y tomar la decisión que se deba en cada caso. 
 * @author paco
 */
public enum CombatResult {
    
    /**
     * El jugador gana el combate y la partida
     */
    WINANDWINGAME,
    /**
     * El jugador gana el combate
     */
    WIN,
    /**
     * El jugador pierde el combate
     */
    LOSE,
    /**
     * El jugador pierde el combate pero escapa del monstruo
     */
    LOSEANDESCAPE,
    /**
     * El jugador pierde y se convierte en sectario
     */
    LOSEANDCONVERT,
    /**
     * El jugador pierde el combate y muere
     */
    LOSEANDDIE;
}
