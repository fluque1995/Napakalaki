/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Random;

/**
 * Clase que representa el dado de juego en la partida. Establece el orden de juego
 * de los jugadores, y sirve para la toma de decisiones tras la pérdida de un combate.
 * @author paco
 */
public class Dice {
    
    ////////////////////////////////////////////////////////////////////////////
    //                                                                        //
    //                        Instance and attributes                         //
    //                                                                        //    
    ////////////////////////////////////////////////////////////////////////////
    
    private static Dice instance = null;
    private Random rnd;
    
    ////////////////////////////////////////////////////////////////////////////
    //                                                                        //
    //                     Constructor and instance getter                    //
    //                                                                        //    
    ////////////////////////////////////////////////////////////////////////////
    
    private Dice(){
        rnd = new Random();
    }
    
    /**
     * Getter de la instancia del dado. Si no existe dado en el juego, lo crea y
     * lo devuelve. Si no, devuelve el dado ya existente.
     * @return Instancia del dado
     */
    public static Dice getInstance() {
        if(instance == null){
            instance = new Dice();
        }
        return instance;
    }
    
    /**
     * Método que representa una nueva tirada del dado. Genera un número aleatorio
     * entre 1 y 6, usando la librería Random de java.
     * @return Número entre 1 y 6 que representa el valor de la tirada
     */
    public int nextNumber(){
        return rnd.nextInt(6) + 1;
    }
}
