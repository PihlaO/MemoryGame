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
        
          
        Pelitilasto helppoTasoTilasto = new Pelitilasto("top 3");
        Pelitilasto keskiTasoTilasto = new Pelitilasto("top 3");
        Pelitilasto vaikeaTasoTilasto = new Pelitilasto("top 3");
   
        AloitusKayttoliittyma kayttoliittymaA = new AloitusKayttoliittyma(helppoTasoTilasto,keskiTasoTilasto, vaikeaTasoTilasto);
        SwingUtilities.invokeLater(kayttoliittymaA);

    }



}
