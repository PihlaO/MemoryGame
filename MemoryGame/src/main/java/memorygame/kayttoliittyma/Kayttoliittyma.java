/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import memorygame.logiikka.Muistipeli;

/**
 *
 * @author okpiok
 */
/*
 *Luodaan muistipelin käyttöliittymä.
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    Muistipeli muistipeli;
    Piirtoalusta piirtoalusta;

    public Kayttoliittyma(Muistipeli muistipeli) {
        this.muistipeli = muistipeli;
    }

    @Override
    public void run() {
        frame = new JFrame("Muistipeli");

        valitaanKayttoliittymanKoko();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Metodi asettaa käyttöliittymälle koon vaikeustason mukaan.
     *
     */
    private void valitaanKayttoliittymanKoko() {

        if (this.muistipeli.getPelilauta().getKorttipakka().haeVaikeustaso().getTasonTunnus() == 1) {
            frame.setPreferredSize(new Dimension(600, 600));
        }
        if (this.muistipeli.getPelilauta().getKorttipakka().haeVaikeustaso().getTasonTunnus() == 2) {
            frame.setPreferredSize(new Dimension(600, 650));
        }
        if (this.muistipeli.getPelilauta().getKorttipakka().haeVaikeustaso().getTasonTunnus() == 3) {
            frame.setPreferredSize(new Dimension(600, 750));
        }
    }

    /**
     * Metodi luo komponentit.
     *
     */
    private void luoKomponentit(Container container) {
        this.piirtoalusta = new Piirtoalusta(this.muistipeli);
        container.add(piirtoalusta);
        frame.addMouseListener(new Hiirikuuntelija(piirtoalusta));
    }

    public JFrame getFrame() {
        return frame;
    }

    public Piirtoalusta getPiirtoalusta() {
        return this.piirtoalusta;
    }
}
