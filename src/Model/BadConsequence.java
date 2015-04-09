/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 * Representa el mal rollo que provoca el monstruo si no consigues derrotarlo en 
 * combate. Existen tres tipos principales de mal rollo: 
 * <P>
 * 1.- Mal rollo que quita un número determinado de objetos y niveles
 * <P> 
 * 2.- Mal rollo que quita unos tesoros determinados
 * <P>
 * 3.- Mal rollo en el que el monstruo te mata
 * @see Monster
 */
public class BadConsequence {
    
    ////////////////////////////////////////////////////////////////////////////
    //                                                                        //
    //                               Attributes                               //
    //                                                                        //    
    ////////////////////////////////////////////////////////////////////////////
    
    private String text;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death;
    
    private ArrayList<TreasureKind> specificVisibleTreasures;
    private ArrayList<TreasureKind> specificHiddenTreasures;
    
    ////////////////////////////////////////////////////////////////////////////
    //                                                                        //
    //                              Constructors                              //
    //                                                                        //    
    ////////////////////////////////////////////////////////////////////////////
    
    /**
     * Constructor de BadConsequence para el tipo de mal rollo en el que se 
     * quitan un número específico de niveles y tesoros.
     * @param text Texto que indica el mal rollo
     * @param levels Niveles que te quita el monstruo
     * @param nVisible Tesoros visibles que te quita el monstruo
     * @param nHidden Tesoros ocultos que te quita el monstruo
     */
    public BadConsequence(String text, int levels, int nVisible, int nHidden){
        
        this.text = text;
        this.levels = levels;
        this.nVisibleTreasures = nVisible;
        this.nHiddenTreasures = nHidden;
        this.death = false;
        this.specificVisibleTreasures = new ArrayList();
        this.specificHiddenTreasures = new ArrayList();     
    }
    
    /**
     * Constructor para BadConsequence que provoca la muerte
     * @param text Texto del mal rollo
     * @param death Bool que indica si el monstruo te mata
     */
    public BadConsequence(String text, boolean death){
        
        this.text = text;
        this.levels = 0;
        this.nVisibleTreasures = 0;
        this.nHiddenTreasures = 0;
        this.death = death;
        this.specificVisibleTreasures = new ArrayList();
        this.specificHiddenTreasures = new ArrayList();
    }
    
    /**
     * Constructor para BadConsequence que especifica el tipo de tesoros que se 
     * pierden.
     * 
     * @param text Texto del mal rollo
     * @param levels Niveles que se pierden
     * @param tVisible Array con los tesoros visibles que se pierden
     * @param tHidden Array con los tesoros ocultos que se pierden
     */
    public BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, 
                            ArrayList<TreasureKind> tHidden){
        
        this.text = text;
        this.levels = levels;
        this.nVisibleTreasures = 0;
        this.nHiddenTreasures = 0;
        this.death = false;
        this.specificVisibleTreasures = tVisible;
        this.specificHiddenTreasures = tHidden;    
    }
    
    ////////////////////////////////////////////////////////////////////////////
    //                                                                        //
    //                  Getters, setters and consult methods                  //
    //                                                                        //    
    ////////////////////////////////////////////////////////////////////////////
    
    /**
     * Comprueba si el mal rollo está vacío.
     * @return Boolean que indica si el mal rollo está vacío
     */
    public boolean isEmpty(){
        return this.text.isEmpty() && this.levels == 0 && this.nVisibleTreasures == 0 &&
                this.nHiddenTreasures == 0 && death == false && this.specificVisibleTreasures == null &&
                this.specificHiddenTreasures == null;
    }
    
    /**
     * Getter para el boolean que indica si el monstruo te mata.
     * @return True si el monstruo te mata, false si no
     */
    public boolean kills(){
        return this.death;
    }

    /**
     * Getter para el texto de BadConsequence.
     * @return String con el texto
     */
    public String getText(){
        return this.text;
    }
    
    /**
     * Getter para los niveles que se pierden.
     * @return Int que indica los niveles
     */
    public int getLevels(){
        return this.levels;
    }
    
    /**
     * Getter para el número de tesoros visibles perdidos.
     * @return Número de tesoros visibles perdidos
     */
    public int getNVisibleTreasures(){
        return this.nVisibleTreasures;
    }
    
    /**
     * Getter para el número de tesoros ocultos perdidos.
     * @return Número de tesoros ocultos perdidos
     */
    public int getNHiddenTreasures(){
        return this.nHiddenTreasures;
    }
    
    /**
     * Getter para el array de tesoros visibles específicos perdidos.
     * @return Array con los tesoros visibles específicos perdidos
     */
    public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
        return this.specificVisibleTreasures;
    }
    
    /**
     * Getter para el array de tesoros ocultos específicos perdidos.
     * @return Array con los tesoros ocultos específicos perdidos
     */
    public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
        return this.specificHiddenTreasures;
    }

    ////////////////////////////////////////////////////////////////////////////
    //                                                                        //
    //                             Other methods                              //
    //                                                                        //    
    ////////////////////////////////////////////////////////////////////////////
    
    public void substractVisibleTreasure(Treasure treasure){
        
    }
    
    public void substractHiddenTreasure(Treasure treasure){
        
    }
    
    public BadConsequence adjustToFitTreasureList(ArrayList<Treasure> h, ArrayList<Treasure> v){
        
    }
    
    /**
     * Método que devuelve un String con la información relativa al BadConsequence
     * sobre el que se llama. En él viene indicado, además del texto del mal rollo,
     * la información respecto de lo que el monstruo te quita. Sirve de apoyo para 
     * el método toString() de la clase Monster.
     * @return String con toda la información
     * @see Monster#toString() 
     */
    public String toString(){
        String printable ="Text = " + text + "\n\t\tLevels = " + Integer.toString(levels) +
                          ", visible treasures = " + Integer.toString(nVisibleTreasures) +
                          ", hidden treasures = " + Integer.toString(nHiddenTreasures);
        
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
