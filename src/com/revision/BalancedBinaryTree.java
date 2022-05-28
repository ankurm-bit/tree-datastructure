package com.revision;

import com.node.Node;

public class BalancedBinaryTree {
    private static boolean balancedBinaryTree(Node root){
        return height(root) != -1;
    }

    private static int height(Node root){
        if(root == null)
            return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        if(lh == -1 || rh == -1)
            return -1;
        if(Math.abs(lh-rh) >1)
            return -1;
        return 1 + Math.max(lh,rh);
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        System.out.println(BalancedBinaryTree.balancedBinaryTree(root));
    }
}
