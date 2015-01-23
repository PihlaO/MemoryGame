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
public class Vaikeustaso {
    // Tänne tasot ja niitä vastaavat korttien lukumäärät
    // 1 = helppo (3*4 korttia), 2 = keskitaso (4*4 korttia), 3 = vaikea (4*5 korttia)

    int tasonTunnus;

    public Vaikeustaso(int taso) {
        this.tasonTunnus = taso;
    }

    public int getTasonTunnus() {
        return tasonTunnus;
    }

    public int haeKorttienLukumaara() { // korjaa tämä metodi!
        if (tasonTunnus == 1) {
            return 12;
        }
        if (tasonTunnus == 2) {
            return 16;
        }
        if (tasonTunnus == 3) {
            return 20;
        } else {
            return 0;
        }
    }

}
