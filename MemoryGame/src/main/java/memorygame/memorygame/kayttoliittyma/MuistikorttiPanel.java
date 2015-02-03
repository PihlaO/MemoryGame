/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.memorygame.kayttoliittyma;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;


/**
 *
 * @author okpiok
 */
public class MuistikorttiPanel extends JPanel {

    public MuistikorttiPanel() {
        super(new GridLayout(2, 2));
        luoKomponentit();
    }

    private void luoKomponentit() {
        
        add(new JButton(""));
        add(new JButton(""));
        add(new JButton(""));
        add(new JButton(""));
        


    }

}
