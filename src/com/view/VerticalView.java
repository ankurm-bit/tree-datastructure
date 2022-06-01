package com.view;

import com.node.Node;

import java.util.*;

public class VerticalView {

    private static List<List<Integer>> verticalView(Node root){
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;
        Map<Integer,List<Integer>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,root));
        while(!q.isEmpty()){
            Pair pair = q.poll();
            int hd = pair.hd;
            Node temp = pair.root;
            if(map.containsKey(hd))
                map.get(hd).add(temp.data);
            else{
                List<Integer> list = new ArrayList<>();
                list.add(temp.data);
                map.put(hd,list);
            }
            if(temp.left != null)
                q.offer(new Pair(hd-1,temp.left));
            if(temp.right != null)
                q.offer(new Pair(hd+1,temp.right));
        }
        for(Map.Entry<Integer,List<Integer>> entry : map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
    public static void main(String[] args) {
      Node root = new Node(40);
      root.left = new Node(20);
      root.right = new Node(7);
      root.left.left = new Node(10);
      root.left.right = new Node(5);
      root.right.left = new Node(8);
      root.right.right = new Node(9);
      List<List<Integer>> result = VerticalView.verticalView(root);
        System.out.println(result);
    }
}
