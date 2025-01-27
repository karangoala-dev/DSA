package DataStructures.BinaryTrees;

import java.util.HashMap;

public class ConstructBinaryTreePostorderInorder {
    HashMap<Integer, Integer> map = new HashMap<>();
    public Node helper(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd){
        if(inStart > inEnd || postStart > postEnd){
            return null;
        }

        Node node = new Node(postorder[postEnd]);

        int ind = map.get(postorder[postEnd]);
        int numsLeft = ind - inStart;

        node.left = helper(inorder, postorder, inStart, ind - 1, postStart, postStart + numsLeft - 1);
        node.right = helper(inorder, postorder, ind + 1, inEnd, numsLeft + postStart, postEnd - 1);

        return node;
    }
    public Node buildTree(int[] inorder, int[] postorder) {
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public static void main(String[] args) {
        
    }
}
