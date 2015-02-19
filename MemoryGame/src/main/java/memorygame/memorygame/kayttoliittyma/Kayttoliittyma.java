/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.memorygame.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import memorygame.memorygame.Muistipeli;
import memorygame.memorygame.domain.Pelilauta;

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

    public Kayttoliittyma(Muistipeli muistipeli) {
        this.muistipeli = muistipeli;
    }

    @Override
    public void run() {
        frame = new JFrame("Muistipeli");
        frame.setPreferredSize(new Dimension(750, 750));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Metodi luo komponentit.
     *
     */
    private void luoKomponentit(Container container) {
        Piirtoalusta piirtoalusta = new Piirtoalusta(this.muistipeli);
        container.add(piirtoalusta);
        JLabel teksti = new JLabel("Muistipeli     " + "     Vaikeustaso: " + this.muistipeli.getTaso().toString() + "     Pelaaja: " + muistipeli.getPelaaja()); // EI PÄIVITÄ PISTEITÄ.
        container.add(teksti, BorderLayout.SOUTH);

        frame.addMouseListener(new Kuuntelija(piirtoalusta, muistipeli, piirtoalusta.haeKuvallisetKortit()));
    }

    public JFrame getFrame() {
        return frame;
    }
    
}
