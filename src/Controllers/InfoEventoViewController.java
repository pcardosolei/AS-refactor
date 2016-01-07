package Controllers;

import Views.InfoEventoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class InfoEventoViewController {
    
    private EventoController eventoControl;
    private MainViewController main;
    private int evento;
    private InfoEventoView view;
    
    public InfoEventoViewController(int evento,EventoController eventoControl,MainViewController main,InfoEventoView view){
        this.evento = evento;
        this.eventoControl = eventoControl;
        this.main = main;
        this.view = view;
        setStats();
        setListeners();
    }
    
    public void setStats(){
        
        view.setEquipa1(eventoControl.getEquipa1(evento));
        view.setEquipa2(eventoControl.getEquipa2(evento));
    }
    
    public void setListeners(){
        this.view.addDeleteListener(new DeleteListener());
        this.view.addEditaListener(new EditaListener());
        this.view.addfinalizarListener(new FinalizarListener());
    }

    class DeleteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {               
                eventoControl.deleteEvento(evento);           
                main.updateTable();
                view.dispose();
        }

    }
    
    class EditaListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
              float odd1 = view.getOdd1();
              float oddx = view.getOddx();
              float odd2 = view.getOdd2();
              eventoControl.editaEvento(evento,odd1,oddx,odd2);
              main.updateTable();
              view.dispose();
        }
        
        
    }
    
    class FinalizarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            char c = view.getEscolha().charAt(0);
            eventoControl.fechaEvento(evento,c);
            main.updateTable();
            main.updateVista();
            main.updateNotificacoes();
            view.dispose();
        }
        
    }
}
