/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.memorygame;

import memorygame.memorygame.kayttoliittymat.Kayttoliittyma;
import javax.swing.SwingUtilities;

/**
 *
 * @author okpiok
 */
public class Paaohjelma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Korttipakka korttipakka = new Korttipakka(1);
        Pelilauta pelilauta = new Pelilauta(korttipakka);
        pelilauta.luoPelilauta();
        pelilauta.tulostaPelilauta();
        //for(Kortti k : korttipakka.pakka){
        //    System.out.println(k);
        //}
        
        //pelilauta.muistikortitkortit[0][0] = korttipakka.pakka.get(0);
        //System.out.println(pelilauta.muistikortitkortit[0][0]);
        //System.out.println(pelilauta.muistikortitkortit[0][1]);
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
        SwingUtilities.invokeLater(kayttoliittyma);
    }

}
