/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import memorygame.domain.Pelaaja;

/**
 *
 * @author okpiok
 */
/*
 * Muistipelin tilasto, jossa luodaan lista pelaajista.
 */
public class Pelitilasto {

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
        tilasto.add(pelaaja);
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
     * @return lista pelaajalista
     */
    public List<Pelaaja> haeTilastolista() {
        return this.tilasto;
    }

    /**
     * Metodi tulostaa pelitilaston.
     *
     */
    public void tulostaTilasto() {
        for (Pelaaja tilasto1 : this.tilasto) {
            System.out.println(tilasto1);
        }
    }

    /**
     * Metodi palauttaa pelaajan listasta indeksin perusteella.
     *
     * @param indeksi pelaajan sijainti listalla
     * @return Pelaaja
     *
     */
    public Pelaaja palautaPelaajaTilastosta(int indeksi) {
        return this.tilasto.get(indeksi);
    }

    /**
     * Metodi järjetää listan.
     */
    public void jarjetaTilasto() {
        Collections.sort(this.tilasto);
    }

}