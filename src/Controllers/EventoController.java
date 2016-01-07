package Controllers;

import Models.Evento;
import Models.Odd;
import Models.Resultado;
import Observer.*;
import java.util.HashMap;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

public class EventoController implements Subject {
    
    private HashMap<Integer,Evento> eventos;
    private ArrayList<Observer> observers;
    
    public EventoController(){
        this.eventos = new HashMap<>();
        this.observers = new ArrayList<>();
    }
    
    
    public void addEvento(String equipa1,String equipa2,float oddEquipa1,float empate, float oddEquipa2){
        OddController odds = new OddController(new Odd(oddEquipa1,empate,oddEquipa2));
        Evento evento = new Evento(equipa1,equipa2,Date.from(Instant.now()),odds);
        this.eventos.put(eventos.size(),evento);       
    }
   
    public void deleteEvento(int evento){this.eventos.remove(evento);}
   
    public OddController getOdds(int evento){return this.eventos.get(evento).getOdds();}
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
               this.notifyApostadores(evento);
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
   
    public void editaEvento(int evento, float odd_1, float odd_x, float odd_2){
        OddController odds = new OddController(new Odd(odd_1,odd_x,odd_2));
        setOdds(evento,odds);
	}
    

    public void registaAposta(int evento,String name,char resultado,double valor){
        float odd_fixada = getOddAposta(evento,resultado);
        this.eventos.get(evento).getApostaController().registaAposta(name,resultado,valor,odd_fixada);
    }

    private float getOddAposta(int evento,char resultado){
        float odd = 0;
        switch(resultado){
            case '1': odd = this.eventos.get(evento).getOdds().getOdd1();
                      break;
            case 'x': odd = this.eventos.get(evento).getOdds().getOddx();
                      break;
            case '2': odd = this.eventos.get(evento).getOdds().getOdd2();
                      break;
        }    
        return odd;
    }
     /*
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

    @Override
    public void notifyApostadores(int evento) {
        for(Observer o: observers){
            o.update(this.eventos.get(evento).getApostaController(),this.eventos.get(evento).getResultado());    
        }
    }

    @Override
    public void register(Observer o) {
        this.observers.add(o);
    }
}
