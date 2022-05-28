package com.dfs;

import com.node.Node;

import java.util.Stack;

public class DFSPractice {

    public static void preOrder(Node root){
        if(root == null)
            return ;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void iterative(Node root){
        if(root == null)
            return ;
        Stack<Node> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            root = st.pop();
            System.out.print(root.data+" ");
            if(root.right != null)st.push(root.right);
            if(root.left != null) st.push(root.left);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.right.right.left = new Node(7);
        System.out.println("USing Recursion");
        preOrder(root);
        System.out.println();
        System.out.println("Using Iterative");
        iterative(root);
    }
}
