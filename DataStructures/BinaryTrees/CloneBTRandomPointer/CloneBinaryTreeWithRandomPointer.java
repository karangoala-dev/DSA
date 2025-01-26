package DataStructures.BinaryNodeWithRandomPointers.CloneBTRandomPointer;

import DataStructures.BinaryTrees.CloneBTRandomPointer.NodeWithRandomPointer;

import java.util.HashMap;

public class CloneBinaryNodeWithRandomPointerWithRandomPointer {
    HashMap<NodeWithRandomPointer, NodeWithRandomPointer> map = new HashMap<>();
    public NodeWithRandomPointer clone(NodeWithRandomPointer node){
        if(node == null){
            return null;
        }

        NodeWithRandomPointer clone = new NodeWithRandomPointer(node.data);
        clone.left = clone(node.left);
        clone.right = clone(node.right);

        map.put(node, clone);

        return clone;
    }

    public void addRandomPointers(NodeWithRandomPointer node){
        if(node == null){
            return;
        }
        //Assign cloneNode.random to clone of node.random
        NodeWithRandomPointer cloneNode = map.get(node);
        if(node.random != null){
            cloneNode.random = map.get(node.random);
        }
        addRandomPointers(node.left);
        addRandomPointers(node.right);
    }


    public NodeWithRandomPointer cloneNodeWithRandomPointer(NodeWithRandomPointer root) {
        return clone(root);
    }
    public static void main(String[] args) {

    }
}
