/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 * Clase que representa el premio que otorga un monstruo si es derrotado en combate.
 * Contiene información relativa al número de niveles y de tesoros que obtiene el
 * jugador si derrota al monstruo en combate
 * @see Monster
 */
public class Prize {
    
    private int treasures;
    private int levels;
    
    /**
     * Constructor por parámetros del premio
     * @param treasures Número de tesoros que gana el jugador si derrota al monstruo
     * @param levels Número de niveles que aumenta
     */
    public Prize(int treasures, int levels){
        
        this.treasures = treasures;
        this.levels = levels;
    }
    
    /**
     * Getter para los tesoros que se obtienen
     * @return Número de tesoros
     */
    public int getTreasures(){
        return this.treasures;
    }
    
    /**
     * Getter para el número de niveles que aumenta
     * @return Niveles que se ganan
     */
    public int getLevels(){
        return this.levels;
    }
    
    /**
     * Método que devuelve un String con la información relativa al premio obtenido.
     * Sirve de apoyo para el método toString() de la clase Monster.
     * @return String con la información relativa al número de niveles que se ganan
     * y al número de tesoros que se obtienen. 
     * @see Monster#toString() 
     */
    public String toString(){
        
        return "Treasures = " + Integer.toString(treasures) + 
                ", levels = " + Integer.toString(levels);
        
    }
    
}
