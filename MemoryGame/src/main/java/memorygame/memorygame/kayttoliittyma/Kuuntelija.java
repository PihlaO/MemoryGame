/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.memorygame.kayttoliittyma;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import memorygame.memorygame.Muistipeli;
import memorygame.memorygame.domain.Kortti;
import memorygame.memorygame.domain.Pelilauta;
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
        System.out.println(e.getX() + " " + e.getY());

        if (!(this.klikattuKortti(e) == null)) {
            System.out.println("Korttia painettu");
            KuvallinenKortti kuvakortti = klikattuKortti(e);
            Kortti kortti = kuvakortti.getKortti();
            System.out.println(kortti);

            if (kortti.onkoKaannetu() == false && !(kortti.equals(muistipeli.getPelilauta().getValittuKortti1()))) {
                kortti.kaannaKortti();
                this.piirtoalusta.repaint();
                this.muistipeli.getPelaaja().lisaaPiste();

                if (muistipeli.getPelilauta().getValittuKortti1() == null) {
                    muistipeli.getPelilauta().setValittuKortti1(kortti);
                    //this.piirtoalusta.repaint();

                    System.out.println(this.muistipeli.getPelilauta().getValittuKortti1());
                    System.out.println("eka valittu:" + this.muistipeli.getPelilauta().getValittuKortti1());

                } else if (!(muistipeli.getPelilauta().getValittuKortti1() == null)) {
                    if (muistipeli.getPelilauta().getValittuKortti2() == null) {
                        muistipeli.getPelilauta().setValittuKortti2(kortti);
                        this.piirtoalusta.repaint();
                        System.out.println("toka valittu" + this.muistipeli.getPelilauta().getValittuKortti2());
                    }
                }

                if (!(muistipeli.getPelilauta().getValittuKortti1() == null) && !(muistipeli.getPelilauta().getValittuKortti2() == null)) {
                    boolean pari = muistipeli.getPelilauta().getValittuKortti1().onkoKortitSamat(muistipeli.getPelilauta().getValittuKortti2());

                    if (pari == false) {
                        try {
                            Thread.sleep(1500);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Kuuntelija.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        muistipeli.getPelilauta().getValittuKortti1().kaannaKortti();
                        muistipeli.getPelilauta().setValittuKortti1(null);
                        muistipeli.getPelilauta().getValittuKortti2().kaannaKortti();

                        muistipeli.getPelilauta().setValittuKortti2(null);
                        System.out.println("eivät ole pari");
                    }

//                    System.out.println(muistipeli.getPelilauta().getValittuKortti1());
//                    System.out.println(muistipeli.getPelilauta().getValittuKortti2());
                    muistipeli.getPelilauta().setValittuKortti1(null);
                    muistipeli.getPelilauta().setValittuKortti2(null);

                }

            }

        }
        if (peliPaattyi()) {
            this.muistipeli.getPelitilasto().tallennaTilastoon(muistipeli.getPelaaja());
            System.out.println("Peli päättyi");
            this.muistipeli.getKayttoliittyma().getFrame().setVisible(false);

            LopetusKayttoliittyma lopetusvalikko = new LopetusKayttoliittyma(muistipeli);
            SwingUtilities.invokeLater(lopetusvalikko);

        }

        System.out.println(this.muistipeli.getPelaaja());

    }

    private boolean peliPaattyi() {
        int i = 0;
        for (KuvallinenKortti kortti : kuvallisetKortit) {

            if (kortti.getKortti().onkoKaannetu() == true) {
                i++;
            }
        }
        if (i == kuvallisetKortit.size()) {
            System.out.println("Peli päättyi");
            return true;
        } else {
            return false;
        }

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

    /**
     * Metodi hakee klikatun kortin.
     *
     * @param MouseEvent
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

//    public void kokeilu() {
//        Timer t = new Timer(1000 * 5, new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                // do your reoccuring task
//            }
//        });
//    }
}
