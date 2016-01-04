package Controllers;

import Models.Odd;


public class OddController {
    
    private Odd odds;
    
    public OddController(Odd odds){
        this.odds = odds;        
    }
    
    public float getOdd1() {return this.odds.getOdd1();}
    public void setOdd1(float odd1) {this.odds.setOdd1(odd1);}
    public float getOddx() {return this.odds.getOddx();}
    public void setOddx(float oddx) {this.odds.setOddx(oddx);}
    public float getOdd2() {return this.odds.getOdd2();}
    public void setOdd2(float odd2) {this.odds.setOdd2(odd2);}    
    
}
