package DataStructures.BinaryTrees;

import java.util.HashMap;

public class ConstructBinaryTreeInorderPreorder {
    HashMap<Integer, Integer> map = new HashMap<>();
    public Node helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }

        Node node = new Node(preorder[preStart]);

        int ind = map.get(preorder[preStart]);
        int numsLeft = ind - inStart;

        node.left = helper(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, ind - 1);
        node.right = helper(preorder, preStart + numsLeft + 1, preEnd, inorder, ind + 1, inEnd);
        return node;
    }
    public Node buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        Node root = helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return root;
    }

    public static void main(String[] args) {
        
    }
}
