package com.shaunabram.datastructures.tree.binarytree;

import com.shaunabram.datastructures.tree.StrNode;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class BinaryTreeSerializerTest {

    @Test
    /**
     *     1
     *    / \
     *   2   3
     *  / \   \
     * 4   5   7
     */
    public void serialize() {
        BinaryTreeSerializer bst = new BinaryTreeSerializer();
        StrNode n1 = createTree();
        String serialized = bst.serialize(n1);
        assertThat(serialized).isEqualTo("1,2,4,5,3,EMPTY,7,");
    }

//    public void deserialize() {
//        BinaryTreeSerializer bst = new BinaryTreeSerializer();
//        String deserializedTree = "1,2,4,5,3,EMPTY,7";
//        IntNode expectedTree = createTree();
//        IntNode actualTree = bst.deserialize(deserializedTree);
//        assertThat(expectedTree).isEqualTo(actualTree);
//    }

    private StrNode createTree() {
        StrNode n7 = new StrNode(7, null, null);
        StrNode n3 = new StrNode(3, null, n7);
        StrNode n5 = new StrNode(5, null, null);
        StrNode n4 = new StrNode(4, null, null);
        StrNode n2 = new StrNode(2, n4, n5);
        return new StrNode(1, n2, n3);
    }
}

