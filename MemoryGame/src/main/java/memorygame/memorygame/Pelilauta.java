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
public class Pelilauta {

    Korttipakka korttipakka;
    Kortti[][] muistikortitkortit;

    public Pelilauta(Korttipakka pakka) {
        this.korttipakka = pakka;
        this.muistikortitkortit = new Kortti[pelilaudanRivienLukumaara()][pelilaudanSarakkeidenLukumaara()];
    }

    public void luoPelilauta() {
        this.korttipakka.luoKortit();
        korttipakka.sekoitaPakka();
        int kortinIndeksiPakssa = 0;
        for (int i = 0; i < pelilaudanRivienLukumaara(); i++) {

            for (int j = 0; j < pelilaudanSarakkeidenLukumaara(); j++) {
                muistikortitkortit[i][j] = korttipakka.pakka.get(kortinIndeksiPakssa);
                kortinIndeksiPakssa++;
            }

        }
    }

    public void tulostaPelilauta() {
        for (int i = 0; i < this.pelilaudanRivienLukumaara(); i++) {

            for (int j = 0; j < pelilaudanSarakkeidenLukumaara(); j++) {
                System.out.println(this.getKorttiXY(i, j));

            }

        }

    }

    public int pelilaudanRivienLukumaara() {
        return korttipakka.vaikeustaso.haeKorttienLukumaara() / 4;
    }

    public int pelilaudanSarakkeidenLukumaara() {
        return 4;
    }

    public Kortti getKorttiXY(int x, int y) {
        return this.muistikortitkortit[x][y];
    }
}
