/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.memorygame;

import memorygame.memorygame.domain.Pelaaja;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author okpiok
 */
/*
 * Muistipelin tilasto, jossa luodaan lista pelaajista. Tilastossa on aina 3 parasta tulosta kerrallaan.
 */
public class Pelitilasto { // lisää metodi järjestä lista!!!!!

    String nimi;
    List<Pelaaja> tilasto;

    public Pelitilasto(String nimi) {
        this.nimi = nimi;
        this.tilasto = new ArrayList<>();
    }

    public String getNimi() {
        return this.nimi;
    }

    /**
     * Metodi tallentaa pelaajan pelitilastoon.
     *
     * @param pelaaja Pelin pelaaja
     */
    public void tallennaTilastoon(Pelaaja pelaaja) {
        if (tilasto.size() <= 3) {
            tilasto.add(pelaaja);
        }
        jarjetaTilasto();
    }

    /**
     * Metodi tyhjentää pelitilaston eli poistaa kaikki pelaajat listasta.
     *
     */
    public void tyhjennaTilasto() {
        tilasto.clear();
    }

    /**
     * Metodi palautta listan tilastossa olevista pelaajista.
     *
     * @return lista pelaajista
     */
    public List<Pelaaja> haeTilastolista() {
        return this.tilasto;
    }

    /**
     * Metodi tulostaa pelitilaston.
     *
     */
    public void tulostaTilasto() {
        for (int i = 0; i < tilasto.size(); i++) {
            System.out.println(tilasto.get(i));

        }
    }

    public Pelaaja palautaPelaajaTilastosta(int indeksi) {
        return this.tilasto.get(indeksi);
    }

    public void jarjetaTilasto() {
//        int luku = 0;
//        List<Pelaaja> apulista = new ArrayList<>();
//        int ekanPisteet =this.tilasto.get(0).getPisteet();
//        int tokanPisteet = this.tilasto.get(1).getPisteet();
//        int kolmannenPisteet = this.tilasto.get(2).getPisteet();
//          int suuri = Math.max(ekanPisteet, tokanPisteet);
//        int suurempi = Math.max(suuri,kolmannenPisteet);
//        
//        for (Pelaaja pelaaja : apulista) {
//            System.out.println(pelaaja);
//        }
    }

}
