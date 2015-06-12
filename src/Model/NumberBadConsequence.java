/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 * Clase que representa el tipo de mal rollo que te hace perder un número de niveles.
 * Esta clase es hija de la clase abstracta {@link BadConsequence}, ya que representa
 * un tipo específico de mal rollo
 * @author Francisco Luque y Antonio Moya
 */
public class NumberBadConsequence extends BadConsequence {
    
    protected int levels;
    protected int nVisibleTreasures;
    protected int nHiddenTreasures;
    
    /**
     * Constructor por parámetros del mal rollo
     * @param text Texto que representa el mal rollo
     * @param levels Número de niveles que se pierden
     * @param nVisible Número de tesoros visibles que se pierden
     * @param nHidden Número de tesoros ocultos que se pierden
     */
    public NumberBadConsequence(String text, int levels, int nVisible, int nHidden){
        super(text);
        this.levels = levels;
        this.nVisibleTreasures = nVisible;
        this.nHiddenTreasures = nHidden;
    }
    
    /**
     * Método que comprueba si el mal rollo es vacío. Para ello, comprueba si no
     * te quedan tesoros de ningún tipo por descartar.
     * @return True si no quedan tesoros por descartar, false en caso contrario
     */
    @Override 
    public boolean isEmpty(){
        return (this.nVisibleTreasures == 0 && 
                this.nHiddenTreasures == 0);
    }
    
    /**
     * Método que devuelve el número de niveles que el mal rollo te quita cuando 
     * se aplica a un jugador.
     * @return Número de niveles que se pierden
     */
    @Override
    public int getLevels(){
        return this.levels;
    }
    
    /**
     * Método que devuelve el número de tesoros visibles que el jugador debe 
     * descartar cuando se le aplica este mal rollo
     * @return Número de tesoros visibles a descartar
     */
    public int getNVisibleTreasures(){
        return this.nVisibleTreasures;
    }
    
    /**
     * Método que devuelve el número de tesoros ocultos que el jugador debe 
     * descartar cuando se le aplica este mal rollo
     * @return Número de tesoros ocultos a descartar
     */
    public int getNHiddenTreasures(){
        return this.nHiddenTreasures;
    }
    
    /**
     * Método que actualiza el mal rollo teniendo en cuenta que el jugador se
     * ha descartado de un tesoro visible
     * @param treasure Tesoro visible del que se descarta el jugador
     */
    @Override
    public void substractVisibleTreasure(Treasure treasure){
        if(this.nVisibleTreasures >0)
            this.nVisibleTreasures -= 1;
    }
    
    /**
     * Método que actualiza el mal rollo teniendo en cuenta que el jugador se
     * ha descartado de un tesoro oculto
     * @param treasure Tesoro oculto del que se descarta el jugador
     */
    @Override
    public void substractHiddenTreasure(Treasure treasure){
        if(this.nHiddenTreasures > 0)
            this.nHiddenTreasures -= 1;
    }
    
    /**
     * Método que ajusta el mal rollo a uno equivalente y que pueda ser cumplido
     * por el jugador al que se le asigna.
     * @param visible Lista de tesoros visibles del jugador en cuestión
     * @param hidden Lista de tesoros ocultos del jugador en cuestión
     * @return Mal rollo debidamente ajustado para que pueda ser cumplido por el
     * jugador
     */
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
    
    /**
     * Método que devuelve una copia del mal rollo que invoca al método, pero
     * con distinta identidad
     * @return Mal rollo copiado con distinta identidad al original
     */
    @Override
    protected NumberBadConsequence copy(){
        NumberBadConsequence badConsequence;
        
        badConsequence = new NumberBadConsequence(this.text, 0, this.nVisibleTreasures, this.nHiddenTreasures);
        
        return badConsequence;
    }
    
    /**
     * Método que devuelve en un string toda la información relativa al mal 
     * rollo que llama al método
     * @return String con la información
     */
    @Override 
    public String toString(){
        String printable = super.toString() + "reduce numero tesoros.\n";
        
        printable += "Text = " + this.text + "\n\t\tLevels = " + Integer.toString(levels) +
                          ", visible treasures = " + Integer.toString(nVisibleTreasures) +
                          ", hidden treasures = " + Integer.toString(nHiddenTreasures);
        
        return printable;
    }
    
}
