package com.company.junit3.demo3;

public class CalculatorAll {

    public static Test suite() {
        TestSuite suite = new TestSuite();
        // 隨便你組合
        suite.add(CalculatorPlusMinusTest.suite());
        suite.add(CalculatorTest.class);
        suite.add(new CalculatorTest("testPlus"));
        return suite;
    }

    public static void main(String[] args) {
        TestRunner.run(suite());
    }
}
