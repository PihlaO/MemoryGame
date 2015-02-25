/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.kayttoliittyma;

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

        if (this.piirtoalusta.getMuistipeli().korttiaKlikattu(e)) {
            this.piirtoalusta.getMuistipeli().logiikka(e);

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

}
