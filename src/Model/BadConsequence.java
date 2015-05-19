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
public abstract class BadConsequence {
    
    ////////////////////////////////////////////////////////////////////////////
    //                                                                        //
    //                               Attributes                               //
    //                                                                        //    
    ////////////////////////////////////////////////////////////////////////////
    
    protected String text;
    protected int levels;
    protected int nVisibleTreasures;
    protected int nHiddenTreasures;
    protected boolean death;
    
    protected ArrayList<TreasureKind> specificVisibleTreasures;
    protected ArrayList<TreasureKind> specificHiddenTreasures;
    
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
    public BadConsequence(String text, int levels, int nVisible, int nHidden, ArrayList<TreasureKind> tVisible, 
                            ArrayList<TreasureKind> tHidden, boolean death){
        
        this.text = text;
        this.levels = levels;
        this.nVisibleTreasures = nVisible;
        this.nHiddenTreasures = nHidden;
        this.death = death;
        this.specificVisibleTreasures = tVisible;
        this.specificHiddenTreasures = tHidden;     
    }
    
    /**
     * Constructor para BadConsequence que provoca la muerte
     * @param text Texto del mal rollo
     * @param death Bool que indica si el monstruo te mata
     */
    /*public BadConsequence(String text, boolean death){
        
        this.text = text;
        this.levels = 0;
        this.nVisibleTreasures = 0;
        this.nHiddenTreasures = 0;
        this.death = death;
        this.specificVisibleTreasures = new ArrayList();
        this.specificHiddenTreasures = new ArrayList();
    }*/
    
    /**
     * Constructor para BadConsequence que especifica el tipo de tesoros que se 
     * pierden.
     * 
     * @param text Texto del mal rollo
     * @param levels Niveles que se pierden
     * @param tVisible Array con los tesoros visibles que se pierden
     * @param tHidden Array con los tesoros ocultos que se pierden
     */
   /* public BadConsequence(String text, int levels, 
        
        this.text = text;
        this.levels = levels;
        this.nVisibleTreasures = 0;
        this.nHiddenTreasures = 0;
        this.death = false;
        this.specificVisibleTreasures = tVisible;
        this.specificHiddenTreasures = tHidden;    
    }*/
    
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
        return this.levels == 0 && this.nVisibleTreasures == 0 && 
                this.nHiddenTreasures == 0 && this.death == false && 
                (this.specificVisibleTreasures == null || this.specificVisibleTreasures.isEmpty()) &&
                (this.specificHiddenTreasures == null || this.specificHiddenTreasures.isEmpty());
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
    
    /**
     * Método que te extrae del mal rollo un tesoro visible, en el sentido,
     * de que si se especifica se quita ese concreto, y si es numérico te dismi-
     * nuye los tesoros visible que se quitan por el mal rollo una unidad.
     * @param treasure Tesoro que se extrae.
     */
    
    public abstract void substractVisibleTreasure(Treasure treasure);/*{
       TreasureKind discarded = null; 
        
       if(nVisibleTreasures > 0)
           nVisibleTreasures -= 1;
       else{
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
    }*/
    /**
     * Método análogo a substracVisibleTreasure pero sobre los tesoros
     * ocultos.
     * @param treasure Tesoro que se extrae.
     * @see BadConsequence#substractVisibleTreasure(Model.Treasure) 
     */
    public abstract void substractHiddenTreasure(Treasure treasure);/*{
        
        TreasureKind discarded = null;
        
        if(nHiddenTreasures > 0)
           nHiddenTreasures -= 1;
       else{
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
    }*/
    
    /**
     * Ajusta el mal rollo que se va a aplicaren función a los tesoros que tenga el jugador.
     * @param visible Lista de tesoros visibles del jugador
     * @param hidden Lista de tesoros ocultos del jugador.
     * @return Mal rollo que queda pendiente ajustado correctamente
     */
    
    public abstract BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> visible,
            ArrayList<Treasure> hidden);/*{
       
        BadConsequence badConsequence = this.copy();
        
        if(!badConsequence.kills()){
            
            if(badConsequence.getNVisibleTreasures() > 0 || badConsequence.getNHiddenTreasures() > 0){
                if(badConsequence.getNVisibleTreasures() > visible.size()){
                    badConsequence.nVisibleTreasures = visible.size();
                }
                
                if(badConsequence.getNHiddenTreasures() > hidden.size()){
                    badConsequence.nHiddenTreasures = hidden.size();
                }
            }
            else{

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
            }
        }
        
        return badConsequence;
        
    }*/
    
    /**
     * Método que devuelve un String con la información relativa al BadConsequence
     * sobre el que se llama. En él viene indicado, además del temoxto del mal rollo,
     * la información respecto de lo que el monstruo te quita. Sirve de apoyo para 
     * el método toString() de la clase Monster.
     * @return String con toda la información
     * @see Monster#toString() 
     */
    public String toString(){
        
        String printable = "Esto es un mal rollo con el siguiente contenido: ";
        return printable;
        /*String printable ="Text = " + text + "\n\t\tLevels = " + Integer.toString(levels) +
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
        return printable;*/
    }
    
    /**
     * Método que copia el mal rollo sin crear identidad
     * @return Mal rollo copiado
     */
    
    protected abstract BadConsequence copy();/*{
        BadConsequence badConsequence;
        if(this.death == true){
            badConsequence = new BadConsequence(this.text, this.death);
        }
        
        else if(this.nVisibleTreasures > 0 || this.nHiddenTreasures > 0){
            badConsequence = new BadConsequence(this.text, 0, this.nVisibleTreasures, this.nHiddenTreasures);
        }
        
        else{
            ArrayList<TreasureKind> newVisibleTreasures = new ArrayList();
            newVisibleTreasures.addAll(this.specificVisibleTreasures);
            
            ArrayList <TreasureKind> newHiddenTreasures = new ArrayList();
            newHiddenTreasures.addAll(this.specificHiddenTreasures);
            
            badConsequence = new BadConsequence(this.text, 0, newVisibleTreasures, newHiddenTreasures);
        }
        
        return badConsequence;
    }*/
}


