/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.memorygame;

import java.util.List;
import javax.swing.SwingUtilities;
import memorygame.memorygame.domain.Kortti;
import memorygame.memorygame.domain.Korttipakka;
import memorygame.memorygame.domain.Pelaaja;
import memorygame.memorygame.domain.Pelilauta;
import memorygame.memorygame.kayttoliittyma.Kayttoliittyma;
import memorygame.memorygame.kayttoliittyma.KuvallinenKortti;
import memorygame.memorygame.valikot.AloitusKayttoliittyma;
import memorygame.memorygame.valikot.LopetusKayttoliittyma;

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
    Kayttoliittyma kayttoliittyma;
    AloitusKayttoliittyma aloituskali;
    List<KuvallinenKortti> kuvallisetKortit;
    List<Kortti> kokeilu;

    public Muistipeli(int vaikeustaso, Pelaaja pelaaja, AloitusKayttoliittyma aloituskali, List<KuvallinenKortti> kuvallisetKortit) {

        this.pelilauta = new Pelilauta(new Korttipakka(vaikeustaso));
        this.pelaaja = pelaaja;
        this.aloituskali = aloituskali;
        this.kuvallisetKortit = kuvallisetKortit;
        this.tilasto= valitunVaikeustasonTilasto(vaikeustaso, aloituskali);
        this.kokeilu= this.pelilauta.getKorttipakka().haeKorttipakka();

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


    public List<KuvallinenKortti> getKuvallisetKortit() {
        return this.kuvallisetKortit;
    }

    private Pelitilasto valitunVaikeustasonTilasto(int vaikeustaso, AloitusKayttoliittyma aloituskali1) {
        if (vaikeustaso == 1) {
            return aloituskali1.getHelponTasonTilasto();
        }
        if (vaikeustaso == 2) {
            return aloituskali1.getKeskiTasonTilasto();
        } else {
            return aloituskali1.getVaikeanTasonTilasto();
        }
    }

    public void ValitaanTokaksiKortiksi(Kortti kortti) {
        this.getPelilauta().setValittuKortti2(kortti);

    }

    public void ValitaanEkaksiKortiksi(Kortti kortti) {
        this.getPelilauta().setValittuKortti1(kortti);
    }

    public boolean PelilaudanEkaKorttiValittu() {
        return !(this.getPelilauta().getValittuKortti1() == null);
    }

    public boolean PelilaudanTokaKorttiValittu() {
        return !(this.getPelilauta().getValittuKortti2() == null);
    }

    /**
     * Metodi pelilaudanKortitValittu palauttaa true, jos Pelilaudan kortti1 ja
     * kortti 2 on valittu ja muulloin false.
     *
     * @return boolean
     */
    public boolean pelilaudanKortitValittu() {
        return !(this.getPelilauta().getValittuKortti1() == null) && !(this.getPelilauta().getValittuKortti2() == null);
    }

    /**
     * Metodi tyhjennaPelilaudanValitusKortit asettaa null Pelilaudan kortti1 ja
     * kortti2 arvoiksi.
     *
     */
    public void tyhjennaPelilaudanValitutKortit() {
        this.getPelilauta().setValittuKortti1(null);
        this.getPelilauta().setValittuKortti2(null);
    }

    /**
     * Metodi kaannaPelilaudanValitutKortit kääntää Pelilaudan kortti1 ja
     * kortti2.
     *
     */
    public void kaannaPelilaudanValitutKortit() {
        this.getPelilauta().getValittuKortti1().kaannaKortti();
        this.getPelilauta().getValittuKortti2().kaannaKortti();
    }

    public boolean pari() {
        return this.getPelilauta().getValittuKortti1().onkoKortitSamat(this.getPelilauta().getValittuKortti2());
    }

    public void lisaaPistePelaajalle() {
        this.getPelaaja().lisaaPiste();
    }

    public void TallennaPelaajaTilastoon() {
        this.getPelitilasto().tallennaTilastoon(this.getPelaaja());
    }

    public boolean peliPaattyi() {
        int i = 0;
        for (KuvallinenKortti kortti : this.getKuvallisetKortit()) {
            if (kortti.getKortti().kaannetty() == true) {
                i++;
            }
        }
        if (i == this.getKuvallisetKortit().size()) {
            return true;
        } else {
            return false;
        }

    }

    public void AvaaLopetusValikko() {
        this.getPelinKayttoliittyma().getFrame().setVisible(false);
        LopetusKayttoliittyma lopetusvalikko = new LopetusKayttoliittyma(this, this.getAloitusKayttoliittyma());
        SwingUtilities.invokeLater(lopetusvalikko);
    }

    public void setKuvallisetKortit(List<KuvallinenKortti> kuvallisetKortit) {
        this.kuvallisetKortit = kuvallisetKortit;
    }
    
    public List<Kortti> getKokeilu(){
        return this.kokeilu;
    }
}
