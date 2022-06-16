package com.view;

import com.node.Node;

import java.util.ArrayList;
import java.util.List;

public class RightView {
    public static void main(String[] args) {

    }

    private List<Integer> rightSideView(Node root){
        List<Integer> rightViewList = new ArrayList<>();
        if(root == null)
            return rightViewList;
        rightView(root,rightViewList,0);
        return rightViewList;
    }

    private void rightView(Node root,List<Integer> rightView,int level){
        if(root == null)
            return ;
        if(level == rightView.size())
            rightView.add(root.data);
        rightView(root.right,rightView,level+1);
        rightView(root.left,rightView,level+1);
    }
}
