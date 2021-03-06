package com.shaunabram.datastructures.sort;

import org.fest.assertions.Assertions;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class QuickSortTest {

    @Test
    public void quicksort_handles_empty_list() {
        int[] unsorted = {};
        int[] sorted = {};
        Assertions.assertThat(QuickSortInPlace.quicksort(unsorted)).isEqualTo(sorted);
    }

    @Test
    public void quicksort_handles_null_list() {
        int[] unsorted = null;
        int[] sorted = null;
        assertThat(QuickSortInPlace.quicksort(unsorted)).isEqualTo(sorted);
    }

    @Test
    public void quicksort_handles_single_element_list() {
        int[] unsorted = {1};
        int[] sorted = {1};
        assertThat(QuickSortInPlace.quicksort(unsorted)).isEqualTo(sorted);
    }

    @Test
    public void quicksort_sorts_simplest_unsorted_list() {
        int[] unsorted = {5,2};
        int[] sorted = {2,5};
        assertThat(QuickSortInPlace.quicksort(unsorted)).isEqualTo(sorted);
    }

    @Test
    public void quicksort_sorts_simpler_unsorted_list() {
        int[] unsorted = {3,2,5,4};
        int[] sorted = {2,3,4,5};
        assertThat(QuickSortInPlace.quicksort(unsorted)).isEqualTo(sorted);
    }

    @Test
    public void quicksort_sorts_simple_unsorted_list() {
        int[] unsorted = {5,2,4,3,1};
        int[] sorted = {1,2,3,4,5};
        assertThat(QuickSortInPlace.quicksort(unsorted)).isEqualTo(sorted);
    }

    @Test
    public void quicksort_sorts_unsorted_list() {
        int[] unsorted = {4,2,9,1,8,6,5,7,3};
        int[] sorted = {1,2,3,4,5,6,7,8,9};
        assertThat(QuickSortInPlace.quicksort(unsorted)).isEqualTo(sorted);
    }

    @Test
    public void quicksort_sorts_unsorted_list2() {
        int[] unsorted = {3,8,2,5,1,4,7,6};
        int[] sorted = {1,2,3,4,5,6,7,8};
        assertThat(QuickSortInPlace.quicksort(unsorted)).isEqualTo(sorted);
    }

    @Test
    public void quicksort_sorts_simple_unbalanced_unsorted_list() {
        int[] unsorted = {2,2,2,1,1};
        int[] sorted = {1,1,2,2,2};
        assertThat(QuickSortInPlace.quicksort(unsorted)).isEqualTo(sorted);
    }

    @Test
    public void quicksort_sorts_unbalanced_unsorted_list() {
        int[] unsorted = {2,2,2,2,2,1,1,1,1,1};
        int[] sorted = {1,1,1,1,1,2,2,2,2,2};
        assertThat(QuickSortInPlace.quicksort(unsorted)).isEqualTo(sorted);
    }
    
}
