
import memorygame.memorygame.Pelaaja;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author okpiok
 */
public class Paaohjelma {

    public static void main(String[] args) {
        Pelaaja p = new Pelaaja("Pekka");
        p.setPisteet(2);
        p.toString();
        p.setPisteet(-4);
        p.toString();
    }

}
