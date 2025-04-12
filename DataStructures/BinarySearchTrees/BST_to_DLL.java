package DataStructures.BinarySearchTrees;

import com.sun.source.tree.Tree;

public class BST_to_DLL {
    private class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int _v){
            this.val = _v;
            this.left = this.right = null;
        }
    }

    private class DoublyListNode{
        int val;
        DoublyListNode prev, next;
        DoublyListNode(int _v){
            this.val = _v;
            this.prev = this.next = null;
        }
    }

    private class Result{
        DoublyListNode first;
        DoublyListNode last;
        Result(DoublyListNode f, DoublyListNode l){
            this.first = f;
            this.last = l;
        }
    }

    public Result helper(TreeNode node){
        if(node == null){
            return null;
        }
        if(node.left == null && node.right == null){
            DoublyListNode dllNode = new DoublyListNode(node.val);
            return new Result(dllNode, dllNode);
        }

        Result leftList = helper(node.left);

        DoublyListNode curr = new DoublyListNode(node.val);
        //connect left ka last to current node dll node.
        leftList.last.next = curr;
        curr.prev = leftList.last;
        //set current node as last of left list
        leftList.last = curr;

        Result rightList = helper(node.right);
        //connect left list ka last to right list ka first
        leftList.last.next = rightList.first;
        rightList.first.prev = leftList.last;
        //set last list ka last as right list ka last
        leftList.last = rightList.last;

        //return the result left list
        return leftList;
    }

    public DoublyListNode bstToDoublyList(TreeNode root) {
        return helper(root).first;
    }

    public static void main(String[] args) {
        BST_to_DLL converter = new BST_to_DLL();

        // Creating a sample BST manually:
        //        4
        //       / \
        //      2   6
        //     / \ / \
        //    1  3 5  7

        TreeNode root = converter.new TreeNode(4);
        root.left = converter.new TreeNode(2);
        root.right = converter.new TreeNode(6);
        root.left.left = converter.new TreeNode(1);
        root.left.right = converter.new TreeNode(3);
        root.right.left = converter.new TreeNode(5);
        root.right.right = converter.new TreeNode(7);

        // Convert BST to Doubly Linked List
        DoublyListNode head = converter.bstToDoublyList(root);

        // Print the Doubly Linked List forward
        System.out.print("Doubly Linked List (Forward): ");
        DoublyListNode tail = null;
        while (head != null) {
            System.out.print(head.val + " ");
            if (head.next == null) tail = head; // Save the last node
            head = head.next;
        }

        // Print the Doubly Linked List backward
        System.out.print("\nDoubly Linked List (Backward): ");
        while (tail != null) {
            System.out.print(tail.val + " ");
            tail = tail.prev;
        }
    }
}
