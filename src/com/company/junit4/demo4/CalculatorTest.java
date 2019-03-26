package com.company.junit4.demo4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

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
        int result = calculator.plus(1, 2);
        assertEquals(expected, result);
    }

    @Test
    public void testMinus() {
        int expected = 1;
        int result = calculator.minus(3, 3);
        assertEquals(expected, result);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(CalculatorTest.class);
        for(Failure failure : result.getFailures()) {
            System.out.println(failure.getTestHeader() +
                    "： " + failure.getMessage());
        }
    }
}
