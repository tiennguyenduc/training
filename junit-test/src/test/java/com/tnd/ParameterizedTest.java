package com.tnd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedTest {

    @Parameterized.Parameters
    public static Collection<Object[]> factorialData() {
        return Arrays.asList(new Object[][] {
                { 0, 1 }, { 1, 1 }, { 2, 2 }, { 3, 6 },
                { 4, 24 }, { 5, 120 },{ 6, 720 }
        });
    }

    @Parameterized.Parameter(value = 0)
    public int number;

    @Parameterized.Parameter(value = 1)
    public int expectedResult;

//    public ParameterizedTest(int input, int expected, int inc) {
//        this.number= input;
//        this.expectedResult= expected;
//        this.inc = inc;
//    }

    @Test
    public void factorial() throws Exception {
        Factorial fact = new Factorial();
        assertEquals(fact.factorial(number),expectedResult);
    }

}
