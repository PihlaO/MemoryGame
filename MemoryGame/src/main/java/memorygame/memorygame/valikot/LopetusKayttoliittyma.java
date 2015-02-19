/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.memorygame.valikot;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import memorygame.memorygame.Muistipeli;

/**
 *
 * @author okpiok
 */
public class LopetusKayttoliittyma implements Runnable {

    private JFrame frame;
    Muistipeli muistipeli;

    public LopetusKayttoliittyma(Muistipeli muistipeli) {
        this.muistipeli = muistipeli;
    }

    @Override
    public void run() {
        frame = new JFrame("Muistipeli");
        frame.setPreferredSize(new Dimension(300, 300));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(11, 1);
        container.setLayout(layout);

        JLabel teksti = new JLabel("Muistipeli päättyi");

//        JLabel tapahtuma = new JLabel("Peli päättyi");
        JLabel pisteesi = new JLabel("Pisteesi:");
        JLabel tulokset = new JLabel(muistipeli.getPelaaja().toString());
        JLabel tyhja1 = new JLabel("    ");
        JLabel tilastonListaus = new JLabel("Top 3 -tilasto:");
        JLabel eka = new JLabel("1. "+ muistipeli.getPelitilasto().palautaPelaajaTilastosta(0).toString());

        JLabel tyhja2 = new JLabel("   ");
        JButton uudelleen = new JButton("Pelaa uudestaan");

        container.add(teksti);
//        container.add(tapahtuma);
        container.add(tyhja1);
        container.add(pisteesi);
        container.add(tulokset);
        container.add(tyhja2);
        container.add(tilastonListaus);
        container.add(eka);
        if (muistipeli.getPelitilasto().haeTilastolista().size() == 2) {
            JLabel toka = new JLabel("2. " +muistipeli.getPelitilasto().palautaPelaajaTilastosta(1).toString());
            container.add(toka);
        }
        if (muistipeli.getPelitilasto().haeTilastolista().size() == 3) {
            JLabel toka = new JLabel("2. " +muistipeli.getPelitilasto().palautaPelaajaTilastosta(1).toString());
            container.add(toka);
            JLabel kolmas = new JLabel("3. " +muistipeli.getPelitilasto().palautaPelaajaTilastosta(2).toString());
            container.add(kolmas);
        }
//        
//       
        container.add(uudelleen);
        uudelleen.addActionListener(new PelinLopetuksenKuuntelija(uudelleen, this));

    }
    
    public JFrame getFrame(){
        return this.frame;
    }
}
