/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.memorygame.kayttoliittyma;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import memorygame.memorygame.domain.Kortti;

/**
 *
 * @author okpiok
 */
/* 
 * Luokka muistipelin korttien kuville.
 */
public class KuvallinenKortti extends Image {

    Image kansikuva;
    Image kuva;
    Kortti kortti;

    public KuvallinenKortti(Image kansikuva, Image kuva, Kortti kortti) {
        this.kansikuva = kansikuva;
        this.kuva = kuva;
        this.kortti = kortti;
    }

    public Kortti getKortti() {
        return this.kortti;
    }

    @Override
    public String toString() {
        return this.kortti.toString();
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
