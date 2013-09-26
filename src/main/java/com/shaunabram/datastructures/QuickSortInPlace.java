package com.shaunabram.datastructures;

public class QuickSortInPlace {
    public static int[] quicksort(int[] input) {
        if (input == null || input.length <= 1) return input;
        return pivot(input, 0, input.length);
    }

    private static int[] pivot(int[] input, int lower, int upper) {
        if (upper-lower<=1) return input;
        int pivot = selectPivot(input, lower);
        printArray("pivoting array ", input, lower, upper, pivot);


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
        //i.e. swap pivot (lower) with last 'less than' number (i-1)
        swap(input, lower, i-1);

        printArray("pivoted array ", input, lower, upper, pivot);

        pivot(input, lower, i-1);
        pivot(input, i+2, input.length);

        return input;
    }

    private static void printArray(String s, int[] input, int lower, int upper, int pivot) {
        System.out.print(s);
        for (int x=lower; x<upper; x++ ) {
            System.out.print(input[x]);
        }
        System.out.print(" around " + pivot + "\n");
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
