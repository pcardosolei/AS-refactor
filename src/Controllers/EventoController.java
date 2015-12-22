/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Evento;
import Models.Odd;
import Models.Resultado;
import java.util.HashMap;
import java.time.Instant;
import java.util.Date;



/**
 *
 * @author Portatilcar
 */
public class EventoController {
    
    private HashMap<Integer,Evento> eventos;
    
    public EventoController(){
        this.eventos = new HashMap<>();
    }
    
    
    public void addEvento(String equipa1,String equipa2,float oddEquipa1,float empate, float oddEquipa2){
        OddController odds = new OddController(new Odd(oddEquipa1,empate,oddEquipa2));
        Evento evento = new Evento(equipa1,equipa2,Date.from(Instant.now()),odds);
        this.eventos.put(eventos.size(),evento);
        
    }
   
    public void deleteEvento(int evento){
        this.eventos.remove(evento);
    }
    
    public void actualizaOdd(int evento, int odd_1, int odd_x, int odd_2){
        OddController odds = new OddController(new Odd(odd_1,odd_x,odd_2));
        setOdds(evento,odds);
	}
   
    
    public String getEquipa1(int evento){return this.eventos.get(evento).getEquipa1();}
    public String getEquipa2(int evento){return this.eventos.get(evento).getEquipa2();}
    
    public void setOdds(int evento,OddController odds) {this.eventos.get(evento).setOdds(odds);}  
    public void setEstado(int evento,boolean estado) {this.eventos.get(evento).setOpen(estado);}
    
    public HashMap<Integer,Evento> getEventos(){
        HashMap<Integer,Evento> aux = new HashMap<>();
        for(Integer a: eventos.keySet()){
            aux.put(a,eventos.get(a));
        }
        return aux;
    }
    
   
    public void fechaEvento(int evento,char resultadofinal){
               registaResultado(evento,resultadofinal);
               eventos.get(evento).setOpen(false);
		//this.notifyApostadores();
	}
    private void registaResultado(int evento,char resultadofinal){
            switch (resultadofinal) {
				case '1':eventos.get(evento).setResultado(Resultado.EQUIPA1);
                                         break;
                                case 'x':eventos.get(evento).setResultado(Resultado.EQUIPA1);
                                         break;
                                case '2':eventos.get(evento).setResultado(Resultado.EQUIPA2);
					 break;
			}
            }
    
    /*
    public void registaAposta(Apostador apostador, int evento){
        this.eventos.get(evento).getApostaController().registaAposta(apostador);
    }

    ?/
    
     
    
        
        /*
         METHODS CHAINING- VEIO DA API Para vir buscar a view e registar a aposta 
        
       
	public void registaAposta(Apostador apostador) {

		Aposta aposta = new Aposta();
		aposta.viewCreateAposta();
		aposta.setApostador(apostador);
		aposta.setOdd_fixada(this.odds);

		this.listaApostas.add(aposta);

	}
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

	
*/
}
