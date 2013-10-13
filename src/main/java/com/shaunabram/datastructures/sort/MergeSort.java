package com.shaunabram.datastructures.sort;

import java.util.Arrays;

public class MergeSort {
    public static int[] mergeSort(final int[] input) {
        int length = input.length;
        if (length == 1) return input;
        int mid = length/2;
        int[] a = Arrays.copyOfRange(input, 0, mid);
        int[] b = Arrays.copyOfRange(input, mid, length);
        return merge(mergeSort(a), mergeSort(b));
    }

    //assumes a and b are already sorted, otherwise results unpredictable!
    protected static int[] merge(final int[] a, final int[] b) {
        int[] merged = new int[a.length + b.length];
        int i = 0;
        int aIndex = 0;
        int bIndex = 0;
        while (aIndex<a.length && bIndex<b.length) {
            int smaller;
            if (a[aIndex] <= b[bIndex]) {
                smaller = a[aIndex++];
            } else {
                smaller = b[bIndex++];
            }
            merged[i++] = smaller;
        }
        //Now either a or b has been completely copied into merged
        //However, we may still need to copy the remaining numbers from the other (yet to be completely processed) array into merged also
        //This is a straight copy as they are already sorted and all guaranteed to be bigger than anything in merged so far
        while (aIndex<a.length) {
            merged[i++] = a[aIndex++];
        }
        while (bIndex<b.length) {
            merged[i++] = b[bIndex++];
        }
        return merged;
    }
}
