package com.shaunabram.datastructures;

public class Fibonacci {

    public static int fibRecursive(int i) {
        if (i==0) return 0;
        if (i==1) return 1;
        else return fibRecursive(i-1) + fibRecursive(i-2);
    }

    public static int fibRecursiveWithCaching(int i) {
        int[] cache = new int[i];
        if (i==0) return 0;
        if (i==1) return 1;
        int arIndex = i-1;
        if (cache[arIndex] != 0) return cache[arIndex];
        else {
            int fib = fibRecursive(i-1) + fibRecursive(i-2);
            cache[arIndex] = fib;
            return fib;
        }
    }

    public static int fib(int n) {
        if (n==0) return 0;
        if (n==1) return 1;
        int fibN = 0;
        int fibNMinusOne = 1;
        int fibNMinusTwo = 0;
        for (int j=2; j<=n; j++) {
            fibN = fibNMinusOne + fibNMinusTwo;
            fibNMinusTwo = fibNMinusOne;
            fibNMinusOne = fibN;
        }
        return fibN;
    }
}
