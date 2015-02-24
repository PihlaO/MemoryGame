/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.memorygame.valikot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author okpiok
 */
public class PelinLopetuksenKuuntelija implements ActionListener {

    JButton uudelleen;
    LopetusKayttoliittyma lopetuskali;
    AloitusKayttoliittyma aloituskali;

    public PelinLopetuksenKuuntelija(JButton uudelleen, LopetusKayttoliittyma lopetuskali, AloitusKayttoliittyma aloituskali) {
        this.uudelleen = uudelleen;
        this.lopetuskali = lopetuskali;
        this.aloituskali = aloituskali;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == uudelleen) {

            this.aloituskali.getFrame().setVisible(true);
            lopetuskali.getFrame().setVisible(false);
        }
    }
}
