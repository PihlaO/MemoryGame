/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.memorygame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author okpiok
 */
public class Korttipakka {
    
    List<Kortti> pakka;
    Vaikeustaso vaikeustaso;
    
    public Korttipakka(int taso) {
        this.pakka = new ArrayList<>();
        this.vaikeustaso = new Vaikeustaso(taso);
    }
    
    public void luoKortit() {        
        int uniikkienKorttienLukumaara=0;
        uniikkienKorttienLukumaara= this.vaikeustaso.haeKorttienLukumaara()/2;
        for (int i = 1; i <= uniikkienKorttienLukumaara; i++) {
            Kortti kortti = new Kortti(i);
            this.pakka.add(kortti);
            Kortti kortinPari = new Kortti(i);
            this.pakka.add(kortinPari);
            
        }
        
    }
    
    public void sekoitaPakka() {
        Collections.shuffle(pakka);
        
    }
}
