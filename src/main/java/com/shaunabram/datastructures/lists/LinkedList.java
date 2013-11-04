package com.shaunabram.datastructures.lists;

public class LinkedList {

    public static Node reverse(Node node) {
        Node previous = null;
        Node current = node;
        while(current!=null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}
