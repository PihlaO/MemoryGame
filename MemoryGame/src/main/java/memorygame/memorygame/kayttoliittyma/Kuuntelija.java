/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.memorygame.kayttoliittyma;

import java.awt.Component;
import java.awt.event.ActionEvent;
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

    public Kuuntelija(Component piirtoalusta, Pelilauta lauta) {
        this.piirtoalusta = piirtoalusta;
        this.pelilauta = lauta;

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //if(!(this.klikattuKortti(e)==null)){
        System.out.println("Korttia painettu");
        //}
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Kortti klikattuKortti(MouseEvent e) { // tarkista toimiiko oikein!
        for (Kortti kortti : pelilauta.getKorttipakka().haeKorttipakka()) {
            if (e.getX() > kortti.getX() && e.getX() <= kortti.getX() + kortti.getLeveys()) {
                if (e.getY() < kortti.getY() && e.getY() >= kortti.getY() + kortti.getKorkeus()) {
                    return kortti;
                }
            }
        }
        return null;
    }

}
