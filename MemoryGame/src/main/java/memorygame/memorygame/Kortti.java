/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.memorygame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

/**
 *
 * @author okpiok
 */
public class Kortti extends Image{

    private int tyyppi;
    private Image kansikuva;
    private Image kuva;
  

    public Kortti(int tyyppi) {
        this.tyyppi = tyyppi;
    }

    public int getTyyppi() {
        return this.tyyppi;
    }

    public String toString() {
        return "Kortin tyyppi on " + this.tyyppi;
    }
    
    public boolean onkoKortitSamat(Kortti kortti){
        if(this.getTyyppi()== kortti.getTyyppi()){
            return true;         
        }
        else {
            return false;
        }
    }

    @Override
    public int getWidth(ImageObserver observer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getHeight(ImageObserver observer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ImageProducer getSource() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Graphics getGraphics() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getProperty(String arg0, ImageObserver arg1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
            
            

}
