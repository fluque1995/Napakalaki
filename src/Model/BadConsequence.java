/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 * Clase abstracta que sirve de apoyo para definir los distintos tipos de mal
 * rollo que existen en el juego. Estos malos rollos se aplican al jugador tras 
 * el combate contra un monstruo, en caso de que el monstruo sea el vencedor.
 * Existen tres tipos principales de mal rollo: 
 * <P>
 * 1.- Mal rollo que quita un número determinado de objetos y niveles
 * <P> 
 * 2.- Mal rollo que quita unos tesoros determinados
 * <P>
 * 3.- Mal rollo en el que el monstruo te mata
 * @see KillingBadConsequence
 * @see NumberBadConsequence
 * @see SpecificBadConsequence
 * @see Monster
 */
public abstract class BadConsequence {
   
    protected String text;
    
    ////////////////////////////////////////////////////////////////////////////
    //                                                                        //
    //                               Constructor                              //
    //                                                                        //    
    ////////////////////////////////////////////////////////////////////////////
    
    /**
     * Constructor de la clase. Dado que esta clase es abstracta, y que nos va
     * a servir como apoyo para las demás, sólo tendrá un atributo, que es común
     * a todos los tipos de mal rollo, que es el texto que los describe.
     * @param text Texto que describe el mal rollo
     */
    BadConsequence(String text){
        this.text = text;
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
    public abstract boolean isEmpty();
    
    /**
     * Getter para el boolean que indica si el monstruo te mata.
     * @return True si el monstruo te mata, false si no
     */
    public boolean kills(){
        return false;
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
    public abstract int getLevels();

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
    
    public abstract void substractVisibleTreasure(Treasure treasure);
    
    /**
     * Método análogo a substracVisibleTreasure pero sobre los tesoros
     * ocultos.
     * @param treasure Tesoro que se extrae.
     * @see BadConsequence#substractVisibleTreasure(Model.Treasure) 
     */
    public abstract void substractHiddenTreasure(Treasure treasure);
    
    /**
     * Ajusta el mal rollo que se va a aplicaren función a los tesoros que tenga el jugador.
     * @param visible Lista de tesoros visibles del jugador
     * @param hidden Lista de tesoros ocultos del jugador.
     * @return Mal rollo que queda pendiente ajustado correctamente
     */
    
    public abstract BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> visible,
            ArrayList<Treasure> hidden);
    
    /**
     * Método que devuelve un String con la información relativa al BadConsequence
     * sobre el que se llama. En él viene indicado, además del temoxto del mal rollo,
     * la información respecto de lo que el monstruo te quita. Sirve de apoyo para 
     * el método toString() de la clase Monster.
     * @return String con toda la información
     * @see Monster#toString() 
     */
    public String toString(){
        
        return "Esto es un mal rollo con el siguiente contenido: ";
        
    }
    
    /**
     * Método que copia el mal rollo en uno nuevo con distinta identidad
     * @return Mal rollo copiado
     */
    protected abstract BadConsequence copy();
}


