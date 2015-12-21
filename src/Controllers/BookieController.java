/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Bookie;
import java.util.HashMap;

/**
 *
 * @author Portatilcar
 */
public class BookieController {
     private HashMap<String,Bookie> bookies;
     
     public BookieController(){
         this.bookies = new HashMap<>();
    }
     
     public void registaBookie(String name,String email,String password) {
        Bookie bookie = new Bookie(name,email,password);    
        this.bookies.put(name,bookie);
     }
    
      public void deleteBookie(String bookie){
        this.bookies.remove(bookie);
    }
      
    public boolean confirmaBookie(String nome,String password){
        boolean flag = false;
        String test;
        try{
            test = this.bookies.get(nome).getPassword();
            flag = test.equals(password);
           }catch(NullPointerException e){
                 System.out.println("cenas bookie");
           }
         return flag;
    }  

    public String getName(String bookie){return bookies.get(bookie).getName();}
    public String getEmail(String bookie){return bookies.get(bookie).getEmail();}
    
    public void setName(String bookie,String name){ bookies.get(bookie).setName(name);}
    public void setEmail(String bookie,String email){bookies.get(bookie).setEmail(email);}
    
}
