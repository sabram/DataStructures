package com.shaunabram.datastructures.misc;

import java.util.PriorityQueue;

/**
 * Utility to keep track if a list of numbers, and return the median at any time.
 * All operations run in Big-Oh = O(log(n)) or better.
 *
 * Implementation use 2 heaps to keep try of the highest and lowest numbers.
 * Since PriorityQueue.head returns the least element
 * and we need a way to get highest element (of the lowest numbers), we store all numbers in loHeap as -ves
 * e.g. 3 and 4 would be added as -3 and -4, hence peek would return least (-4) which really gives us the max (4).
 *
 * This is the solution to a problem from the Heaps lectures in
 * Algorithms: Design and Analysis, Part 1, by Tim Roughgarden
 * https://class.coursera.org/algo-004/lecture/62
 *
 */
public class MedianTracker {

    PriorityQueue<Integer> loHeap;
    PriorityQueue<Integer> hiHeap;

    public MedianTracker() {
        loHeap = new PriorityQueue<Integer>();
        hiHeap = new PriorityQueue<Integer>();
    }

    //runs in log n time: //Big-Oh = O(log(n))
    public void add(int i) {
        //special handling for first addition
        if (loHeap.size() == 0) { //Big-Oh = O(1)
            loHeap.offer(i * -1); //Big-Oh = O(log(n))
            return;
        }

        //put number in smallest heap
        if (i<loHeap.peek()) { //Big-Oh = O(1)
            loHeap.offer(i * -1); //Big-Oh = O(log(n))
        } else { //i>=loHeap.peek()
            hiHeap.offer(i); //Big-Oh = O(log(n))
        }

        //rebalance if necessary
        if (loHeap.size() > hiHeap.size() + 1) {
            int move = loHeap.remove() * -1; //Big-Oh = O(log(n))
            hiHeap.offer(move); //Big-Oh = O(log(n))
        } else if (hiHeap.size() > loHeap.size() + 1) {
            int move = hiHeap.remove(); //Big-Oh = O(log(n))
            loHeap.offer(move * -1); //Big-Oh = O(log(n))
        } //else hiHeap.size() == loHeap.size() so no rebalance necessary
    }

    //runs in constant time: Big-Oh = O(1)
    public double getMedian() {
        double median;
        if (loHeap.size() > hiHeap.size()) { //Big-Oh = O(1)
            //get highest of the low numbers
            median = loHeap.peek() * -1; //Big-Oh = O(1)
        } else if (loHeap.size() < hiHeap.size()) { //Big-Oh = O(1)
            //get lowest of the high numbers
            median = hiHeap.peek(); //Big-Oh = O(1)
        } else {
            int a = loHeap.peek() * -1; //Big-Oh = O(1)
            int b = hiHeap.peek(); //Big-Oh = O(1)
            median = (a + b)/2.0; //Big-Oh = O(1)
        }
        return median;
    }

}
