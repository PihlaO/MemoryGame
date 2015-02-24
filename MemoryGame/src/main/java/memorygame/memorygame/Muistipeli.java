/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.memorygame;

import java.awt.event.MouseEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public Muistipeli(int vaikeustaso, Pelaaja pelaaja, AloitusKayttoliittyma aloituskali, List<KuvallinenKortti> kuvallisetKortit) {

        this.pelilauta = new Pelilauta(new Korttipakka(vaikeustaso));
        this.pelaaja = pelaaja;
        this.aloituskali = aloituskali;
        this.kuvallisetKortit = kuvallisetKortit;
        this.tilasto = valitunVaikeustasonTilasto(vaikeustaso, aloituskali);

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

    public void logiikka(MouseEvent e) {

        KuvallinenKortti kuvakortti = klikattuKortti(e);
        Kortti kortti = kuvakortti.getKortti();

        if (this.pelilaudanKortitValittu()) {

            if (!this.pari()) {
                this.kaannaPelilaudanValitutKortit();
            }
            this.tyhjennaPelilaudanValitutKortit();
        }

        if (!kortti.kaannetty()) {
            kortti.kaannaKortti();
            this.lisaaPistePelaajalle();

            if (!this.PelilaudanEkaKorttiValittu()) {
                this.ValitaanEkaksiKortiksi(kortti);
            } else if (this.PelilaudanEkaKorttiValittu()) {
                if (!this.PelilaudanTokaKorttiValittu()) {
                    this.ValitaanToiseksiKortiksi(kortti);

                }
            }

            this.kayttoliittyma.getPiirtoalusta().repaint();

            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Muistipeli.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (this.peliPaattyi()) {
            this.TallennaPelaajaTilastoon();
            this.AvaaLopetusValikko();

        }

    }

    /**
     * Metodi hakee klikatun kortin.
     *
     * @param e Hiiren klikkaus
     * @return kuvallinen kortin
     */
    public KuvallinenKortti klikattuKortti(MouseEvent e) {
        for (KuvallinenKortti kuva : this.getKuvallisetKortit()) {
            Kortti kortti = kuva.getKortti();

            if (e.getX() > kortti.getX() * 100 + 50 && e.getY() > kortti.getY() * 100 + 50) {
                if (e.getX() < kortti.getX() * 105 + 50 + kortti.getLeveys() && e.getY() < kortti.getY() * 123 + 50 + kortti.getKorkeus()) {

                    return kuva;
                }
            }

        }
        return null;
    }

    public boolean korttiaKlikattu(MouseEvent e) {
        return !(this.klikattuKortti(e) == null);
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

    /**
     * Metodi asettaa valitun kortin peliladan kortti2:seen.
     *
     * @param kortti klikattu kortti
     */
    public void ValitaanToiseksiKortiksi(Kortti kortti) {
        this.getPelilauta().setValittuKortti2(kortti);

    }

    /**
     * Metodi asettaa valitun kortin peliladan kortti1:seen.
     *
     * @param kortti klikattu kortti
     */
    public void ValitaanEkaksiKortiksi(Kortti kortti) {
        this.getPelilauta().setValittuKortti1(kortti);
    }

    /**
     * Metodi tarkistaa onko pelilaudan kortti1:seen asetettu kortti. Jos on
     * asetettu,metodi palauttaa true. Muulloin false.
     *
     * @return totuusarvo
     */
    public boolean PelilaudanEkaKorttiValittu() {
        return !(this.getPelilauta().getValittuKortti1() == null);
    }

    /**
     * Metodi tarkistaa onko pelilaudan kortti2:seen asetettu kortti. Jos on
     * asetettu,metodi palauttaa true. Muulloin false.
     *
     * @return totuusarvo
     */
    public boolean PelilaudanTokaKorttiValittu() {
        return !(this.getPelilauta().getValittuKortti2() == null);
    }

    /**
     * Metodi tarkistaa onko pelilaudan kortti1:seen asetettu kortti. Jos on
     * asetettu,metodi palauttaa true. Muulloin false.
     *
     * @return totuusarvo
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

    /**
     * Metodi tarkistaa onko valitut kortit samat. Jos ovat pari, niin
     * metodipalauttaa true. Muulloin false.
     *
     * @return totuusarvo
     */
    public boolean pari() {
        return this.getPelilauta().getValittuKortti1().onkoKortitSamat(this.getPelilauta().getValittuKortti2());
    }

    /**
     * Metodi lisää 1 pisteen pelaajalle.
     *
     */
    public void lisaaPistePelaajalle() {
        this.getPelaaja().lisaaPiste();
    }

    /**
     * Metodi tallemtaa pelaajan tiedot pelitilastoon.
     *
     */
    public void TallennaPelaajaTilastoon() {
        this.getPelitilasto().tallennaTilastoon(this.getPelaaja());
    }

    /**
     * Metodi tarkistaa onko kaikki pelin kortit käännetty.
     *
     * @return totuusarvo
     */
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

    /**
     * Metodi tekee pelin käyttöliittymästä näkymättömän ja avaa
     * lopetuskäyttööliittymän.
     *
     */
    public void AvaaLopetusValikko() {
        this.getPelinKayttoliittyma().getFrame().setVisible(false);
        LopetusKayttoliittyma lopetusvalikko = new LopetusKayttoliittyma(this, this.getAloitusKayttoliittyma());
        SwingUtilities.invokeLater(lopetusvalikko);
    }

    public void setKuvallisetKortit(List<KuvallinenKortti> kuvallisetKortit) {
        this.kuvallisetKortit = kuvallisetKortit;
    }

}
