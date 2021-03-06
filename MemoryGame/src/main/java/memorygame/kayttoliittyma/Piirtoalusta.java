/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.kayttoliittyma;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import memorygame.domain.Kortti;
import memorygame.domain.Korttipakka;
import memorygame.domain.KuvallinenKortti;
import memorygame.logiikka.Muistipeli;

/**
 *
 * @author okpiok
 */
/*
 * Muistipelin piirtoalusta.
 */
public class Piirtoalusta extends JPanel {

    Muistipeli muistipeli;
    private BufferedImage kansikuva;
    private BufferedImage kuva;
    private BufferedImage taustakuva;

    public Piirtoalusta(Muistipeli muistipeli) {
        this.muistipeli = muistipeli;
        super.setBackground(Color.WHITE);
        luoKuvallisetKortit();
        lisaaKuuntelija(this);

    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        haePohjaTiedostosta();
        this.piirraTausta(graphics);

        luoFontti(graphics);
        TilanneTeksti(this.muistipeli.getPelilauta().getKorttipakka().haeVaikeustaso().getTasonTunnus(), graphics);
        piirraKortit(graphics);

    }

    /**
     * Metodi hakee ja piirtää kuvat.
     *
     */
    private void piirraKortit(Graphics graphics) {
        for (Kortti k : this.muistipeli.getPelilauta().getKorttipakka().haeListaKorteista()) {
            Kortti kortti = k;
            if (kortti.kaannetty()) {
                this.haeKuvaTiedostosta(kortti.getTyyppi());
                this.piirraKortinKuva(kortti, graphics);
            } else {
                this.haeKansikuvaTiedostosta();
                this.piirraKortinKansi(k, graphics);
            }
        }
    }

    /**
     * Metodi luo fontin.
     *
     */
    private void luoFontti(Graphics graphics) {

        Font stringFont = new Font("Fontti", Font.BOLD, 12);
        graphics.setFont(stringFont);

    }

    /**
     * Metodi selvittää tilanne tekstin.
     *
     */
    private void TilanneTeksti(int tasontunnus, Graphics graphics) {
        String teksti = "       Vaikeustaso: " + this.muistipeli.getPelilauta().getKorttipakka().haeVaikeustaso().toString() + "     Pelaaja: " + muistipeli.getPelaaja();

        if (tasontunnus == 1) {
            kirjoitaHelpontasonTilanne(graphics, teksti);
        }
        if (tasontunnus == 2) {
            kirjoitaKeskitasonTilanne(graphics, teksti);
        }

        if (tasontunnus == 3) {
            KirjoitaVaikeanTasonTilanne(graphics, teksti);

        }
    }

    /**
     * Metodi kirjoittaa tilannetekstin vaikealle tasolle.
     *
     */
    private void KirjoitaVaikeanTasonTilanne(Graphics graphics, String teksti) {

        graphics.drawString(teksti, 20, 700);

    }

    /**
     * Metodi kirjoittaa tilannetekstin keskitasolle.
     *
     */
    private void kirjoitaKeskitasonTilanne(Graphics graphics, String teksti) {

        graphics.drawString(teksti, 20, 600);

    }

    /**
     * Metodi kirjoittaa tilannetekstin helpolle tasolle.
     *
     */
    private void kirjoitaHelpontasonTilanne(Graphics graphics, String teksti) {

        graphics.drawString(teksti, 20, 550);

    }

    /**
     * Metodi lisaa kuuntelijan.
     *
     * @param muistipelin piirtoalusta
     *
     */
    private void lisaaKuuntelija(Piirtoalusta piirtoalusta) {
        Hiirikuuntelija k = new Hiirikuuntelija(piirtoalusta);
        this.addMouseListener(k);
    }

    /**
     * Metodi piirtää korteille kansikuvat.
     *
     * @param k
     * @param graphics
     */
    private void piirraPakanKorteilleKansi(Korttipakka pakka, Graphics graphics) {
        for (Kortti kortti : this.muistipeli.getPelilauta().getKorttipakka().haeListaKorteista()) {
            this.piirraKortinKansi(kortti, graphics);

        }
    }

    /**
     * Metodi piirtää kortin kansikuvan.
     *
     * @param k
     * @param graphics
     */
    public void piirraKortinKansi(Kortti k, Graphics graphics) {

        graphics.drawImage(kansikuva, k.getX() * 105 + 50, k.getY() * 123 + 50, k.getLeveys(), k.getKorkeus(), this);

    }

    /**
     * Metodi piirtää kortin kuvan.
     *
     * @param k
     * @param graphics
     */
    public void piirraKortinKuva(Kortti k, Graphics graphics) {
        graphics.drawImage(kuva, k.getX() * 105 + 50, k.getY() * 123 + 50, k.getLeveys(), k.getKorkeus(), this);

    }

    /**
     * Metodi piirtää muistipelille taustakuvan.
     *
     */
    private void piirraTausta(Graphics graphics) {
        graphics.drawImage(taustakuva, 0, 0, 750, 750, this);
    }

    /**
     * Metodi luo kuvalliset kortit.
     *
     */
    public void luoKuvallisetKortit() {

        for (Kortti kortti : this.muistipeli.getPelilauta().getKorttipakka().haeListaKorteista()) {

            KuvallinenKortti kuvallinenkortti = new KuvallinenKortti(kortti);
            this.muistipeli.getKuvallisetKortit().add(kuvallinenkortti);

        }

    }

    /**
     * Metodi lukee tiedostosta kuvan.
     *
     * @param tyyppi
     *
     */
    public void haeKuvaTiedostosta(int tyyppi) {

        try {
            File kuvatiedosto = new File("./src/kuva" + tyyppi + ".JPG");
            kuva = ImageIO.read(kuvatiedosto);

        } catch (IOException e) {
            System.out.println("tiedoston luku ei onnistu.");

        }
    }

    /**
     * Metodi lukee tiedostosta kansikuvan.
     *
     */
    public void haeKansikuvaTiedostosta() {
        try {
            File kuvatiedosto = new File("./src/kansi.JPG");
            kansikuva = ImageIO.read(kuvatiedosto);

        } catch (IOException e) {
            System.out.println("tiedoston luku ei onnistu.");

        }

    }

    /**
     * Metodi lukee tiedostosta muistipelin taustakuvan.
     *
     */
    private void haePohjaTiedostosta() {
        try {
            File kuvatiedosto = new File("./src/pohja.JPG");
            taustakuva = ImageIO.read(kuvatiedosto);
        } catch (IOException e) {
            System.out.println("tiedoston luku ei onnistu.");
        }
    }

    public Muistipeli getMuistipeli() {
        return this.muistipeli;
    }

}
