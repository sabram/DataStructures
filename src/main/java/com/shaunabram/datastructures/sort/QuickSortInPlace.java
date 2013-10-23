package com.shaunabram.datastructures.sort;

import java.util.Arrays;

public class QuickSortInPlace {
    public static int[] quicksort(int[] input) {
        if (input == null || input.length <= 1) return input;
        return pivot(input, 0, input.length);
    }

    private static int[] pivot(int[] input, int lower, int upper) {
        if (upper-lower<=1) {
            //debug
            if ((upper-lower)==1) {
                System.out.println("as is " + input[lower]);
            }

            return input;
        }
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
        //i.e. swap pivot last 'less than' number (lower)
        int pivotIdx = i-1;
        swap(input, lower, pivotIdx);

        printArray("pivoted array ", input, lower, upper, pivot);
        System.out.println("(pivotIdx=" + pivotIdx + " in array " + Arrays.toString(input));

        pivot(input, lower, pivotIdx);
        pivot(input, pivotIdx+1, input.length);

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
