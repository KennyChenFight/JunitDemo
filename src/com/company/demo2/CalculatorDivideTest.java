package com.company.demo2;

public class CalculatorDivideTest implements Test {

    @Override
    public void run() {
        Calculator calculator = new Calculator();
        int expected = 2;
        int result = calculator.divide(6, 3);
        Assert.assertEquals(expected, result);
    }
}
