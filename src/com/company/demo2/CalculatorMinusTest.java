package com.company.demo2;

public class CalculatorMinusTest implements Test {

    @Override
    public void run() {
        Calculator calculator = new Calculator();
        int expected = 1;
        int result = calculator.minus(3, 2);
        Assert.assertEquals(expected, result);
    }
}
