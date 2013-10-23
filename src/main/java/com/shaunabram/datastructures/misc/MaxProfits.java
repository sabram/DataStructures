package com.shaunabram.datastructures.misc;

import com.google.common.collect.MinMaxPriorityQueue;

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
        MinMaxPriorityQueue<Integer> maxPricesHeap = createHeapOfPrices(stockPrices);

        int maxProfit = 0;
        for (Integer buyPrice : stockPrices) {
            Integer sellPrice = maxPricesHeap.peekLast();
            int tmpMaxProfit = sellPrice - buyPrice;
            if (tmpMaxProfit > maxProfit) {
                maxProfit = tmpMaxProfit;
            }
            maxPricesHeap.remove(buyPrice);
        }
        if (maxProfit<0) maxProfit = 0;
        return maxProfit;
    }

    /**
     * Note that since head of a PriorityQueue is the min element, and
     * we want the max, we are using a MinMaxPriorityQueue, which
     * provides both peek() and peekLast() in constant time.
     */
    private static MinMaxPriorityQueue<Integer> createHeapOfPrices(Integer[] stockPrices) {
        MinMaxPriorityQueue<Integer> maxPricesHeap = MinMaxPriorityQueue.create();
        for (Integer stockPrice : stockPrices) {
            maxPricesHeap.add(stockPrice);
        }
        return maxPricesHeap;
    }
}
