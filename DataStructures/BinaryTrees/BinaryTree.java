package DataStructures.BinaryTrees;

import java.util.*;

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

    //Level order traversal ( BFS )
    public void levelOrderPrint(Node node) {
        if (node == null) {
            System.out.println("Tree is empty.");
            return;
        }

        List<List<Node>> result = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            int len = queue.size();
            List<Node> currentLevel = new ArrayList<>();
            while(len != 0){
                Node current = queue.poll();
                if(current.left != null){
                    queue.offer(current.left);
                }
                if(current.right != null){
                    queue.offer((current.right));
                }
                currentLevel.add(current);
                len--;
            }
            result.add(currentLevel);
        }

        for (int i = 0; i < result.size(); i++){
            System.out.print("Level " + i + " : ");
            for (Node nodeAtLevel : result.get(i)) {
                System.out.print(nodeAtLevel + " ");
            }
            System.out.println();
        }
    }

    public void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.val);
        inOrder(node.right);
    }

    public void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val);
    }

    public int helper(Node node, int len){
        if(node == null){
            return len;
        }
        len += 1;
        return Math.max(helper(node.left, len), helper(node.right, len));
    }
    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        return helper(root, 0);
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
