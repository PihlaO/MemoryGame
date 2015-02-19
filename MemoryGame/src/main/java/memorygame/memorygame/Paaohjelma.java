/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.memorygame;

import javax.swing.SwingUtilities;
import memorygame.memorygame.domain.Pelaaja;

import memorygame.memorygame.valikot.AloitusKayttoliittyma;
import memorygame.memorygame.valikot.LopetusKayttoliittyma;

/**
 *
 * @author okpiok
 */
public class Paaohjelma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        Muistipeli peli = new Muistipeli(3, new Pelaaja("Anna"));
//        Pelaaja p = new Pelaaja("antti");
//        Pelaaja p1 = new Pelaaja("antti1");
//        Pelaaja p2 = new Pelaaja("antti2");
//        peli.tilasto.tallennaTilastoon(p);
//        peli.tilasto.tallennaTilastoon(p1);
//        peli.tilasto.tallennaTilastoon(p2);
//
//        LopetusKayttoliittyma lopetus = new LopetusKayttoliittyma(peli);
//        SwingUtilities.invokeLater(lopetus);

//        AloitusKayttoliittyma kayttoliittymaA = new AloitusKayttoliittyma();
//        SwingUtilities.invokeLater(kayttoliittymaA);
        
        Muistipeli peli = new Muistipeli(1, new Pelaaja("pelaajan nimi"));
        peli.kaynnista();
//          Pelitilasto tilasto = new Pelitilasto("top");
//        Pelaaja p = new Pelaaja("antti");
//        Pelaaja p1 = new Pelaaja("antti1");
//        Pelaaja p2 = new Pelaaja("antti2");
//        tilasto.tallennaTilastoon(p);
//        tilasto.tallennaTilastoon(p1);
//        tilasto.tallennaTilastoon(p2);
//        System.out.println(tilasto.palauta3parasta());
    }
}
