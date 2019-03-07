package com.company.demo2;

public class CalculatorPlusMinusTest {

    public static Test suite() {
        TestSuite suite = new TestSuite();
        suite.add(new CalculatorPlusTest());
        suite.add(new CalculatorMinusTest());
        return suite;
    }

    public static void main(String[] args) {
        TestRunner.run(suite());
    }
}
