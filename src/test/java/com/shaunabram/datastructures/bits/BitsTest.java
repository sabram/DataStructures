package com.shaunabram.datastructures.bits;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

//Work in progress!!
public class BitsTest {

    @Test
    public void getBit() {
        //1 = 001
        assertTrue(Bits.getBit(1, 0));
        assertFalse(Bits.getBit(1, 1));

        //2 = 010
        assertFalse(Bits.getBit(2, 0));
        assertTrue(Bits.getBit(2, 1));
        assertFalse(Bits.getBit(2, 0));

        //5 = 101
        assertTrue(Bits.getBit(5, 0));
        assertFalse(Bits.getBit(5, 1));
        assertTrue(Bits.getBit(5, 2));
        assertFalse(Bits.getBit(5, 3));

        //7 = 111
        assertTrue(Bits.getBit(7, 0));
        assertTrue(Bits.getBit(7, 1));
        assertTrue(Bits.getBit(7, 2));
        assertFalse(Bits.getBit(7, 3));

//        System.out.print(Bits.getBit(7, 3));
//        System.out.print(Bits.getBit(7, 2));
//        System.out.print(Bits.getBit(7, 1));
//        System.out.println(Bits.getBit(7, 0));
    }

    // return ((num & (1 << i)) != 0);

    @Test
    public void setBit() {
        //1 = 001
        assertEquals(Bits.setBit(1, 0), 0b1);
        assertEquals(Bits.setBit(1, 1), 0b11);

        //2 = 010
        assertEquals(Bits.setBit(2, 0), 3);
        assertEquals(Bits.setBit(2, 1), 2);
        assertEquals(Bits.setBit(2, 2), 6);

        //5 = 101
        assertEquals(Bits.setBit(5, 0), 5);
        assertEquals(Bits.setBit(5, 1), 7);
        assertEquals(Bits.setBit(5, 2), 5);
        assertEquals(Bits.setBit(5, 3), 13);
    }

    @Test
    //not a test so much as an experiment/workpad
    public void test() {
        int i;

        i = 1; //001
        assertEquals(i << 1, 0b10);

        i = 4; //0100
        assertEquals(i << 2, 0b10000);
        assertEquals(i >> 2, 0b1);
    }
}
