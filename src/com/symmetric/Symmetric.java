package com.symmetric;

import com.node.Node;

public class Symmetric {

    private static boolean isSymmetric(Node root){
        if(root == null)
            return true;
        return isSymmetricUtil(root.left,root.right);
    }

    private static boolean isSymmetricUtil(Node root1,Node root2){
        if(root1 == null || root2 == null)
            return root1 == root2 ;
        return (root1.data == root2.data) && isSymmetricUtil(root1.left,root2.right) && isSymmetricUtil(root1.right,root2.left);
    }
}
