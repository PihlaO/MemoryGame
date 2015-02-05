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
        Pelilauta pelilauta = new Pelilauta(new Korttipakka(1));
        pelilauta.luoPakkaJaTaulukkoKorteista();
        
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(pelilauta);
        SwingUtilities.invokeLater(kayttoliittyma);

        //Korttipakka korttipakka = new Korttipakka(1);
        // Pelilauta pelilauta = new Pelilauta(korttipakka);
        //pelilauta.luoPelilauta();
        // pelilauta.tulostaPelilauta();
        //Kortti k = pelilauta.getKorttiXY(2,1);
        // System.out.println(k.getX());
        // System.out.println(k.getY());
       // for (int i = 0; i < pelilauta.pelilaudanRivienLukumaara(); i++) {
        //   for (int j = 0; j < pelilauta.pelilaudanSarakkeidenLukumaara(); j++) {
        //        System.out.println(pelilauta.getKorttiXY(i, j));
        //        }
        //    }
        //System.out.println("");
        // System.out.println(k);
        //}
        //for(Kortti k : korttipakka.pakka){
        //    System.out.println(k);
        //}
        //pelilauta.muistikortitkortit[0][0] = korttipakka.pakka.get(0);
        //System.out.println(pelilauta.muistikortitkortit[0][0]);
        //System.out.println(pelilauta.muistikortitkortit[0][1]);
    }
}
