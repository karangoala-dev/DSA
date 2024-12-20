package DataStructures.BinaryTrees;

class TreeInfo{
    boolean isBalanced;
    int height;

    TreeInfo(boolean isBalanced, int height) {
        this.isBalanced = isBalanced;
        this.height = height;
    }
}

public class isHeightBalanced {
    public TreeInfo helper(Node node){
        if(node == null){
            return new TreeInfo(true, 0);
        }
        TreeInfo left = helper(node.left);
        TreeInfo right = helper(node.right);
        if(left.isBalanced && right.isBalanced && Math.abs(left.height - right.height) <= 1)
            return new TreeInfo(true, 1 + Math.max(left.height, right.height));
        return new TreeInfo(false, 1 + Math.max(left.height, right.height));
    }
    public boolean isBalanced(Node root) {
        TreeInfo res = helper(root);
        return res.isBalanced;
    }

    public static void main(String[] args) {
        // Test case 1: Balanced tree
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);

        isHeightBalanced checker1 = new isHeightBalanced();
        System.out.println("Tree 1 is balanced: " + checker1.isBalanced(root1)); // Expected: true

        // Test case 2: Unbalanced tree
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.left.left = new Node(3);
        root2.left.left.left = new Node(4);

        isHeightBalanced checker2 = new isHeightBalanced();
        System.out.println("Tree 2 is balanced: " + checker2.isBalanced(root2)); // Expected: false

        // Test case 3: Empty tree
        Node root3 = null;

        isHeightBalanced checker3 = new isHeightBalanced();
        System.out.println("Tree 3 is balanced: " + checker3.isBalanced(root3)); // Expected: true

        // Test case 4: Single node tree
        Node root4 = new Node(10);

        isHeightBalanced checker4 = new isHeightBalanced();
        System.out.println("Tree 4 is balanced: " + checker4.isBalanced(root4)); // Expected: true

        // Test case 5: Slightly unbalanced tree
        Node root5 = new Node(1);
        root5.left = new Node(2);
        root5.right = new Node(3);
        root5.left.left = new Node(4);
        root5.left.left.left = new Node(5);

        isHeightBalanced checker5 = new isHeightBalanced();
        System.out.println("Tree 5 is balanced: " + checker5.isBalanced(root5)); // Expected: false
    }
}
