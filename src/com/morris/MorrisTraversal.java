package com.morris;

import com.node.Node;

import java.util.ArrayList;
import java.util.List;

public class MorrisTraversal {
    public static void main(String[] args) {

    }

    private List<Integer> inOrder(Node root){
        List<Integer> inOrder = new ArrayList<>();
        if(root == null)
            return inOrder;
        Node curr = root;
        while(curr != null){
            if(curr.left == null){
                inOrder.add(curr.data);
                curr = curr.right;
            }else{
                Node prev = curr.left;
                while(prev.right != null && prev.right != curr)
                    prev = prev.right;
                if(prev.right == null){
                    prev.right = curr;
                    inOrder.add(curr.data);
                    curr = curr.left;
                }else{
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
        return inOrder;
    }
}
