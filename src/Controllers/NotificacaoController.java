/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Notificacao;
import java.util.ArrayList;

/**
 *
 * @author PauloCardoso
 */
public class NotificacaoController {
    
    private ArrayList<Notificacao> notificacoes;
    
    public NotificacaoController(){
        notificacoes = new ArrayList<>();
    }
    
    public ArrayList<Notificacao> getNotificacoes(){return notificacoes;}
    public void addNotificacao(String notificacao){
        Notificacao nova = new Notificacao(notificacao);
        notificacoes.add(nova);
    }
}
