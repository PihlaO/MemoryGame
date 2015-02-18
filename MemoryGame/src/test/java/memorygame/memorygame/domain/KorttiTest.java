package memorygame.memorygame.domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import memorygame.memorygame.domain.Kortti;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
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
        Kortti kortti = new Kortti(1);
        assertEquals(1, kortti.getTyyppi());

    }

    @Test
    public void toStringToimiiOikein() {
        assertEquals("Kortin tyyppi on 1käännettyfalse", kortti.toString());
    }

    @Test
    public void tarkistaakoSamatKortitOikein() {
        Kortti kortti = new Kortti(1);
        Kortti kortinPari = new Kortti(1);
        assertEquals(true, kortti.onkoKortitSamat(kortinPari));
    }

    @Test
    public void tarkistaakoErillaisetKortitOikein() {
        Kortti kortti = new Kortti(1);
        Kortti kortinPari = new Kortti(2);
        assertEquals(false, kortti.onkoKortitSamat(kortinPari));
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
    public void kaantaaKortinOikeinpain(){
        kortti.kaannaKortti();
        assertEquals(true, kortti.onkoKaannetu());
    }
    
    @Test 
    public void kaantaaKortinVaarinpain(){
        kortti.kaannaKortti();
        kortti.kaannaKortti();
        assertEquals(false, kortti.onkoKaannetu());
    }
}
