package DataStructures.DoublyLinkedList;

import java.util.HashMap;

public class LRUCache {
    private static class DLLNode{
        int key;
        int val;
        DLLNode prev;
        DLLNode next;

        public DLLNode(int _k, int _v, DLLNode _p, DLLNode _n){
            this.key = _k;
            this.val = _v;
            this.prev = _p;
            this.next = _n;
        }
    }

    DLLNode dummyHead;
    DLLNode dummyTail;

    HashMap<Integer, DLLNode> map;

    private int maxCapacity;

    public LRUCache(int capacity) {
        this.maxCapacity = capacity;
        this.map = new HashMap<>();
        this.dummyHead = new DLLNode(-1, -1, null, null);
        this.dummyTail = new DLLNode(-1, -1, null, null);

        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        DLLNode node = map.get(key);
        //now, delete this node from DLL and insert at start of DLL as it was accessed
        deleteNode(node);
        insertAtStart(node);

        return node.val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            //just update the value and move to front
            DLLNode node = map.get(key);
            node.val = value;
            deleteNode(node);
            insertAtStart(node);
        }
        else {
            DLLNode node = new DLLNode(key, value, null, null);
            insertAtStart(node);
            map.put(key, node);
            if(map.size() > maxCapacity){
                //maxCapacity breached, remove the least recently used node from map and DLL
                DLLNode LRUNode = dummyTail.prev;
                deleteNode(LRUNode);
                map.remove(LRUNode.key);
            }
        }
    }

    public void deleteNode(DLLNode node){
        //this is a utility fn to delete a DLL Node from a DLL
        DLLNode prev = node.prev;
        DLLNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    public void insertAtStart(DLLNode node){
        //this is a utility fn to insert a DLL Node at start of a DLL(just after dummyHead)
        DLLNode next = dummyHead.next;
        dummyHead.next = node;
        node.prev = dummyHead;

        node.next = next;
        next.prev = node;
    }

    public static void main(String[] args) {

    }
}
