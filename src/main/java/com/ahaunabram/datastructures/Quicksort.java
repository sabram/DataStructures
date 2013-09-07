package com.ahaunabram.datastructures;

import java.util.Arrays;

public class Quicksort {
    public static int[] quicksort(int[] input) {
        return pivot(input);
    }

    private static int[] pivot(int[] input) {
        if (input.length <= 1) return input;
        int pivot = selectPivot(input);
        int i=1;
        int j=1;
        while (j<input.length) {
            int next = input[j];
            if (next < pivot) {
                swap(input, i, j);
                i++;
            }
            j++;
        }

        //recursively sort lower and upper
        int[] lower = {};
        if (i>1) {
            lower = Arrays.copyOfRange(input, 1, i);
            lower = pivot(lower);
        }
        int[] upper = {};
        if ((j-i)>0) {
            upper = Arrays.copyOfRange(input, i, input.length);
            upper = pivot(upper);
        }

        return merge(lower, pivot, upper);
    }

    private static int[] merge(int[] lower, int pivot, int[] upper) {
        int[] merged = new int[lower.length + upper.length + 1];
        int i = 0;
        while (i<merged.length) {
            if (lower.length>0) {
                for (int lowerNum : lower) {
                    merged[i++] = lowerNum;
                }
            }
            merged[i++] = pivot;
            if (upper.length>0) {
                for (int upperNum : upper) {
                    merged[i++] = upperNum;
                }
            }
        }
        return merged;
    }

    private static void swap(int[] input, int i, int j) {
        int tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }

    private static int selectPivot(int[] unsorted) {
        return unsorted[0];
    }
}
