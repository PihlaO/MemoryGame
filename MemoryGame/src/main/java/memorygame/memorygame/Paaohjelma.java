/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.memorygame;

import javax.swing.SwingUtilities;

import memorygame.memorygame.valikot.AloitusKayttoliittyma;

/**
 *
 * @author okpiok
 */
public class Paaohjelma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AloitusKayttoliittyma kayttoliittyma = new AloitusKayttoliittyma();
        SwingUtilities.invokeLater(kayttoliittyma);
//        Muistipeli peli = new Muistipeli(1);
//        peli.kaynnista();

    }
}
