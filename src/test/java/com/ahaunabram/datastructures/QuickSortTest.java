package com.ahaunabram.datastructures;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class QuickSortTest {

    @Test
    public void quicksort_handles_empty_list() {
        int[] unsorted = {};
        int[] sorted = {};
        assertThat(Quicksort.quicksort(unsorted)).isEqualTo(sorted);
    }

    @Test
    public void quicksort_handles_null_list() {
        int[] unsorted = null;
        int[] sorted = null;
        assertThat(Quicksort.quicksort(unsorted)).isEqualTo(sorted);
    }

    @Test
    public void quicksort_handles_single_element_list() {
        int[] unsorted = {1};
        int[] sorted = {1};
        assertThat(Quicksort.quicksort(unsorted)).isEqualTo(sorted);
    }

    @Test
    public void quicksort_sorts_simple_unsorted_list() {
        int[] unsorted = {5,2};
        int[] sorted = {2,5};
        assertThat(Quicksort.quicksort(unsorted)).isEqualTo(sorted);
    }

    @Test
    public void quicksort_sorts_unsorted_list() {
        int[] unsorted = {5,2,9,1,8,6,4,3,7};
        int[] sorted = {1,2,3,4,5,6,7,8,9};
        assertThat(Quicksort.quicksort(unsorted)).isEqualTo(sorted);
    }

    @Test
    public void quicksort_sorts_simple_unbalanced_unsorted_list() {
        int[] unsorted = {2,2,2,1,1};
        int[] sorted = {1,1,2,2,2};
        assertThat(Quicksort.quicksort(unsorted)).isEqualTo(sorted);
    }

    @Test
    public void quicksort_sorts_unbalanced_unsorted_list() {
        int[] unsorted = {2,2,2,2,2,1,1,1,1,1};
        int[] sorted = {1,1,1,1,1,2,2,2,2,2};
        assertThat(Quicksort.quicksort(unsorted)).isEqualTo(sorted);
    }
    
}
