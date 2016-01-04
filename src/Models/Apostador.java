package Models;


public class Apostador extends Utilizador{
        
	private double betESScoins;
        
	public Apostador(String name, String email,String password) {
                super(name,email,password);
                this.betESScoins = 0;
	}
        
	public double getBetESScoins() {return betESScoins;}
	public void setBetESScoins(double betESScoins) {this.betESScoins = betESScoins;}
        
}