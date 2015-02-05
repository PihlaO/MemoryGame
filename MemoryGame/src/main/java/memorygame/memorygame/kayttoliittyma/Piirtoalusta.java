/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.memorygame.kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import memorygame.memorygame.domain.Kortti;
import memorygame.memorygame.Muistipeli;
import memorygame.memorygame.domain.Pelilauta;

/**
 *
 * @author okpiok
 */
/*
 * Muistipelin piirtoalusta.
 */
public class Piirtoalusta extends JPanel {
    
    Pelilauta pelilauta;
    
    
    public Piirtoalusta(Pelilauta p) {
        this.pelilauta = p;
        super.setBackground(Color.WHITE);
        
    }
    
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        
        for (Kortti kortti : this.pelilauta.getKorttipakka().haeKorttipakka()) {
            this.piirraKortti(kortti, graphics);
            
        }
        
    }
    
    public void piirraKortti(Kortti k, Graphics graphics) {
        graphics.fillRect(k.getX()*100+50, k.getY()*100+50, k.getKorkeus(), k.getLeveys());
    }
    
}
