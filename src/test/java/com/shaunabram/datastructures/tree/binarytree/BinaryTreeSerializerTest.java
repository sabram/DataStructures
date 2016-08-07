package com.shaunabram.datastructures.tree.binarytree;

import com.shaunabram.datastructures.tree.IntNode;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class BinaryTreeSerializerTest {

    @Test
    public void serialize() {
        BinaryTreeSerializer bst = new BinaryTreeSerializer();
        IntNode n1 = createTree();
        String serialized = bst.serialize(n1);
        assertThat(serialized).isEqualTo("1,2,4,5,3,EMPTY,7,");
    }


    //wways to do this
    //1) take string an store in an array. e.g. parent = i/2
    //problem is that this requres keeping the whole tree (string and arrat representation of) in memory
    //2) you know that at each level, you are going to have log 2^n entries, and
    //log 2^n+1 entries on the next level
    //so read ahead next 2^ entries, and 2 at a time, put them in parents...


//    public void deserialize() {
//        BinaryTreeSerializer bst = new BinaryTreeSerializer();
//        String deserializedTree = "1,2,4,5,3,EMPTY,7";
//        IntNode expectedTree = createTree();
//        IntNode actualTree = bst.deserialize(deserializedTree);
//        assertThat(expectedTree).isEqualTo(actualTree);
//    }

    /**
     *     1
     *    / \
     *   2   3
     *  / \   \
     * 4   5   7
     */
    private IntNode createTree() {
        IntNode n7 = new IntNode(7, null, null);
        IntNode n3 = new IntNode(3, null, n7);
        IntNode n5 = new IntNode(5, null, null);
        IntNode n4 = new IntNode(4, null, null);
        IntNode n2 = new IntNode(2, n4, n5);
        return new IntNode(1, n2, n3);
    }
}

