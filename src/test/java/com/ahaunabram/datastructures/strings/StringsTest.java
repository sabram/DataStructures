package com.ahaunabram.datastructures.strings;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class StringsTest {

    @Test
    public void reverseString() {
        assertThat(Strings.reverse("abcde")).isEqualTo("edcba");
    }

    @Test
    public void reverseUsingStack() {
        assertThat(Strings.reverseUsingStack("abcde")).isEqualTo("edcba");
    }
}
