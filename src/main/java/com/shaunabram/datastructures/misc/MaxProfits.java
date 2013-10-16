package com.shaunabram.datastructures.misc;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 *  I have an array stockPricesYesterday where the keys are the number of minutes
 *  into the day (starting with midnight) and the values are the price of Apple
 *  stock at that time.
 *  For example, the stock cost $500 at 1am, so stockPricesYesterday[60] = 500.
 *
 *  Write an efficient algorithm for computing the best profit I could have made
 *  from 1 purchase and 1 sale of an Apple stock yesterday.
 */
public class MaxProfits {

    public static int getMaxProfit(Integer[] stockPrices) {
        Queue<Integer> maxPricesHeap = createHeapOfPrices(stockPrices);

        int maxProfit = 0;
        for (Integer buyPrice : stockPrices) {
            Integer sellPrice = getMaxPrice(maxPricesHeap);
            int tmpMaxProfit = sellPrice - buyPrice;
            if (tmpMaxProfit > maxProfit) {
                maxProfit = tmpMaxProfit;
            }
            removePrice(maxPricesHeap, buyPrice);
        }
        if (maxProfit<0) maxProfit = 0;
        return maxProfit;
    }

    private static boolean removePrice(Queue<Integer> maxPricesHeap, Integer buyPrice) {
        return maxPricesHeap.remove(buyPrice * -1);
    }

    private static Integer getMaxPrice(Queue<Integer> maxPricesHeap) {
        return -1 * maxPricesHeap.peek();
    }

    /**
     * Note that since head of a PriorityQueue is the min element, and
     * we want the max, we are storing all numbers are -ve
     */
    private static Queue<Integer> createHeapOfPrices(Integer[] stockPrices) {
        Queue<Integer> maxPricesHeap = new PriorityQueue<>();
        for (Integer stockPrice : stockPrices) {
            maxPricesHeap.add(-1 * stockPrice);
        }
        return maxPricesHeap;
    }
}
