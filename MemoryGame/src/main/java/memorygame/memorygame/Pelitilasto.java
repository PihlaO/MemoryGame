/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.memorygame;

import memorygame.memorygame.domain.Pelaaja;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author okpiok
 */
/*
 * Muistipelin tilasto, jossa luodaan lista pelaajista.
 */
public class Pelitilasto {

    String nimi;
    List<Pelaaja> tilasto;

    public Pelitilasto(String nimi) {
        this.nimi = nimi;
        this.tilasto = new ArrayList<>();
    }

    public String getNimi() {
        return this.nimi;
    }

    public void tallennaTilastoon(Pelaaja pelaaja) {
        tilasto.add(pelaaja);
    }
    
    public void tyhjennaTilasto(){
        tilasto.clear();
    }
    
    public List<Pelaaja> haeTilastolista(){
        return this.tilasto;
    }

    public void tulostaTilasto() {
        for (int i = 0; i < tilasto.size(); i++) {
            System.out.println(tilasto.get(i));

        }
    }

}
