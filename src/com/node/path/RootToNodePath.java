package com.node.path;

import com.node.Node;

import java.util.ArrayList;
import java.util.List;

public class RootToNodePath {

    private static List<Integer> path(Node root){
        List<Integer> ans = new ArrayList<>();
        int x = 7;
        if(root == null)
            return ans;
        getPath(root,ans,x);
        return ans;
    }

    private static boolean getPath(Node root, List<Integer> ans, int x){
        if(root == null)
            return false;
        ans.add(root.data);
        if(root.data == x)
            return true;
        if(getPath(root.left,ans,x) || getPath(root.right,ans,x))
            return true ;
        ans.remove(ans.size()-1);
        return false;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(7);
        List<Integer> ans = RootToNodePath.path(root);
        ans.forEach(val -> System.out.print(val+" "));
    }
}
