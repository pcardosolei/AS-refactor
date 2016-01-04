package main;

import Controllers.MainViewController;
import Views.MainView;

public class BetESSAPI {
    
    public static void main(String[] args){       
        MainView main = new MainView();
        MainViewController app = new MainViewController(main);     
    }
}
