package com.range.sum;

import com.node.Node;

public class BSTRangeSum {
    private static int sum = 0 ;
    private static int rangeSumBST(Node root, int low , int high){
        if(root==null) return 0;
        if(root.data>=low && root.data<=high){
            sum += root.data;
            rangeSumBST(root.left, low, high);
            rangeSumBST(root.right, low, high);
        }
        else if(root.data<low)
            rangeSumBST(root.right, low, high);
        else rangeSumBST(root.left, low, high);
        return sum;
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right.right = new Node(18);
        System.out.println(BSTRangeSum.rangeSumBST(root,7,15));
    }
}
