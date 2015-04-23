/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author paco
 */
public class Player {
    
    ////////////////////////////////////////////////////////////////////////////
    //                                                                        //
    //                               Attributes                               //
    //                                                                        //    
    ////////////////////////////////////////////////////////////////////////////

    private boolean dead;
    private String name;
    private int level;
    
    private static final int MAXHIDDENTREASURES = 4;
    
    private ArrayList<Treasure> hiddenTreasures;
    private ArrayList<Treasure> visibleTreasures;
    private BadConsequence pendingBadConsequence;

    ////////////////////////////////////////////////////////////////////////////
    //                                                                        //
    //                             Private methods                            //
    //                                                                        //    
    ////////////////////////////////////////////////////////////////////////////

    /**
     * Revive the player
     */
    private void bringToLife(){
        this.dead = false;
    }
    
    /**
     * Increment the player level
     * @param levels Incremented levels
     */
    private void incrementLevels(int levels){
        this.level += levels;
        if (this.level > 10){
            this.level = 10;
        }
    }
    
    /**
     * Decrement the player level
     * @param levels Decremented levels
     */
    private void decrementLevels(int levels){
        this.level -= levels;
        if (this.level < 1){
            this.level = 1;
        }
    }
    
    /**
     * BadConsequence setter
     * @param badConsequence Bad consequence to be set 
     */
    private void setPendingBadConsequence(BadConsequence badConsequence){
        this.pendingBadConsequence = badConsequence;
    }
    
    /**
     * The player dies
     */
    private void die(){
        this.dead = true;
    }
    
    /**
     * Make the player discard necklace. 
     */
    private void discardNecklaceIfVisible(){
        CardDealer cardDealer = CardDealer.getInstance();
        for (Treasure t: this.visibleTreasures){
            if (t.getType() == TreasureKind.NECKLACE){
                cardDealer.giveTreasureBack(t);
                this.visibleTreasures.remove(t);
            }
        }
        
        
      
    }
    
    /**
     * Kill the player if he had no treasures. Player cannot stay alive w/out
     * treasures, so he's killed and he will get new treasures when revive
     */
    private void dieIfNoTreasures(){
        if(this.hiddenTreasures.isEmpty() && this.visibleTreasures.isEmpty()){
            this.dead = true;
        }
    }
    
    /**
     * Test if player can buy levels or not
     * @param levels Number of levels the player wants to buy
     * @return True if it's possible to buy them, false if not
     */
    private boolean canIBuyLevels(int levels){
        return (this.level + levels < 10);
    }
    
    ////////////////////////////////////////////////////////////////////////////
    //                                                                        //
    //                             Public methods                             //
    //                                                                        //    
    ////////////////////////////////////////////////////////////////////////////
    
    /**
     * Computa el valor en monedas de oro de un array de tesoros que se pasa como
     * argumento. Este valor se utiliza después para ver el número de niveles que
     * puede comprar el jugador. Puede comprar un nivel por cada 1000 monedas de oro
     * @param treasures Tesoros que quiere vender
     * @return Valor en monedas de oro del array de tesoros
     */
    protected float computeGoldCoinsValue(ArrayList<Treasure> treasures){
        float totalLevels = 0;
        for (Treasure t: treasures){
            totalLevels += t.getGoldCoins();
        }
        return totalLevels/(float)1000;
    }
    
    public void applyPrize(Prize prize){
        
    }
    
    public CombatResult combat(Monster monster){
        
    }
    
    public void applyBadConsequence(BadConsequence badConsequence){
        
    }
    
    public boolean makeVisibleTreasure(Treasure treasure){
        
    }
    
