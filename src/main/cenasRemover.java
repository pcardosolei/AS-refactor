/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Portatilcar
 */

/*
public class cenasRemover {
    
    
	public void registaAposta(Apostador apostador, Evento evento) {
		evento.registaAposta(apostador);
	}

	// Interface sobre Eventos

	public boolean actualizaOdd(Evento evento, int odd_1, int odd_x, int odd_2){

		return evento.actualizaOdd(odd_1,odd_x,odd_2);
	}

	public boolean  fechaEvento(Evento evento, char resultado){
		return evento.fechaEvento(resultado);
	}
        
        public void fechaEvento(Bookie bookie,Evento evento){
             evento.setEstado(true);
        }

	public void viewEventos(){

		ListIterator<Evento> listIterator = this.listaEventos.listIterator();
		while (listIterator.hasNext()) {
			System.out.println(listIterator.next().viewEvento());
		}
	}
         
	public Evento registaEvento(String equipa1, String equipa2) {

		Evento aposta = new Evento(equipa1,equipa2, Date.from(Instant.now()));
		this.listaEventos.add(aposta);
		return aposta;
	}

	public Evento registaEvento() {


		Evento newevento = new Evento();

		newevento.viewCreateEvento();
		this.listaEventos.add(newevento);
		return newevento;
	}
        
        public Evento registaEvento(Bookie bookie){
                Evento newevento = new Evento();

		newevento.viewCreateEvento();
		this.listaEventos.add(newevento);
		return newevento;
        }
        
	// Interface sobre Apostadores

	public void viewApostadores(){

		ListIterator<Apostador> lista = this.listaApostadores.listIterator();
		while(lista.hasNext()){
			System.out.println(lista.next());
		}
	}

	public Apostador registaApostador(String nome, String  email, double coins){

		Apostador newuser = new Apostador(nome, email, coins);
		listaApostadores.add(newuser);
		return newuser;
	}

	public Apostador registaApostador() {


		Apostador newuser = new Apostador();
		newuser.viewCreateApostador();
		this.listaApostadores.add(newuser);


		return newuser;
	}

	public Apostador actualizaApostador(Apostador apostador) {


		apostador.viewUpdateApostadpr(apostador);


		return apostador;
	}

	public boolean deleteApostador(Apostador apostador){
		apostador.viewDeleteApostador();
		return this.listaApostadores.remove(apostador);

	}

	// Interface sobre Bookies

	// TO-DO
        public Bookie registaBookie(){
                Bookie newuser = new Bookie();
		newuser.viewCreateApostador();
		this.listaBookies.add(newuser);


		return newuser;
        }
        
        
	// Objects view
	@Override
	public String toString() {
		return "BetESSAPI{" +
				"name=" + name +
				", betESStotal=" + betESStotal +
				'}';
	}
}
*/