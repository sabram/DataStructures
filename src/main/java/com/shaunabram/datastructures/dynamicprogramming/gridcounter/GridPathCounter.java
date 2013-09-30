package com.shaunabram.datastructures.dynamicprogramming.gridcounter;

import java.util.ArrayList;
import java.util.List;

/**
 * Starting at the upper left corner (0,0) of an x by y grid,
 * and moving only right or down,
 * how many paths are there to the bottom right corner (x,y)?
 *
 * As an optional extra, no-go spots (blocked coordinates) can be supplied.
 *
 * The solution below uses dynamic programming.
 * The tests use the alternative approach to validate this solution i.e. the n Choose r formula.
 */
public class GridPathCounter {

    public static int countPaths(int x, int y) {
        List<Coordinate> noBlockedCoords = new ArrayList<>();
        return countPaths(x, y, noBlockedCoords);
    }

    public static int countPaths(int x, int y, List<Coordinate> blockedCoords) {
        Coordinate coordinate = new Coordinate(x,y);
        if (blockedCoords.contains(coordinate)) return 0;

        if (x==0 && y==0) return 1;
        else if (x==0) return countPaths(x, y-1, blockedCoords);
        else if (y==0) return countPaths(x-1, y, blockedCoords);
        else return countPaths(x-1, y, blockedCoords) + countPaths(x, y-1, blockedCoords);
    }

}
