/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Clase principal del juego Napakalaki. Gestiona la ejecución
 * del juego
 * @author Francisco Luque y Antonio Moya
 */
public class Napakalaki {

    private static Napakalaki instance = null;
    
    Monster currentMonster;
    ArrayList<Player> players;
    Player currentPlayer;
    
    private Napakalaki(){}
    
    private void initPlayers(ArrayList<String> names){
        
    }
    
    private Player nextPlayer(){
        
    }
    
    public static Napakalaki getInstance(){
        if (instance == null){
            instance = new Napakalaki();
        }
        
        return instance;
    }
    
    CombatResult combat(){
        
    }
    
    void discardVisibleTreasure(Treasure treasure){
        
    }
    
    void discardHiddenTreasures(Treasure treasure){
        
    }
    
    boolean makeTreasureVisible(Treasure treasure){
        
    }
    
    boolean buyLevels(ArrayList<Treasure> visibleTreasures, ArrayList<Treasure> hiddenTreasures){
        
    }
    
    void initGame(ArrayList<String> players){
        
    }
    
    Player getCurrentPlayer(){
        return this.currentPlayer;
    }
    
    Monster getCurrentMonster(){
        return this.currentMonster;
    }
    
    boolean canMakeVisibleTreasure(){
        
    }
    
    ArrayList<Treasure> getVisibleTreasures(){
        
    }
    
    ArrayList<Treasure> getHiddenTreasures(){
        
    }
    
    boolean nextTurn(){
        
    }
    
    boolean newtTurnAllowed(){
        
    }
    
    boolean endOfGame(CombatResult result){
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        /*
        * Creating consults for some parameters.
        */
        
        System.out.println("Monstruos con nivel mayor que 10:");
        for (Monster m: monsters){
            if (m.getCombatLevel() > 10){
               System.out.println(m.toString());
            }
        }
        
        System.out.println("Monstruos cuyo mal rollo implica sólo pérdida de niveles:");
        for (Monster m: monsters){
            if (m.getBadConsequence().getNVisibleTreasures() == 0 && 
                m.getBadConsequence().getNHiddenTreasures() == 0 && 
                m.getBadConsequence().kills() == false && 
                m.getBadConsequence().getSpecificVisibleTreasures().isEmpty() && 
                m.getBadConsequence().getSpecificHiddenTreasures().isEmpty()){
                System.out.println(m.toString());
            }
        }
        
        System.out.println("Monstruos que te aumentan más de un nivel:");
        for (Monster m: monsters){
            if (m.getPrize().getLevels() > 1){
                System.out.println(m.toString());
            }
        }
        
        System.out.println("Monstruos que te hacen perder armas de una mano:");
        for (Monster m: monsters) {
   
            ArrayList<TreasureKind> specificTreasures = new ArrayList<>();
            
            specificTreasures.addAll(m.getBadConsequence().getSpecificVisibleTreasures());
            specificTreasures.addAll(m.getBadConsequence().getSpecificHiddenTreasures());

            for (TreasureKind treasure: specificTreasures) {
                if (treasure == TreasureKind.ONEHAND){
                    System.out.println(m.toString());
                    break;
                }
            }
        }
    }
    
}
