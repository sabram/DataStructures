package com.shaunabram.datastructures;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MedianTrackerTest {

    @Test
    public void test() {
        MedianTracker medianTracker = new MedianTracker();
        medianTracker.add(1);
        assertEquals(1, medianTracker.getMedian(), 0.000);
        medianTracker.add(9);
        assertEquals(5, medianTracker.getMedian(), 0.000);
        medianTracker.add(4);
        assertEquals(4, medianTracker.getMedian(), 0.000);
        medianTracker.add(5);
        assertEquals(4.5, medianTracker.getMedian(), 0.000);
    }
}
