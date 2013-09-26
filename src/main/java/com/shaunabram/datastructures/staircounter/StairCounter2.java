package com.shaunabram.datastructures.staircounter;

/**
 * Recursive solution using caching (Dynamic programming)
 */
public class StairCounter2 {

    int[] a;
    int numStairs;

    public StairCounter2(int numStairs) {
        this.numStairs = numStairs;
        a = new int[numStairs];
    }

    public int countHops() {
        return countHops(numStairs);
    }

    private int countHops(int numStairs) {
        return getHops(numStairs - 1) + getHops(numStairs - 2) + getHops(numStairs - 3);
    }

    private int getHops(int numStairs) {
        if (numStairs<0) return 0;
        else if (numStairs==0) return 1;
        else if (a[numStairs] == 0) {
            int j = countHops(numStairs);
            a[numStairs] = j;
        }
        return a[numStairs];
    }
}
