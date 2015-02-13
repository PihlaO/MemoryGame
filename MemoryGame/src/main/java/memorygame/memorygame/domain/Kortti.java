/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.memorygame.domain;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

/**
 *
 * @author okpiok
 */

/* 
 * Mustipelikortin luokka. 
 */
public class Kortti {

    private int tyyppi;
    private boolean kaannettu;
    int x;
    int y;
    int korkeus;
    int leveys;
    private Image kansikuva;
    private Image kuva;

    public Kortti(int tyyppi) {
        this.tyyppi = tyyppi;
        this.kaannettu = false;
        this.korkeus = 70;
        this.leveys = 90;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int koordinaatti) {
        this.x = koordinaatti;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int koordinaatti) {
        this.y = koordinaatti;
    }

    public int getKorkeus() {
        return this.korkeus;
    }

    public int getLeveys() {
        return this.leveys;
    }

    public int getTyyppi() {
        return this.tyyppi;
    }


    public void setKansikuva(Image i) {

    }

    public void setKuva(Image i) {

    }

    public Image getKansikuva() {
        return this.kansikuva;
    }

    public Image getKuva() {
        return this.kuva;
    }

    public boolean onkoKaannetu() {
        return this.kaannettu;
    }

    public void kaannaKortti() {
        if (this.onkoKaannetu() == true) {
            this.kaannettu = false;
        } else {
            this.kaannettu = true;
        }
    }

    public boolean onkoKortitSamat(Kortti kortti) {
        if (this.getTyyppi() == kortti.getTyyppi()) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return "Kortin tyyppi on " + this.tyyppi + "käännetty" + this.kaannettu;
    }

}