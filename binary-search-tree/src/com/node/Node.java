package com.node;

public class Node {
    public int data;
    public Node left,right;

    public Node(){}
    public Node(int data){
        this.data=data;
    }

    public String toString(){
        return String.valueOf(data);
    }

}
