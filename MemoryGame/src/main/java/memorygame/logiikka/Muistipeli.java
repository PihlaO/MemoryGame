/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.logiikka;

import java.awt.event.MouseEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import memorygame.domain.Pelitilasto;
import memorygame.domain.Kortti;
import memorygame.domain.Korttipakka;
import memorygame.domain.Pelaaja;
import memorygame.domain.Pelilauta;
import memorygame.kayttoliittyma.Kayttoliittyma;
import memorygame.kayttoliittyma.KuvallinenKortti;
import memorygame.kayttoliittyma.valikot.AloitusKayttoliittyma;
import memorygame.kayttoliittyma.valikot.LopetusKayttoliittyma;

/**
 *
 * @author okpiok
 */
/*
 * Muistipelin luokka. Luokka sisältää pelin logiikan.
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

    /**
     * Metodissa on muistipelin logiikka.
     *
     * @param kortti
     */
    public void logiikka(Kortti kortti) {

        if (this.pelilaudanKortitValittu()) {

            if (!this.pari()) {
                this.kaannaPelilaudanValitutKortit();
            }
            this.tyhjennaPelilaudanValitutKortit();
        }

        if (!kortti.kaannetty()) {
            kortti.kaannaKortti();
            this.pelaaja.lisaaPiste();

            if (!this.PelilaudanEkaKorttiValittu()) {
                this.ValitaanEkaksiKortiksi(kortti);
            } else {
                if (!this.PelilaudanTokaKorttiValittu()) {
                    this.ValitaanToiseksiKortiksi(kortti);

                }
            }

//            this.kayttoliittyma.getPiirtoalusta().repaint();

//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Muistipeli.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }

        if (this.peliPaattyi()) {
            this.tilasto.tallennaTilastoon(this.pelaaja);
            this.AvaaLopetusValikko();

        }

    }

    /**
     * Metodi havaitsee klikkauksen.
     *
     * @param e
     */
    public void klikkausHavaittu(MouseEvent e) {
        KuvallinenKortti kuvakortti = klikattuKortti(e);
        Kortti kortti = kuvakortti.getKortti();
        logiikka(kortti);
    }

    /**
     * Metodi hakee klikatun kortin.
     *
     * @param e Hiiren klikkaus
     * @return kuvallinen kortin
     */
    public KuvallinenKortti klikattuKortti(MouseEvent e) {
        for (KuvallinenKortti kuvallinenKortti : this.kuvallisetKortit) {
            Kortti kortti = kuvallinenKortti.getKortti();

            if (e.getX() > kortti.getX() * 100 + 50 && e.getY() > kortti.getY() * 100 + 50) {
                if (e.getX() < kortti.getX() * 105 + 50 + kortti.getLeveys() && e.getY() < kortti.getY() * 123 + 50 + kortti.getKorkeus()) {

                    return kuvallinenKortti;
                }
            }

        }
        return null;
    }

    /**
     * Metodi kertoo, onko hiiren klikkaus osunut korttiin. Jos korttia on
     * klikattu metodi palauttaa true, muulloin false.
     *
     * @param e Hiiren klikkaus
     * @return totuusarvo
     */
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

    /**
     * Metodi palautta pelaajan valitseman vaikeustasontason.
     *
     * @param vaikeustaso pelaajan valitsema vaikeustaso
     * @param aloituskayttoliittyma
     * @return Pelitilasto
     */
    public Pelitilasto valitunVaikeustasonTilasto(int vaikeustaso, AloitusKayttoliittyma aloituskayttoliittyma) {
        if (vaikeustaso == 1) {
            return aloituskayttoliittyma.getHelponTasonTilasto();
        }
        if (vaikeustaso == 2) {
            return aloituskayttoliittyma.getKeskiTasonTilasto();
        } else {
            return aloituskayttoliittyma.getVaikeanTasonTilasto();
        }
    }

    /**
     * Metodi asettaa valitun kortin peliladan kortti2:seen.
     *
     * @param kortti klikattu kortti
     */
    public void ValitaanToiseksiKortiksi(Kortti kortti) {
        this.pelilauta.setValittuKortti2(kortti);

    }

    /**
     * Metodi asettaa valitun kortin peliladan kortti1:seen.
     *
     * @param kortti klikattu kortti
     */
    public void ValitaanEkaksiKortiksi(Kortti kortti) {
        this.pelilauta.setValittuKortti1(kortti);
    }

    /**
     * Metodi tarkistaa onko pelilaudan kortti1:seen asetettu kortti. Jos on
     * asetettu,metodi palauttaa true. Muulloin false.
     *
     * @return totuusarvo
     */
    public boolean PelilaudanEkaKorttiValittu() {
        return !(this.pelilauta.getValittuKortti1() == null);
    }

    /**
     * Metodi tarkistaa onko pelilaudan kortti2:seen asetettu kortti. Jos on
     * asetettu,metodi palauttaa true. Muulloin false.
     *
     * @return totuusarvo
     */
    public boolean PelilaudanTokaKorttiValittu() {
        return !(this.pelilauta.getValittuKortti2() == null);
    }

    /**
     * Metodi tarkistaa onko pelilaudan kortti1:seen ja kortti2:seen asetettu
     * kortti. Jos on asetettu,metodi palauttaa true. Muulloin false.
     *
     * @return totuusarvo
     */
    public boolean pelilaudanKortitValittu() {
        return !(this.pelilauta.getValittuKortti1() == null) && !(this.pelilauta.getValittuKortti2() == null);
    }

    /**
     * Metodi asettaa null Pelilaudan kortti1 ja kortti2 arvoiksi.
     *
     */
    public void tyhjennaPelilaudanValitutKortit() {
        this.pelilauta.setValittuKortti1(null);
        this.pelilauta.setValittuKortti2(null);
    }

    /**
     * Metodi kääntää Pelilaudan kortti1 ja kortti2.
     *
     */
    public void kaannaPelilaudanValitutKortit() {
        this.pelilauta.getValittuKortti1().kaannaKortti();
        this.pelilauta.getValittuKortti2().kaannaKortti();
    }

    /**
     * Metodi tarkistaa onko valitut kortit samat. Jos ovat pari, niin
     * metodipalauttaa true. Muulloin false.
     *
     * @return totuusarvo
     */
    public boolean pari() {
        return this.pelilauta.getValittuKortti1().onkoKortitSamat(this.getPelilauta().getValittuKortti2());
    }

    /**
     * Metodi tarkistaa onko kaikki pelin kortit käännetty.
     *
     * @return totuusarvo
     */
    public boolean peliPaattyi() {
        int i = 0;
        for (KuvallinenKortti kortti : this.kuvallisetKortit) {
            if (kortti.getKortti().kaannetty() == true) {
                i++;
            }
        }
        if (i == this.kuvallisetKortit.size()) {
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
