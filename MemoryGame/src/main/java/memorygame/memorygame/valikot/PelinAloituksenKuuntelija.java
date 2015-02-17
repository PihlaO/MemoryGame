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

    public PelinAloituksenKuuntelija(JTextField nimiKentta, JButton helppo, JButton keskitaso, JButton vaikea) {
        this.nimiKentta = nimiKentta;
        this.helppo = helppo;
        this.keskitaso = keskitaso;
        this.vaikea = vaikea;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        this.pelaaja = new Pelaaja(nimiKentta.getText());

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
        Muistipeli m = new Muistipeli(3);
        m.kaynnista();
//            System.out.println("v");
    }

    private void luoJaKaynnistaKeskitasonPeli() {
        //            System.out.println("k");
        Muistipeli m = new Muistipeli(2);
        m.kaynnista();
    }

    private void luoJaKaynnistaHelppoPeli() {
        //            System.out.println("h");
        Muistipeli m = new Muistipeli(1);
        m.kaynnista();
    }

}
