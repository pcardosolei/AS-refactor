/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.LoginInfo;
import Views.LoginView;
import Views.MainView;


/**
 *
 * @author Portatilcar
 */
public class MainViewController {
    
    private LoginInfo loginInfo;
    private MainView mainview;
    private ApostadorController apostadorControlador;
    private BookieController bookiesControlador;
    
    public MainViewController(MainView view){
        this.mainview = view;
        this.loginInfo = new LoginInfo();
        apostadorControlador = new ApostadorController();
        bookiesControlador  = new BookieController();
        startApp();
        this.mainview.setVisible(true);
    }
    
    
  
    public void updateLogin(){
        this.mainview.setEmailText(apostadorControlador.getEmail(loginInfo.getName()));
        this.mainview.setNomeText(apostadorControlador.getName(loginInfo.getName()));
    }
    
    public void startApp(){
        LoginView login = new LoginView();  
        LoginViewController loginController = new LoginViewController(login,apostadorControlador,bookiesControlador,loginInfo);   
        loginController.setMainController(this);
        login.setVisible(true);
        
    }
}
