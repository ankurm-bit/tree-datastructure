package com.count;

import com.node.Node;

public class NoOfNodesInCompleteBT {

    private int totalNumberOfNodes(Node root){
        if(root == null)
            return 0 ;
        int left = leftHeight(root);
        int right = rightHeight(root);

        if(left == right)
            return ((2 <<(left)) -1);
        else
            return totalNumberOfNodes(root.left) + totalNumberOfNodes(root.right)+1;
    }

    private int leftHeight(Node root){
        int count = 0 ;
        while(root.left != null){
            count++;
            root = root.left ;
        }
        return count;
    }

    private int rightHeight(Node root){
        int count =0 ;
        while(root.right != null){
            count++ ;
            root = root.right;
        }
        return count;
    }
}
