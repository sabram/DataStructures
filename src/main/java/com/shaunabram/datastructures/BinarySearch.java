package com.shaunabram.datastructures;

import java.util.Arrays;

/**
 * PROBLEM Implement a function to perform a binary search on a sorted array of integers to
 * find the index of a given integer.
 *
 * Comment on the efficiency of this search:
 *      Worst case performance is log n (where log is binary log, i.e. log base 2)
 * compare it with other search methods
 *
 */
public class BinarySearch {


    public static int recursive(int[] ar, int target) {
        int lower = 0;
        int upper = ar.length-1;
        while (lower <= upper) {
            int candidateIndex = mid(lower, upper);
            int candidate = ar[candidateIndex];
            if (candidate < target) {
                lower = candidateIndex + 1;
                int[] newar = Arrays.copyOfRange(ar, lower, upper + 1);
                recursive(newar, target);
            } else if (candidate > target) {
                upper = candidateIndex - 1;
                int[] newar = Arrays.copyOfRange(ar, lower, upper + 1);
                recursive(newar, target);
            } else {
                return candidateIndex;
            }
        }
        return -1;
    }

    public static int iterative(int[] ar, int target) {
        int lower = 0;
        int upper = ar.length-1;
        while ((lower <= upper) ) {
            int candidateIndex = mid(lower, upper);
            int candidate = ar[candidateIndex];
            if (candidate < target) {
                lower = candidateIndex+1;
            } else if (candidate > target) {
                upper = candidateIndex-1;
            } else {
                return candidateIndex;
            }

        }
        return -1;
    }

    public static int sys(int[] ar, int target) {
        return Arrays.binarySearch(ar, target);
    }

    public static int mid(int lower, int upper) {
        //surprisingly, this may not work:
        //  (lower+upper)/2;
        //see http://googleresearch.blogspot.com/2006/06/extra-extra-read-all-about-it-nearly.html
        return (lower + upper) >>> 1;
    }
}
