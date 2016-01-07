/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;


import Exception.SemSaldoException;
import Views.CriarApostaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author PauloCardoso
 */
public class CriarApostaViewController {
   
    private CriarApostaView view;
    private EventoController eventosController;
    private ApostadorController apostadorController;
    private int evento;
    private String apostador;
    
    public CriarApostaViewController(int evento,EventoController eventosController,CriarApostaView view,String apostador,ApostadorController apostadorController){
         this.view = view;
         this.eventosController = eventosController;
         this.apostadorController = apostadorController;
         this.view.addRegistoListener(new RegistoListener());
         this.apostador = apostador;
         this.evento = evento;
         setStats();
    }
    
    class RegistoListener implements ActionListener {
               
        @Override 
        public void actionPerformed(ActionEvent e) {
            char escolha;
            double valor;      
            try{
                escolha =  view.getEscolha().charAt(0);
                valor = view.getValor();
                adicionarAposta(evento,escolha,valor);
                }
            catch(Exception a){
                System.out.println("ERRO adicionar aposta"); 
            }       
        }
    }   
    
    
    public void adicionarAposta(int evento,char escolha,double valor){
        try{
            apostadorController.checkAposta(apostador, valor);
            eventosController.registaAposta(evento,apostador,escolha,valor);
            view.dispose();
        }catch(SemSaldoException e){
            
        }
    }
    
    public void setStats(){
        view.setEquipa1(eventosController.getEquipa1(evento));
        view.setEquipa2(eventosController.getEquipa2(evento));
        OddController odds = eventosController.getOdds(evento);
        view.setOddEquipa1(odds.getOdd1());
        view.setOddEquipa2(odds.getOdd2());
        view.setOddEmpate(odds.getOddx());
    }
}
