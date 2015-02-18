/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.memorygame.domain;


/**
 *
 * @author okpiok
 */
/* 
 * Luodaan korttipakka ja taulukko korteista. Lisäksi asetetaan korteille koordinaatit.
 */
public class Pelilauta {

    Korttipakka korttipakka;
    Kortti valittuKortti1;
    Kortti valittuKortti2;
    Kortti[][] TaulukkoKorteista;

    public Pelilauta(Korttipakka pakka) {
        this.korttipakka = pakka;
        this.TaulukkoKorteista = new Kortti[pelilaudanSarakkeidenLukumaara()][pelilaudanRivienLukumaara()];
    }

    /**
     * Metodi luo korttipakan ja taulukon korteille.
     *
     */
    public void luoPakkaJaTaulukkoKorteista() {
        this.luoPakka();
        this.luoTaulukkoKorteilla();
    }

    /**
     * Metodi luo korttipakan.
     *
     */
    public void luoPakka() {
        this.korttipakka.luoKortit();
        korttipakka.sekoitaPakka();
    }

    /**
     * Metodi luo taulukon korteille.
     *
     */
    public void luoTaulukkoKorteilla() {
        asetaKorttiTaulukkoon();
        this.AsetaPakanKorteilleKoordinaatit();
    }

    public Kortti[][] getTaulukkoKorteista() {
        return this.TaulukkoKorteista;
    }

    /**
     * Metodi asettaa kortit taulukkoon.
     *
     */
    public void asetaKorttiTaulukkoon() {
        int kortinIndeksiPakassa = 0;
        for (int i = 0; i < pelilaudanSarakkeidenLukumaara(); i++) {

            for (int j = 0; j < pelilaudanRivienLukumaara(); j++) {
                TaulukkoKorteista[i][j] = korttipakka.pakka.get(kortinIndeksiPakassa);
                kortinIndeksiPakassa++;
            }

        }
    }

    /**
     * Metodi asettaa korteille koordinaatit.
     *
     */
    public void AsetaPakanKorteilleKoordinaatit() {
        for (Kortti kortti : this.korttipakka.haeKorttipakka()) {
            AsetaKortilleKoordinaatit(kortti);
        }

    }

    /**
     * Metodi asettaa yksittäiselle kortille koordinaatit.
     *
     */
    public void AsetaKortilleKoordinaatit(Kortti kortti) {
        for (int i = 0; i < this.pelilaudanSarakkeidenLukumaara(); i++) {
            for (int j = 0; j < pelilaudanRivienLukumaara(); j++) {
                if (kortti.equals(this.getKorttiXY(i, j))) {
                    kortti.setX(i);
                    kortti.setY(j);
                }

            }
        }
    }

    public void tulostaPelilauta() {
        for (int i = 0; i < this.pelilaudanSarakkeidenLukumaara(); i++) {
            for (int j = 0; j < pelilaudanRivienLukumaara(); j++) {
                System.out.println(this.getKorttiXY(i, j));

            }

        }

    }

    public int pelilaudanSarakkeidenLukumaara() {
        return 4;
    }

    public int pelilaudanRivienLukumaara() {
        return korttipakka.vaikeustaso.haeKorttienLukumaara() / 4;
    }

    public Kortti getKorttiXY(int x, int y) {
        return this.TaulukkoKorteista[x][y];
    }

    public Korttipakka getKorttipakka() {
        return this.korttipakka;
    }

    public void setValittuKortti1(Kortti k) {
        this.valittuKortti1 = k;
    }

    public Kortti getValittuKortti1() {
        return this.valittuKortti1;
    }

    public Kortti getValittuKortti2() {
        return this.valittuKortti2;
    }

    public void setValittuKortti2(Kortti k) {
        this.valittuKortti2 = k;
    }
    


}
