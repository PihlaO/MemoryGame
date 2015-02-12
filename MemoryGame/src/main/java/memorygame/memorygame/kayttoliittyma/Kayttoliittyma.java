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
import javax.swing.JButton;
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
    Pelilauta pelilauta;

    public Kayttoliittyma(Pelilauta pelilauta) {
        this.pelilauta = pelilauta;
    }

    @Override
    public void run() {
        frame = new JFrame("Muistipeli");
        frame.setPreferredSize(new Dimension(600, 600));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        Piirtoalusta piirtoalusta = new Piirtoalusta(this.pelilauta);
        container.add(piirtoalusta);
        frame.addMouseListener(new Kuuntelija(piirtoalusta, pelilauta, piirtoalusta.haeKuvallisetKortit())); /// Mihin kuuntelija? Yksi kaikkiin kuviin.
    }

}
