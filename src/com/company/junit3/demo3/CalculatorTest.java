package com.company.junit3.demo3;

public class CalculatorTest extends TestCase {

    private Calculator calculator;

    public CalculatorTest() {

    }

    public CalculatorTest(String name) {
        super(name);
    }

    @Override
    protected void setUp() {
        calculator = new Calculator();
    }

    @Override
    protected void tearDown() {
        calculator = null;
    }

    public void testPlus() {
        int expected = 5;
        int result = calculator.plus(3, 2);
        assertEquals(expected, result);
    }

    public void testMinus() {
        int expected = 1;
        int result = calculator.minus(3, 2);
        assertEquals(expected, result);
    }

    public static void main(String[] args) {
        TestRunner.run(CalculatorTest.class);
    }
}
