/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.memorygame.valikot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTextField;
import memorygame.memorygame.Muistipeli;
import memorygame.memorygame.domain.Pelaaja;
import memorygame.memorygame.kayttoliittyma.KuvallinenKortti;

/**
 *
 * @author okpiok
 */
public class PelinAloituksenKuuntelija implements ActionListener {

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

            Pelaaja pelaaja = new Pelaaja(teksti);
            luoJaKaynnistaPeli(e, pelaaja);
        }

    }

    private void luoJaKaynnistaPeli(ActionEvent e, Pelaaja pelaaja) {
        if (e.getSource() == helppo) {
            luoJaKaynnistaHelppoPeli(pelaaja);
        }
        if (e.getSource() == keskitaso) {
            luoJaKaynnistaKeskitasonPeli(pelaaja);
        }

        if (e.getSource() == vaikea) {
            luoJaKaynnistaVaikeaPeli(pelaaja);
        }

    }

    private void luoJaKaynnistaVaikeaPeli(Pelaaja pelaaja) {
        Muistipeli m = new Muistipeli(3, pelaaja, this.aloituskali, new ArrayList<KuvallinenKortti>());
        m.kaynnista();
        this.aloituskali.getFrame().setVisible(false);

    }

    private void luoJaKaynnistaKeskitasonPeli(Pelaaja pelaaja) {
        Muistipeli m = new Muistipeli(2, pelaaja, this.aloituskali, new ArrayList<KuvallinenKortti>());
        m.kaynnista();
        this.aloituskali.getFrame().setVisible(false);
    }

    private void luoJaKaynnistaHelppoPeli(Pelaaja pelaaja) {

        Muistipeli m = new Muistipeli(1, pelaaja, this.aloituskali, new ArrayList<KuvallinenKortti>());
        m.kaynnista();
        this.aloituskali.getFrame().setVisible(false);

    }

}
