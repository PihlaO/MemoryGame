package memorygame.memorygame.domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import memorygame.memorygame.domain.Pelaaja;
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
public class PelaajaTest {

    Pelaaja pelaaja;

    public PelaajaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        pelaaja = new Pelaaja("Anna");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriAsettaaNimenOikein() {
        assertEquals("Anna", pelaaja.getNimi());
    }

    @Test
    public void setPisteetEiAsetaNegatiivistaArvoa() {
        pelaaja.setPisteet(-1);
        assertEquals(0, pelaaja.getPisteet());
    }

    @Test
    public void setPisteetAsettaaPositiivisetArvotOikein() {
        pelaaja.setPisteet(2);
        assertEquals(2, pelaaja.getPisteet());
    }

    @Test
    public void setPisteetAsettaaNollanOikein() {
        pelaaja.setPisteet(2);
        pelaaja.setPisteet(0);
        assertEquals(0, pelaaja.getPisteet());
    }
    
    @Test 
    public void toStringToimiiOikein(){
        assertEquals("Anna 0", pelaaja.toString());
    }

}
