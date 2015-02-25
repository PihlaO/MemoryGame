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
import memorygame.kayttoliittyma.KuvallinenKortti;
import memorygame.kayttoliittyma.valikot.AloitusKayttoliittyma;
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

    Muistipeli muistipeli;
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
        this.aloituskali = new AloitusKayttoliittyma(new Pelitilasto("top3"), new Pelitilasto("top3"), new Pelitilasto("top3"));
        muistipeli = new Muistipeli(1, this.pelaaja, aloituskali, new ArrayList<KuvallinenKortti>());
        this.pelikali = new Kayttoliittyma(muistipeli);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void palauttaaPelilaudanOikein() {

        assertEquals(this.muistipeli.pelilauta, muistipeli.getPelilauta());
    }

    @Test
    public void palauttaaPelaajanOikein() {

        assertEquals(this.pelaaja, this.muistipeli.getPelaaja());
    }

    @Test
    public void palauttaaKayttoliittymanOikein() {

        assertEquals(this.aloituskali, muistipeli.getAloitusKayttoliittyma());
    }

    @Test
    public void asettaaToisenaValitunKortinOikein() {
        Kortti kortti = new Kortti(3);
        muistipeli.ValitaanToiseksiKortiksi(kortti);
        assertEquals(kortti, muistipeli.pelilauta.getValittuKortti2());
    }

    @Test
    public void asettaaEnsinValitunKortinOikein() {
        Kortti kortti = new Kortti(3);
        muistipeli.ValitaanEkaksiKortiksi(kortti);
        assertEquals(kortti, muistipeli.pelilauta.getValittuKortti1());
    }

    @Test
    public void ensimmainenKorttiValittu() {
        Kortti kortti = new Kortti(3);
        muistipeli.ValitaanEkaksiKortiksi(kortti);

        assertEquals(true, muistipeli.PelilaudanEkaKorttiValittu());
    }

    @Test
    public void toinenKorttiValittu() {
        Kortti kortti = new Kortti(3);
        muistipeli.ValitaanToiseksiKortiksi(kortti);

        assertEquals(true, muistipeli.PelilaudanTokaKorttiValittu());
    }

    @Test
    public void pelilaudanMolemmatKortitValittu() {

        Kortti kortti = new Kortti(3);
        muistipeli.ValitaanEkaksiKortiksi(kortti);
        Kortti kortti2 = new Kortti(3);
        muistipeli.ValitaanToiseksiKortiksi(kortti);

        assertEquals(true, muistipeli.pelilaudanKortitValittu());
    }

    @Test
    public void tyhjentaaValitutKortitOikein() {

        Kortti kortti = new Kortti(3);
        muistipeli.ValitaanEkaksiKortiksi(kortti);
        Kortti kortti2 = new Kortti(3);
        muistipeli.ValitaanToiseksiKortiksi(kortti);
        muistipeli.tyhjennaPelilaudanValitutKortit();

        assertEquals(null, muistipeli.getPelilauta().getValittuKortti1());
        assertEquals(null, muistipeli.getPelilauta().getValittuKortti2());
    }

    @Test
    public void kaantaaPelilaudanValitutKortitOikein() {
        Kortti kortti = new Kortti(3);
        muistipeli.ValitaanEkaksiKortiksi(kortti);
        Kortti kortti2 = new Kortti(3);
        muistipeli.ValitaanToiseksiKortiksi(kortti2);
        muistipeli.kaannaPelilaudanValitutKortit();

        assertEquals(true, muistipeli.getPelilauta().getValittuKortti1().kaannetty());
        assertEquals(true, muistipeli.getPelilauta().getValittuKortti2().kaannetty());
    }

    @Test
    public void testaaPari() {
        Kortti kortti = new Kortti(3);
        muistipeli.ValitaanEkaksiKortiksi(kortti);
        Kortti kortti2 = new Kortti(3);
        muistipeli.ValitaanToiseksiKortiksi(kortti2);
        assertEquals(true, muistipeli.pari());
    }

    @Test
    public void testaaEiPari() {
        Kortti kortti = new Kortti(3);
        muistipeli.ValitaanEkaksiKortiksi(kortti);
        Kortti kortti2 = new Kortti(4);
        muistipeli.ValitaanToiseksiKortiksi(kortti2);
        assertEquals(false, muistipeli.pari());
    }

    @Test
    public void lisaaPisteenPelaajalleOikein() {
        this.pelaaja.lisaaPiste();
        this.pelaaja.lisaaPiste();
        assertEquals(2, muistipeli.getPelaaja().getPisteet());
    }



    @Test
    public void asettaaKuvallisetKortitListanOiekin() {
        List<KuvallinenKortti> lista = new ArrayList<>();
        this.muistipeli.setKuvallisetKortit(lista);
        assertEquals(lista, this.muistipeli.getKuvallisetKortit());
    }
}
