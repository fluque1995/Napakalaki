/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.CombatResult;
import Model.Napakalaki;

/**
 *
 * @author paco
 */
public class NapakalakiView extends javax.swing.JFrame {
    
    /**
     * Creates new form NapakalakiView
     */
    public NapakalakiView() {
        initComponents();
        this.setTitle("Napakalaki");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        monsterView = new GUI.MonsterView();
        resultLabel = new javax.swing.JLabel();
        combatResult = new javax.swing.JLabel();
        meetMonsterButton = new javax.swing.JButton();
        combatButton = new javax.swing.JButton();
        nextTurnButton = new javax.swing.JButton();
        playerView = new GUI.PlayerView();
        jScrollPane1 = new javax.swing.JScrollPane();
        noNextTurnMessage = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        resultLabel.setText("Resultado del combate:");

        combatResult.setText("combatResult");

        meetMonsterButton.setText("Meet the monster");
        meetMonsterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meetMonsterButtonActionPerformed(evt);
            }
        });

        combatButton.setText("Attack!");
        combatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combatButtonActionPerformed(evt);
            }
        });

        nextTurnButton.setText("Next turn");
        nextTurnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextTurnButtonActionPerformed(evt);
            }
        });

        playerView.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        noNextTurnMessage.setColumns(20);
        noNextTurnMessage.setRows(5);
        noNextTurnMessage.setText("No puedes pasar al siguiente turno porque te quedan\ncondiciones por cumplir:\n - No has cumplido el mal rollo que te corresponde\n - Tienes más de cuatro tesoros ocultos");
        noNextTurnMessage.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setViewportView(noNextTurnMessage);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(meetMonsterButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(combatButton)
                        .addGap(274, 274, 274)
                        .addComponent(nextTurnButton))
                    .addComponent(playerView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(monsterView, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                    .addComponent(combatResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(resultLabel)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(monsterView, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(resultLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combatResult)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(playerView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nextTurnButton)
                        .addContainerGap(31, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combatButton)
                            .addComponent(meetMonsterButton))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void meetMonsterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meetMonsterButtonActionPerformed
        this.monsterView.setVisible(true);
        this.monsterView.setMonster(this.napakalakiModel.getCurrentMonster());
        this.monsterView.setLevelDisplay(this.napakalakiModel.getCurrentPlayer());
        this.meetMonsterButton.setEnabled(false);
        this.combatButton.setEnabled(true);
        
        this.playerView.setEnabledMakeVisibleButton(false);
        this.playerView.setEnabledBuyLevelsButton(false);
        this.playerView.setEnabledDiscardTreasuresButton(false);

        this.repaint();
    }//GEN-LAST:event_meetMonsterButtonActionPerformed

    private void combatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combatButtonActionPerformed
        
        this.result = this.napakalakiModel.combat();
        
        String resultText = null;
        
        switch (result) {
            case WINANDWINGAME : 
              resultText = "¡¡¡ H A S   G A N A D O   L A   P A R T I D A !!!";
              break;
            case WIN :
              resultText = "Ganaste el combate";
              break;
            case LOSE :
              resultText = "Has perdido el combate, te toca cumplir el mal rollo";
              break;
            case LOSEANDESCAPE :
              resultText = "Perdiste el combate pero has logrado escapar";
              break;
            case LOSEANDDIE :
              resultText = "Perdiste el combate y además estás muerto";
              break;
            case LOSEANDCONVERT :
              resultText = "Perdiste el combate pero te conviertes en sectario";
              break;
        }
        this.combatResult.setText(resultText);
        this.playerView.setPlayer(this.napakalakiModel.getCurrentPlayer());
        this.resultLabel.setVisible(true);
        this.combatResult.setVisible(true);
        this.combatButton.setEnabled(false);
        this.nextTurnButton.setEnabled(true);
        
        this.playerView.setEnabledMakeVisibleButton(true);
        this.playerView.setEnabledDiscardTreasuresButton(true);
        
    }//GEN-LAST:event_combatButtonActionPerformed

    private void nextTurnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextTurnButtonActionPerformed
        
        if(this.result != CombatResult.WINANDWINGAME){
            if(this.napakalakiModel.nextTurn()){
                this.setNapakalaki(this.napakalakiModel);
            }else{
                this.noNextTurnMessage.setVisible(true);
                this.noNextTurnMessage.setEditable(false);
            }
        }else{
            System.exit(0);
        }
    }//GEN-LAST:event_nextTurnButtonActionPerformed

   public void showView(){
       this.setVisible(true);
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton combatButton;
    private javax.swing.JLabel combatResult;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton meetMonsterButton;
    private GUI.MonsterView monsterView;
    private javax.swing.JButton nextTurnButton;
    private javax.swing.JTextArea noNextTurnMessage;
    private GUI.PlayerView playerView;
    private javax.swing.JLabel resultLabel;
    // End of variables declaration//GEN-END:variables
    private Napakalaki napakalakiModel;
    CombatResult result;

    public void setNapakalaki(Napakalaki napakalaki){
        
        this.napakalakiModel = napakalaki;
        this.playerView.setPlayer(this.napakalakiModel.getCurrentPlayer());
        this.playerView.setNapakalaki(this.napakalakiModel);
        this.monsterView.setVisible(false);
        this.resultLabel.setVisible(false);
        this.combatResult.setVisible(false);
        this.noNextTurnMessage.setVisible(false);
        this.combatButton.setEnabled(false);
        this.nextTurnButton.setEnabled(false);
        this.meetMonsterButton.setEnabled(true);
        
        this.playerView.setEnabledBuyLevelsButton(true);
        this.playerView.setEnabledMakeVisibleButton(true);
        this.playerView.setEnabledDiscardTreasuresButton(true);
        
        repaint();
    }
}
