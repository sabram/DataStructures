package com.shaunabram.datastructures;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

public class FibonacciTest {

    List<Integer> fibResults;

    @Before
    public void setup() {
        fibResults = Lists.newArrayList(0,1,1,2,3,5,8,13,21,34);
    }
    @Test
    public void fib() {
        for (int i=0; i<10; i++) {
            int expected = fibResults.get(i);
            int actual = Fibonacci.fib(i);
            assertThat(actual)
                    .overridingErrorMessage(i + " Fib should be " + expected + " but got " + actual)
                    .isEqualTo(expected);
        }

    }
}
