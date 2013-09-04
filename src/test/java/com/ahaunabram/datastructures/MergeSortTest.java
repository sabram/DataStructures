package com.ahaunabram.datastructures;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class MergeSortTest {

    @Test
    public void mergesort_sorts_simple_unsorted_list() {
        int[] unsorted = {5,2};
        int[] sorted = {1,2,3,4,5,6,7,8,9};
        assertThat(MergeSort.mergeSort(unsorted)).isEqualTo(sorted);
    }

    @Test
    public void mergesort_sorts_unsorted_list() {
        int[] unsorted = {5,2,9,1,8,6,4,3,7};
        int[] sorted = {1,2,3,4,5,6,7,8,9};
        assertThat(MergeSort.mergeSort(unsorted)).isEqualTo(sorted);
    }

    @Test
    public void mergesort_sorts_unbalanced_unsorted_list() {
        int[] unsorted = {1,1,1,1,1,2,2,2,2,2};
        int[] sorted = {1,1,1,1,2,2,2,2,2};
        assertThat(MergeSort.mergeSort(unsorted)).isEqualTo(sorted);
    }
}
