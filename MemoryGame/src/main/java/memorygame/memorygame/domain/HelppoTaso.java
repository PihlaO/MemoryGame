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
 * Luokka kuvaa helppoa vaikeustasoa.
 */
public class HelppoTaso {

    int korttienLukumaara;

    public HelppoTaso() {
        korttienLukumaara = 12;

    }

    /**
     * Metodi palautta korttien lukumäärän.
     *
     * @return korttien lukumäärä
     */
    public int haeKorttienLukumaara() {
        return this.korttienLukumaara;
    }

}
