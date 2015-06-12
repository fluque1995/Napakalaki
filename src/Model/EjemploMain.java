
package Model;

import GUI.NapakalakiView;
import GUI.PlayerNamesCapture;
import Test.GameTester;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EjemploMain {

    public static void main(String[] args){
        
        Napakalaki napakalakiModel = Napakalaki.getInstance();
        NapakalakiView napakalakiView = new NapakalakiView();
        ArrayList<String> names = new ArrayList();
        
        PlayerNamesCapture namesCapture = new PlayerNamesCapture(napakalakiView, true);
        names = namesCapture.getNames();
        
        if(names.isEmpty()){
            JOptionPane.showMessageDialog(napakalakiView,"Debes cambiar el nombre de al menos un jugador,\n"
                    + "si no no puede iniciarse el juego");
            System.exit(0);
        }
        
        Dice.createInstance(napakalakiView);
        
        napakalakiModel.initGame(names);
        napakalakiView.setNapakalaki(napakalakiModel);
        napakalakiView.showView();
    
    }
}
