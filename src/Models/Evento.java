package Models;


import Controllers.ApostaController;
import Controllers.OddController;
import java.util.*;
import java.time.Instant;


public class Evento  {

	private String equipa1;
	private String equipa2;
	private Resultado resultado_final;
	private Date dataEvento;
	private int id;
	private ApostaController listaApostas;
	private boolean isOpen;
	private OddController odds;
        
	public Evento(String equipa1, String equipa2, Date data,OddController odds) {
		this.equipa1 = equipa1;
		this.equipa2 = equipa2;
		this.isOpen = false;
		this.resultado_final = null;
		this.dataEvento = data;
		this.odds = odds;
		this.listaApostas = new ApostaController();
	}
        
        public HashMap<Integer,Aposta> getApostas(){return listaApostas.getApostas();}
        public String getEquipa1(){return equipa1;}
        public String getEquipa2() {return this.equipa2;}
        public boolean isOpen(){return this.isOpen();}
        public Resultado getResultado(){return this.resultado_final;}
        
	public void setEquipa1(String equipa1) {this.equipa1 = equipa1;}
	public void setEquipa2(String equipa2) {this.equipa2 = equipa2;}
	public void setDataEvento(Date dataEvento) {this.dataEvento = dataEvento;}
        public void setOpen(boolean open){this.isOpen = open;}
        public void setResultado(Resultado resultado){ this.resultado_final = resultado;}
        
}
     

