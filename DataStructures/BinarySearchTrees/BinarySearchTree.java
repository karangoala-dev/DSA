package DataStructures.BinarySearchTrees;

import DataStructures.BinaryTrees.Node;

import java.util.Scanner;

public class BinarySearchTree {
    public Node root;
    public static Scanner scanner = new Scanner(System.in);

    public Node insertANode(Node root, int val){
        if(root == null){
            return new Node(val);
        }
        Node currentNode = root;
        while(true){
            if(val < currentNode.val){
                if(currentNode.left == null){
                    currentNode.left = new Node(val);
                    break;
                }
                else {
                    currentNode = currentNode.left;
                }
            }
            else{
                if(currentNode.right == null){
                    currentNode.right = new Node(val);
                    break;
                }
                else {
                    currentNode = currentNode.right;
                }
            }
        }
        return root;
    }


}
