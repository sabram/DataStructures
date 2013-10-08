package com.shaunabram.datastructures.misc;

import java.util.HashSet;
import java.util.Set;

public class Subsets {

    public static final Set<Integer> EMPTY_SET = new HashSet<>();

//    public static Set<Set<Integer>> findSubsets(Set<Integer> s) {
//        System.out.println("Finding sunsets for " + s);
//        if (s==null) return null;
//        Set<Set<Integer>> allSubsets = new HashSet<>();
//        if (s.size()==0) return allSubsets;
//        s.remove(EMPTY_SET);
//        if (s.size() >= 1) {
//            allSubsets.add(s);
//            for (int index=0; index<s.size(); index++) {
//                Set<Integer> subsetMinusOne = new HashSet<>(s);
//                Integer first = removeOne(subsetMinusOne, index);
//                Set<Set<Integer>> subsets = findSubsets(subsetMinusOne);
//                allSubsets.addAll(subsets);
//                for (Set<Integer> i : subsets) {
//                    Set<Integer> newSet = new HashSet<>();
//                    newSet.add(first);
//                    newSet.addAll(i);
//                    allSubsets.addAll(subsets);
//                }
//                Set<Integer> setWithJustFirst = new HashSet<>();
//                setWithJustFirst.add(first);
//                allSubsets.add(setWithJustFirst);
//            }
//
//        }
//        allSubsets.add(EMPTY_SET);
//        return allSubsets;
//    }
//
//    private static Integer removeOne(Set<Integer> set, int i) {
//        Iterator<Integer> iterator = set.iterator();
//        int index = 0;
//        Integer next = null;
//        while (iterator.hasNext()) {
//            next = iterator.next();
//            if (i==index) {
//                set.remove(next);
//                break;
//            }
//        }
//        return next;
//    }

    public static Set<Set<Integer>> findSubsets(Set<Integer> set) {
        if (set==null) return null;
        double expectedSubsetsSize = Math.pow(2, set.size());
        Set<Set<Integer>> rSet = new HashSet<>();
        if (set.isEmpty()) {
            rSet.add(set);
        } else if (set.size()==1) {
            rSet.add(EMPTY_SET);
            rSet.add(set);
        } else {
            Integer removed = removeElement(set);
            Set<Set<Integer>> subsets = findSubsets(set);
            rSet.addAll(subsets);
            for (Set<Integer> subset : subsets) {
                Set<Integer> subsetCloned = new HashSet<>(subset);
                subsetCloned.add(removed);
                rSet.add(subsetCloned);
            }
        }
        assert rSet.size() == expectedSubsetsSize : "expected" + expectedSubsetsSize + " was " + rSet.size();
        return rSet;
    }

    private static Integer removeElement(Set<Integer> set) {
        Integer removed = null;
        for (Integer integer : set) {
            set.remove(integer);
            removed = integer;
            break;
        }
        return removed;
    }
}
