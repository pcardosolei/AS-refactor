package main;

public class Aposta {
    
        /*
            tratar do switch na Aposta
        */

        private Apostador apostador;
	private float m_aposta;
	private Resultado resultado;
	private float odd_fixada;


	public Aposta(){
		this.apostador = null;
		this.m_aposta = 0;
		this.resultado = null;
		this.odd_fixada = 0;
		}

	public Aposta(Apostador apostador, float m_aposta, char resultado, float odd_actual) {
		this.apostador = apostador;
		this.m_aposta = m_aposta;
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
		this.odd_fixada = odd_actual;
		}

	// getter and setters

	public Apostador getApostador() {return apostador;}

	public Resultado getResultado() {return resultado;}

	public float getM_aposta() {return m_aposta;}
  
	public float getOdd_fixada() {return odd_fixada;}

	public void setOdd_fixada(float odd_fixada) {this.odd_fixada = odd_fixada;}

	public void setM_aposta(float m_aposta) {this.m_aposta = m_aposta;}

	public void setApostador(Apostador apostador) {this.apostador = apostador;}

	public void setResultado(Resultado resultado) {this.resultado = resultado;}
}