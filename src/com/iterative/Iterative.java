package com.iterative;

import com.node.Node;

import java.util.Stack;

public class Iterative {

    public static void preOrder(Node root){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            System.out.print(root.data+" ");
            if(root.right != null)stack.push(root.right);
            if(root.left != null)stack.push(root.left);
        }
        System.out.println("*** END *** ");
    }

    public static void inOrder(Node root){
     Stack<Node> st = new Stack<>();
     Node node = root;
     while(true){
         if(node != null ){
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
        System.out.println();
    }

    /*
    * Using Two Stack iterate PostOrder
    *
    */
    public static void postOrder(Node root){
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        if(root == null)
            return ;
        st1.push(root);
        while(!st1.isEmpty()){
            root = st1.pop();
            st2.push(root);
            if(root.left != null) st1.push(root.left);
            if(root.right != null)st1.push(root.right);
        }
        System.out.println(st2);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(7);

//        preOrder(root);
        postOrder(root);
    }
}
