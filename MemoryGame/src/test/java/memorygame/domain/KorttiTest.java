package memorygame.domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class KorttiTest {

    Kortti kortti;

    public KorttiTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        kortti = new Kortti(1);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriAsettaaTyypinOikein() {
        Kortti k = new Kortti(1);
        assertEquals(1, k.getTyyppi());

    }

    @Test
    public void toStringToimiiOikein() {
        assertEquals("Kortin tyyppi on 1käännettyfalse", kortti.toString());
    }

    @Test
    public void tarkistaakoSamatKortitOikein() {
        Kortti kortti1 = new Kortti(1);
        Kortti kortinPari = new Kortti(1);
        assertEquals(true, kortti1.onkoKortitSamat(kortinPari));
    }

    @Test
    public void tarkistaakoErillaisetKortitOikein() {
        Kortti kortti1 = new Kortti(1);
        Kortti kortinPari = new Kortti(2);
        assertEquals(false, kortti1.onkoKortitSamat(kortinPari));
    }

    @Test
    public void palauttaaXoikein() {
        kortti.setX(70);
        assertEquals(70, kortti.getX());
    }

    @Test
    public void palauttaaYoikein() {
        kortti.setY(90);
        assertEquals(90, kortti.getY());
    }

    @Test
    public void palauttaaKorkeudenoikein() {
        assertEquals(120, kortti.getKorkeus());
    }

    @Test
    public void palauttaaLeveydenoikein() {
        assertEquals(100, kortti.getLeveys());
    }

    @Test
    public void kaantaaKortinOikeinpain() {
        kortti.kaannaKortti();
        assertEquals(true, kortti.kaannetty());
    }

    @Test
    public void kaantaaKortinVaarinpain() {
        kortti.kaannaKortti();
        kortti.kaannaKortti();
        assertEquals(false, kortti.kaannetty());
    }
}
