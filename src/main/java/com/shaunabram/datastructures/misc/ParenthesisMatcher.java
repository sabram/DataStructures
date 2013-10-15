package com.shaunabram.datastructures.misc;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ParenthesisMatcher {

    private static final char OPEN = '(';
    private static final char CLOSE = ')';

    public static int getMatchingParen(String s, int openPos) {
        if (s==null) return -1;
        Map<Integer, Integer> matchingParens = getMatchingParens(s);
        Integer closingPos = matchingParens.get(openPos);
        if (closingPos==null) return -1;
        return closingPos;
    }

    private static Map<Integer, Integer> getMatchingParens(String s) {
        Map<Integer, Integer> matchingParens = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        int i = 1;
        while (i<chars.length+1) {
            if (chars[i-1] == OPEN) {
                stack.push(i);
            }
            if (chars[i-1] == CLOSE) {
                int open = stack.pop();
                matchingParens.put(open, i);
            }
            i++;
        }
        return matchingParens;
    }
}
