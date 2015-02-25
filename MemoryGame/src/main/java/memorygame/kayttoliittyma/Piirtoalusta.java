/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.kayttoliittyma;

import memorygame.kayttoliittyma.KuvallinenKortti;
import memorygame.kayttoliittyma.Hiirikuuntelija;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import memorygame.logiikka.Muistipeli;
import memorygame.domain.Kortti;
import memorygame.domain.Korttipakka;

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
    private BufferedImage pohja;

    public Piirtoalusta(Muistipeli muistipeli) {
        this.muistipeli = muistipeli;
        super.setBackground(Color.WHITE);
        luoKuvallisetKortit();
        lisaaKuuntelija(this);

    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

//        haePohjaTiedostosta();  // ei vielä taustakuvaa
//        this.piirraTausta(graphics);
        graphics.drawString("Muistipeli     " + "     Vaikeustaso: " + this.muistipeli.getPelilauta().getKorttipakka().haeVaikeustaso().toString() + "     Pelaaja: " + muistipeli.getPelaaja(), 17, 700);

        for (Kortti k : this.muistipeli.getPelilauta().getKorttipakka().haeKorttipakka()) {
            Kortti kortti = k;
            if (kortti.kaannetty()) {
                this.haeKuvaTiedostosta(kortti.getTyyppi());
                this.piirraKortinKuva(kortti, graphics);
            } else {
                haeKansikuvaTiedostosta();
                this.piirraKortinKansi(k, graphics);
            }
        }

    }

    /**
     * Metodi lukee tiedostosta kansikuvan.
     *
     */
    /**
     * Metodi lukee tiedostosta kuvan.
     *
     */
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

    private void piirraPakanKorteilleKansi(Korttipakka pakka, Graphics graphics) {
        for (Kortti kortti : this.muistipeli.getPelilauta().getKorttipakka().haeKorttipakka()) {
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
     * Metodi luo kuvalliset kortit.
     *
     */
    public void luoKuvallisetKortit() {

        for (Kortti kortti : this.muistipeli.getPelilauta().getKorttipakka().haeKorttipakka()) {

            KuvallinenKortti kuvallinenkortti = new KuvallinenKortti(kortti);
            this.muistipeli.getKuvallisetKortit().add(kuvallinenkortti);

        }

    }

    public void haeKuvaTiedostosta(int tyyppi) {

        try {
            File kuvatiedosto = new File("./kuva" + tyyppi + ".jpg");
            kuva = ImageIO.read(kuvatiedosto);

        } catch (IOException e) {
            System.out.println("tiedoston luku ei onnistu.");

        }
    }
//

    public void haeKansikuvaTiedostosta() {
        try {
            File kuvatiedosto = new File("./kansikuva.png");
            kansikuva = ImageIO.read(kuvatiedosto);

        } catch (IOException e) {
            System.out.println("tiedoston luku ei onnistu.");

        }

    }
    public Muistipeli getMuistipeli(){
        return this.muistipeli;
    }

//    private boolean piirraTausta(Graphics graphics) {
//        return graphics.drawImage(pohja, 0 ,0, 750, 750, this);
//    }
//        private void haePohjaTiedostosta() {  
//        try {
//            File kuvatiedosto = new File("./******.jpg");
//            pohja = ImageIO.read(kuvatiedosto);
//        } catch (IOException e) {
//            System.out.println("tiedoston luku ei onnistu.");
//        }
//    }
}
