/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package memorygame.memorygame;

import memorygame.memorygame.domain.Korttipakka;
import memorygame.memorygame.domain.Pelilauta;
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
public class MuistipeliTest {

    Muistipeli muistipeli;
    
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
        muistipeli = new Muistipeli(new Pelilauta(new Korttipakka(1)));
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void palauttaaPelilaudanOikein() {
        
        assertEquals(this.muistipeli.pelilauta, muistipeli.getPelilauta());
    }
}
