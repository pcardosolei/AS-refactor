package Models;


import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.time.Instant;


public class Evento  {


	private static AtomicInteger uniqueId=new AtomicInteger();
        /*
          AtomicInteger não é necessário para os id se trabalharmos sobre a forma de hashmaps de inteiros 
            para controlar todos os eventos.
          Id pode ser removido pela ideia anterior.
        Nota: o isOpen nunca fica diferente de false.
        */
	private String equipa1;
	private String equipa2;
	private Resultado resultado_final;
	private Date dataEvento;
	private int id;
	private HashMap<Integer,Aposta> listaApostas;
	private boolean isOpen;
	private Odd odds;
        
	public Evento(String equipa1, String equipa2, Date data) {
		this.equipa1 = equipa1;
		this.equipa2 = equipa2;
		this.isOpen = false;
		this.resultado_final = null;
		this.dataEvento = data;
		this.id=uniqueId.getAndIncrement();
		//this.odds = new Odd();
		this.listaApostas = new HashMap<Integer,Aposta>();

	}
        
        /* 
        Mesmo do anterior mas entender pq é que necessários dois construtores.
        se remover o de baixo é remover os sets e os gets.
        */
        
	public Evento() {
		this.equipa1 = null;
		this.equipa2 = null;
		this.isOpen = false;
		this.resultado_final = null;
		this.dataEvento = null;
		this.id=uniqueId.getAndIncrement();
		//this.odds = new Odd();
		this.listaApostas = new HashMap<Integer,Aposta>();

	}

	public void setEquipa1(String equipa1) {this.equipa1 = equipa1;}

	public String getEquipa2() {return this.equipa2;}

	public void setEquipa2(String equipa2) {this.equipa2 = equipa2;}

	public void setDataEvento(Date dataEvento) {this.dataEvento = dataEvento;}
        
        
}
     

