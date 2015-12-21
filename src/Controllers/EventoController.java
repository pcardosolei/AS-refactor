/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Evento;
import Models.Odd;
import java.util.HashMap;
import java.time.Instant;
import java.util.Date;



/**
 *
 * @author Portatilcar
 */
public class EventoController {
    
    private HashMap<Integer,Evento> eventos;
    
    public EventoController(Evento evento){
        this.eventos = new HashMap<>();
    }
    
    
    public void addEvento(String equipa1,String equipa2,int oddEquipa1,int empate, int oddEquipa2){
        OddController odds = new OddController(new Odd(oddEquipa1,empate,oddEquipa2));
        Evento evento = new Evento(equipa1,equipa2,Date.from(Instant.now()),odds);
        this.eventos.put(eventos.size(),evento);
    }
   
    public void deleteEvento(int evento){
        this.eventos.remove(evento);
    }
    /*
    public void registaAposta(Apostador apostador, Evento evento) {evento.getApostaController().registaAposta(apostador);}

    
    
	public boolean actualizaOdd(Evento evento, int odd_1, int odd_x, int odd_2){

		return evento.actualizaOdd(odd_1,odd_x,odd_2);
	}
      
    public boolean  fechaEvento(Evento evento, char resultado){
		return evento.fechaEvento(resultado);
	}
        
      public void fechaEvento(Bookie bookie,int a){eventos.get(a).setOpen(false);}
    
      /*
     
      
	public boolean fechaEvento(char resultadofinal){

			switch (resultadofinal) {
				case '1':
					this.resultado_final = Resultado.EQUIPA1;
					break;
				case 'x':
					this.resultado_final = Resultado.EMPATE;
					break;
				case '2':
					this.resultado_final = Resultado.EQUIPA2;
					break;
			}
		this.isOpen = false;
		this.notifyApostadores();
		return true;
	}
        
        /*
         METHODS CHAINING- VEIO DA API Para vir buscar a view e registar a aposta 
        
       
	public void registaAposta(Apostador apostador) {

		Aposta aposta = new Aposta();
		aposta.viewCreateAposta();
		aposta.setApostador(apostador);
		aposta.setOdd_fixada(this.odds);

		this.listaApostas.add(aposta);

	}
        /*
         actualizaOdd e updateOdds utilizam o mesmo codigo para fazer a mesma coisa 
            com a diferença do tipo retornado
        
        public boolean actualizaOdd(int odd1, int oddx, int odd2 ){
		this.odds.setOddx(oddx);
		this.odds.setOdd1(odd1);
		this.odds.setOdd2(odd2);
		return true;
	}
        
        public void updateOdds(float odd_1, float odd_x, float odd_2){
                this.odds.setOdd1(odd_1);
		this.odds.setOdd2(odd_2);
		this.odds.setOddx(odd_x);
	}

        
	public void setEstado(boolean estado) {
		// TODO - implement Aposta.setEstado
                this.isOpen = estado;
	}
        
        /*
         METODO MUITO GRANDE 
         VAI BUSCAR MUITOS METODOS DE OUTRA CLASS
         REALIZA TAREFAS QUE PODIAM SER REALIZADAS NUMA CAMADA MAIS BAIXA COM MENOS RECURSOS
      
	public void notifyApostadores() {
		int premio = 0;
		if (!this.isOpen){
			Enumeration<Aposta> lista_apostas = this.listaApostas.elements();
			while (lista_apostas.hasMoreElements()) {
				Aposta aposta = lista_apostas.nextElement();

				if (this.resultado_final == aposta.getResultado()) {

					switch (aposta.getResultado()) {
						case EQUIPA1:
							premio = (int) (aposta.getM_aposta() * aposta.getOdd_fixada().getOdd1());
							break;
						case EMPATE:
							premio = (int) (aposta.getM_aposta() * aposta.getOdd_fixada().getOddx());
							;
							break;
						case EQUIPA2:
							premio = (int) (aposta.getM_aposta() * aposta.getOdd_fixada().getOdd2());
							;
							break;
					}
				}
				aposta.getApostador().update(premio+"");
			}
		}
	}

	public void setOdds(float odd_1, float odd_x, float odd_2) {
		this.odds = new Odd(odd_1,odd_x,odd_2);
	}
*/
}
