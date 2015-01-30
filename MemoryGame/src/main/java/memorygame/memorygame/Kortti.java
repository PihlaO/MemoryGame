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
public class Kortti {

    private int tyyppi;
  

    public Kortti(int tyyppi) {
        this.tyyppi = tyyppi;
    }

    public int getTyyppi() {
        return this.tyyppi;
    }

    public String toString() {
        return "Kortin tyyppi on " + this.tyyppi;
    }
    
    public boolean onkoKortitSamat(Kortti kortti){
        if(this.getTyyppi()== kortti.getTyyppi()){
            return true;         
        }
        else {
            return false;
        }
    }
            
            

}
