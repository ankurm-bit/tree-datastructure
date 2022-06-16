package com.serializiation;

import com.node.Node;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeSerializationAndDeserialization {

    private static String serialize(Node root){
        if(root == null)
            return "";
        StringBuilder res = new StringBuilder();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node temp = q.poll();
            if(temp == null) {
                res.append("# ");
                continue;
            }
            res.append(temp.data+" ");
            q.offer(temp.left);
            q.offer(temp.right);
        }
        return res.toString();
    }

    private static Node deSerialize(String data){
        if(data == "")
            return null;
        String [] values = data.split(" ");
        Queue<Node> q = new LinkedList<>();
        Node root = new Node(Integer.parseInt(values[0]));
        q.offer(root);
        for(int i =1 ; i< values.length ;i++){
            Node parent = q.poll();
            if(!values[i].equals("#")){
                Node left = new Node(Integer.parseInt(values[i]));
                parent.left = left;
                q.offer(left);
            }
            if(!values[++i].equals("#")){
                Node right = new Node(Integer.parseInt(values[i]));
                parent.right = right ;
                q.offer(right);
            }
        }
        return root;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        String serialized = BinaryTreeSerializationAndDeserialization.serialize(root);
        System.out.println(serialized);
    }
}
