package com.shaunabram.datastructures.knapsack;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

public class KnapsackTest {

    @Test
    public void test() {
        Item i1 = new Item(3,4);
        Item i2 = new Item(2,3);
        Item i3 = new Item(4,2);
        Item i4 = new Item(4,3);
        List<Item> items = Lists.newArrayList(i1, i2, i3, i4);
        int maxWeight = 6;
        int maxValue = Knapsack.findMaxValue(maxWeight, items);
        int expectedMaxValue = 8;
        assertThat(maxValue).isEqualTo(expectedMaxValue);
    }

}
