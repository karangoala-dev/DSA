package DataStructures.DoublyLinkedList.LFUCache;

import java.util.HashMap;
import java.util.Queue;

class DLLNode{
    int key;
    int val;
    int freq;
    DLLNode prev;
    DLLNode next;

    public DLLNode(int _k, int _v, DLLNode _p, DLLNode _n){
        this.key = _k;
        this.val = _v;
        this.freq = 1;
        this.prev = _p;
        this.next = _n;
    }
}

class DoublyLinkedList{
    int listSize;
    DLLNode head;
    DLLNode tail;

    DoublyLinkedList(){
        this.listSize = 0;
        this.head = new DLLNode(-1, -1, null, null);
        this.tail = new DLLNode(-1, -1, null, null);

        head.next = tail;
        tail.prev = head;
    }

    public void removeNode(DLLNode node){
        DLLNode prev = node.prev;
        DLLNode next = node.next;
    }
}

public class LFUCache {
    int maxCapacity;
    DLLNode dummyHead;
    DLLNode dummyTail;
    HashMap<Integer, DLLNode> map;
    HashMap<Integer, Queue<DLLNode>> freqMap;

    public LFUCache(int capacity) {
        this.maxCapacity = capacity;
        this.dummyHead = new DLLNode(-1, -1, null, null);
        this.dummyTail = new DLLNode(-1, -1, null, null);
        this.map = new HashMap<>();
        this.freqMap = new HashMap<>();

        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        DLLNode node = map.get(key);
        node.freq += 1;

    }

    public void put(int key, int value) {

    }

    public static void main(String[] args) {

    }
}
