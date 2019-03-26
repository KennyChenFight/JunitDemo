package com.company.junit3.demo2;

public class CalculatorMultiplyTest implements Test {

    @Override
    public void run() {
        Calculator calculator = new Calculator();
        int expected = 6;
        int result = calculator.multiply(2, 3);
        Assert.assertEquals(expected, result);
    }
}
