/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.memorygame;

import javax.swing.SwingUtilities;
import memorygame.memorygame.domain.HelppoTaso;
import memorygame.memorygame.domain.Kortti;
import memorygame.memorygame.domain.Korttipakka;
import memorygame.memorygame.domain.Pelilauta;
import memorygame.memorygame.kayttoliittyma.Kayttoliittyma;

/**
 *
 * @author okpiok
 */
public class Paaohjelma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Muistipeli peli = new Muistipeli(3);
        peli.kaynnista();
        
        
    }
}


