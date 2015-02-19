/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.memorygame;

import javax.swing.SwingUtilities;
import memorygame.memorygame.domain.Korttipakka;
import memorygame.memorygame.domain.Pelaaja;
import memorygame.memorygame.domain.Pelilauta;
import memorygame.memorygame.domain.Vaikeustaso;
import memorygame.memorygame.kayttoliittyma.Kayttoliittyma;

/**
 *
 * @author okpiok
 */
/*
 * Muistipeli
 */
public class Muistipeli {
    
    Pelilauta pelilauta;
    Pelaaja pelaaja;
    Vaikeustaso taso;
    Kayttoliittyma kayttoliittyma;
    Pelitilasto tilasto;
    
    public Muistipeli(int vaikeustaso, Pelaaja pelaaja) {
        this.pelilauta = new Pelilauta(new Korttipakka(vaikeustaso));
        this.tilasto = new Pelitilasto("Top 5:");
        this.pelaaja = pelaaja;
        taso = new Vaikeustaso(vaikeustaso);
    }

    /**
     * Metodi käynnistää muistipelin.
     *
     */
    public void kaynnista() {
        pelilauta.luoPakkaJaTaulukkoKorteista();
        
        this.kayttoliittyma = new Kayttoliittyma(this);
        SwingUtilities.invokeLater(kayttoliittyma);
        tilasto.tallennaTilastoon(new Pelaaja("Pekka"));
        tilasto.tallennaTilastoon(new Pelaaja("Anna"));
        tilasto.tulostaTilasto();
    }
    
    public Pelilauta getPelilauta() {
        return this.pelilauta;
    }
    
    public Pelaaja getPelaaja() {
        return this.pelaaja;
    }
    
    public Vaikeustaso getTaso() {
        return this.taso;
    }
    
    public Kayttoliittyma getKayttoliittyma() {
        return this.kayttoliittyma;
    }
    
    public Pelitilasto getPelitilasto() {
        return this.tilasto;
    }
}
