package com.shaunabram.datastructures.sort;

public class QuickSortInPlace {
    public static int[] quicksort(int[] input) {
        if (input == null || input.length <= 1) return input;
        return pivot(input, 0, input.length);
    }

    private static int[] pivot(int[] input, int lower, int upper) {
        if (upper-lower<=1) return input;
        int pivot = selectPivot(input, lower);

        int i=lower+1;
        int j=i;
        while (j<upper) {
            int next = input[j];
            if (next < pivot) {
                swap(input, i, j);
                i++;
            }
            j++;
        }

        //put pivot in its rightful place
        //i.e. swap pivot last 'less than' number (lower)
        int pivotIdx = i-1;
        swap(input, lower, pivotIdx);

        //recursively sort the array the left and right of the pivot
        pivot(input, lower, pivotIdx);
        pivot(input, pivotIdx+1, input.length);

        return input;
    }

    private static void swap(int[] input, int i, int j) {
        int tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }

    private static int selectPivot(int[] input, int lower) {
        return input[lower];
    }
}
