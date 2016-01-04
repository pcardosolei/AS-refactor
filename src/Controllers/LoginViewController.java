package Controllers;

import Exception.ErroException;
import Models.LoginInfo;
import Views.LoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginViewController {
    
    private final LoginInfo loginInfo;
    private LoginView view;
    private ApostadorController apostadoresController;
    private BookieController bookiesController;
    private MainViewController mainController;
    
    public LoginViewController(LoginView view,ApostadorController apostadoresController,BookieController bookiesController,LoginInfo logininfo){
        this.view = view;
        this.loginInfo = logininfo;
        this.apostadoresController = apostadoresController;
        this.bookiesController = bookiesController;
        this.view.addLoginListener(new LoginListener());
        this.view.addRegistoListener(new RegistoListener());
    }
    
    public void setMainController(MainViewController controlador){
        this.mainController = controlador;
    }
    
    class LoginListener implements ActionListener {

            String nome, password, escolha , email;

    @Override
    public void actionPerformed(ActionEvent e) {
            try{
                nome = view.getUsername();
                password = view.getPassword();
                escolha = view.getEscolha();
                email = view.getEmail();       
                confirmarUser(nome,password,escolha);
                }catch(NullPointerException a){
                   view.setNotificacao("Introduza campos válidos");
                }
        }
    }
    
    class RegistoListener implements ActionListener {

            String nome, password, escolha , email;
            
    @Override
    public void actionPerformed(ActionEvent e) {
            try{
                nome = view.getUsername();
                password = view.getPassword();
                escolha = view.getEscolha();
                email = view.getEmail();
                adicionarUser(nome,password,escolha,email);
                }catch(NullPointerException a){
                   view.setNotificacao("Introduza campos válidos");
            }
        }
    }
    
    public void adicionarUser(String nome,String password,String escolha,String email){
        if(escolha.equals("Apostador"))
            apostadoresController.registaApostador(nome,email,password);
         else
             bookiesController.registaBookie(nome,email,password);           
    }
    
    public void confirmarUser(String nome,String password,String escolha){
        try{
        boolean flag;
        if(escolha.equals("Apostador"))
            flag = apostadoresController.confirmaApostador(nome,password);
        else
            flag = bookiesController.confirmaBookie(nome,password);
        if(flag){        
            loginInfo.setName(nome);
            loginInfo.setTipo(escolha);
            mainController.updateVista();
            view.dispose();
        }
        }catch(ErroException b){
            view.setNotificacao(b.getMessage());
        }
    }
}
   

