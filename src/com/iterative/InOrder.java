package com.iterative;

import com.node.Node;

import java.util.Stack;

public class InOrder {
    public static void inOrder(Node root){
        Stack<Node> st = new Stack<>();
        Node currentNode = root;
        while(true){
            if(currentNode != null){
                st.push(currentNode);
                currentNode = currentNode.left;
            }else{
                if(st.isEmpty())
                    break;
                currentNode = st.pop();
                System.out.print(currentNode.data+" ");
                currentNode = currentNode.right;
            }
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(7);
        inOrder(root);
    }
}
