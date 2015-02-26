/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame.domain;

/**
 *
 * @author okpiok
 */
/* 
 * Luokka muistipelin korttien kuville.
 */
public class KuvallinenKortti{

    Kortti kortti;

    public KuvallinenKortti(Kortti kortti) {

        this.kortti = kortti;

    }

    public Kortti getKortti() {
        return this.kortti;
    }

    @Override
    public String toString() {
        return this.kortti.toString();
    }
}
