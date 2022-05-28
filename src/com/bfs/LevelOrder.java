package com.bfs;

import com.node.Node;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {
    public void levelOrder(Node root){
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node currentNode = queue.poll();
            System.out.print(currentNode.data +" ");
            if(currentNode.left != null) queue.add(currentNode.left);
            if(currentNode.right != null) queue.add(currentNode.right);
//            System.out.println();
        }
    }
    public static void main(String[] args) {
        LevelOrder level = new LevelOrder();
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);

        level.levelOrder(root);
    }
}
