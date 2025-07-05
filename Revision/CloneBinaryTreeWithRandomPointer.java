package Revision;

import java.util.HashMap;

class Tree{
    int data;
    Tree left,right,random;
    Tree(int d){
        data=d;
        left=null;
        right=null;
        random=null;
    }
}

public class CloneBinaryTreeWithRandomPointer {
    HashMap<Tree, Tree> map = new HashMap<>();
    public Tree preorder(Tree node){
        if(node == null){
            return null;
        }

        Tree clone = new Tree(node.data);
        map.put(node, clone);
        clone.left = preorder(node.left);
        clone.right = preorder(node.right);
        return clone;
    }
    public void addRandomPointer(Tree node){
        if(node == null){
            return;
        }
        if(node.random != null){
            map.get(node).random = map.get(node.random);
        }

        addRandomPointer(node.left);
        addRandomPointer(node.right);
    }
    public Tree cloneTree(Tree root) {
        preorder(root);
        addRandomPointer(root);
        return map.get(root);
    }
    public static void main(String[] args) {

    }
}
