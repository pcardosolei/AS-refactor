/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;

/**
 *
 * @author PauloCardoso
 */
public class VistasConsola {
    //	Views para Apostador

        public static void main(){
            public BufferedReader in;
            public PrintStream out;
        }
        /*
        VIEWS é para sairem daqui
        */
	public void viewCreateAposta(){
		String readinput;
		this.out.println("Introduza o resultado e o montante a apostar: montante, resultado\n");
		try {
			readinput = this.in.readLine();
			String[] tokens = readinput.split(",");


			switch (tokens[1]) {
				case "1":
					this.setResultado(Resultado.EQUIPA1);
					break;
				case "x":
					this.setResultado(Resultado.EMPATE);
					break;
				case "2":
					this.setResultado(Resultado.EQUIPA2);
					break;
			}

			this.setM_aposta(Float.parseFloat(tokens[0]));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

    /*
         VISTAS PARA A INTERFACE
        */
	public void viewCreateApostador(){

		String readinput;
		this.out.print("Introduza os seguintes dados de Apostador: (Nome, email, montante betESScoins\n");
		try {
			readinput = this.in.readLine();
			String[] tokens = readinput.split(",");
			this.setName(tokens[0]);
			this.setEmail(tokens[1]);
			this.setBetESScoins(Double.parseDouble(tokens[2]));
			this.viewApostador();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void viewUpdateApostadpr(Apostador apostador){

		String readinput;
		this.out.print("Introduza novos dados de Apostador: (Nome("+ this.name +"), email("+this.email+"), montante betESScoins("+ this.betESScoins+")\n");
		try {
			readinput = this.in.readLine();
			String[] tokens = readinput.split(",");
			apostador.setName(tokens[0]);
			apostador.setEmail(tokens[1]);
			apostador.setBetESScoins(Double.parseDouble(tokens[2]));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void viewDeleteApostador(){
		this.out.println("Remover Apostador"+this.viewApostador());

	}

	public String viewApostador(){

		String view;
		view = new String ("Apostador{" + "email='" + email +  ", betESScoins=" + betESScoins + ", name='" + name + '\'' + '}');
		this.out.println(view);
		return view;

	}

@Override
	public String toString() {
		return "Apostador{" +
				"email='" + email + '\'' +
				", betESScoins=" + betESScoins +
				", name='" + name + '\'' +
				'}';
	}

		// Views de Bookie

	public void viewCreateBookie(){

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

	public void viewDeleteBookie(){
		this.out.println("Remover Bookie"+this.viewBookie());

	}

	public String viewBookie(){

		String view;
		view = new String ("Bookie{" + "email='" + email +  ", betESScoins=" + betESScoins + ", name='" + name + '\'' + '}');
		this.out.println(view);
		return view;

	}
}
