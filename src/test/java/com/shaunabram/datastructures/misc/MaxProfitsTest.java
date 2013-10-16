package com.shaunabram.datastructures.misc;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class MaxProfitsTest {
    @Test
    public void getMaxProfit1() throws Exception {
        Integer[] prices = {1,2,3,4};
        assertThat(MaxProfits.getMaxProfit(prices)).isEqualTo(3);
    }

    @Test
    public void getMaxProfit2() throws Exception {
        Integer[] prices = {4,3,2,1};
        assertThat(MaxProfits.getMaxProfit(prices)).isEqualTo(0);
    }

    @Test
    public void getMaxProfit3() throws Exception {
        Integer[] prices = {4,1,1,3};
        assertThat(MaxProfits.getMaxProfit(prices)).isEqualTo(2);
    }

    @Test
    public void getMaxProfit4() throws Exception {
        Integer[] prices = {9,8,7,10};
        assertThat(MaxProfits.getMaxProfit(prices)).isEqualTo(3);
    }
}
