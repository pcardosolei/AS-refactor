/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

/**
 *
 * @author PauloCardoso
 */
public class SemSaldoException extends Exception{
    
    public String getMessage(){return "Não possui fundos";}
}
