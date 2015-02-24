/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.memorygame.kayttoliittyma;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import memorygame.memorygame.Muistipeli;
import memorygame.memorygame.domain.Kortti;

/**
 *
 * @author okpiok
 */
/*
 *Luodaan muistipelille hiirenkuuntelija.
 */
public class Hiirikuuntelija implements MouseListener {

    Piirtoalusta piirtoalusta;
    Muistipeli muistipeli;

    

    public Hiirikuuntelija(Piirtoalusta piirtoalusta, Muistipeli muistipeli) {
        this.piirtoalusta = piirtoalusta;
        this.muistipeli = muistipeli;


    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (korttiaKlikattu(e)) {
            KuvallinenKortti kuvakortti = klikattuKortti(e);
            Kortti kortti = kuvakortti.getKortti();

            if (!kortti.kaannetty()) {
                kortti.kaannaKortti();
                this.muistipeli.lisaaPistePelaajalle();

                if (!this.muistipeli.PelilaudanEkaKorttiValittu()) {
                    this.muistipeli.ValitaanEkaksiKortiksi(kortti);
                } else if (this.muistipeli.PelilaudanEkaKorttiValittu()) {
                    if (!this.muistipeli.PelilaudanTokaKorttiValittu()) {
                        this.muistipeli.ValitaanTokaksiKortiksi(kortti);

                    }
                }
                System.out.println("piirrä");
                 this.piirtoalusta.validate();
                this.piirtoalusta.repaint();
               
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Hiirikuuntelija.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("piirretty");

                if (this.muistipeli.pelilaudanKortitValittu()) {

                    if (!this.muistipeli.pari()) {
                        this.muistipeli.kaannaPelilaudanValitutKortit();
                    }
                    this.muistipeli.tyhjennaPelilaudanValitutKortit();
                }
            }
        }
        if (this.muistipeli.peliPaattyi()) {
            this.muistipeli.TallennaPelaajaTilastoon();
            this.muistipeli.AvaaLopetusValikko();

        }

    }

    /**
     * Metodi hakee klikatun kortin.
     *
     * @param e Hiiren klikkaus
     * @return kuvallinen kortin
     */
    public KuvallinenKortti klikattuKortti(MouseEvent e) {
        for (KuvallinenKortti kuva : this.muistipeli.getKuvallisetKortit()) {
            Kortti kortti = kuva.getKortti();

            if (e.getX() > kortti.getX() * 100 + 50 && e.getY() > kortti.getY() * 100 + 50) {
                if (e.getX() < kortti.getX() * 105 + 50 + kortti.getLeveys() && e.getY() < kortti.getY() * 123 + 50 + kortti.getKorkeus()) {

                    return kuva;
                }
            }

        }
        return null;
    }

    public boolean korttiaKlikattu(MouseEvent e) {
        return !(this.klikattuKortti(e) == null);
    }


    @Override
    public void mousePressed(MouseEvent e
    ) {
    }

    @Override
    public void mouseReleased(MouseEvent e
    ) {
    }

    @Override
    public void mouseEntered(MouseEvent e
    ) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
