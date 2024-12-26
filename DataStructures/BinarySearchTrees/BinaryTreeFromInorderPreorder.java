package DataStructures.BinarySearchTrees;

import DataStructures.BinaryTrees.Node;

import java.util.HashMap;

public class BinaryTreeFromInorderPreorder {
    HashMap<Integer, Integer> map = new HashMap<>();
    public Node helper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }

        Node currentRoot = new Node(preorder[preStart]);

        int ind = map.get(preorder[preStart]);
        int numsLeft = ind - inStart;

        currentRoot.left = helper(preorder, inorder, preStart + 1, preStart + numsLeft, inStart, ind - 1);
        currentRoot.right = helper(preorder, inorder, preStart + numsLeft + 1, preEnd, ind + 1, inEnd);
        return currentRoot;
    }
    public Node buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        Node root = helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        return root;
    }
}
