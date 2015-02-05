package memorygame.memorygame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.List;
import memorygame.memorygame.domain.Pelaaja;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sun.org.mozilla.javascript.ast.ForInLoop;

/**
 *
 * @author okpiok
 */
public class PelitilastoTest {

    Pelitilasto pelitilasto;
    Pelaaja pelaaja;

    public PelitilastoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        pelitilasto = new Pelitilasto("tilasto");
        pelaaja = new Pelaaja("Anna");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getNimiPalauttaaNimen() {
        assertEquals("tilasto", pelitilasto.getNimi());

    }

    @Test
    public void tallentaaTilastoonOikein() {

        pelitilasto.tallennaTilastoon(pelaaja);
    }

    @Test
    public void lisaaPelaajanTilastoon() {
        pelitilasto.tallennaTilastoon(pelaaja);
        String teksti = "";
        for (Pelaaja pelaaja : this.pelitilasto.tilasto) {
            teksti = pelaaja.toString();
        }
        assertEquals("Anna 0", teksti);
    }

    @Test
    public void tyhjentaaTilaston() {
        pelitilasto.tallennaTilastoon(pelaaja);
        pelitilasto.tyhjennaTilasto();
        List<Pelaaja> tyhjaLista = new ArrayList<>();
        assertEquals(tyhjaLista, pelitilasto.haeTilastolista());

    }

    @Test
    public void tulostaaTilastonOikein() {

    }

}
