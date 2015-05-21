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
    
    public NumberBadConsequence(String text, int level, int nVisible, int nHidden){
        super(text, level, nVisible, nHidden, new ArrayList(), new ArrayList(), false);
    }
    
    @Override 
    public boolean isEmpty(){
        return (this.nVisibleTreasures == 0 && 
                this.nHiddenTreasures == 0);
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
        BadConsequence badConsequence = this.copy();
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
    
    
}
