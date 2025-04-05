package DataStructures.BinaryTrees;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinaryTree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "#";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                //if current is not null, add its child to the queue and value to string
                if(curr != null){
                    q.add(curr.left);
                    q.add(curr.right);
                    sb.append(curr.val);
                    sb.append(",");
                }
                //if current is null, just add a delimiter "#" to the string
                else {
                    sb.append("#,");
                }
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.charAt(0) == '#'){
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        int i = 0;
        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[i]));
        q.add(root);
        for(i = 1; i < nodes.length; i++){
            TreeNode curr = q.poll();
            if(!nodes[i].equals("#")){
                curr.left = new TreeNode(Integer.parseInt(nodes[i]));
                q.add(curr.left);
            }
            i++;
            if(!nodes[i].equals("#")){
                curr.right = new TreeNode(Integer.parseInt(nodes[i]));
                q.add(curr.right);
            }
        }
        return root;
    }
    public static void main(String[] args) {
        SerializeDeserializeBinaryTree codec = new SerializeDeserializeBinaryTree();

        // Given tree structure: [4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2]
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(-7);
        root.right = new TreeNode(-3);
        root.right.left = new TreeNode(-9);
        root.right.right = new TreeNode(-3);
        root.right.left.left = new TreeNode(9);
        root.right.left.right = new TreeNode(-7);
        root.right.right.left = new TreeNode(-4);
        root.right.right.right = new TreeNode(6);
        root.right.right.right.left = new TreeNode(-6);
        root.right.right.right.right = new TreeNode(-6);
        root.right.right.right.left.left = new TreeNode(0);
        root.right.right.right.left.right = new TreeNode(6);
        root.right.right.right.right.left = new TreeNode(5);
        root.right.right.right.right.left.left = new TreeNode(9);
        root.right.right.right.right.left.right = new TreeNode(-1);
        root.right.right.right.right.left.right.left = new TreeNode(-4);
        root.right.right.right.right.left.right.left.right = new TreeNode(-2);

        // Serialize the tree
        String serialized = codec.serialize(root);
        System.out.println("Serialized Tree: " + serialized);

        // Deserialize the tree
        TreeNode deserializedRoot = codec.deserialize(serialized);

        // Serialize again to verify correctness
        String verifySerialization = codec.serialize(deserializedRoot);
        System.out.println("Re-Serialized Tree (after deserialization): " + verifySerialization);
    }
}
