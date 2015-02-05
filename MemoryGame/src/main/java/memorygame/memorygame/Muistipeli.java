/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package memorygame.memorygame;

import memorygame.memorygame.domain.Pelilauta;

/**
 *
 * @author okpiok
 */
/*
 * Muistipeli
 */
public class Muistipeli {
    /// Kokeilu
    Pelilauta pelilauta;
    
    public Muistipeli(Pelilauta pelilauta){
        this.pelilauta = pelilauta;
    }
    
    public Pelilauta getPelilauta(){
        return this.pelilauta;
    }
}
