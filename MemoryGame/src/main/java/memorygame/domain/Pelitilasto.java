/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        this.tilasto.add(pelaaja);
        jarjestaTilasto();
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
    public void jarjestaTilasto() {
        Collections.sort(this.tilasto);
    }

}
