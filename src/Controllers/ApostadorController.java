/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Exception.ErroException;
import Exception.SemSaldoException;
import Models.Apostador;
import Observer.Observer;
import java.util.HashMap;

/**
 *
 * @author Portatilcar
 */
public class ApostadorController implements Observer {
    
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
    
    public boolean confirmaApostador(String nome,String password) throws ErroException{
        boolean flag = false;
        String test;
           try{
            test = this.apostadores.get(nome).getPassword();
            flag = test.equals(password);
           }catch(NullPointerException e){
               throw new ErroException("Utilizador não existente");
           }
           if(!flag){
               throw new ErroException("Introduza utilizador e senha corretas");
           }
         return flag;
    }

    public void actualizarSaldo(String nome,double valor,String escolha) throws SemSaldoException{
        if(escolha.equals("deposito")){
            apostadores.get(nome).setBetESScoins(apostadores.get(nome).getBetESScoins()+valor);
        }else{
            if(apostadores.get(nome).getBetESScoins() >= valor)   
            apostadores.get(nome).setBetESScoins(apostadores.get(nome).getBetESScoins()-valor);
            else
                throw new SemSaldoException();}
            mainController.updateVista();
        }

    @Override
    public void update(String notificacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }

