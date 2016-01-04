package Models;

public class Aposta {
    
        private String apostador;
	private double m_aposta;
	private Resultado resultado;
	private float odd_fixada;
        
	public Aposta(String apostador, double m_aposta, char resultado, float odd_actual) {
		this.apostador = apostador;
		this.m_aposta = m_aposta;
                setResultadoAposta(resultado);
		this.odd_fixada = odd_actual;
		}

	public String getApostador() {return apostador;}
	public Resultado getResultado() {return resultado;}
	public double getM_aposta() {return m_aposta;}
	public float getOdd_fixada() {return odd_fixada;}
	
        public void setOdd_fixada(float odd_fixada) {this.odd_fixada = odd_fixada;}
	public void setM_aposta(double m_aposta) {this.m_aposta = m_aposta;}
	public void setApostador(String apostador) {this.apostador = apostador;}
	public void setResultado(char resultado) {setResultadoAposta(resultado);}
        
   
        private void setResultadoAposta(char resultado){
            switch (resultado) {
			case '1':
				this.resultado = Resultado.EQUIPA1;
				break;
			case 'x':
				this.resultado = Resultado.EMPATE;
				break;
			case '2':
				this.resultado = Resultado.EQUIPA2;
				break;
		}
        }
}