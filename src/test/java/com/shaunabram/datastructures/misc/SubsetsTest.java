package com.shaunabram.datastructures.misc;

import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.Set;

import static org.fest.assertions.Assertions.assertThat;

public class SubsetsTest {

    @Test
    public void testFindSubsets_returns_null_for_null_Set() {
        Set<Integer> set = null;
        Set<Set<Integer>> subsets = Subsets.findSubsets(set);
        assertThat(subsets).isNull();
    }

    @Test
    public void testFindSubsets_for_1_element_Set() {
        Set<Integer> set = Sets.newHashSet(1);
        Set<Set<Integer>> subsets = Subsets.findSubsets(set);

        Set<Integer> a = Sets.newHashSet(1);
        assertThat(subsets).containsOnly(Subsets.EMPTY_SET, a);
    }

    @Test
    public void testFindSubsets_for_2_element_Set() {
        Set<Integer> set = Sets.newHashSet(1, 2);
        Set<Set<Integer>> subsets = Subsets.findSubsets(set);

        Set<Integer> a = Sets.newHashSet(1);
        Set<Integer> b = Sets.newHashSet(2);
        Set<Integer> c = Sets.newHashSet(1, 2);
        assertThat(subsets).containsOnly(Subsets.EMPTY_SET, a, b, c);
    }

    @Test
    public void testFindSubsets_for_3_element_Set() {
        Set<Integer> set = Sets.newHashSet(1, 2, 3);
        Set<Set<Integer>> subsets = Subsets.findSubsets(set);

        Set<Integer> a = Sets.newHashSet(1);
        Set<Integer> b = Sets.newHashSet(2);
        Set<Integer> c = Sets.newHashSet(3);
        Set<Integer> d = Sets.newHashSet(1, 2);
        Set<Integer> e = Sets.newHashSet(2, 3);
        Set<Integer> f = Sets.newHashSet(1, 3);
        Set<Integer> g = Sets.newHashSet(1, 2, 3);
        assertThat(subsets).containsOnly(Subsets.EMPTY_SET, a, b, c, d, e, f, g);
    }

    @Test
    public void testFindSubsets_for_4_element_Set() {
        Set<Integer> set = Sets.newHashSet(1, 2, 3, 4);
        Set<Set<Integer>> subsets = Subsets.findSubsets(set);

        Set<Integer> a = Sets.newHashSet(1);
        Set<Integer> b = Sets.newHashSet(2);
        Set<Integer> c = Sets.newHashSet(3);
        Set<Integer> d = Sets.newHashSet(4);
        Set<Integer> e = Sets.newHashSet(1, 2);
        Set<Integer> f = Sets.newHashSet(1, 3);
        Set<Integer> g = Sets.newHashSet(1, 4);
        Set<Integer> h = Sets.newHashSet(2, 3);
        Set<Integer> i = Sets.newHashSet(2, 4);
        Set<Integer> j = Sets.newHashSet(3, 4);
        Set<Integer> k = Sets.newHashSet(1, 2, 3);
        Set<Integer> l = Sets.newHashSet(1, 2, 4);
        Set<Integer> m = Sets.newHashSet(1, 3, 4);
        Set<Integer> n = Sets.newHashSet(2, 3, 4);
        Set<Integer> o = Sets.newHashSet(1, 2, 3, 4);
        assertThat(subsets).containsOnly(Subsets.EMPTY_SET, a, b, c, d, e, f, g, h, i, j, k, l, m, n, o);
    }
}
