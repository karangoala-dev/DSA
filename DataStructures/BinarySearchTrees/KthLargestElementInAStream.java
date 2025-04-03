package DataStructures.BinarySearchTrees;

import DataStructures.BinaryTrees.Node;

public class KthLargestElementInAStream {
    int maxSize;
    int currentSize;
    Node root;

    public void addNode(int val){
        Node ptr = root;
        if(root == null){
            root = new Node(val);
            return;
        }
        while(true){
            if(ptr.val > val){
                //go left
                if(ptr.left == null){
                    ptr.left = new Node(val);
                    break;
                }
                else{
                    ptr = ptr.left;
                }
            }
            else{
                //go right
                if(ptr.right == null){
                    ptr.right = new Node(val);
                    break;
                }
                else{
                    ptr = ptr.right;
                }
            }
        }
    }

    public void removeSmallest(){
        if(root == null){
            return;
        }
        if(root.left == null){
            root = root.right;
            currentSize--;
            return;
        }
        Node ptr = this.root;
        while(ptr.left.left != null){
            ptr = ptr.left;
        }
        currentSize--;
        //if left child has a right child, attach it in place of left child
        ptr.left = ptr.left.right;
    }

    public int getSmallest(){
        //smallest will be the leftmost node;
        Node ptr = this.root;
        while(ptr.left != null){
            ptr = ptr.left;
        }
        return ptr.val;
    }

    public KthLargestElementInAStream(int k, int[] nums) {
        this.maxSize = k;
        this.currentSize = 0;
        if(nums.length == 0){
            root = null;
            return;
        }
        root = new Node(nums[0]);
        this.currentSize++;
        for(int i = 1; i < nums.length; i++){
            addNode(nums[i]);
            this.currentSize++;
            if(currentSize > maxSize){
                removeSmallest();
            }
        }
    }

    public int add(int val) {
        addNode(val);
        this.currentSize++;
        if(currentSize > maxSize){
            removeSmallest();
        }
        return getSmallest();
    }
    public static void main(String[] args) {

    }
}
