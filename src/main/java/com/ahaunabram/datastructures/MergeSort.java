package com.ahaunabram.datastructures;

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

    private static int[] merge(int[] a, int[] b) {
        int[] sorted = new int[a.length + b.length];
        int i=0;
        int aIndex = 0;
        int bIndex = 0;
        while (i<sorted.length) {
            if (a[aIndex] < b[bIndex]) {
                sorted[i++] = a[aIndex];
                aIndex++;
            } else if (a[aIndex] > b[bIndex]) {
                sorted[i++] = b[bIndex];
                bIndex++;
            } else {
                sorted[i++] = a[aIndex++];
                sorted[i++] = b[bIndex++];
            }
            if (aIndex>=a.length) {
                for (; bIndex<b.length; bIndex++) {
                    int bValue = b[bIndex];
                    sorted[i++] = bValue;
                }
                return sorted;
            }
            if (bIndex>=b.length) {
                for (; aIndex<a.length; aIndex++) {
                    int aValue = a[aIndex];
                    sorted[i++] = aValue;
                }
                return sorted;
            }
        }
        return sorted;
    }
}
