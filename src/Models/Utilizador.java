/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author PauloCardoso
 */
public class Utilizador {
        private String email;
	private String name;
        
        public Utilizador(String email,String name){
             this.email = email;
             this.name = name;
        }
        
        public String getEmail() {return email;}

	public String getName() {return name;}

	public void setEmail(String email) {this.email = email;}

	public void setName(String name) {this.name = name;}
}
