package com.company.junit4.demo3;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @After
    public void tearDown() {
        calculator = null;
    }

    @Test
    public void testPlus() {
        int expected = 5;
        int result = calculator.plus(3, 2);
        assertEquals(expected, result);
    }

    @Test
    public void testMinus() {
        int expected = 1;
        int result = calculator.minus(3, 2);
        assertEquals(expected, result);
    }

    @Ignore(value = "Calculator 尚未定義 Multiply")
    @Test
    public void testMultiply() {

    }

    @Test(expected = Exception.class)
    public void testException() {
        System.out.println(1/0);  // 應該丟出例外
    }

    @Test(timeout = 2000)
    public void testTime() {
        while(true) {
            break;
        }
    }
}
