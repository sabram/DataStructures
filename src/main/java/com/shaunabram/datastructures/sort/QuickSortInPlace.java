package com.shaunabram.datastructures.sort;

public class QuickSortInPlace {
    public static int[] quicksort(int[] input) {
        if (input == null || input.length <= 1) return input;
        return quicksort(input, 0, input.length);
    }

    private static int[] quicksort(int[] input, int lowerIdx, int upperIdx) {
        if (upperIdx-lowerIdx<=1) return input;

        //for simplicity, we just use the first element as the pivot
        int pivotIdx = lowerIdx;

        //But if we didn't use first element as the pivot,
        //this algo would still work as long as we move the pivot to the start.
        //For example
        //int pivotIdx = selectPivot(input, lowerIdx, upperIdx);
        //swap(input, lowerIdx, pivotIdx);

        pivotIdx = pivot(input, lowerIdx, upperIdx, pivotIdx);

        //recursively sort the array the left and right of the pivot
        quicksort(input, lowerIdx, pivotIdx);
        quicksort(input, pivotIdx + 1, input.length);

        return input;
    }

    private static int pivot(int[] input, int lowerIdx, int upperIdx, int pivotIdx) {
        int pivot = input[pivotIdx];
        int i=lowerIdx+1;
        int j=i;
        while (j<upperIdx) {
            int next = input[j];
            if (next < pivot) {
                swap(input, i, j);
                i++;
            }
            j++;
        }

        //put pivot in its rightful place
        //i.e. swap pivot (at lowerIdx) with the last 'less than' number (at i-1)
        swap(input, lowerIdx, i-1);

        return i-1;
    }

    private static void swap(int[] input, int i, int j) {
        int tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }

    @SuppressWarnings("unused")
    //unused but left as a placeholder for improving pivot selection
    private static int selectPivot(int[] input, int lower, int upper) {
        return lower;
    }
}
