package com.boundary;

import com.node.Node;

import java.util.ArrayList;
import java.util.List;

public class BondaryTraversalClockWise {
    private static boolean isLeaf(Node root){
        return (root.left == null && root.right == null);
    }

    private static void addRightBoundary(Node root , List<Integer> ans){
        Node curr = root.right;
        while(curr != null){
            if(!isLeaf(curr))
                ans.add(curr.data);
            if(curr.right != null)
                curr = curr.right;
            else
                curr = curr.left;
        }
    }

    private static void addLeftBoundary(Node root, List<Integer> ans){
        Node curr = root.left;
        List<Integer> temp = new ArrayList<>();
        while(curr != null){
            if(!isLeaf(curr))
                temp.add(curr.data);
            if(curr.left != null)
                curr = curr.left;
            else
                curr = curr.right;
            int i ;
            for(i = temp.size()-1 ; i >=0 ;i--)
                ans.add(temp.get(i));
        }
    }
    public static void main(String[] args) {

    }
}
