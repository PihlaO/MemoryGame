/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.memorygame.valikot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import memorygame.memorygame.Muistipeli;
import memorygame.memorygame.domain.Pelaaja;

/**
 *
 * @author okpiok
 */
public class PelinAloituksenKuuntelija implements ActionListener {

    private Pelaaja pelaaja;
    private JTextField nimiKentta;
    private JButton helppo;
    private JButton keskitaso;
    private JButton vaikea;
    AloitusKayttoliittyma aloituskali;

    public PelinAloituksenKuuntelija(JTextField nimiKentta, JButton helppo, JButton keskitaso, JButton vaikea, AloitusKayttoliittyma aloituskali) {
        this.nimiKentta = nimiKentta;
        this.helppo = helppo;
        this.keskitaso = keskitaso;
        this.vaikea = vaikea;
        this.aloituskali = aloituskali;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String teksti = nimiKentta.getText();
//        teksti.trim();

        if (!(teksti.length() < 13)) {
            return;
        } else {

            this.pelaaja = new Pelaaja(teksti);

        }
        luoJaKaynnistaPeli(e);

    }

    private void luoJaKaynnistaPeli(ActionEvent e) {
        if (e.getSource() == helppo) {
            luoJaKaynnistaHelppoPeli();
        }
        if (e.getSource() == keskitaso) {
            luoJaKaynnistaKeskitasonPeli();
        }

        if (e.getSource() == vaikea) {
            luoJaKaynnistaVaikeaPeli();
        }

    }

    private void luoJaKaynnistaVaikeaPeli() {
        Muistipeli m = new Muistipeli(3, this.pelaaja, this.aloituskali);
        m.kaynnista();
        this.aloituskali.getFrame().setVisible(false);

    }

    private void luoJaKaynnistaKeskitasonPeli() {
        Muistipeli m = new Muistipeli(2, this.pelaaja, this.aloituskali);
        m.kaynnista();
        this.aloituskali.getFrame().setVisible(false);
    }

    private void luoJaKaynnistaHelppoPeli() {

        Muistipeli m = new Muistipeli(1, this.pelaaja, this.aloituskali);
        m.kaynnista();
        this.aloituskali.getFrame().setVisible(false);

    }

}
