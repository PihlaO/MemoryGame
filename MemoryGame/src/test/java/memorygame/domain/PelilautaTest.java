/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author okpiok
 */
public class PelilautaTest {

    Pelilauta pelilauta;

    public PelilautaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.pelilauta = new Pelilauta(new Korttipakka(1));
    }

    @After
    public void tearDown() {
    }

    @Test
    public void AsettaaPelilaudanSarakkeidenLukumaaranoikein() {
        assertEquals(3, this.pelilauta.pelilaudanRivienLukumaara());
    }

    @Test
    public void AsettaaPelilaudanRivienLukumaaranoikein() {
        assertEquals(4, this.pelilauta.pelilaudanSarakkeidenLukumaara());
    }

    @Test
    public void palauttaaPakanOikein() {
        pelilauta.luoPakka();
        assertEquals(pelilauta.korttipakka, pelilauta.getKorttipakka());

    }

    @Test
    public void palauttaaOikeanKortinKoordinaateillaXY() {
        pelilauta.luoPakkaJaTaulukkoKorteista();

        assertEquals(this.pelilauta.getTaulukkoKorteista()[1][2], pelilauta.getKorttiXY(1, 2));
    }

    @Test
    public void asettaaKortinTaulukkoonOikein() {
        pelilauta.korttipakka.luoKortit();
        Kortti k = pelilauta.korttipakka.haeListaKorteista().get(0);
        this.pelilauta.asetaKorttiTaulukkoon();
        assertEquals(this.pelilauta.getTaulukkoKorteista()[0][0], k);
    }

    @Test
    public void asettaaKortinTaulukkoonOikein2() {
        pelilauta.korttipakka.luoKortit();
        Kortti k = pelilauta.getKorttipakka().haeListaKorteista().get(0);
        this.pelilauta.asetaKorttiTaulukkoon();
        assertEquals(this.pelilauta.getTaulukkoKorteista()[0][0].getX(), k.getX());

    }

    @Test
    public void asettaaEnsinmaisenaValitunKortinOikein() {
        Kortti vallittu = new Kortti(1);
        pelilauta.setValittuKortti1(vallittu);
        assertEquals(vallittu, pelilauta.getValittuKortti1());

    }

    @Test
    public void asettaaToisenaValitunKortinOikein() {
        Kortti vallittu = new Kortti(1);
        pelilauta.setValittuKortti2(vallittu);
        assertEquals(vallittu, pelilauta.getValittuKortti2());

    }

}
