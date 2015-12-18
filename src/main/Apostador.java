package main;

import Observer.Observer;

public class Apostador extends Utilizador implements Observer{
        
    
        /*
        OBSERVER PASSA PARA O CONTROLLER ACHO EU-
        */
	private String email;
	private double betESScoins;
	private String name;
        
	public Apostador(String name, String email, double betESScoins) {
                super(name,email);
                this.betESScoins = betESScoins;
	}
        
	public double getBetESScoins() {return betESScoins;}
	public void setBetESScoins(double betESScoins) {this.betESScoins = betESScoins;}
        
        //DEIXAR ESTAR PARA Já - estudar isto
	@Override
	public void update(String notificacao) {


		System.out.println("\nApostador(" + this.name + "):" + notificacao + "\n");
	}    
    
}