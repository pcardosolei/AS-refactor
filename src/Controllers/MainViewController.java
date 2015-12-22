/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Evento;
import Models.LoginInfo;
import Views.CriarEventoView;
import Views.InfoEventoView;
import Views.LoginView;
import Views.MainView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;


/**
 *
 * @author Portatilcar
 */
public class MainViewController {
    
    private LoginInfo loginInfo;
    private MainView mainview;
    private ApostadorController apostadorControlador;
    private BookieController bookiesControlador;
    private CriarEventoListener eventolistener;
    private EventoController eventoController;
    
    public MainViewController(MainView view){
        this.mainview = view;
        this.loginInfo = new LoginInfo();
        apostadorControlador = new ApostadorController(this);
        bookiesControlador  = new BookieController();
        eventoController = new EventoController();
        startApp();
        this.mainview.setVisible(true);
        startListeners();
    }
    
    
  
    public void updateVista(){
        this.mainview.setEmailText(apostadorControlador.getEmail(loginInfo.getName()));
        this.mainview.setNomeText(apostadorControlador.getName(loginInfo.getName()));
        this.mainview.setUtilizadorText(loginInfo.getName());
        this.mainview.setBetESS(apostadorControlador.getCoins(loginInfo.getName()));
    }
    
    public void startApp(){
        LoginView login = new LoginView();  
        LoginViewController loginController = new LoginViewController(login,apostadorControlador,bookiesControlador,loginInfo);   
        loginController.setMainController(this);
        login.setVisible(true);
        
    }
    
    public void startListeners(){
        this.mainview.addCriarEventoListener(new CriarEventoListener(this));
        this.mainview.addTransacaoListener(new TransacaoListener());
        this.mainview.addEventoInfoListener(new InfoEventoListener(this));
        }
    
    public void updateTable(){
        HashMap<Integer,Evento> eventos = eventoController.getEventos();
        this.mainview.setTable(eventos);
    }

    class CriarEventoListener implements ActionListener {

        private MainViewController main;
        public CriarEventoListener(MainViewController mainV){
            this.main = mainV;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            CriarEventoView cEventoView = new CriarEventoView();
            CriarEventoViewController eventoViewController = new CriarEventoViewController(cEventoView,eventoController,main);
            cEventoView.setVisible(true);
        }
    }
    
    class TransacaoListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            double valor = Double.parseDouble(mainview.getValor());
            String escolha = mainview.getEscolha();
            apostadorControlador.actualizarSaldo(loginInfo.getName(),valor,escolha);
        }
        
    }
    
    class InfoEventoListener implements ActionListener {
        
        private MainViewController main;
        public InfoEventoListener(MainViewController mainV){
            this.main = mainV;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
            int evento = Integer.parseInt(mainview.getEvento());
            InfoEventoView iview = new InfoEventoView();
            InfoEventoViewController eventosController = new InfoEventoViewController(evento,eventoController,main,iview);
            iview.setVisible(true);
        } catch(NullPointerException a){
            System.out.println("Erro infolistener");
        }
        }
        
    }
    
    
}
