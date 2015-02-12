/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.memorygame;

import javax.swing.SwingUtilities;
import memorygame.memorygame.domain.Korttipakka;
import memorygame.memorygame.domain.Pelilauta;
import memorygame.memorygame.kayttoliittyma.Kayttoliittyma;

/**
 *
 * @author okpiok
 */
/*
 * Muistipeli
 */
public class Muistipeli {

    /// Kokeilu

    Pelilauta pelilauta;

    public Muistipeli(int vaikeustaso) {
        this.pelilauta =  new Pelilauta(new Korttipakka(vaikeustaso));
    }

    public void kaynnista() {
        pelilauta.luoPakkaJaTaulukkoKorteista();

        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(pelilauta);
        SwingUtilities.invokeLater(kayttoliittyma);
    }

    public Pelilauta getPelilauta() {
        return this.pelilauta;
    }
}
