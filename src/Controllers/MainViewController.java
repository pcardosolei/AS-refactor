package Controllers;

import Exception.SemSaldoException;
import Models.Evento;
import Models.LoginInfo;
import Models.Notificacao;
import Views.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

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
        eventoController.register(apostadorControlador);
        startApp();
        this.mainview.OffApostador();
        this.mainview.OffBookie();
        this.mainview.setVisible(true);        
        startListeners();
    }
    
    
  
    public void updateVista(){
        if(loginInfo.getTipo().equals("Apostador")){
        this.mainview.setEmailText(apostadorControlador.getEmail(loginInfo.getName()));
        this.mainview.setNomeText(apostadorControlador.getName(loginInfo.getName()));
        this.mainview.setUtilizadorText(loginInfo.getName());
        this.mainview.setBetESS(apostadorControlador.getCoins(loginInfo.getName()));
        this.mainview.OnApostador();
        }else{
        this.mainview.setEmailText(bookiesControlador.getEmail(loginInfo.getName()));
        this.mainview.setNomeText(bookiesControlador.getName(loginInfo.getName()));
        this.mainview.setUtilizadorText(loginInfo.getName());
        this.mainview.OffApostador();
        }
    }
    
    public void addUtilizadorTab(){this.mainview.OnApostador();}
    
    public void addBookieTab(){ this.mainview.OnBookie();}
    
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
        this.mainview.addCriarApostaListener(new CriarApostaListener());
        }
    
    public void updateTable(){
        HashMap<Integer,Evento> eventos = eventoController.getEventos();
        this.mainview.setTable(eventos);
    }
    
    public void updateNotificacoes(){
        try{   
            ArrayList<Notificacao> notificacoes = this.apostadorControlador.getNotificacoes(loginInfo.getName());
            this.mainview.setTableNotif(notificacoes);
        }catch(NullPointerException e){
            System.out.println("erro");
        }
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
    
    class CriarApostaListener implements ActionListener {   
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
            int evento = mainview.getEvento();
            CriarApostaView iview = new CriarApostaView();
            CriarApostaViewController apostasController = new CriarApostaViewController(evento,eventoController,iview,loginInfo.getName(),apostadorControlador);
            iview.setVisible(true);
        } catch(NullPointerException a){
            System.out.println("Erro infolistener");
        }
        }
    }
    
    class TransacaoListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
            double valor = Double.parseDouble(mainview.getValor());
            String escolha = mainview.getEscolha();
            apostadorControlador.actualizarSaldo(loginInfo.getName(),valor,escolha);
            }catch(SemSaldoException a){
                mainview.setErro(a.getMessage());
            }   
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
            int evento = mainview.getEvento();
            InfoEventoView iview = new InfoEventoView();
            InfoEventoViewController eventosController = new InfoEventoViewController(evento,eventoController,main,iview);
            iview.setVisible(true);
        } catch(NullPointerException a){
            System.out.println("Erro infolistener");
        }
        }       
    }   
}
