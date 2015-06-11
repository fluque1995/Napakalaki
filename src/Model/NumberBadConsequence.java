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
public class NumberBadConsequence extends BadConsequence {
    
    protected int levels;
    protected int nVisibleTreasures;
    protected int nHiddenTreasures;
    
    public NumberBadConsequence(String text, int levels, int nVisible, int nHidden){
        super(text);
        this.levels = levels;
        this.nVisibleTreasures = nVisible;
        this.nHiddenTreasures = nHidden;
    }
    
    @Override 
    public boolean isEmpty(){
        return (this.nVisibleTreasures == 0 && 
                this.nHiddenTreasures == 0);
    }
    
    @Override
    public int getLevels(){
        return this.levels;
    }
    
    @Override
    public int getNVisibleTreasures(){
        return this.nVisibleTreasures;
    }
    
    @Override
    public int getNHiddenTreasures(){
        return this.nHiddenTreasures;
    }
    
    @Override
    public void substractVisibleTreasure(Treasure treasure){
        if(this.nVisibleTreasures >0)
            this.nVisibleTreasures -= 1;
    }
    
    @Override
    public void substractHiddenTreasure(Treasure treasure){
        if(this.nHiddenTreasures > 0)
            this.nHiddenTreasures -= 1;
    }
    
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> visible,
            ArrayList<Treasure> hidden){
        NumberBadConsequence badConsequence = (NumberBadConsequence) this.copy();
        if(badConsequence.getNVisibleTreasures() > visible.size()){
            badConsequence.nVisibleTreasures = visible.size();
        }
                
        if(badConsequence.getNHiddenTreasures() > hidden.size()){
             badConsequence.nHiddenTreasures = hidden.size();
        }
        return badConsequence;
    }
    
    @Override
    protected BadConsequence copy(){
        BadConsequence badConsequence;
        
         badConsequence = new NumberBadConsequence(this.text, 0, this.nVisibleTreasures, this.nHiddenTreasures);
        
        return badConsequence;
    }
    
    @Override 
    public String toString(){
        String printable = super.toString() + "reduce numero tesoros.\n";
        
        printable += "Text = " + this.text + "\n\t\tLevels = " + Integer.toString(levels) +
                          ", visible treasures = " + Integer.toString(nVisibleTreasures) +
                          ", hidden treasures = " + Integer.toString(nHiddenTreasures);
        
        return printable;
    }
    
    @Override
    public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
        return null;
    }
    
    @Override
    public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
        return null;
    }
    
}
