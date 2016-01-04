
package Models;


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
