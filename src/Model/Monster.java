/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * Clase que representa las cartas de monstruo que hay en el juego. Cada instancia
 * de esta clase representa una carta de monstruo. Contiene información relativa
 * a este para el combate:
 * <P>
 * 1.- Nombre del monstruo<P>
 * 2.- Nivel de combate<P>
 * 3.- Premio por victoria en combate, representado por un objeto de la clase {@link Prize}<P>
 * 4.- Mal rollo que provoca en el jugador si pierde el combate, representado por
 * un objeto de la clase {@link BadConsequence}
 */
public class Monster implements Card{
    
    ////////////////////////////////////////////////////////////////////////////
    //                                                                        //
    //                               Attributes                               //
    //                                                                        //    
    ////////////////////////////////////////////////////////////////////////////
    
    private String name;
    private int combatLevel;
    private BadConsequence badConsequence;
    private Prize prize;
    private int levelChangeAgainstCultistPlayer;
    ////////////////////////////////////////////////////////////////////////////
    //                                                                        //
    //                               Constructor                              //
    //                                                                        //    
    ////////////////////////////////////////////////////////////////////////////
    
    /**
     * Constructor con parámetros para el monstruo.
     * @param name Nombre del monstruo
     * @param combatLevel Nivel de combate
     * @param prize Premio por victoria
     * @param bc Mal rollo por derrota
     */
    public Monster(String name, int combatLevel,int levelChange, BadConsequence bc, Prize prize){
        
        this.name = name;
        this.combatLevel = combatLevel;
        this.badConsequence = bc;
        this.prize = prize;
        this.levelChangeAgainstCultistPlayer = levelChange;
    }
    
    public Monster(String name, int combatLevel, BadConsequence bc, Prize prize){
        
        this.name = name;
        this.combatLevel = combatLevel;
        this.badConsequence = bc;
        this.prize = prize;
        this.levelChangeAgainstCultistPlayer = 0;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    //                                                                        //
    //                                 Getters                                //
    //                                                                        //    
    ////////////////////////////////////////////////////////////////////////////
    
    /**
     * Getter para el nombre del monstruo.
     * @return String con dicho nombre
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Getter para el nivel de combate del monstruo
     * @return Nivel de combate
     */
    public int getLevel(){
        return this.combatLevel;
    }
    
    /**
     * Getter para el mal rollo que provoca el monstruo
     * @return Objeto de la clase BadConsequence que representa dicho mal rollo
     */
    public BadConsequence getBadConsequence(){
        return this.badConsequence;
    }
    
    /**
     * Getter para el premio que otorga el monstruo
     * @return Objeto de la clase Prize que representa dicho premio
     */
    public Prize getPrize(){
        return this.prize;
    }
    
    /**
     * Método que devuelve un String con la información relativa al monstruo.
     * @return String con la información relativa al monstruo. Devuelve su nombre,
     * nivel de combate, premio y mal rollo.
     * @see BadConsequence#toString()
     * @see Prize#toString()
     */
    public String toString(){
        
        String text = "Name = " + name + ", combat level = " + Integer.toString(combatLevel);
        
        if(this.levelChangeAgainstCultistPlayer != 0){
            text += ", modificación de nivel contra sectarios = " + Integer.toString(this.levelChangeAgainstCultistPlayer);
        }
         
        text += "\n\tPrize: " + prize.toString() + "\n\tBad consequence: " +
                badConsequence.toString() + "\n";
        
        return text;
        
    }
    
    @Override
    public int getBasicValue(){
        return this.getLevel();
    }
    
    @Override
    public int getSpecialValue(){
        return this.getLevel() + this.levelChangeAgainstCultistPlayer;
    }
        
}