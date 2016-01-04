
package Models;


public class Utilizador {
        private String email;
	private String name;
        private String password;
        
        public Utilizador(String name,String email,String password){
             this.email = email;
             this.name = name;
             this.password = password;
        }
        
        public String getEmail() {return email;}
	public String getName() {return name;}
        public String getPassword(){return password;}
	
        public void setEmail(String email) {this.email = email;}
        public void setPassword(String password) {this.password= password;}
	public void setName(String name) {this.name = name;}
}
