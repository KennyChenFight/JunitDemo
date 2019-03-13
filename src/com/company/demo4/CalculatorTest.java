package com.company.demo4;

import junit.framework.TestCase;

public class CalculatorTest extends TestCase {

    private Calculator calculator;

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

}
