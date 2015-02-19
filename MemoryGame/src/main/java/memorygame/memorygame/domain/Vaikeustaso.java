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
 * Pelin vaikeustaso. 
 * Tasot ja niitä vastaavat korttien lukumäärät:
 * 1 = helppo (3*4 korttia=12), 2 = keskitaso (4*4 korttia= 16), 3 = vaikea (4*5 korttia=20)
 * Oletuksena on helppotaso (12 korttia)
 */
public class Vaikeustaso {

    int tasonTunnus;
    String nimi;

    public Vaikeustaso(int taso) {
        this.tasonTunnus = taso;
        asetaTasolleNimi();
    }

    private void asetaTasolleNimi() {
        if (tasonTunnus == 1) {
            this.nimi = "Helppo";
        }
        if (tasonTunnus == 2) {
            this.nimi = "Keskitaso";
        }
        if (tasonTunnus == 3) {
            this.nimi = "Vaikea";
        }
    }

    public int getTasonTunnus() {
        return tasonTunnus;
    }

    @Override
    public String toString() {
        return this.nimi;
    }

    /**
     * Metodi hakee tason korttien lukumäärän.
     *
     * @return korttien lukumäärä
     */
    public int haeKorttienLukumaara() {
        if (tasonTunnus == 1) {
            return 12;
        }
        if (tasonTunnus == 2) {
            return 16;
        }
        if (tasonTunnus == 3) {
            return 20;
        } else {
            return 12;
        }
    }

}
