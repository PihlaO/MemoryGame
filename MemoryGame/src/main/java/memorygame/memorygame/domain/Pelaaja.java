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
 * Pelaaja luokka. 
 * Pelaajalla on nimi ja pisteet. 
 */
public class Pelaaja {

    String nimi;
    int pisteet;

    public Pelaaja(String nimi) {
        this.nimi = nimi;
        this.pisteet = 0;
    }

    public String getNimi() {
        return this.nimi;
    }

    public int getPisteet() {
        return this.pisteet;
    }
/**
 * Metodi asettaa pelaajalle pisteet
 *
 * @param   luku   Pelin antama luku
 * 
 */
    public void setPisteet(int luku) {
        if (luku >= 0) {
            this.pisteet = luku;
        }
    }
    
    public void lisaaPiste(){
        int luku= getPisteet()+1;
        setPisteet(luku);
    }

    public String toString() {
        return this.nimi + " " + "     Pisteet: "+ getPisteet();
    }
}
