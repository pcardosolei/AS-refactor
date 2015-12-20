/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Portatilcar
 */
public class EventoOld {
       /*
            perguntar ao andre se a classe resultado faz algum sentido. 
        
            não é 
      
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

	
	// views Evento
        /*
            Long Class
            vistas devem ser utilizadas numa outra camada
       
	public String viewEvento() {
		return "Evento{" +
				"equipa1='" + equipa1 + '\'' +
				", equipa2='" + equipa2 + '\'' +
				", resultado_final=" + resultado_final +
				", estado=" + isOpen +
				", data da aposta" + dataEvento.toString() +
				", ultima odd" + this.odds.toString() +
				'}';
	}

        
        /*
         viewCreateEvento + viewUpdateEvento teem o mesmo codigo para realizar duas acções diferentes
        
	public void viewCreateEvento(){

		String readinput;
		this.out.print("Introduza as equipas participantes no evento: (Equipa1, Equipa2, DataEvento)\n");
		try {
			readinput = this.in.readLine();
			String[] tokens = readinput.split(",");
			this.setEquipa2(tokens[1]);
			this.setEquipa1(tokens[0]);
			this.setDataEvento(Date.from(Instant.now()));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void viewUpdateEvento(){
		String readinput;
		this.out.print("Introduza as equipas participantes no evento: (Equipa1, Equipa2, DataEvento)\n");
		try {
			readinput = this.in.readLine();
			String[] tokens = readinput.split(",");
			this.setEquipa2(tokens[1]);
			this.setEquipa1(tokens[0]);
			this.setDataEvento(Date.from(Instant.now()));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void viewDeleteApostador(){
		this.out.println("Remover Apostador" + this.viewEvento());

	}
*/
}
