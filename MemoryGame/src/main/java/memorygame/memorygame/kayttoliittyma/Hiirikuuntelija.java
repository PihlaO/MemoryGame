/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.memorygame.kayttoliittyma;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import memorygame.memorygame.Muistipeli;
import memorygame.memorygame.domain.Kortti;
import memorygame.memorygame.valikot.LopetusKayttoliittyma;

/**
 *
 * @author okpiok
 */
/*
 *Luodaan muistipelille hiirenkuuntelija.
 */
public class Hiirikuuntelija implements MouseListener {

    Component piirtoalusta;
    Muistipeli muistipeli;
    List<KuvallinenKortti> kuvallisetKortit;

    public Hiirikuuntelija(Component piirtoalusta, Muistipeli muistipeli, List<KuvallinenKortti> kuvallisetKortit) {
        this.piirtoalusta = piirtoalusta;
        this.muistipeli = muistipeli;
        this.kuvallisetKortit = kuvallisetKortit;

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (korttiaKlikattu(e)) {
            KuvallinenKortti kuvakortti = klikattuKortti(e);
            Kortti kortti = kuvakortti.getKortti();

            if (!kortti.kaannetty()) {
                kortti.kaannaKortti();
                lisaaPistePelaajalle();

                if (!PelilaudanEkaKorttiValittu()) {
                    ValitaanEkaksiKortiksi(kortti);
                } else if (PelilaudanEkaKorttiValittu()) {
                    if (!PelilaudanTokaKorttiValittu()) {
                        ValitaanTokaksiKortiksi(kortti);

                    }
                }
//                System.out.println("piirrä");
                this.piirtoalusta.repaint();
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(Hiirikuuntelija.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                System.out.println("piirretty");

                if (pelilaudanKortitValittu()) {

                    if (!pari()) {
                        kaannaPelilaudanValitutKortit();
                    }
                    tyhjennaPelilaudanValitutKortit();
                }
            }
        }
        if (peliPaattyi()) {
            TallennaPelaajaTilastoon();
            AvaaLopetusValikko();

        }

    }

    private void ValitaanTokaksiKortiksi(Kortti kortti) {
        muistipeli.getPelilauta().setValittuKortti2(kortti);

    }

    private void ValitaanEkaksiKortiksi(Kortti kortti) {
        muistipeli.getPelilauta().setValittuKortti1(kortti);
    }

    private boolean PelilaudanEkaKorttiValittu() {
        return !(muistipeli.getPelilauta().getValittuKortti1() == null);
    }

    private boolean PelilaudanTokaKorttiValittu() {
        return !(muistipeli.getPelilauta().getValittuKortti2() == null);
    }

    private boolean korttiaKlikattu(MouseEvent e) {
        return !(this.klikattuKortti(e) == null);
    }

    /**
     * Metodi pelilaudanKortitValittu palauttaa true, jos Pelilaudan kortti1 ja
     * kortti 2 on valittu ja muulloin false.
     *
     * @return boolean
     */
    private boolean pelilaudanKortitValittu() {
        return !(muistipeli.getPelilauta().getValittuKortti1() == null) && !(muistipeli.getPelilauta().getValittuKortti2() == null);
    }

    /**
     * Metodi tyhjennaPelilaudanValitusKortit asettaa null Pelilaudan kortti1 ja
     * kortti2 arvoiksi.
     *
     */
    private void tyhjennaPelilaudanValitutKortit() {
        muistipeli.getPelilauta().setValittuKortti1(null);
        muistipeli.getPelilauta().setValittuKortti2(null);
    }

    /**
     * Metodi kaannaPelilaudanValitutKortit kääntää Pelilaudan kortti1 ja
     * kortti2.
     *
     */
    private void kaannaPelilaudanValitutKortit() {
        muistipeli.getPelilauta().getValittuKortti1().kaannaKortti();
        muistipeli.getPelilauta().getValittuKortti2().kaannaKortti();
    }

    private boolean pari() {
        return muistipeli.getPelilauta().getValittuKortti1().onkoKortitSamat(muistipeli.getPelilauta().getValittuKortti2());
    }

    private void lisaaPistePelaajalle() {
        this.muistipeli.getPelaaja().lisaaPiste();
    }

    private void TallennaPelaajaTilastoon() {
        this.muistipeli.getPelitilasto().tallennaTilastoon(muistipeli.getPelaaja());
    }

    private boolean peliPaattyi() {
        int i = 0;
        for (KuvallinenKortti kortti : kuvallisetKortit) {
            if (kortti.getKortti().kaannetty() == true) {
                i++;
            }
        }
        if (i == kuvallisetKortit.size()) {
            return true;
        } else {
            return false;
        }

    }

    private void AvaaLopetusValikko() {
        this.muistipeli.getPelinKayttoliittyma().getFrame().setVisible(false);
        LopetusKayttoliittyma lopetusvalikko = new LopetusKayttoliittyma(muistipeli, this.muistipeli.getAloitusKayttoliittyma());
        SwingUtilities.invokeLater(lopetusvalikko);
    }

    /**
     * Metodi hakee klikatun kortin.
     *
     * @param e Hiiren klikkaus
     * @return kuvallinen kortin
     */
    public KuvallinenKortti klikattuKortti(MouseEvent e) {
        for (KuvallinenKortti kuva : kuvallisetKortit) {
            Kortti kortti = kuva.getKortti();

            if (e.getX() > kortti.getX() * 100 + 50 && e.getY() > kortti.getY() * 100 + 50) {
                if (e.getX() < kortti.getX() * 105 + 50 + kortti.getLeveys() && e.getY() < kortti.getY() * 123 + 50 + kortti.getKorkeus()) {

                    return kuva;
                }
            }

        }
        return null;
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
