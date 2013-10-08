package com.shaunabram.datastructures.misc;

import java.util.HashSet;
import java.util.Set;

public class Subsets {

    public static final Set<Integer> EMPTY_SET = new HashSet<>();

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
