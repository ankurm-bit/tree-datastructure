package com.revision;

import com.node.Node;

import java.util.*;

public class LevelOrderTraversal {

    private static void levelOrder(Node root){
        if(root == null)
            return ;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size;i++){
                if(q.peek().left != null) q.offer(q.peek().left);
                if(q.peek().right != null)q.offer(q.peek().right);
                System.out.print(q.poll().data+" ");
            }
            System.out.println();
        }
    }

    public static void normalZigZag(Node root){
        if(root == null)
            return ;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        boolean leftToRight = true ;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0 ; i < size ; i++){
                if(q.peek().left != null) q.offer(q.peek().left);
                if(q.peek().right != null) q.offer(q.peek().right);
                if(leftToRight)
                    System.out.print(q.poll().data +" ");
                else
                    list.add(q.poll().data);
            }
            if(!leftToRight){
                Collections.reverse(list);
                list.stream().forEach(l -> {
                    System.out.print(l+" ");
                });
            }
            leftToRight = !leftToRight;
            System.out.println();
        }
    }



    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
//        LevelOrderTraversal.levelOrder(root);
        LevelOrderTraversal.normalZigZag(root);
    }
}
