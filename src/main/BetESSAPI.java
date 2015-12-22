/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Controllers.MainViewController;
import Views.MainView;

/**
 *
 * @author Portatilcar
 */
public class BetESSAPI {
    
    
    public static void main(String[] args){
        
        MainView main = new MainView();
        MainViewController app = new MainViewController(main);
        
    }
    
}
