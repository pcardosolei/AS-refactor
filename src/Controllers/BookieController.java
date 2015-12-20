/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Bookie;

/**
 *
 * @author Portatilcar
 */
public class BookieController {
      private Bookie bookie;
    
    
     public BookieController(Bookie bookie){
        this.bookie = bookie;
    }
     
    public String getName(){return bookie.getName();}
    
}
