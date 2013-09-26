package com.shaunabram.datastructures.dynamicprogramming.staircounter;

import com.google.common.collect.Lists;
import com.shaunabram.datastructures.staircounter.StairCounter;
import com.shaunabram.datastructures.staircounter.StairCounter2;
import com.shaunabram.datastructures.staircounter.StairCounter3;
import org.junit.Test;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

public class StairCounterTest {

    @Test
    public void naiveRecursiveSolution() {
        List<Integer> expectedResults = Lists.newArrayList(1, 2, 4, 7, 13, 24, 44);
        for (int i=0; i<7; i++) {
            int expected = expectedResults.get(i);
            assertThat(StairCounter.countHops(i+1)).isEqualTo(expected);
        }
    }

    @Test
    public void dynamicProgrammingSolutionWithCaching() {
        List<Integer> expectedResults = Lists.newArrayList(1, 2, 4, 7, 13, 24, 44);
        for (int i=0; i<7; i++) {
            int expected = expectedResults.get(i);
            StairCounter2 counter = new StairCounter2(i+1);
            assertThat(counter.countHops()).isEqualTo(expected);
        }
    }

    @Test
    public void dynamicProgrammingSolutionWithoutCaching() {
        List<Integer> expectedResults = Lists.newArrayList(1, 2, 4, 7, 13, 24, 44);
        for (int i=0; i<7; i++) {
            int expected = expectedResults.get(i);
            assertThat(StairCounter3.countHops(i+1)).isEqualTo(expected);
        }
    }

}
