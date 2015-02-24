/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.memorygame;

import java.util.ArrayList;
import memorygame.memorygame.domain.Pelaaja;
import memorygame.memorygame.kayttoliittyma.Kayttoliittyma;
import memorygame.memorygame.kayttoliittyma.KuvallinenKortti;
import memorygame.memorygame.valikot.AloitusKayttoliittyma;
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
        muistipeli = new Muistipeli(1, this.pelaaja, new AloitusKayttoliittyma(new Pelitilasto("top3"), new Pelitilasto("top3"),new Pelitilasto("top3")),new ArrayList<KuvallinenKortti>());
        this.pelikali = new Kayttoliittyma(muistipeli);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void palauttaaPelilaudanOikein() {

        assertEquals(this.muistipeli.pelilauta, muistipeli.getPelilauta());
    }

}
