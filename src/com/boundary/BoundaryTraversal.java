package com.boundary;

import com.node.Node;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {
    private static boolean isLeaf(Node root){
        return (root.left == null && root.right == null);
    }

    private static void addLeftBoundary(Node root , List<Integer> ans){
        Node curr = root.left ;
        while(curr != null){
            if(!isLeaf(curr))
                ans.add(curr.data);
            if(curr.left != null)
                curr = curr.left;
            else
                curr = curr.right;

        }
    }

    private static void addRightBoundary(Node root,List<Integer> ans){
        Node curr = root.right;
        List<Integer> temp = new ArrayList<>();
        while(curr != null){
            if(!isLeaf(curr))
                temp.add(curr.data);
            if(curr.right != null)
                curr = curr.right;
            else
                curr = curr.left;
        }
        int i ;
        for(i = temp.size()-1 ; i>=0;i--)
            ans.add(temp.get(i));
    }

    private static void addLeaf(Node root,List<Integer> ans){
        if(isLeaf(root)) {
            ans.add(root.data);
            return;
        }
        if(root.left != null) addLeaf(root.left,ans);
        if(root.right != null)addLeaf(root.right,ans);
    }

    private static List<Integer> boundaryTreeAnticlockwise(Node root){
        List<Integer> ans = new ArrayList<>();
        if(!isLeaf(root))
            ans.add(root.data);
        addLeftBoundary(root,ans);
        addLeaf(root,ans);
        addRightBoundary(root,ans);
        return ans;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.left.right = new Node(4);
        root.left.left.right.left = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(7);
        root.right.right = new Node(8);
        root.right.right.left = new Node(9);
        root.right.right.left.left = new Node(10);
        root.right.right.left.right = new Node(11);
        List<Integer> res = BoundaryTraversal.boundaryTreeAnticlockwise(root);
        res.forEach(
                list ->{
                    System.out.print(list+" ");
                });
    }
}
