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
public class Cultist implements Card{
    private String name;
    private int gainedLevels;
    
    public Cultist(String name, int gainedLevels){
        this.name = name;
        this.gainedLevels = gainedLevels;
    }
    
    @Override
    public int getBasicValue(){
        return this.gainedLevels;
    }
    
    @Override
    public int getSpecialValue(){
        return this.getBasicValue()*CultistPlayer.getTotalCultistPlayers();
    }
    
    public String to_String(){
        return "Nombre: " + this.name + ", niveles ganados: " + Integer.toString(gainedLevels) + "\n";
    }
}
