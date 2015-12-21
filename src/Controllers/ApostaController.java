/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Aposta;
import Models.Apostador;
import Models.Resultado;
import java.util.HashMap;

/**
 *
 * @author Portatilcar
 */
public class ApostaController {
    
    
    private HashMap<Integer,Aposta> listaApostas;
    
    public ApostaController(){
        this.listaApostas = new HashMap<>();
    }
    
        public Apostador getApostador(int a) {return listaApostas.get(a).getApostador();}
	public Resultado getResultado(int a) {return listaApostas.get(a).getResultado();}
	public float getM_aposta(int a) {return listaApostas.get(a).getM_aposta();}
	public float getOdd_fixada(int a) {return listaApostas.get(a).getOdd_fixada();}
        
        public void setApostador(int a,Apostador apostador){this.listaApostas.get(a).setApostador(apostador);}
        public void setResultado(int a,char resultado){this.listaApostas.get(a).setResultado(resultado);}
        public void setM_aposta(int a){this.listaApostas.get(a).setM_aposta(a);}
        public void setOdd_fixada(int a){this.listaApostas.get(a).setOdd_fixada(a);}
        
        public HashMap<Integer,Aposta> getApostas(){
            HashMap<Integer,Aposta> aux = new HashMap<>();
            for(int a: listaApostas.keySet()){
                aux.put(a,listaApostas.get(a));
            }
            return aux;}
        
        public void adicionarAposta(){
            Aposta aposta = new Aposta();
            this.listaApostas.put(listaApostas.size(),aposta);
        }
        
        public void removeAposta(int a){
            this.listaApostas.remove(a);
        }
        
}
