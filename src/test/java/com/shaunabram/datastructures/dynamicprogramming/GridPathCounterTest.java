package com.shaunabram.datastructures.dynamicprogramming;

import com.shaunabram.datastructures.dynamicprogramming.gridcounter.GridPathCounter;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class GridPathCounterTest {

    @Test
    public void countPaths() {
        assertThat(GridPathCounter.countPaths(1, 1)).isEqualTo(nChooseR(2,1));
        assertThat(GridPathCounter.countPaths(2, 1)).isEqualTo(nChooseR(3,1));
        assertThat(GridPathCounter.countPaths(1, 2)).isEqualTo(nChooseR(3,1));
        assertThat(GridPathCounter.countPaths(2, 2)).isEqualTo(nChooseR(4,2));
        assertThat(GridPathCounter.countPaths(4, 3)).isEqualTo(nChooseR(7,3));
        assertThat(GridPathCounter.countPaths(5, 4)).isEqualTo(nChooseR(9,4));
    }

    int nChooseR(int n, int r) {
        return factorial(n) / ( factorial(r) * (factorial(n-r)));
    }

    public static int factorial(int n) {
        int fact = 1; // this  will be the result
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
