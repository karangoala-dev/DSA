package DataStructures.LinkedList;

import java.util.HashMap;

public class CopyListWithRandomPointer {
    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    HashMap<Node, Node> map;
    public Node copyRandomList(Node head) {
        map = new HashMap<>();
        Node ptr = head;
        Node prev = null;
        while (ptr != null){
            Node clone = new Node(ptr.val);
            map.put(ptr, clone);
            if(prev != null){
                prev.next = clone;
            }
            prev = clone;
            ptr = ptr.next;
        }
        ptr = head;
        while (ptr != null){
            Node clone = map.get(ptr);
            if(ptr.random != null){
                clone.random = map.get(ptr.random);
            }
            ptr = ptr.next;
        }
        return map.get(head);
    }
    public static void main(String[] args) {

    }
}
