package com.shaunabram.datastructures.lists;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class LinkedListTest {
    @Test
    public void reverse() {
        Node three = new Node(3, null);
        Node two = new Node(2, three);
        Node one = new Node(1, two);

        Node newList = LinkedList.reverse(one);
        assertThat(newList.val).isEqualTo(3);
        assertThat(newList.next.val).isEqualTo(2);
        assertThat(newList.next.next.val).isEqualTo(1);
        assertThat(newList.next.next.next).isEqualTo(null);
    }
}
