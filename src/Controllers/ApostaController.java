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
    
	public Resultado getResultado(int a) {return listaApostas.get(a).getResultado();}
	public double getM_aposta(int a) {return listaApostas.get(a).getM_aposta();}
	public float getOdd_fixada(int a) {return listaApostas.get(a).getOdd_fixada();}
        public String getApostador(int a){return listaApostas.get(a).getApostador();}
        
        public void setApostador(int a,String apostador){this.listaApostas.get(a).setApostador(apostador);}
        public void setResultado(int a,char resultado){this.listaApostas.get(a).setResultado(resultado);}
        public void setM_aposta(int a){this.listaApostas.get(a).setM_aposta(a);}
        public void setOdd_fixada(int a){this.listaApostas.get(a).setOdd_fixada(a);}
        
        public HashMap<Integer,Aposta> getApostas(){
            HashMap<Integer,Aposta> aux = new HashMap<>();
            for(int a: listaApostas.keySet()){
                aux.put(a,listaApostas.get(a));
            }
            return aux;}
        
        public void registaAposta(String name,char resultado,double valor,float odd){
            Aposta aposta = new Aposta(name,valor,resultado,odd);
            this.listaApostas.put(listaApostas.size(),aposta);
        }
        
        public void removeAposta(int a){this.listaApostas.remove(a);}
        
}
