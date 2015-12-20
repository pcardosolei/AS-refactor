/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Aposta;
import Models.Apostador;
import Models.Resultado;

/**
 *
 * @author Portatilcar
 */
public class ApostaController {
    
    
    private Aposta aposta;
    
    public ApostaController(Aposta aposta){
        this.aposta = aposta;
    }
    
        public Apostador getApostador() {return aposta.getApostador();}
	public Resultado getResultado() {return aposta.getResultado();}
	public float getM_aposta() {return aposta.getM_aposta();}
	public float getOdd_fixada() {return aposta.getOdd_fixada();}
}
