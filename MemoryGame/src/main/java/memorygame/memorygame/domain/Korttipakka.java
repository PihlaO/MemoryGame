/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.memorygame.domain;

import memorygame.memorygame.domain.Kortti;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author okpiok
 */

/* 
 * Korttipakan luokka. Tässä luokassa luodaan korttipakka ja pelin vaikeustaso.
 */
public class Korttipakka {

    List<Kortti> pakka;
    Vaikeustaso vaikeustaso;

    public Korttipakka(int tunnus) {
        this.pakka = new ArrayList<>();
        this.vaikeustaso = new Vaikeustaso(tunnus);
    }

    /**
     * Metodi luo muistipelikortit ja tallentaa ne korttipakkaan.
     *
     */
    public void luoKortit() {
        int uniikkienKorttienLukumaara = 0;
        uniikkienKorttienLukumaara = this.haeVaikeustaso().haeKorttienLukumaara() / 2;
        for (int i = 1; i <= uniikkienKorttienLukumaara; i++) {
            Kortti kortti = new Kortti(i);
            this.pakka.add(kortti);
            Kortti kortinPari = new Kortti(i);
            this.pakka.add(kortinPari);

        }

    }

    /**
     * Metodi sekoittaa korttipakan.
     *
     */
    public void sekoitaPakka() {
        Collections.shuffle(pakka);

    }

    /**
     * Metodi palauttaa pelin vaikeustason
     *
     * @return pelin vaikeustaso
     */
    public Vaikeustaso haeVaikeustaso() {
        return this.vaikeustaso;
    }

    /**
     * Metodi palauttaa korttipakan eli listan korteista
     *
     * @return pelin korttipakka
     */
    public List<Kortti> haeKorttipakka() {
        return this.pakka;
    }
}
