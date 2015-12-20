/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Evento;
import Models.Resultado;

/**
 *
 * @author Portatilcar
 */
public class EventoController {
    
    private Evento evento;
    private Resultado resultado;
    private OddController odds;
    
    public EventoController(Evento evento){
        this.evento = evento;
    }
    
    /*
	public void registaAposta(Apostador apostador, Evento evento) {
		evento.registaAposta(apostador);
        }

	public boolean actualizaOdd(Evento evento, int odd_1, int odd_x, int odd_2){

		return evento.actualizaOdd(odd_1,odd_x,odd_2);
	}
      
    public boolean  fechaEvento(Evento evento, char resultado){
		return evento.fechaEvento(resultado);
	}
        
        public void fechaEvento(Bookie bookie,Evento evento){
             evento.setEstado(true);
        }
    */
}
