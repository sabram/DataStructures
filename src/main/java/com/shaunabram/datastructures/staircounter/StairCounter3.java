package com.shaunabram.datastructures.staircounter;

/**
 * Best solution (so far!) using neither recursion nor caching.
 */
public class StairCounter3 {

    public static int countHops(int numStairs) {
        if (numStairs == 0) return 0;
        else if (numStairs == 1) return 1;
        else if (numStairs == 2) return 2;
        else if (numStairs == 3) return 4;
        else {
            int numHops = 0;
            int hopsMinus1 = 1;
            int hopsMinus2 = 2;
            int hopsMinus3 = 4;
            for (int i=3; i<numStairs; i++) {
                numHops = hopsMinus1 + hopsMinus2 + hopsMinus3;
                hopsMinus1 = hopsMinus2;
                hopsMinus2 = hopsMinus3;
                hopsMinus3 = numHops;
            }
            return numHops;
        }
    }
}
