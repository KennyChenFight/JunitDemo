package com.company.junit3.demo6;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

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

    public static Test suite() {
        TestSuite suite = new TestSuite();
        suite.addTest(new CalculatorTest("testPlus"));
        return suite;
    }

    public static void main(String[] args) {
        TestRunner.run(suite());
    }
}
