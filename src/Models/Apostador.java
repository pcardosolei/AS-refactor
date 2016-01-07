package Models;

import Controllers.NotificacaoController;


public class Apostador extends Utilizador{
        
	private double betESScoins;
        private NotificacaoController notificacoes;
        
	public Apostador(String name, String email,String password) {
                super(name,email,password);
                this.betESScoins = 0;
                notificacoes = new NotificacaoController();
	}
        
	public double getBetESScoins() {return betESScoins;}
	public void setBetESScoins(double betESScoins) {this.betESScoins = betESScoins;}
        
        public NotificacaoController getNotificacoes(){return notificacoes;}
}