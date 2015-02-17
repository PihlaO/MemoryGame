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
import memorygame.memorygame.domain.Kortti;
import memorygame.memorygame.domain.Pelilauta;

/**
 *
 * @author okpiok
 */
/*
 *Luodaan muistipelille hiirenkuuntelija.
 */
public class Kuuntelija implements MouseListener {

    Component piirtoalusta;
    Pelilauta pelilauta;
    List<KuvallinenKortti> kuvallisetKortit;

    public Kuuntelija(Component piirtoalusta, Pelilauta lauta, List<KuvallinenKortti> kuvallisetKortit) {
        this.piirtoalusta = piirtoalusta;
        this.pelilauta = lauta;
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
            if (kortti.onkoKaannetu() == false) {
                kortti.kaannaKortti();
                System.out.println(kortti);

                this.piirtoalusta.repaint();
                if (pelilauta.getValittuKortti1() == null) {
                    pelilauta.setValittuKortti1(kortti);

                    System.out.println("eka valittu:" + this.pelilauta.getValittuKortti1());

                } else if (!(pelilauta.getValittuKortti1() == null)) {
                    if (pelilauta.getValittuKortti2() == null) {
                        pelilauta.setValittuKortti2(kortti);

                        System.out.println("toka valittu" + this.pelilauta.getValittuKortti2());
                    }
                }

                this.piirtoalusta.repaint();

                if (!(pelilauta.getValittuKortti1() == null) && !(pelilauta.getValittuKortti2() == null)) {
                    boolean pari = pelilauta.getValittuKortti1().onkoKortitSamat(pelilauta.getValittuKortti2());
                    this.piirtoalusta.repaint();
                    if (pari == false) {
                        pelilauta.getValittuKortti1().kaannaKortti();
                        pelilauta.setValittuKortti1(null);
                        pelilauta.getValittuKortti2().kaannaKortti();
                        pelilauta.setValittuKortti2(null);
                    }

                    System.out.println(this.pelilauta.getValittuKortti1());
                    System.out.println(this.pelilauta.getValittuKortti2());

                    pelilauta.setValittuKortti1(null);
                    pelilauta.setValittuKortti2(null);

                    System.out.println("ok");

                }
            }

        }
        this.piirtoalusta.repaint();

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
                if (e.getX() < kortti.getX() * 100 + 50 + kortti.getKorkeus() && e.getY() < kortti.getY() * 100 + 50 + kortti.getLeveys()) {

                    return kuva;
                }
            }

        }
        return null;
    }
}
