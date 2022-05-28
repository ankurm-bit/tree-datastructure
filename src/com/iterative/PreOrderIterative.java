package com.iterative;

import com.node.Node;

import java.util.Stack;

public class PreOrderIterative {

    public static void iteratingPreOrder(Node root){
        Stack<Node> st = new Stack<Node>();
        if(root == null)
            return ;
        st.push(root);
        while(!st.isEmpty()){
            root = st.pop();
            System.out.print(root.data+" ");
            if(root.right != null) st.push(root.right);
            if(root.left != null) st.push(root.left);
        }
    }

    public static void iterativeInOrder(Node root){
        if(root == null)
            return ;
        Stack<Node> st = new Stack<Node>();
        Node node = root ;
        while(true){
            if(node != null){

                st.push(node);
                node = node.left;
            }else{
                if(st.isEmpty())
                    break;
                node = st.pop();
                System.out.print(node.data+" ");
                node = node.right;
            }
        }
    }

    public static void preOrderTraversal(Node root){
        if(root == null)
            return ;
        Stack<Node> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            root = st.pop();
            System.out.print(root.data+" ");
            if(root.right != null)st.push(root.right);
            if(root.left != null)st.push(root.left);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(7);

        iteratingPreOrder(root);
//        iterativeInOrder(root);
//        preOrderTraversal(root);
    }
}
