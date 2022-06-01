package com.revision;

import com.node.Node;
import com.view.Pair;

import java.util.*;

public class BottomView {

    private static List<Integer> bottomView(Node root){
        List<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,root));
        Map<Integer,Integer> map = new TreeMap<>();
        while(!q.isEmpty()){
            Pair pair = q.poll();
            int hd = pair.hd ;
            Node temp = pair.root;
            map.put(hd,temp.data);
            if(temp.left != null)
                q.offer(new Pair(hd-1,temp));
            if(temp.right != null)
                q.offer(new Pair(hd+1,temp));
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
            ans.add(entry.getValue());
        return ans;
    }
    public static void main(String[] args) {

    }
}
