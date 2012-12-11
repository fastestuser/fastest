/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package client.blogic.testing.ttree.tactics;
import java.math.BigInteger;
import java.util.*;


/**
 *
 * @author Pablo Rodriguez Monetti
 */
public class NRTacticInfo extends TacticInfo{


    private String var;
    private List<BigInteger> numbers;



    public void setVar(String var){
        this.var = var;
    }


    public String getVar(){
        return var;
    }


    public void setNumbers(List<BigInteger> numbers){
        this.numbers = numbers;
    }

    public List<BigInteger> getNumbers(){
        return numbers;
    }



}
