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
public class ErroException extends Exception {
 
    private String text;
    public ErroException(String text){
        this.text = text;
    }
    
    public String getMessage(){
        return this.text;
    }  
}
