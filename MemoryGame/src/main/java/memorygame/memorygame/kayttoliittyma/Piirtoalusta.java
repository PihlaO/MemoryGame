/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.memorygame.kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import memorygame.memorygame.Muistipeli;
import memorygame.memorygame.domain.Kortti;
import memorygame.memorygame.domain.Pelilauta;

/**
 *
 * @author okpiok
 */
/*
 * Muistipelin piirtoalusta.
 */
public class Piirtoalusta extends JPanel {

    Pelilauta pelilauta;
    private BufferedImage kansikuva;
    private BufferedImage kuva;
    List<Kuva> kuvallisetKortit;

    public Piirtoalusta(Pelilauta pelilauta) {
        this.pelilauta = pelilauta;
        super.setBackground(Color.WHITE);
        this.kuvallisetKortit = new ArrayList<>();

        haeKansikuvaTiedostosta();
//        haeKuvatTiedostosta();
        this.luoKuvallisetKortit();

        lisaaKuuntelija(this);

    }

    /**
     * Metodi lukee tiedostosta kansikuvan.
     *
     */
    private void haeKansikuvaTiedostosta() {
        try {
            File kuvatiedosto = new File("./kansikuva.png");
            kansikuva = ImageIO.read(kuvatiedosto);
        } catch (IOException e) {
            System.out.println("tiedoston luku ei onnistu.");
        }
    }

    /**
     * Metodi lisaa kuuntelijan.
     *
     * @param muistipelin piirtoalusta
     *
     */
    private void lisaaKuuntelija(Piirtoalusta piirtoalusta) {
        Kuuntelija k = new Kuuntelija(piirtoalusta, pelilauta, kuvallisetKortit);
        this.addMouseListener(k);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        for (Kortti kortti : this.pelilauta.getKorttipakka().haeKorttipakka()) {
            this.piirraKortinKansi(kortti, graphics);

        }
        for (Kuva k : this.kuvallisetKortit) {
            Kortti kortti = k.getKortti();
            if (kortti.onkoKaannetu() == true) {
                haeKuvaTiedostosta(kortti.getTyyppi());
                this.piirraKortinKuva(kortti, graphics);
            }
        }

    }

    /**
     * Metodi luo kuvalliset kortit.
     *
     */
    public void luoKuvallisetKortit() {
        for (Kortti kortti : pelilauta.getKorttipakka().haeKorttipakka()) {
            Kuva kuvallinenkortti = new Kuva(kansikuva, kuva, kortti);
            kuvallisetKortit.add(kuvallinenkortti);

        }
        System.out.println("koko:" + kuvallisetKortit.size());

    }

    /**
     * Metodi piirtää kortin kansikuvan.
     *
     */
    public void piirraKortinKansi(Kortti k, Graphics graphics) {

        graphics.drawImage(kansikuva, k.getX() * 100 + 50, k.getY() * 100 + 50, k.getKorkeus(), k.getLeveys(), this);
    }

    /**
     * Metodi piirtää kortin kuvan.
     *
     */
    public void piirraKortinKuva(Kortti k, Graphics graphics) {
        graphics.drawImage(kuva, k.getX() * 100 + 50, k.getY() * 100 + 50, k.getKorkeus(), k.getLeveys(), this);

    }

    /**
     * Metodi hakee listan kuvallisita korteista.
     *
     * @return kuvalliset kortit
     *
     */
    public List<Kuva> haeKuvallisetKortit() {
        return this.kuvallisetKortit;
    }

//    private void haeKuvatTiedostosta() {
//        for (Kortti k : pelilauta.getKorttipakka().haeKorttipakka()) {
//            haeKuvaTiedostosta(k.getTyyppi());
//        }
//    }
    /**
     * Metodi lukee tiedostosta kuvan.
     *
     */
    private void haeKuvaTiedostosta(int tyyppi) {

        try {
            File kuvatiedosto = new File("./kuva" + tyyppi + ".jpg");
            kuva = ImageIO.read(kuvatiedosto);
        } catch (IOException e) {
            System.out.println("tiedoston luku ei onnistu.");
        }
    }

}
