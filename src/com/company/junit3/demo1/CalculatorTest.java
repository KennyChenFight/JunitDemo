package com.company.junit3.demo1;

public class CalculatorTest {

    public static void main(String[] args) {
        TestRunner runner = new TestRunner();
        runner.add(new CalculatorPlusTest());
        runner.add(new CalculatorMinusTest());
        runner.run();
    }
}
