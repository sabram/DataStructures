package com.shaunabram.datastructures.dynamicprogramming.gridcounter;

/**
 * Starting at the upper left corner (0,0) of an x by y grid,
 * and moving only right or down,
 * how many paths are there to the bottom right corner (x,y)?
 *
 * The solution below uses dynamic programming.
 * The tests use the alternative approach to validate this solution i.e. the n Choose r formula.
 */
public class GridPathCounter {

    public static int countPaths(int x, int y) {
        if (x==0 && y==0) return 1;
        else if (x==0) return countPaths(x, y-1);
        else if (y==0) return countPaths(x-1, y);
        else return countPaths(x-1, y) + countPaths(x, y-1);
    }

}
