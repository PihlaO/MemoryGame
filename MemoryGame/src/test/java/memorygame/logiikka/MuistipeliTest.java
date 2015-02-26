/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.logiikka;

import java.util.ArrayList;
import java.util.List;
import memorygame.domain.Kortti;
import memorygame.domain.Pelaaja;
import memorygame.domain.Pelitilasto;
import memorygame.kayttoliittyma.Kayttoliittyma;
import memorygame.domain.KuvallinenKortti;
import memorygame.kayttoliittyma.valikot.AloitusKayttoliittyma;
import memorygame.kayttoliittyma.valikot.LopetusKayttoliittyma;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author okpiok
 */
public class MuistipeliTest {

    Muistipeli muistipeliHelppo;
    Muistipeli muistipeliKeskitaso;
    Muistipeli muistipeliVaikea;
    Kayttoliittyma pelikali;
    Pelaaja pelaaja;
    AloitusKayttoliittyma aloituskali;
 

    public MuistipeliTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.pelaaja = new Pelaaja("Anna");
        this.aloituskali = new AloitusKayttoliittyma(new Pelitilasto("top3"), new Pelitilasto("top3k"), new Pelitilasto("top3v"));
        this.muistipeliHelppo = new Muistipeli(1, this.pelaaja, aloituskali, new ArrayList<KuvallinenKortti>());
        this.muistipeliKeskitaso = new Muistipeli(2, this.pelaaja, aloituskali, new ArrayList<KuvallinenKortti>());
        this.muistipeliVaikea = new Muistipeli(3, this.pelaaja, aloituskali, new ArrayList<KuvallinenKortti>());
        this.pelikali = new Kayttoliittyma(muistipeliHelppo);


    }

    @After
    public void tearDown() {
    }

    @Test
    public void palauttaaPelilaudanOikein() {

        assertEquals(this.muistipeliHelppo.pelilauta, muistipeliHelppo.getPelilauta());
    }

    @Test
    public void palauttaaPelaajanOikein() {

        assertEquals(this.pelaaja, this.muistipeliHelppo.getPelaaja());
    }

    @Test
    public void palauttaaKayttoliittymanOikein() {

        assertEquals(this.aloituskali, muistipeliHelppo.getAloitusKayttoliittyma());
    }

    @Test
    public void asettaaToisenaValitunKortinOikein() {
        Kortti kortti = new Kortti(3);
        muistipeliHelppo.ValitaanToiseksiKortiksi(kortti);
        assertEquals(kortti, muistipeliHelppo.pelilauta.getValittuKortti2());
    }

    @Test
    public void asettaaEnsinValitunKortinOikein() {
        Kortti kortti = new Kortti(3);
        muistipeliHelppo.ValitaanEkaksiKortiksi(kortti);
        assertEquals(kortti, muistipeliHelppo.pelilauta.getValittuKortti1());
    }

    @Test
    public void ensimmainenKorttiValittu() {
        Kortti kortti = new Kortti(3);
        muistipeliHelppo.ValitaanEkaksiKortiksi(kortti);

        assertEquals(true, muistipeliHelppo.PelilaudanEkaKorttiValittu());
    }

    @Test
    public void toinenKorttiValittu() {
        Kortti kortti = new Kortti(3);
        muistipeliHelppo.ValitaanToiseksiKortiksi(kortti);

        assertEquals(true, muistipeliHelppo.PelilaudanTokaKorttiValittu());
    }

    @Test
    public void pelilaudanMolemmatKortitValittu() {

        Kortti kortti = new Kortti(3);
        muistipeliHelppo.ValitaanEkaksiKortiksi(kortti);
        Kortti kortti2 = new Kortti(3);
        muistipeliHelppo.ValitaanToiseksiKortiksi(kortti);

        assertEquals(true, muistipeliHelppo.pelilaudanKortitValittu());
    }

    @Test
    public void tyhjentaaValitutKortitOikein() {

        Kortti kortti = new Kortti(3);
        muistipeliHelppo.ValitaanEkaksiKortiksi(kortti);
        Kortti kortti2 = new Kortti(3);
        muistipeliHelppo.ValitaanToiseksiKortiksi(kortti);
        muistipeliHelppo.tyhjennaPelilaudanValitutKortit();

        assertEquals(null, muistipeliHelppo.getPelilauta().getValittuKortti1());
        assertEquals(null, muistipeliHelppo.getPelilauta().getValittuKortti2());
    }

    @Test
    public void kaantaaPelilaudanValitutKortitOikein() {
        Kortti kortti = new Kortti(3);
        muistipeliHelppo.ValitaanEkaksiKortiksi(kortti);
        Kortti kortti2 = new Kortti(3);
        muistipeliHelppo.ValitaanToiseksiKortiksi(kortti2);
        muistipeliHelppo.kaannaPelilaudanValitutKortit();

        assertEquals(true, muistipeliHelppo.getPelilauta().getValittuKortti1().kaannetty());
        assertEquals(true, muistipeliHelppo.getPelilauta().getValittuKortti2().kaannetty());
    }

    @Test
    public void testaaPari() {
        Kortti kortti = new Kortti(3);
        muistipeliHelppo.ValitaanEkaksiKortiksi(kortti);
        Kortti kortti2 = new Kortti(3);
        muistipeliHelppo.ValitaanToiseksiKortiksi(kortti2);
        assertEquals(true, muistipeliHelppo.pari());
    }

    @Test
    public void testaaEiPari() {
        Kortti kortti = new Kortti(3);
        muistipeliHelppo.ValitaanEkaksiKortiksi(kortti);
        Kortti kortti2 = new Kortti(4);
        muistipeliHelppo.ValitaanToiseksiKortiksi(kortti2);
        assertEquals(false, muistipeliHelppo.pari());
    }

    @Test
    public void lisaaPisteenPelaajalleOikein() {
        this.pelaaja.lisaaPiste();
        this.pelaaja.lisaaPiste();
        assertEquals(2, muistipeliHelppo.getPelaaja().getPisteet());
    }

    @Test
    public void asettaaKuvallisetKortitListanOiekin() {
        List<KuvallinenKortti> lista = new ArrayList<>();
        this.muistipeliHelppo.setKuvallisetKortit(lista);
        assertEquals(lista, this.muistipeliHelppo.getKuvallisetKortit());
    }

    @Test
    public void palauttaPelinKayttoliittymanOikein() {
        boolean totuus = false;
        muistipeliHelppo.kaynnista();
        if (!(this.muistipeliHelppo.getPelinKayttoliittyma() == null)) {
            totuus = true;
        }
        assertEquals(true, totuus);
    }

    @Test
    public void hakeeTilastonOikein() {
        assertEquals(this.muistipeliHelppo.tilasto, this.muistipeliHelppo.getPelitilasto());
    }

    @Test
    public void hakeeHelponPelitilastonOikein() {

        this.muistipeliHelppo.valitunVaikeustasonTilasto(1, aloituskali);

        assertEquals("top3", this.muistipeliHelppo.tilasto.getNimi());
    }

    @Test
    public void hakeeKeskivaikeanPelitilastonOikein() {

        this.muistipeliKeskitaso.valitunVaikeustasonTilasto(2, aloituskali);

        assertEquals("top3k", this.muistipeliKeskitaso.tilasto.getNimi());
    }

    @Test
    public void hakeePelitilastonOikein4() {

        this.muistipeliHelppo.valitunVaikeustasonTilasto(3, aloituskali);

        assertEquals("top3v", this.muistipeliVaikea.tilasto.getNimi());
    }

    @Test
    public void hakeeVaikeanPelitilastonOikein() {

        this.muistipeliHelppo.valitunVaikeustasonTilasto(-1, aloituskali);

        assertEquals("top3", this.muistipeliHelppo.tilasto.getNimi());
    }

    @Test
    public void peliEiPaaty() {
        KuvallinenKortti k1 = new KuvallinenKortti(new Kortti(1));
        KuvallinenKortti k2 = new KuvallinenKortti(new Kortti(2));
        KuvallinenKortti k3 = new KuvallinenKortti(new Kortti(3));
        k2.getKortti().kaannaKortti();
        this.muistipeliHelppo.getKuvallisetKortit().add(k1);
        this.muistipeliHelppo.getKuvallisetKortit().add(k2);
        this.muistipeliHelppo.getKuvallisetKortit().add(k3);
        assertEquals(false, this.muistipeliHelppo.peliPaattyi());
    }

    @Test
    public void peliPaattyiOikein() {
        KuvallinenKortti k1 = new KuvallinenKortti(new Kortti(1));
        KuvallinenKortti k2 = new KuvallinenKortti(new Kortti(2));
        KuvallinenKortti k3 = new KuvallinenKortti(new Kortti(3));
        k1.getKortti().kaannaKortti();
        k2.getKortti().kaannaKortti();
        k3.getKortti().kaannaKortti();
        this.muistipeliHelppo.getKuvallisetKortit().add(k1);
        this.muistipeliHelppo.getKuvallisetKortit().add(k2);
        this.muistipeliHelppo.getKuvallisetKortit().add(k3);
        assertEquals(true, this.muistipeliHelppo.peliPaattyi());
    }

    @Test
    public void logiikkaValitseeEkanKortinOikein() {
        try {
            this.muistipeliHelppo.kaynnista();
            Kortti kortti = this.muistipeliHelppo.getPelilauta().getKorttiXY(1, 2);
            this.muistipeliHelppo.logiikka(kortti);

        } catch (Exception e) {

        }

        assertEquals(true, this.muistipeliHelppo.PelilaudanEkaKorttiValittu());
    }

    @Test
    public void logiikkaValitseeTokanKortinOikein() {
        try {
            this.muistipeliHelppo.kaynnista();
            Kortti kortti = this.muistipeliHelppo.getPelilauta().getKorttiXY(1, 2);
            Kortti kortti2 = this.muistipeliHelppo.getPelilauta().getKorttiXY(1, 2);
            this.muistipeliHelppo.pelilauta.setValittuKortti1(kortti);
            this.muistipeliHelppo.logiikka(kortti2);

        } catch (Exception e) {

        }

        assertEquals(true, this.muistipeliHelppo.PelilaudanTokaKorttiValittu());
    }
    
        @Test
    public void logiikkaTyhjentaaValitutKortitOikein() {
        try {
            this.muistipeliHelppo.kaynnista();
            Kortti kortti = new Kortti(1);
            Kortti kortti2 = new Kortti(2);
            this.muistipeliHelppo.pelilauta.setValittuKortti1(kortti);
            this.muistipeliHelppo.pelilauta.setValittuKortti2(kortti2);
    
            this.muistipeliHelppo.logiikka(this.muistipeliHelppo.getPelilauta().getKorttiXY(1, 2));
        } catch (Exception e) {

        }

        assertEquals(this.muistipeliHelppo.getPelilauta().getKorttiXY(1, 2), this.muistipeliHelppo.pelilauta.getValittuKortti1());
        assertEquals(null, this.muistipeliHelppo.pelilauta.getValittuKortti2());
    }
}
