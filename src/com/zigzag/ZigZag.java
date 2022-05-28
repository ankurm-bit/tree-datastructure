package com.zigzag;

import com.node.Node;

import java.util.*;

public class ZigZag {

    private static List<List<Integer>> zigzagtraversal(Node root){
       List<List<Integer>> result = new ArrayList<>();
       if(root == null)
           return result;
       Queue<Node> nodesQueue = new LinkedList<>();
       nodesQueue.offer(root);
       boolean leftToRight = true ;
       while(!nodesQueue.isEmpty()){
           int size = nodesQueue.size();
           List<Integer> row = new ArrayList<>(size);
           for(int i=0 ; i< size;i++){
               if(nodesQueue.peek().left != null) nodesQueue.offer(nodesQueue.peek().left);
               if(nodesQueue.peek().right != null) nodesQueue.offer(nodesQueue.peek().right);
               if(leftToRight)
                   row.add(nodesQueue.poll().data);
               else
                   row.add(0,nodesQueue.poll().data);
           }
           leftToRight = !leftToRight;
           result.add(row);
       }
       return result;
    }

    private static void display(List<List<Integer>> result){

        result.stream().forEach(r ->{
            System.out.println(r);
        });
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        List<List<Integer>> result = zigzagtraversal(root);
        display(result);
    }
}
