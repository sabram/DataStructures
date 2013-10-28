package com.shaunabram.datastructures.tree.binarytree;

import com.shaunabram.datastructures.tree.IntNode;
import com.shaunabram.datastructures.tree.StrNode;

import java.util.StringTokenizer;

/**
 * You have Binary tree. This binary is going to be serialized and transferred to you server.
 Your server will deserialize the binary tree.
 Can you write 2 functions (Serialize, Deserialize)?
 */
public class BinaryTreeSerializer {

    private static final String EMPTY = "EMPTY";
    public StrNode deserialize(String tree) {
//        StringTokenizer tokenizer = new StringTokenizer(tree);
//        int count = 0;
//        while(tokenizer.hasMoreElements()) {
//            String next = tokenizer.nextToken();
//            IntNode newNode = null;
//            if (next != null && next != EMPTY) {
//                int nextNum = Integer.parseInt(next);
//                newNode = new IntNode(nextNum);
//            }
//            IntNode child;
//            IntNode parent = null;
//            boolean isLeft = true;
//            if (count == 0) {
////                // root node
////                StrNode root = new StrNode(next);
////                parent = root;
////            } else {
//                if (next.equals(EMPTY)) {
//                    isLeft = !isLeft;
//                } else {
//                    child = new StrNode(next);
//                    if (isLeft) {
//                        parent.setLeft(child);
//                    } else {
//                        parent.getRight() = child;
//                    }
//                }
//                parent = child;
////            }
//            i++;
//            return root;
        return null;
    }

    //returns comma separated list representation of the tree using a preorder traversal and
    public String serialize(IntNode node) {
        if (node == null) return "";
        StringBuilder sb = new StringBuilder();

        int val = node.getValue();
        String left = serialize(node.getLeft());
        String right = serialize(node.getRight());
        addVal(sb, val);
        if (left != "" || right != "") {
            if (left == "") left = EMPTY + ",";
            addVal(sb, left);
            //suspect we need: if (right == "") right = ",";
            addVal(sb, right);
        } else {
//            addVal(sb, ",");
        }

        return sb.toString();
    }

    private void addVal(StringBuilder sb, int val) {
        sb.append(val).append(",");
    }

    private void addVal(StringBuilder sb, String val) {
        sb.append(val);
//        if (!val.endsWith(",")) {
//            sb.append(",");
//        }
    }
}
