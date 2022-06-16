package com.increase.order.search;

import com.node.Node;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private static void inOrder(Node root , List<Integer> subList){
        if(root == null)
            return ;
        inOrder(root.left,subList);
        subList.add(root.data);
        inOrder(root.right,subList);
    }

    private static Node increasingBST(Node root){
        List<Integer> subList = new ArrayList<>();
        inOrder(root,subList);
        Node dummyNode = new Node();
        Node curr = dummyNode;
        for(int val : subList){
            curr.right = new Node(val);
            curr = curr.right;
        }
        return dummyNode.right;
    }
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.right = new Node(8);
        root.left.left.left = new Node(1);
        root.right.right.left = new Node(7);
        root.right.right.right = new Node(9);

        Solution.increasingBST(root);

    }
}
