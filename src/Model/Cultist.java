/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * Clase que representa las cartas de sectario del juego. Este tipo de cartas 
 * sirven para modificar el comportamiento del jugador cuando se convierte 
 * en jugador sectario. Los jugadores se convierten en sectarios si al perder 
 * un combate tienen que cumplir el mal rollo, pero vuelven a tirar un dado 
 * y sacan un 5 o un 6. Es un tipo de carta, así que implementa la interfaz
 * {@link Card}
 * @author antonio
 */
public class Cultist implements Card{
    private String name;
    private int gainedLevels;
    
    /**
     * Constructor de la carta de sectario
     * @param name Nombre de la carta
     * @param gainedLevels Bonificación de niveles que le aporta al jugador 
     * por ser sectario
     */
    public Cultist(String name, int gainedLevels){
        this.name = name;
        this.gainedLevels = gainedLevels;
    }
    
    /**
     * Valor básico de la carta
     * @return Número de niveles que aporta
     */
    @Override
    public int getBasicValue(){
        return this.gainedLevels;
    }
    
    /**
     * Valor especial de la carta, calculado como el valor básico de la carta
     * multiplicado por el número de jugadores sectarios que existen en el juego.
     * Este valor se suma al nivel de combate del jugador, aumentando dicho nivel
     * de combate.
     * @return Valor especial de la carta
     */
    @Override
    public int getSpecialValue(){
        return this.getBasicValue()*CultistPlayer.getTotalCultistPlayers();
    }
    
    /**
     * Método que devuelve un string con la información de la carta. Devuelve
     * el nombre de dicha carta más la bonificación de niveles que aporta.
     * @return 
     */
    public String to_String(){
        return "Nombre: " + this.name + ", niveles ganados: " + Integer.toString(gainedLevels) + "\n";
    }
}
