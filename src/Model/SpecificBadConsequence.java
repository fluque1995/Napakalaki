/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author antonio
 */
public class SpecificBadConsequence extends BadConsequence{
    
    protected int levels;
    protected ArrayList<TreasureKind> specificVisibleTreasures;
    protected ArrayList<TreasureKind> specificHiddenTreasures;
    
    public SpecificBadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, 
            ArrayList<TreasureKind> tHidden){
        super(text);
        this.levels = levels;
        this.specificVisibleTreasures = tVisible;
        this.specificHiddenTreasures = tHidden;
    
    }
    
    @Override
    public boolean isEmpty(){
        return (this.specificVisibleTreasures == null || this.specificVisibleTreasures.isEmpty()) &&
                (this.specificHiddenTreasures == null || this.specificHiddenTreasures.isEmpty());
    }
    
    @Override
    public void substractVisibleTreasure(Treasure treasure){
        TreasureKind discarded = null;
        boolean encontrado = false;  
         for(TreasureKind t: this.specificVisibleTreasures){
            if(t == treasure.getType() && !encontrado){
                discarded = t;
                encontrado = true;
            }
         }
         if(discarded != null){
             this.specificVisibleTreasures.remove(discarded);
         }
    }
    
    @Override
    public void substractHiddenTreasure(Treasure treasure){
        TreasureKind discarded = null;
        boolean encontrado = false;  
         for(TreasureKind t: this.specificHiddenTreasures){
            if(t == treasure.getType() && !encontrado && t != null){
                discarded = t;
                encontrado = true;
            }
         }
         if (discarded != null){
            this.specificHiddenTreasures.remove(discarded);
         }
    }
    
    @Override
    public int getLevels(){
        return this.levels;
    }
    
    @Override
    public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
        return this.specificVisibleTreasures;
    }
    @Override
    public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
        return this.specificHiddenTreasures;
    }
    
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> visible,
            ArrayList<Treasure> hidden){
        BadConsequence badConsequence = this.copy();
        ArrayList<TreasureKind> treasure_visible_types = new ArrayList();
        ArrayList<TreasureKind> treasure_hidden_types = new ArrayList();
                
        for(Treasure treasure: hidden){
            treasure_hidden_types.add(treasure.getType());
        }

        for(int i=0; i<badConsequence.getSpecificHiddenTreasures().size(); i++){
            boolean encontrado = false;
            for(int j=0; j<treasure_hidden_types.size() && !encontrado; j++){
                if(badConsequence.getSpecificHiddenTreasures().get(i) == treasure_hidden_types.get(j)){
                    treasure_hidden_types.remove(treasure_hidden_types.get(j));
                        encontrado = true;
                }
            }
            if(!encontrado){
                badConsequence.getSpecificHiddenTreasures().remove(badConsequence.getSpecificHiddenTreasures().get(i));
                i--;
            }
        }               
            
        for(Treasure treasure: visible){
            treasure_visible_types.add(treasure.getType());
        }

        for(int i=0; i<badConsequence.getSpecificVisibleTreasures().size(); i++){
            boolean encontrado = false;
            for(int j=0; j<treasure_visible_types.size() && !encontrado; j++){
                if(badConsequence.getSpecificVisibleTreasures().get(i) == treasure_visible_types.get(j)){
                    treasure_visible_types.remove(treasure_visible_types.get(j));
                        encontrado = true;
                }
            }
            if(!encontrado){
                badConsequence.getSpecificVisibleTreasures().remove(badConsequence.getSpecificVisibleTreasures().get(i));
                i--;
            }
        }
        return badConsequence;
    }
    
    @Override
    protected BadConsequence copy(){
        BadConsequence badConsequence;
        
        ArrayList<TreasureKind> newVisibleTreasures = new ArrayList();
        newVisibleTreasures.addAll(this.specificVisibleTreasures);
            
        ArrayList <TreasureKind> newHiddenTreasures = new ArrayList();
        newHiddenTreasures.addAll(this.specificHiddenTreasures);
            
        badConsequence = new SpecificBadConsequence(this.text, 0, newVisibleTreasures, newHiddenTreasures);
        
        return badConsequence;
    }
    
    @Override 
    public String toString(){
        String printable = super.toString() + "quita tesoros especificos.\n";
        
        if (!this.specificVisibleTreasures.isEmpty()){
            printable += "\n\t\tSpecific visible treasures = ";
            for (TreasureKind treasure: this.specificVisibleTreasures){
                printable += treasure.name() + ", ";
            }
        }
        
        if (!this.specificHiddenTreasures.isEmpty()){
            printable += "\n\t\tSpecific hidden treasures = ";
            for (TreasureKind treasure: this.specificHiddenTreasures){
                printable += treasure.name() + ", ";
            }
        }
        
        return printable;
    }

    @Override
    public int getNVisibleTreasures() {
        return 0;
    }

    @Override
    public int getNHiddenTreasures() {
        return 0;
    }
}
