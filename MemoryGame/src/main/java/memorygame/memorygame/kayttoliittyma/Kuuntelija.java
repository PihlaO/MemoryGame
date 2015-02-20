/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.memorygame.kayttoliittyma;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
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
public class Kuuntelija implements MouseListener {

    Piirtoalusta piirtoalusta;
    Muistipeli muistipeli;
    List<KuvallinenKortti> kuvallisetKortit;

    public Kuuntelija(Piirtoalusta piirtoalusta, Muistipeli muistipeli, List<KuvallinenKortti> kuvallisetKortit) {
        this.piirtoalusta = piirtoalusta;
        this.muistipeli = muistipeli;
        this.kuvallisetKortit = kuvallisetKortit;

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (!(this.klikattuKortti(e) == null)) {
            KuvallinenKortti kuvakortti = klikattuKortti(e);
            Kortti kortti = kuvakortti.getKortti();
            
            if (kortti.onkoKaannetu() == false) {
                kortti.kaannaKortti();
                this.piirtoalusta.repaint();
                this.muistipeli.getPelaaja().lisaaPiste();
                
                if (muistipeli.getPelilauta().getValittuKortti1() == null) {
                    muistipeli.getPelilauta().setValittuKortti1(kortti);
                    this.piirtoalusta.repaint();
                } else if (!(muistipeli.getPelilauta().getValittuKortti1() == null)) {
                    if (muistipeli.getPelilauta().getValittuKortti2() == null) {
                        muistipeli.getPelilauta().setValittuKortti2(kortti);

//                        this.piirtoalusta.repaint();
//                        try {
//                            Thread.sleep(3000);
//                        } catch (InterruptedException ex) {
//                            Logger.getLogger(Kuuntelija.class.getName()).log(Level.SEVERE, null, ex);
//                        }
                    }
                }

                if (!(muistipeli.getPelilauta().getValittuKortti1() == null) && !(muistipeli.getPelilauta().getValittuKortti2() == null)) {
                    boolean pari = muistipeli.getPelilauta().getValittuKortti1().onkoKortitSamat(muistipeli.getPelilauta().getValittuKortti2());

                    if (pari == false) {
                        muistipeli.getPelilauta().getValittuKortti1().kaannaKortti();
                        muistipeli.getPelilauta().getValittuKortti2().kaannaKortti();
                    }
                    muistipeli.getPelilauta().setValittuKortti1(null);
                    muistipeli.getPelilauta().setValittuKortti2(null);
                }
            }
        }
        if (peliPaattyi()) {
            TallennaPelaajaTilastoon();
            AvaaLopetusValikko();

        }

    }

    private void TallennaPelaajaTilastoon() {
        this.muistipeli.getPelitilasto().tallennaTilastoon(muistipeli.getPelaaja());
    }

    private boolean peliPaattyi() {
        int i = 0;
        for (KuvallinenKortti kortti : kuvallisetKortit) {
            if (kortti.getKortti().onkoKaannetu() == true) {
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
