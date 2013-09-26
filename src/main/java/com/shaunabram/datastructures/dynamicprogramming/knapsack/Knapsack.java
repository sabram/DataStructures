package com.shaunabram.datastructures.dynamicprogramming.knapsack;

import java.util.List;

public class Knapsack {

    public static int findMaxValue(int maxWeight, List<Item> items) {
        int rowMax = maxWeight;
        int colMax = items.size();
        int[][] a = new int[rowMax+1][colMax+1];

        //initialize column 0 to be zeros.
        //Because in an optimal solution, zeros items have zero weight.
        //Don't really need to store this; just doing for clarity.
        for (int row=0; row<=rowMax; row++) {
            a[row][0] = 0;
        }

        for (int col=1; col<=colMax; col++) { //iterate through each item
            Item item = items.get(col-1);
            for (int row=0; row<=rowMax; row++) { //iterate though each possible weight
                int case1 = a[row][col-1];
                int case2;
                if (item.weight > row) {
                    case2 = case1;
                } else {
                    case2 = a[row-item.weight][col-1] + item.value;
                }
                a[row][col] = biggerOf(case1, case2);
            }
        }
        display(a);
        return a[rowMax][colMax];
    }

    private static int biggerOf(int case1, int case2) {
        return case1>case2?case1:case2;
    }

    private static void display(int[][] a) {
        int numRows = a.length;
        int numCols = a[0].length;
        for (int row=0; row<numRows; row++) {
            String prefix = "";
            for (int col=0; col<numCols; col++) {
                System.out.print(prefix + a[row][col]);
                prefix = ",";
            }
            System.out.print("\n");
        }
    }
}
