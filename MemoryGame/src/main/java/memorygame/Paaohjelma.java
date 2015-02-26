/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame;

import memorygame.domain.Pelitilasto;
import javax.swing.SwingUtilities;
import memorygame.kayttoliittyma.valikot.AloitusKayttoliittyma;

/**
 *
 * @author okpiok
 */
public class Paaohjelma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
          
        Pelitilasto helppoTasoTilasto = new Pelitilasto("Helpon tason top 3 -tilasto:");
        Pelitilasto keskiTasoTilasto = new Pelitilasto("Keskitason top 3 -tilasto:");
        Pelitilasto vaikeaTasoTilasto = new Pelitilasto("Vaikean tason top 3 -tilasto:");

        AloitusKayttoliittyma kayttoliittymaA = new AloitusKayttoliittyma(helppoTasoTilasto,keskiTasoTilasto, vaikeaTasoTilasto);
        SwingUtilities.invokeLater(kayttoliittymaA);

    }



}
