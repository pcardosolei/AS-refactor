/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Apostador;
import java.util.HashMap;

/**
 *
 * @author Portatilcar
 */
public class ApostadorController {
    
    private HashMap<String,Apostador> apostadores;   
    private MainViewController mainController;
    
    
    public ApostadorController(MainViewController main){
        this.mainController = main;
        apostadores = new HashMap<>();
    }
    
    
    public double getCoins(String apostador){ return apostadores.get(apostador).getBetESScoins();}
    public String getName(String apostador){return apostadores.get(apostador).getName();}
    public String getEmail(String apostador){return apostadores.get(apostador).getEmail();}
    
    public void setCoins(String apostador,double coins){apostadores.get(apostador).setBetESScoins(coins);}
    public void setName(String apostador,String nome){apostadores.get(apostador).setName(nome);}
    public void setEmail(String apostador,String email){apostadores.get(apostador).setEmail(email);}
    
    public void registaApostador(String name,String email,String password){
        Apostador apostador = new Apostador(name,email,password);    
        this.apostadores.put(name,apostador);
	}
    
    public void deleteApostador(String apostador){this.apostadores.remove(apostador);}
    
    public boolean confirmaApostador(String nome,String password){
        boolean flag = false;
        String test;
        try{
            test = this.apostadores.get(nome).getPassword();
            flag = test.equals(password);
           }catch(NullPointerException e){
                 System.out.println("cenas ");
           }
         return flag;
    }

    public void actualizarSaldo(String nome,double valor,String escolha){
        if(escolha.equals("deposito")){
            apostadores.get(nome).setBetESScoins(apostadores.get(nome).getBetESScoins()+valor);
        }else
            apostadores.get(nome).setBetESScoins(apostadores.get(nome).getBetESScoins()-valor);
        mainController.updateVista();
    }
    
}
