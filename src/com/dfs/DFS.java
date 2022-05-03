package com.dfs;

import com.node.Node;

import java.util.ArrayList;
import java.util.List;

public class DFS {


    public void preOrderTranversal(Node root){
        if(root == null)
            return ;
        System.out.print(root.data+" ");
        preOrderTranversal(root.left);
        preOrderTranversal(root.right);
    }

    public void inOrderTraversal(Node root){
        if(root == null)
            return ;
        inOrderTraversal(root.left);
        System.out.print(root.data+" ");
        inOrderTraversal(root.right);
    }

    public void postOrderTraversal(Node root){
        if(root == null)
            return ;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data+" ");
    }

    public static void main(String[] args) {
        DFS preOrderTranversal = new DFS();
        Node root = new Node(10);
        root.left=new Node(20);
        root.right= new Node(30);
        root.left.left = new Node(40);
        root.left.right= new Node(50);

        System.out.println("=== Pre Order Traversal ===");
        preOrderTranversal.preOrderTranversal(root);
        System.out.println();

        System.out.println("=== In Order Traversal ==== ");
        preOrderTranversal.inOrderTraversal(root);
        System.out.println();

        System.out.println("==== Post Order Traversal === ");
        preOrderTranversal.postOrderTraversal(root);
        System.out.println();
    }
}
