/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.kayttoliittyma;

import memorygame.domain.KuvallinenKortti;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import memorygame.domain.Kortti;

/**
 *
 * @author okpiok
 */

/*
 *Luodaan muistipelille hiirenkuuntelija.
 */
public class Hiirikuuntelija implements MouseListener {

    Piirtoalusta piirtoalusta;

    public Hiirikuuntelija(Piirtoalusta piirtoalusta) {
        this.piirtoalusta = piirtoalusta;

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (korttiaKlikattu(e)) {
            this.piirtoalusta.muistipeli.logiikka(this.klikattuKortti(e));
        }
        this.piirtoalusta.repaint();

    }

    /**
     * Metodi hakee klikatun kortin.
     *
     * @param e Hiiren klikkaus
     * @return klikattu kortti
     */
    public Kortti klikattuKortti(MouseEvent e) {
        for (KuvallinenKortti kuvallinenKortti : this.piirtoalusta.muistipeli.getKuvallisetKortit()) {
            Kortti kortti = kuvallinenKortti.getKortti();

            if (e.getX() > kortti.getX() * 100 + 50 && e.getY() > kortti.getY() * 100 + 50) {
                if (e.getX() < kortti.getX() * 105 + 50 + kortti.getLeveys() && e.getY() < kortti.getY() * 123 + 50 + kortti.getKorkeus()) {

                    return kortti;
                }
            }

        }
        return null;
    }

    /**
     * Metodi kertoo, onko hiiren klikkaus osunut korttiin. Jos korttia on
     * klikattu metodi palauttaa true, muulloin false.
     *
     * @param e Hiiren klikkaus
     * @return totuusarvo
     */
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
