/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.memorygame.valikot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

/**
 *
 * @author okpiok
 */
public class PelinLopetuksenKuuntelija implements ActionListener {

    JButton uudelleen;

    public PelinLopetuksenKuuntelija(JButton uudelleen) {
        this.uudelleen = uudelleen;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == uudelleen) {
            AloitusKayttoliittyma kayttoliittymaA = new AloitusKayttoliittyma();
            SwingUtilities.invokeLater(kayttoliittymaA);
        }
    }
}
