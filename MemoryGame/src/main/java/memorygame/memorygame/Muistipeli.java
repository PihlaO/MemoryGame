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
import memorygame.memorygame.valikot.AloitusKayttoliittyma;

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
    Pelitilasto tilasto;
    Korttipakka korttipakka;
    Kayttoliittyma kayttoliittyma;
    AloitusKayttoliittyma aloituskali;

    public Muistipeli(int vaikeustaso, Pelaaja pelaaja, AloitusKayttoliittyma aloituskali) {
        this.korttipakka = new Korttipakka(vaikeustaso);
        this.pelilauta = new Pelilauta(this.korttipakka);
        this.pelaaja = pelaaja;
        this.aloituskali = aloituskali;
        tilastonValinta(vaikeustaso, aloituskali);

    }

    /**
     * Metodi käynnistää muistipelin.
     *
     */
    public void kaynnista() {

        pelilauta.luoPakkaJaTaulukkoKorteista();
        this.kayttoliittyma = new Kayttoliittyma(this);
        SwingUtilities.invokeLater(kayttoliittyma);

    }

    public Pelilauta getPelilauta() {
        return this.pelilauta;
    }

    public Pelaaja getPelaaja() {
        return this.pelaaja;
    }

    public Kayttoliittyma getPelinKayttoliittyma() {
        return this.kayttoliittyma;
    }

    public AloitusKayttoliittyma getAloitusKayttoliittyma() {
        return this.aloituskali;
    }

    public Pelitilasto getPelitilasto() {
        return this.tilasto;
    }
    
    public Korttipakka getKorttipakka(){
        return this.korttipakka;
    }

    private void tilastonValinta(int vaikeustaso, AloitusKayttoliittyma aloituskali1) {
        if (vaikeustaso == 1) {
            this.tilasto = aloituskali1.getHelponTasonTilasto();
        }
        if (vaikeustaso == 2) {
            this.tilasto = aloituskali1.getKeskiTasonTilasto();
        }
        if (vaikeustaso == 3) {
            this.tilasto = aloituskali1.getVaikeanTasonTilasto();
        }
    }
}
