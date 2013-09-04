package com.ahaunabram.datastructures;

import java.util.Arrays;

public class MergeSort {
    public static int[] mergeSort(final int[] unsorted) {

        int length = unsorted.length;
        if (length == 1) {
            return unsorted;
        }
        int mid = length/2;
        
        int[] a = Arrays.copyOfRange(unsorted, 0, mid);
        int[] b = Arrays.copyOfRange(unsorted, mid, length);
        int[] aSorted = mergeSort(a);
        int[] bSorted = mergeSort(b);
        int aIndex = 0;
        int bIndex = 0;
        int i=0;
        int[] sorted = new int[length];
        while (i<length) {
            if (aSorted[aIndex] < bSorted[bIndex]) {
                sorted[i] = aSorted[aIndex];
                aIndex++;
            } else if (aSorted[aIndex] > bSorted[bIndex]) {
                sorted[i] = bSorted[bIndex];
                bIndex++;
            } else {
                sorted[i++] = aSorted[aIndex++];
                sorted[i] = bSorted[bIndex++];
            }
            i++;
            if (aIndex>=a.length) {
                for (; bIndex<bSorted.length; bIndex++) {
                    int bValue = bSorted[bIndex];
                    sorted[i++] = bValue;
                }
                return sorted;
            }
            if (bIndex>=b.length) {
                for (; aIndex<aSorted.length; aIndex++) {
                    int aValue = aSorted[aIndex];
                    sorted[i++] = aValue;
                }
                return sorted;
            }
        }
        return sorted;
    }
}
