package com.ahaunabram.datastructures.strings;

import java.util.ArrayDeque;
import java.util.Deque;

public class Strings {
    public static String reverse(String str) {
        char[] chars = str.toCharArray();
        int len = chars.length;
        char[] reversed = new char[len];
        int revIndex = len-1;
        for (char aChar : chars) {
            reversed[revIndex--] = aChar;
        }
        return new String(reversed);
    }

    public static String reverseUsingStack(String str) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            stack.push(aChar);
        }
        StringBuilder builder = new StringBuilder();
        for (char aChar : chars) {
            builder.append(stack.pop());
        }
        return builder.toString();
    }
}
