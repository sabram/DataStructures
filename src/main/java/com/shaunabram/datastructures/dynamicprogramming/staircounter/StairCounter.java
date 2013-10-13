package com.shaunabram.datastructures.dynamicprogramming.staircounter;

/**
 * Naive recursive solution
 */
public class StairCounter {

    public static int countHops(int numStairs) {
        if (numStairs<0) return 0;
        else if (numStairs==0) return 1;
        else return countHops(numStairs - 1) + countHops(numStairs - 2) + countHops(numStairs - 3);
    }

}
