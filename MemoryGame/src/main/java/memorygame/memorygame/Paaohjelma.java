/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.memorygame;

/**
 *
 * @author okpiok
 */
public class Paaohjelma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pelaaja p = new Pelaaja("Pekka");
        Pelaaja p2 = new Pelaaja("Anna");
        Pelitilasto tilasto= new Pelitilasto("top5");
        tilasto.tallennaTilastoon(p);
        tilasto.tallennaTilastoon(p2);
        tilasto.tulostaTilasto();
    }

}
