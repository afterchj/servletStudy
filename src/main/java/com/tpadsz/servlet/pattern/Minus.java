package com.tpadsz.servlet.pattern;

/**
 * Created by hongjian.chen on 2017/11/2.
 */
public class Minus extends AbstractCalculator implements ICalculator{
    public int calculate(String exp) {
        int arrayInt[] = split(exp,"-");
        return arrayInt[0]-arrayInt[1];
    }

    public int calculate(int num1, int num2) {
        return num1-num2;
    }
}
