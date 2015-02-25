/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package memorygame.domain;

import memorygame.domain.Vaikeustaso;
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
public class VaikeustasoTest {
    
    Vaikeustaso vaikeustaso;
    
    public VaikeustasoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test 
    public void palauttaaTasonTunnuksenOikein(){
        this.vaikeustaso = new Vaikeustaso(1);
        assertEquals(1, vaikeustaso.getTasonTunnus());
    }
    @Test 
    public void palauttaaOletusPakanKorttienLukumaaran(){
        vaikeustaso = new Vaikeustaso(-1);
        assertEquals(12, vaikeustaso.haeKorttienLukumaara());
    }
    @Test 
    public void nimeaaHelpontasonPoikein(){
        vaikeustaso = new Vaikeustaso(1);
        assertEquals("Helppo", vaikeustaso.toString());
    }
    
 


}
