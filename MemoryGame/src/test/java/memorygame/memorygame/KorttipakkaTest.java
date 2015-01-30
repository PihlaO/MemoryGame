/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.memorygame;

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
public class KorttipakkaTest {

    Korttipakka korttipakkaHelppo;
    Korttipakka korttipakkaKeskitaso;
    Korttipakka korttipakkaVaikea;

    public KorttipakkaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        korttipakkaHelppo = new Korttipakka(1);
        korttipakkaKeskitaso = new Korttipakka(2);
        korttipakkaVaikea = new Korttipakka(3);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void luodaankoHelppoPakkaOikein() {
        korttipakkaHelppo.luoKortit();
        assertEquals(12, korttipakkaHelppo.vaikeustaso.haeKorttienLukumaara());

    }

    @Test
    public void luodaankoKeskitasonPakkaOikein() {
        korttipakkaKeskitaso.luoKortit();
        assertEquals(16, korttipakkaKeskitaso.vaikeustaso.haeKorttienLukumaara());

    }

    @Test
    public void luodaankoVaikeaPakkaOikein() {
        korttipakkaVaikea.luoKortit();
        assertEquals(20, korttipakkaVaikea.vaikeustaso.haeKorttienLukumaara());

    }

    @Test
    public void luodaankoOletusPakkaOikein() {
        Korttipakka oletusPakka= new Korttipakka(0);
        oletusPakka.luoKortit();
        assertEquals(12, oletusPakka.vaikeustaso.haeKorttienLukumaara());

    }
    
    @Test 
    public void luodaankoKortitOikein(){
        int pakassaKortteja=0;
        korttipakkaHelppo.luoKortit();
        pakassaKortteja= korttipakkaHelppo.pakka.size();
        assertEquals(12, pakassaKortteja);
        
    }
}
