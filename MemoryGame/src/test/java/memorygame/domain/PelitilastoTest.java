package memorygame.domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.List;
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
        for (Pelaaja p : this.pelitilasto.tilasto) {
            teksti = p.toString();
        }
        assertEquals("Anna      Pisteet: 0", teksti);
    }

    @Test
    public void tyhjentaaTilaston() {
        pelitilasto.tallennaTilastoon(pelaaja);
        pelitilasto.tyhjennaTilasto();
        List<Pelaaja> tyhjaLista = new ArrayList<>();
        assertEquals(tyhjaLista, pelitilasto.haeTilastolista());

    }

    @Test
    public void hakeePelaajanListastaIndeksillaOikein() {
        pelitilasto.tallennaTilastoon(pelaaja);

        assertEquals(this.pelaaja, pelitilasto.palautaPelaajaTilastosta(0));
    }

    @Test
    public void jarjestaaTilastonOikein() {
        Pelaaja pekka = new Pelaaja("Pekka");
        pekka.setPisteet(10);
        pelitilasto.tallennaTilastoon(pekka);

        pelitilasto.tallennaTilastoon(pelaaja);

        Pelaaja jussi = new Pelaaja("Jussi");
        jussi.setPisteet(100);
        pelitilasto.tallennaTilastoon(jussi);

        List<Pelaaja> apulista = new ArrayList<>();
        apulista.add(this.pelaaja);
        apulista.add(pekka);
        apulista.add(jussi);

        this.pelitilasto.jarjestaTilasto();

        assertEquals(apulista, this.pelitilasto.tilasto);
    }

}
