package DataStructures.BinarySearchTrees;

import com.sun.source.tree.Tree;

public class BST_to_DLL {
    private class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int _v) {
            this.val = _v;
            this.left = this.right = null;
        }
    }

    private class DoublyListNode {
        int val;
        DoublyListNode prev, next;

        DoublyListNode(int _v) {
            this.val = _v;
            this.prev = this.next = null;
        }
    }

    private class Result {
        DoublyListNode first;
        DoublyListNode last;

        Result(DoublyListNode f, DoublyListNode l) {
            this.first = f;
            this.last = l;
        }
    }

    public Result helper(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.left == null && node.right == null) {
            DoublyListNode dllNode = new DoublyListNode(node.val);
            return new Result(dllNode, dllNode);
        }

        DoublyListNode curr = new DoublyListNode(node.val);

        Result leftList = helper(node.left);

        //if left list is null, set left list as having only current node as first and last;
        if (leftList == null) {
            leftList = new Result(curr, curr);
        } else {
            //connect left ka last to current node dll node.
            leftList.last.next = curr;
            curr.prev = leftList.last;
            //set current node as last of left list
            leftList.last = curr;
        }

        Result rightList = helper(node.right);
        if (rightList != null) {
            //connect left list ka last to right list ka first
            leftList.last.next = rightList.first;
            rightList.first.prev = leftList.last;
            //set last list ka last as right list ka last
            leftList.last = rightList.last;
        }

        //return the result left list
        return leftList;
    }

    public DoublyListNode bstToDoublyList(TreeNode root) {
        if(root == null){
            return null;
        }
        return helper(root).first;
    }

    //for printing DLL
    private static void printDLL(DoublyListNode head) {
        if (head == null) {
            System.out.println("Empty list.");
            return;
        }
        DoublyListNode tail = null;
        System.out.print("Forward: ");
        while (head != null) {
            System.out.print(head.val + " ");
            if (head.next == null) tail = head;
            head = head.next;
        }

        System.out.print("\nBackward: ");
        while (tail != null) {
            System.out.print(tail.val + " ");
            tail = tail.prev;
        }
        System.out.println();
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

        System.out.println("\n\n--- Test Case 2: Only root node ---");
        TreeNode single = converter.new TreeNode(10);
        DoublyListNode head2 = converter.bstToDoublyList(single);
        printDLL(head2);

        System.out.println("\n\n--- Test Case 3: Left-skewed tree ---");
        //     3
        //    /
        //   2
        //  /
        // 1
        TreeNode leftSkewed = converter.new TreeNode(3);
        leftSkewed.left = converter.new TreeNode(2);
        leftSkewed.left.left = converter.new TreeNode(1);
        DoublyListNode head3 = converter.bstToDoublyList(leftSkewed);
        printDLL(head3);

        System.out.println("\n\n--- Test Case 4: Right-skewed tree ---");
        // 1
        //  \
        //   2
        //    \
        //     3
        TreeNode rightSkewed = converter.new TreeNode(1);
        rightSkewed.right = converter.new TreeNode(2);
        rightSkewed.right.right = converter.new TreeNode(3);
        DoublyListNode head4 = converter.bstToDoublyList(rightSkewed);
        printDLL(head4);

        System.out.println("\n\n--- Test Case 5: Null tree ---");
        TreeNode nullTree = null;
        DoublyListNode head5 = converter.bstToDoublyList(nullTree);
        printDLL(head5);

        System.out.println("\n\n--- Test Case 6: Unbalanced BST ---");
        //       10
        //      /
        //     5
        //      \
        //       7
        TreeNode unbalanced = converter.new TreeNode(10);
        unbalanced.left = converter.new TreeNode(5);
        unbalanced.left.right = converter.new TreeNode(7);
        DoublyListNode head6 = converter.bstToDoublyList(unbalanced);
        printDLL(head6);

    }
}
