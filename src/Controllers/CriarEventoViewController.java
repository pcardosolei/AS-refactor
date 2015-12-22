/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Views.CriarEventoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author PauloCardoso
 */
public class CriarEventoViewController  {
    
    private CriarEventoView view;
    private EventoController eventosController;
    private MainViewController mainView;
    
    public CriarEventoViewController(CriarEventoView  view,EventoController eventosController,MainViewController main){
        
         this.mainView = main;
         this.view = view;
         this.eventosController = eventosController;
         this.view.addRegistoListener(new CriarEventoViewController.RegistoListener());
    }
    
    class RegistoListener implements ActionListener {
        
        
        @Override 
        public void actionPerformed(ActionEvent e) {
            String equipa1,equipa2;
            float oddEquipa1,oddEmpate,oddEquipa2;
        
            try{
                equipa1 = view.getEquipa1();
                equipa2 = view.getEquipa2();
                oddEquipa1 = view.getOddEquipa1();
                oddEmpate = view.getOddEmpate();
                oddEquipa2 = view.getOddEquipa2();
                adicionarEvento(equipa1,equipa2,oddEquipa1,oddEmpate,oddEquipa2);
                }
            catch(Exception a){
                System.out.println("ERRO adicionar evento"); 
            }
        }
    }   
    
    public void adicionarEvento(String equipa1,String equipa2,float odd1,float oddx,float odd2){
        eventosController.addEvento(equipa1, equipa2, odd1, oddx, odd2);
        mainView.updateTable();
        view.dispose();
    }
    
}

