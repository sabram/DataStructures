package com.ahaunabram.datastructures;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

//TODO: Would be nice to have each test run against all three binary search implementations.
public class BinarySearchTest {

    @Test
    public void bsearch_returns_correct_index_for_single_element_array() {
        int[] sortedIntArray = {100};
        int index = BinarySearch.recursive(sortedIntArray, 100);
        assertEquals(0, index);
    }

    @Test
    public void bsearch_returns_correct_index_when_finding_first_element_in_double_element_array() {
        int[] sortedIntArray = {100, 200};
        int index = BinarySearch.recursive(sortedIntArray, 100);
        assertEquals(0, index);
    }

    @Test
        public void bsearch_returns_correct_index_when_finding_last_element_in_double_element_array() {
            int[] sortedIntArray = {100, 200};
            int index = BinarySearch.recursive(sortedIntArray, 200);
            assertEquals(1, index);
        }

    @Test
    public void bsearch_returns_correct_index_when_finding_middle_in_array() {
        int[] sortedIntArray = {0,1,2};
        int index = BinarySearch.recursive(sortedIntArray, 2);
        assertEquals(2, index);
    }

    @Test
    public void bsearch_returns_correct_index_when_finding_last_in_array() {
        int[] sortedIntArray = {0,5,10,15,20,25};
        int index = BinarySearch.recursive(sortedIntArray, 25);
        assertEquals(5, index);
    }

    @Test
    public void bsearch_returns_correct_index_when_finding_fist_in_array() {
        int[] sortedIntArray = {0,5,10,15,20,25};
        int index = BinarySearch.recursive(sortedIntArray, 0);
        assertEquals(0, index);
    }

    @Test
    public void bsearch_returns_negative_when_target_not_found() {
        int[] sortedIntArray = {0,1,2};
        int index = BinarySearch.recursive(sortedIntArray, 4);
        /* My implementations return -1;
           Arrays.binarySearch returns (-(insertion point) - 1)
         */
        assertTrue(index < 0);
    }

    @Test
    public void mid_picks_middle() {
        assertEquals(2, BinarySearch.mid(1, 3));
    }

    @Test
    public void mid_pick_lower_when_upper_eqs_lowerPlusOne() {
        //when upper = lower + 1
        //mid can be either upper or lower? Just do consistently.
        //we always do on the lower side.
        assertEquals(1, BinarySearch.mid(1, 2));
    }

    @Test
    public void mid_picks_lower_when_upper_eqs_lower() {
        assertEquals(1, BinarySearch.mid(1, 1));
    }

    @Test
    public void mid_handles_large_numbers() {
        int expected = Integer.MAX_VALUE -1 ;
        assertEquals(expected, BinarySearch.mid(Integer.MAX_VALUE-1, Integer.MAX_VALUE));
    }
}
