package com.company.demo5;

import junit.framework.TestCase;
import junit.framework.TestResult;

public class CalculatorTest extends TestCase {

    private Calculator calculator;

    public CalculatorTest(String name) {
        super(name);
    }

    @Override
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Override
    public void tearDown() throws Exception {
        calculator = null;
    }

    public void testPlus() {
        int expected = 3;
        int result = calculator.plus(1, 2);
        assertEquals(expected, result);
    }

    public void testMinus() {
        int expected = 1;
        int result = calculator.minus(3, 2);
        assertEquals(expected, result);
    }

    public static void main(String[] args) {
        CalculatorTest[] calculatorTests = {
                new CalculatorTest("testPlus"),
                new CalculatorTest("testMinus")};

        for(CalculatorTest test: calculatorTests) {
            TestResult result = test.run();
            System.out.println(test.getName());
            System.out.println("\tError: " + result.errorCount());
            System.out.println("\tFailure: " + result.failureCount());
        }
    }
}
