package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PauloCardoso
 */
public class Bookie implements Observer {
    	private String email;
	private double betESScoins;
	private String name;
	private  BufferedReader in;
	private  PrintStream out = null;

	public Bookie(String name, String email, double betESScoins) {
		this.email = email;
		this.name = name;
		this.in = new BufferedReader(new InputStreamReader(System.in));
		this.out = System.out;
	}

	public Bookie() {
		this.in = new BufferedReader(new InputStreamReader(System.in));
		this.out = System.out;
	}

	public String getEmail() {
		return email;
	}

	public double getBetESScoins() {
		return betESScoins;
	}

	public String getName() {
		return name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setBetESScoins(double betESScoins) {
		this.betESScoins = betESScoins;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Bookie{" +
				"email='" + email + '\'' +
				", betESScoins=" + betESScoins +
				", name='" + name + '\'' +
				'}';
	}

	@Override
	public void update(String notificacao) {


		System.out.println("\nApostador(" + this.name + "):" + notificacao + "\n");
	}


	// Views de Apostador

	public void viewCreateApostador(){

		String readinput;
		this.out.print("Introduza os seguintes dados de Apostador: (Nome, email, montante betESScoins\n");
		try {
			readinput = this.in.readLine();
			String[] tokens = readinput.split(",");
			this.setName(tokens[0]);
			this.setEmail(tokens[1]);
			this.setBetESScoins(Double.parseDouble(tokens[2]));
			this.viewBookie();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void viewUpdateBookie(Bookie bookie){

		String readinput;
		this.out.print("Introduza novos dados de Bookie: (Nome("+ this.name +"), email("+this.email+"), montante betESScoins("+ this.betESScoins+")\n");
		try {
			readinput = this.in.readLine();
			String[] tokens = readinput.split(",");
			bookie.setName(tokens[0]);
			bookie.setEmail(tokens[1]);
			bookie.setBetESScoins(Double.parseDouble(tokens[2]));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void viewDeleteApostador(){
		this.out.println("Remover Bookie"+this.viewBookie());

	}

	public String viewBookie(){

		String view;
		view = new String ("Bookie{" + "email='" + email +  ", betESScoins=" + betESScoins + ", name='" + name + '\'' + '}');
		this.out.println(view);
		return view;

	}

}
