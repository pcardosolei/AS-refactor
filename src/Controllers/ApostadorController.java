/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Apostador;

/**
 *
 * @author Portatilcar
 */
public class ApostadorController {
    
    private Apostador apostador;
    
    
    public ApostadorController(Apostador apostador){
        this.apostador = apostador;
    }
    
    public double getCoins(){ return apostador.getBetESScoins();}
    public String getName(){return apostador.getName();}
    
    
}
