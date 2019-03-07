package com.company.demo2;

public class CalculatorDivideMultiplyTest {

    public static Test suite() {
        TestSuite suite = new TestSuite();
        suite.add(new CalculatorDivideTest());
        suite.add(new CalculatorMultiplyTest());
        return suite;
    }

    public static void main(String[] args) {
        TestRunner.run(suite());
    }
}
