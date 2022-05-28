package com.common;

import com.node.Node;

import java.util.Stack;

public class InOrder {
    public static void inOrderUsingRecursion(Node root){
        if(root == null)
            return ;
        inOrderUsingRecursion(root.left);
        System.out.print(root.data+" ");
        inOrderUsingRecursion(root.right);
    }

    public static void inOrder(Node root){
      Stack<Node> st = new Stack<>();
      Node node = root;
      while (true){
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

    public static void postOrder(Node root){
        if(root == null)
            return ;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

    public static void postOrderIterative(Node root){
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        if(root == null)
            return ;
        st1.push(root);
        while(!st1.isEmpty()){
            root = st1.pop();
            st2.push(root);
            if(root.left != null)st1.push(root.left);
            if(root.right != null)st2.push(root.right);
        }
        while(!st2.isEmpty()){
            System.out.print(st2.pop()+" ");
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);
        root.right.left = new Node(6);
        inOrderUsingRecursion(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        System.out.println(" *** Post Order ***** ");
        postOrder(root);
    }
}
