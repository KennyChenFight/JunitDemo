package com.company.junit4.demo2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(value= Parameterized.class)
public class CalculatorTest {

    @Parameterized.Parameters
    public static Collection<Integer[]> getPararmeters() {
        return Arrays.asList(
                new Integer[][] {
                        {5, 3, 2}, // expected, para1, para2
                        {3, 1, 2}, // expected, para1, para2
                        {2, 1, 1}  // expected, para1, para2
                }
        );
    }

    private int expected;
    private int para1;
    private int para2;

    public CalculatorTest(int expected, int para1, int para2) {
        this.expected = expected;
        this.para1 = para1;
        this.para2 = para2;
    }

    @Test
    public void testPlus() {
        Calculator calculator = new Calculator();
        int result = calculator.plus(para1, para2);
        assertEquals(expected, result);
    }

}
