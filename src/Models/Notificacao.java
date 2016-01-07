/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.time.Instant;
import java.util.Date;

/**
 *
 * @author PauloCardoso
 */
public class Notificacao {
    
    private String notificacao;
    private Date data;
    
    public Notificacao(String notificacao){
        this.notificacao = notificacao;
        data = Date.from(Instant.now());
    }

    public String getNotif(){return this.notificacao;}
    public Date getDate(){return this.data;}
}
