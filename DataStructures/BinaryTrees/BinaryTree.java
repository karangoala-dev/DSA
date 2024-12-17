package DataStructures.BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {
    public Node root;
    private static Scanner scanner = new Scanner(System.in);

    public static Node treeBuilder(Node current){
        System.out.println("Enter the left child of " + current.val);
        int leftData = scanner.nextInt();
        if(leftData == -1){
            current.left = null;
        }
        else{
            current.left = treeBuilder(new Node(leftData));
        }

        System.out.println("Enter the right child of " + current.val);
        int rightData = scanner.nextInt();
        if(rightData == -1){
            current.right = null;
        }
        else {
            current.right = treeBuilder(new Node(rightData));
        }
        return current;
    }

    public Node BinaryTree(){
        System.out.println("Enter value for root node (-1 for null) -> ");
        int data = scanner.nextInt();
        if(data == -1){
            return null;
        }
        this.root = new Node(data);
        return treeBuilder(root);
    }
}
