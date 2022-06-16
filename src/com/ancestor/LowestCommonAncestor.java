package com.ancestor;

import com.node.Node;

public class LowestCommonAncestor {

    private static Node lCA(Node root, Node a, Node b){
        if(root == null || root ==a || root == b)
            return root ;

        Node left = lCA(root.left,a,b);
        Node right = lCA(root.right,a,b);
        if(left == null)
            return right;
        else if(right== null)
            return left;
        else
            return root;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(8);
        root.right.left.left = new Node(6);
        root.right.right.right = new Node(10);

        Node result = LowestCommonAncestor.lCA(root,root.right.left.left,root.right.right.right);
        System.out.println(result.data);

    }
}
