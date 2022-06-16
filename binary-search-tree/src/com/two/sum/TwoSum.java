package com.two.sum;

import com.node.Node;

import java.util.ArrayList;
import java.util.List;

public class TwoSum {
   private static List<Integer> list = new ArrayList<>();

   private static void inOrder(Node root , List<Integer> list){
       if(root == null)
           return ;
       inOrder(root.left,list);
       list.add(root.data);
       inOrder(root.right,list);
   }

   public static boolean findTarget(Node root, int k ){
       if(root == null)
           return false;
       inOrder(root,list);
       int i =0 , j = list.size()-1;
       while(i<j){
           if(list.get(i)+list.get(j) == k)
               return true;
           i++;
           j--;
       }
       return false;
   }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.right = new Node(7);
        TwoSum.inOrder(root,list);
        System.out.println(TwoSum.findTarget(root,9));
    }
}
