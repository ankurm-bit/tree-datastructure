package com.revision;

import com.node.Node;
import com.view.Pair;

import java.util.*;

public class TopView {

    private static List<Integer> topView(Node root){
        List<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;
        Map<Integer,Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,root));
        while(!q.isEmpty()){
            Pair pair = q.poll();
            int hd = pair.hd;
            Node temp = pair.root;
            if(!map.containsKey(hd))
                map.put(hd, temp.data);
            if(temp.left != null)
                q.offer(new Pair(hd-1,temp.left));
            if(temp.right != null)
                q.offer(new Pair(hd+1,temp.right));
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet())
            ans.add(entry.getValue());
        return  ans;
    }
    public static void main(String[] args) {
       Node root = new Node(10);
       root.left = new Node(20);
       root.right = new Node(30);
       root.left.left = new Node(40);
       root.left.right = new Node(60);
       root.right.left = new Node(90);
       root.right.right = new Node(100);

       List<Integer> result = TopView.topView(root);
       result.forEach(r -> System.out.print(r+" "));
    }
}
