/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.memorygame.domain;

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
    public void asettaaKortilleOikeinKoordinaatit() {

    }

    @Test
    public void asettaaPakanKorteilleOikeinKoordinaatit() {

    }

}