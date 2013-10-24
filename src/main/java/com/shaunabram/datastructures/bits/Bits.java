package com.shaunabram.datastructures.bits;

public class Bits {

    public static boolean getBit(int num, int i) {
        int mask = 1 << i;
        int result = num & mask;
        return result > 0;
    }

    public static int setBit(int num, int i) {
        int mask = 1 << i;
        int result = num | mask;
        return result;
    }

    public static void main(String[] args){
        int i = 1;
        System.out.println(i);
        int j = i << 1;
        System.out.println(j);
        j = j << 1;
        System.out.println(j);

        i = 5;
        System.out.println(i);
        j = i >> 1;
        System.out.println(j);

        i=5;
        j = i << 1;
        System.out.println(j);
    }
}