    /**
     * Comprueba si el jugador reúne las condiciones necesarias para convertir en
     * visible el tesoro que se pasa como argumento.
     * @param treasure Tesoro que se quiere convertir en visible
     * @return True si se puede convertir en visible, false en caso contrario
     */
    public boolean canMakeTreasureVisible(Treasure treasure){
        TreasureKind treasureType = treasure.getType();
        boolean allowed = true;
        
        if(treasureType == TreasureKind.BOTHHANDS){
            for(Treasure t: this.visibleTreasures){
                if(t.getType() == TreasureKind.BOTHHANDS || t.getType() == TreasureKind.ONEHAND){
                    allowed = false;
                }
            }
        } else if(treasureType == TreasureKind.ONEHAND && allowed){
            int count = 0;
            for(Treasure t: this.visibleTreasures){
                if(t.getType() == TreasureKind.ONEHAND){
                    count += 1;
                }
                
                if(t.getType() == TreasureKind.BOTHHANDS || (t.getType() == TreasureKind.ONEHAND && count > 1)){
                    allowed = false;
                }
            }
            
        } else if (allowed){
            for (Treasure t: this.visibleTreasures){
                if(t.getType() == treasureType){
                    allowed = false;
                }
            }
        }
        return allowed;
    }
    
    public void discardVisibleTreasure(Treasure treasure){
        this.visibleTreasures.remove(treasure);
        if((this.pendingBadConsequence != null) && (!this.pendingBadConsequence.isEmpty())){
            this.pendingBadConsequence.substractVisibleTreasure(treasure);
        }
        CardDealer dealer = CardDealer.getInstance();
        dealer.giveTreasureBack(treasure);
        this.dieIfNoTreasures();
        
    }
    
    public void discardHiddenTreasure(Treasure treasure){
        
    }
    
    public boolean buyLevels(ArrayList<Treasure> hiddenTreasures, ArrayList<Treasure> visibleTreasures){
        
    }
    
    /**
     * Getter para el nivel de combat del jugador. Este nivel se computa como el
     * nivel real del jugador más los niveles que le otorguen los bonus de los 
     * tesoros visibles que lleve.
     * @return Nivel total de combate del jugador
     */
    public int getCombatLevel(){
        int combatLevel = this.level;
        boolean hasNecklace = false;
        
        for (Treasure t: this.visibleTreasures){
            if (t.getType() == TreasureKind.NECKLACE){
                hasNecklace = true;
            }
        }
        
        if(hasNecklace){
            for (Treasure t: this.visibleTreasures){
                combatLevel += t.getMaxBonus();
            }
        } else {
            for (Treasure t: this.visibleTreasures){
                combatLevel += t.getMinBonus();
            }
        }
        
        return combatLevel;
    }
    
    /**
     * Comprueba si el estado del jugador es consistente como para que el jugador
     * termine su turno.
     * @return True si el jugador está en un estado válido, false en caso contrario
     */
    public boolean validState(){
        return this.pendingBadConsequence.isEmpty() &&
                this.hiddenTreasures.size() <= MAXHIDDENTREASURES;
    }
    
    public boolean initTreasures(){
        
    }
    
    /**
     * Método que comprueba si el jugador está muerto.
     * @return True si lo está, false en caso contrario
     */
    public boolean isDead(){
        return this.dead;
    }
    
    /**
     * Comprueba si el jugador tiene algún tesoro visible.
     * @return True si lo tiene, false en caso contrario
     */
    public boolean hasVisibleTreasures(){
        return !this.visibleTreasures.isEmpty();
    }
    
    /**
     * Constructor del jugador. Inicializa al jugador a un estado válido, con el
     * que inicia la partida.
     * @param name Nombre del jugador en la partida
     */
    public Player(String name){
        this.name = name;
        this.level = 1;
        this.dead = true;
    }
    
    /**
     * Getter para el array de tesoros visibles. 
     * @return Array de tesoros visibles
     */
    public ArrayList<Treasure> getVisibleTreasures(){
        return this.visibleTreasures;
    }
    
    /**
     * Getter para el array de tesoros ocultos.
     * @return Array de tesoros ocultos
     */
    public ArrayList<Treasure> getHiddenTreasures(){
        return this.hiddenTreasures;
    }
}
