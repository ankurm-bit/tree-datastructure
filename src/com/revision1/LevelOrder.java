package com.revision1;

import com.node.Node;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {

    private static void levelOrder(Node root){
        if(root == null)
            return ;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++) {
                if(q.peek().left != null) q.offer(q.peek().left);
                if(q.peek().right != null) q.offer(q.peek().right);
                System.out.print(q.poll().data +" ");
            }
        }
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right.right = new Node(18);
        LevelOrder.levelOrder(root);
    }
}
