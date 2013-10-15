package com.shaunabram.datastructures.misc;

import org.junit.Test;
import static com.shaunabram.datastructures.misc.ParenthesisMatcher.*;
import static org.fest.assertions.Assertions.assertThat;

public class ParenthesisMatcherTest {
    
    @Test
    public void getMatchingParen_return_m1_for_null() {
        assertThat(getMatchingParen(null, 1)).isEqualTo(-1);
    }

    @Test
    public void getMatchingParen_return_m1_for_no_matching() {
        assertThat(getMatchingParen("(", 1)).isEqualTo(-1);
    }

    @Test
    public void getMatchingParen_simple() {
        assertThat(getMatchingParen("(x)", 1)).isEqualTo(3);
    }

    @Test
    public void getMatchingParen_complex() {
        String s = "Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing.";
        assertThat(getMatchingParen(s, 11)).isEqualTo(80);
        assertThat(getMatchingParen(s, 29)).isEqualTo(47);
        assertThat(getMatchingParen(s, 58)).isEqualTo(79);
        assertThat(getMatchingParen(s, 69)).isEqualTo(78);
    }
}
