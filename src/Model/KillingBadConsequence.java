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
public class KillingBadConsequence extends BadConsequence{
    
    public KillingBadConsequence(String text){
        super(text);
    }
    
    @Override
    public boolean isEmpty(){
        return true;
    }
    
    @Override
    public boolean kills(){
        return true;
    }
    
    @Override
    public void substractVisibleTreasure(Treasure treasure){
        // no sense here
    }
    
    @Override
    public void substractHiddenTreasure(Treasure treasure){
    // no sense here
    }
    
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> visible,
            ArrayList<Treasure> hidden){
        BadConsequence badConsequence = this.copy();
        return badConsequence;
    }
    
    @Override
    protected KillingBadConsequence copy(){
        KillingBadConsequence badConsequence;
        
        badConsequence = new KillingBadConsequence(this.getText());
        
        return badConsequence;
    }
    
    @Override 
    public String toString(){
        String printable = super.toString() + "muerte.\n";
        printable += this.text;
        return printable;
    }
   
    @Override
    public int getLevels(){
        return 0;
    }

}
