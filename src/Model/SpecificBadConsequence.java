/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 * Clase que representa el tipo de mal rollo que implica la pérdida de tesoros 
 * de tipo específico. Esta clase es hija de la clase {@link BadConsequence}, ya
 * que representa un tipo específico de mal rollo
 * @author Francisco Luque y Antonio Moya
 */
public class SpecificBadConsequence extends BadConsequence{
    
    protected int levels;
    protected ArrayList<TreasureKind> specificVisibleTreasures;
    protected ArrayList<TreasureKind> specificHiddenTreasures;
    
    /**
     * Constructo de la clase
     * @param text Texto asociado al mal rollo
     * @param levels Número de niveles que se pierden
     * @param tVisible Array de {@link TreasureKind} que indica los tipos de tesoros
     * específicos visibles que se pierden
     * @param tHidden Array de {@link TreasureKind} que indica los tipos de tesoros
     * específicos ocultos que se pierden
     */
    public SpecificBadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, 
            ArrayList<TreasureKind> tHidden){
        super(text);
        this.levels = levels;
        this.specificVisibleTreasures = tVisible;
        this.specificHiddenTreasures = tHidden;
    
    }
    
    /**
     * Método que comprueba si el mal rollo es vacío. En este caso, se corresponde
     * con que el jugador no se tenga que descartar de nigún tipo de tesoro específico.
     * @return True si el mal rollo es vacío, false en caso contrario
     */
    @Override
    public boolean isEmpty(){
        return (this.specificVisibleTreasures == null || this.specificVisibleTreasures.isEmpty()) &&
                (this.specificHiddenTreasures == null || this.specificHiddenTreasures.isEmpty());
    }
    
    /**
     * Método que reajusta el mal rollo, teniendo en cuenta que el jugador se 
     * ha descartado de un tesoro visible. 
     * @param treasure Tesoro que ha descartado el jugador
     */
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
    
    /**
     * Método que reajusta el mal rollo, teniendo en cuenta que el jugador se 
     * ha descartado de un tesoro oculto.
     * @param treasure Tesoro que ha descartado el jugador
     */
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
    
    /**
     * Método que devuelve el número de niveles que se pierden cuando se aplica
     * este mal rollo a un jugador
     * @return Número de niveles perdidos
     */
    @Override
    public int getLevels(){
        return this.levels;
    }
    
    /**
     * Método que devuelve el array de tipos de tesoros visibles que se pierden cuando se
     * aplica este mal rollo
     * @return ArrayList de {@link TreasureKind} con los tipos de tesoros visibles a descartar
     */
    public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
        return this.specificVisibleTreasures;
    }
    
    /**
     * Método que devuelve el array de tipos de tesoros ocultos que se pierden cuando se
     * aplica este mal rollo
     * @return ArrayList de {@link TreasureKind} con los tipos de tesoros ocultos a descartar
     */
    public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
        return this.specificHiddenTreasures;
    }
    
    /**
     * Método que ajusta el mal rollo a otro equivalente que pueda ser cumplido
     * por el jugador. Esto se utiliza para que el jugador pueda cumplir el mal
     * rollo que se le asigna con los tesoros que tiene en ese momento
     * @param visible Tesoros visibles que tiene el jugador
     * @param hidden Tesoros ocultos que tiene el jugador
     * @return Mal rollo ajustado para que pueda ser cumplido por el jugador
     */
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> visible,
            ArrayList<Treasure> hidden){
        SpecificBadConsequence badConsequence = this.copy();
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
    
    /**
     * Método que devuelve una copia del mal rollo con una identidad distinta
     * @return Mal rollo copiado
     */
    @Override
    protected SpecificBadConsequence copy(){
        SpecificBadConsequence badConsequence;
        
        ArrayList<TreasureKind> newVisibleTreasures = new ArrayList();
        newVisibleTreasures.addAll(this.specificVisibleTreasures);
            
        ArrayList <TreasureKind> newHiddenTreasures = new ArrayList();
        newHiddenTreasures.addAll(this.specificHiddenTreasures);
            
        badConsequence = new SpecificBadConsequence(this.text, 0, newVisibleTreasures, newHiddenTreasures);
        
        return badConsequence;
    }
    
    /**
     * Método que devuelve en un string toda la información del mal rollo
     * @return String con dicha información
     */
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

}
