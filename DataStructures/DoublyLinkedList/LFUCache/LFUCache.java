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
    DLLNode dummyHead;
    DLLNode dummyTail;

    DoublyLinkedList(){
        this.listSize = 0;
        this.dummyHead = new DLLNode(-1, -1, null, null);
        this.dummyTail = new DLLNode(-1, -1, null, null);

        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public void removeNode(DLLNode node){
        DLLNode prev = node.prev;
        DLLNode next = node.next;
        this.listSize--;
        prev.next = next;
        next.prev = prev;
    }

    public void insertAtStart(DLLNode node){
        DLLNode next = dummyHead.next;
        dummyHead.next = node;
        node.prev = dummyHead;
        this.listSize++;
        node.next = next;
        next.prev = node;
    }
}

public class LFUCache {
    int maxCapacity;
    int minFrequency;
    int currSize;
    DLLNode dummyHead;
    DLLNode dummyTail;
    HashMap<Integer, DLLNode> map;
    HashMap<Integer, DoublyLinkedList> freqMap;

    public LFUCache(int capacity) {
        this.maxCapacity = capacity;
        this.currSize = 0;
        this.minFrequency = 0;
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
        update(node);
        return node.val;
    }

    public void put(int key, int value) {

    }

    //This fn must increase frequency for this node, and remove the node from the current freq DLL to next freq DLL, also, if after removal, no of elements is 0 then update
    //minFrequency
    public void update(DLLNode node){
        int freq = node.freq;
        node.freq += 1;
        //get freq list and remove node from it
        DoublyLinkedList freqList = freqMap.get(freq);
        freqList.removeNode(node);
        if(freq == minFrequency && freqList.listSize == 0){
            //increment minFreq
            minFrequency++;
        }

        //now add this node to new frequency list
        DoublyLinkedList newFreqList = freqMap.getOrDefault(node.freq, new DoublyLinkedList());
        newFreqList.insertAtStart(node);

        //finally update the frequency map
        freqMap.put(node.freq, newFreqList);
    }

    public static void main(String[] args) {

    }
}
