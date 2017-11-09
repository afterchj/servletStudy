package com.tpadsz.servlet.pattern;

/**
 * Created by hongjian.chen on 2017/11/2.
 */
public class StrategyTest {
    public static void main(String[] args) {
        String exp = "2+8";
        String exp2="8-2";
        ICalculator cal = new Plus();
        AbstractCalculator calculator=new Minus();
        int result = cal.calculate(exp);
        int result2=calculator.calculate(exp2,"\\-");
        System.out.println(result+"     "+result2);
    }
}
