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
public class LoginInfo {
        private String tipo;
	private String name;
        
        public LoginInfo(){
             this.tipo = " ";
             this.name = " ";
        }
        
        public String getTipo() {return tipo;}
	public String getName() {return name;}
	
        public void setTipo(String tipo) {this.tipo = tipo;}
	public void setName(String name) {this.name = name;}
}
