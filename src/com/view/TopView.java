package com.view;

import com.node.Node;

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
            Pair pair =  q.remove();
            int hd = pair.hd;
            Node temp = pair.root;
            if(!map.containsKey(hd))
                map.put(hd, temp.data);
            if(temp.left != null)
                q.offer(new Pair(hd-1,temp.left));
            if(temp.right != null)
                q.offer(new Pair(hd +1 ,temp.right));

        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
            ans.add(entry.getValue());
        return ans;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);
        root.left.right.left = new Node(6);
        List<Integer> ans = TopView.topView(root);
        ans.forEach(val -> System.out.print(val +" "));
    }
}
