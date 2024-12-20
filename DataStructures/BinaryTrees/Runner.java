package DataStructures.BinaryTrees;

public class Runner {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Test case 1: Empty tree
        System.out.println("Test Case 1: Empty tree");
        System.out.print("PreOrder: ");
        tree.preOrder(null); // Expected output: (nothing)
        System.out.print("\nInOrder: ");
        tree.inOrder(null); // Expected output: (nothing)
        System.out.print("\nPostOrder: ");
        tree.postOrder(null); // Expected output: (nothing)

        // Test case 2: Single node tree
        System.out.println("\n\nTest Case 2: Single node tree");
        Node root1 = new Node(1);
        System.out.print("PreOrder: ");
        tree.preOrder(root1); // Expected output: 1
        System.out.print("\nInOrder: ");
        tree.inOrder(root1); // Expected output: 1
        System.out.print("\nPostOrder: ");
        tree.postOrder(root1); // Expected output: 1

        // Test case 3: Small binary tree
        System.out.println("\n\nTest Case 3: Small binary tree");
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);

        System.out.print("PreOrder: ");
        tree.preOrder(root2); // Expected output: 1 2 4 5 3
        System.out.print("\nInOrder: ");
        tree.inOrder(root2); // Expected output: 4 2 5 1 3
        System.out.print("\nPostOrder: ");
        tree.postOrder(root2); // Expected output: 4 5 2 3 1

        // Test case 4: Tree with missing children
        System.out.println("\n\nTest Case 4: Tree with missing children");
        Node root3 = new Node(1);
        root3.left = new Node(2);
        root3.right = new Node(3);
        root3.left.right = new Node(4);

        System.out.print("PreOrder: ");
        tree.preOrder(root3); // Expected output: 1 2 4 3
        System.out.print("\nInOrder: ");
        tree.inOrder(root3); // Expected output: 2 4 1 3
        System.out.print("\nPostOrder: ");
        tree.postOrder(root3); // Expected output: 4 2 3 1
    }
}
