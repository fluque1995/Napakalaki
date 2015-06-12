/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 * Clase que representa el tipo de mal rollo en el cual el monstruo te mata. Esta
 * clase es hija de la clase {@link BadConsequence}, ya que es un caso particular
 * de mal rollo
 * @author Francisco Luque y Antonio Moya
 */
public class KillingBadConsequence extends BadConsequence{
    
    /**
     * Constructor de la clase. Esta clase sólo necesita del texto que representa
     * al mal rollo, ya que su consecuencia es siempre la misma, la muerte del
     * jugador.
     * @param text Texto que representa al mal rollo
     */
    public KillingBadConsequence(String text){
        super(text);
    }
    
    /**
     * Método que comprueba si el mal rollo está vacío. Siempre devuelve true, ya
     * que por la implementación del juego se considera que este mal rollo no tiene
     * contenido, ya que no depende del jugador cumplir o no el mal rollo, como 
     * ocurren con los malos rollo que obligan a descartar tesoros
     * @return True
     */
    @Override
    public boolean isEmpty(){
        return true;
    }
    
    /**
     * Método que comprueba si el mal rollo te mata. En este caso particular siempre
     * devuelve true
     * @return True
     */
    @Override
    public boolean kills(){
        return true;
    }
    
    /**
     * Método que sirve para ajustar las lista de tesoros visibles. No tiene sentido en 
     * esta clase, de hecho no se llama nunca a este método, pero se pueden producir
     * errores si no se sobrescribe.
     * @param treasure Tesoro que se extrae de la lista de tesoros visibles del jugador
     */
    @Override
    public void substractVisibleTreasure(Treasure treasure){
        // no sense here
    }
    
    /**
     * Método que sirve para ajustar las lista de tesoros ocultos. No tiene sentido en 
     * esta clase, de hecho no se llama nunca a este método, pero se pueden producir
     * errores si no se sobrescribe.
     * @param treasure Tesoro que se extrae de la lista de tesoros ocultos del jugador
     */
    @Override
    public void substractHiddenTreasure(Treasure treasure){
    // no sense here
    }
    
    /**
     * Método que ajusta el mal rollo para que pueda ser cumplido por el jugador.
     * En esta subclase no realiza nada, sólo copia el mal rollo del monstruo y
     * lo devuelve, ya que en este tipo de mal rollo no hay que reajustar nada.
     * @param visible Lista de tesoros visibles del jugador
     * @param hidden Lista de tesoros ocultos del jugador
     * @return BadConsequence reajustado, en este caso, igual al original
     */
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> visible,
            ArrayList<Treasure> hidden){
        BadConsequence badConsequence = this.copy();
        return badConsequence;
    }
    
    /**
     * Método que realiza una copia del mal rollo en cuestión, creando un nuevo
     * objeto con distinta identidad
     * @return Copia del mal rollo
     */
    @Override
    protected KillingBadConsequence copy(){
        KillingBadConsequence badConsequence;
        
        badConsequence = new KillingBadConsequence(this.getText());
        
        return badConsequence;
    }
    
    /**
     * Método que devuelve en un string la información relativa al mal rollo
     * @return Cadena de texto con toda la información del mal rollo
     */
    @Override 
    public String toString(){
        String printable = super.toString() + "muerte.\n";
        printable += this.text;
        return printable;
    }
   
    /**
     * Método que devuelve el número de niveles que se pierden cuando a un jugador
     * se le aplica este mal rollo.
     * @return 0. Este tipo de mal rollo no implica nunca pérdida de niveles
     */
    @Override
    public int getLevels(){
        return 0;
    }

}
