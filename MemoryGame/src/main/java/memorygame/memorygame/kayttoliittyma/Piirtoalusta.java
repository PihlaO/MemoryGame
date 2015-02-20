/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.memorygame.kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import memorygame.memorygame.Muistipeli;
import memorygame.memorygame.domain.Kortti;
import memorygame.memorygame.domain.Korttipakka;

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
    List<KuvallinenKortti> kuvallisetKortit;

    public Piirtoalusta(Muistipeli muistipeli) {
        this.muistipeli = muistipeli;
        super.setBackground(Color.WHITE);
        this.kuvallisetKortit = new ArrayList<>();

        haeKansikuvaTiedostosta();
        this.luoKuvallisetKortit();

        lisaaKuuntelija(this);

    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

//        haePohjaTiedostosta();  // ei vielä pohjakuvaa
//        this.piirraTausta(graphics);
        
        graphics.drawString("Muistipeli     " + "     Vaikeustaso: " + this.muistipeli.getKorttipakka().haeVaikeustaso().toString() + "     Pelaaja: " + muistipeli.getPelaaja(), 17, 700);
        
        for (KuvallinenKortti k : this.kuvallisetKortit) {
            Kortti kortti = k.getKortti();
            if (kortti.kaannetty()) {
                haeKuvaTiedostosta(kortti.getTyyppi());
                this.piirraKortinKuva(kortti, graphics);
            } else {
                this.piirraKortinKansi(kortti, graphics);
            }
        }

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

    /**
     * Metodi lisaa kuuntelijan.
     *
     * @param muistipelin piirtoalusta
     *
     */
    private void lisaaKuuntelija(Piirtoalusta piirtoalusta) {
        Hiirikuuntelija k = new Hiirikuuntelija(piirtoalusta, muistipeli, kuvallisetKortit);
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
     */
    public void piirraKortinKansi(Kortti k, Graphics graphics) {

        graphics.drawImage(kansikuva, k.getX() * 105 + 50, k.getY() * 123 + 50, k.getLeveys(), k.getKorkeus(), this);

    }

    /**
     * Metodi piirtää kortin kuvan.
     *
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
            KuvallinenKortti kuvallinenkortti = new KuvallinenKortti(kansikuva, kuva, kortti);
            kuvallisetKortit.add(kuvallinenkortti);
        }

    }

    /**
     * Metodi hakee listan kuvallisita korteista.
     *
     * @return kuvalliset kortit
     *
     */
    public List<KuvallinenKortti> haeKuvallisetKortit() {
        return this.kuvallisetKortit;
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
