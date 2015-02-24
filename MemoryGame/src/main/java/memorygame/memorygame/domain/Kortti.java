/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.memorygame.domain;

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
    int leveys;
    int korkeus;

    public Kortti(int tyyppi) {
        this.tyyppi = tyyppi;
        this.kaannettu = false;
        this.leveys = 100;
        this.korkeus = 120;
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

    /**
     * Metodi kertoo, onko kortti käännetty. Jos kortti on käännetty, niin
     * metodi palauttaa true, muulloin false.
     *
     * @return Kortin tila
     */
    public boolean kaannetty() {
        return this.kaannettu;
    }

    /**
     * Metodi kääntää kortin.
     *
     */
    public void kaannaKortti() {
        if (this.kaannetty() == true) {
            this.kaannettu = false;
        } else {
            this.kaannettu = true;
        }
    }

    /**
     * Metodi vertaa kahden kortin tyyppejä ja selvittää onko kortit samat.
     *
     * @param kortti varrattava kortti
     * @return totuusarvo
     *
     */
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
