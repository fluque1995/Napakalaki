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
        CardDealer dealer = CardDealer.getInstance();
        for(Treasure treasure: this.visibleTreasures){
            dealer.giveTreasureBack(treasure);
        }
        
        this.visibleTreasures.clear();
        
        for(Treasure treasure: this.hiddenTreasures){
            dealer.giveTreasureBack(treasure);
        }
        
        this.hiddenTreasures.clear();
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
        int nLevels = prize.getLevels();
        this.incrementLevels(nLevels);
        int nPrize = prize.getTreasures();
        CardDealer dealer = CardDealer.getInstance();
        
        for(int i=0; i<nPrize; i++){
            Treasure treasure = dealer.nextTreasure();
            this.hiddenTreasures.add(treasure);
        }
        
    }
    
    public CombatResult combat(Monster monster){
        CombatResult combatResult;
        int myLevel = this.getCombatLevel();
        int levelMonster = monster.getLevel();
        if(myLevel > levelMonster){
           Prize prize = monster.getPrize();
           this.applyPrize(prize);
           if(this.level < 10)
               combatResult = CombatResult.WIN;
           else{
               combatResult = CombatResult.WINANDWINGAME;
           }
        }
        else{
            Dice dice = Dice.getInstance();
            int escape = dice.nextNumber();
            
            if(escape < 5){
                BadConsequence bad = monster.getBadConsequence();
                boolean amIDead = bad.kills();
                
                if(amIDead == true){
                    this.die();
                    combatResult = CombatResult.LOSEANDDIE;
                }
                else{
                    this.applyBadConsequence(bad);
                    combatResult = CombatResult.LOSE;
                }
            }
            
            else{
                combatResult = CombatResult.LOSEANDESCAPE;
            }
        }
        this.discardNecklaceIfVisible();
        return combatResult;
    }
    
    public void applyBadConsequence(BadConsequence badConsequence){
        int nLevels = badConsequence.getLevels();
        this.decrementLevels(nLevels);
        BadConsequence pendingBad = 
                badConsequence.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures);
        
        this.setPendingBadConsequence(pendingBad);
        
    }
    
    public boolean makeVisibleTreasure(Treasure treasure){
        boolean canI = this.canMakeTreasureVisible(treasure);
        if(canI){
            this.visibleTreasures.add(treasure);
            this.hiddenTreasures.remove(treasure);
        }
        return canI;
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
        this.hiddenTreasures.remove(treasure);
        if((this.pendingBadConsequence != null) && (!this.pendingBadConsequence.isEmpty())){
            this.pendingBadConsequence.substractHiddenTreasure(treasure);
        }
        CardDealer dealer = CardDealer.getInstance();
        dealer.giveTreasureBack(treasure);
        this.dieIfNoTreasures();
    }
    
    public boolean buyLevels(ArrayList<Treasure> visibleTreasures, ArrayList<Treasure> hiddenTreasures){
        float levels = this.computeGoldCoinsValue(visibleTreasures);
        levels += this.computeGoldCoinsValue(hiddenTreasures);
        boolean canI = this.canIBuyLevels((int) levels);
        if(canI){
            this.incrementLevels((int) levels);
            for(Treasure treasure: visibleTreasures){
                this.discardVisibleTreasure(treasure);
            }
            for(Treasure treasure: hiddenTreasures){
                this.discardHiddenTreasure(treasure);
            }
        }
        
        return canI;
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
    
    public void initTreasures(){
        this.bringToLife();
        Dice dice = Dice.getInstance();
        int number = dice.nextNumber();
        CardDealer dealer = CardDealer.getInstance();
        if(number == 1){
            Treasure treasure = dealer.nextTreasure();
            this.hiddenTreasures.add(treasure);
        }
        else if(number < 6){
            for(int i=0; i<2; i++){
                Treasure treasure = dealer.nextTreasure();
                this.hiddenTreasures.add(treasure);
            }
        }
        else{
            for(int i=0; i<3; i++){
                Treasure treasure = dealer.nextTreasure();
                this.hiddenTreasures.add(treasure);
            }
        }
        
        
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
    
    public String getName(){
        return this.name;
    }
}
