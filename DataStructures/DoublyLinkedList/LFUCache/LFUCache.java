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
    HashMap<Integer, DLLNode> map;
    HashMap<Integer, DoublyLinkedList> freqMap;

    public LFUCache(int capacity) {
        this.maxCapacity = capacity;
        this.currSize = 0;
        this.minFrequency = 0;
        this.map = new HashMap<>();
        this.freqMap = new HashMap<>();
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
        if(maxCapacity == 0){
            return;
        }
        if(map.containsKey(key)){
            //if key exists, just update value and frequency
            map.get(key).val = value;
            update(map.get(key));
        }
        else {
            //we need to add new node
            currSize++;
            if(currSize > maxCapacity){
                //remove the LRU node from the minFreq list and from map
                DoublyLinkedList minFreqList = freqMap.get(minFrequency);
                map.remove(minFreqList.dummyTail.prev.freq);
                minFreqList.removeNode(minFreqList.dummyTail.prev);
                currSize--;
            }
            //this also means new minFrequency will be 1
            minFrequency = 1;
            DLLNode node = new DLLNode(key, value, null, null);
            map.put(key, node);
            DoublyLinkedList freqList = freqMap.getOrDefault(1, new DoublyLinkedList());
            freqList.insertAtStart(node);
            freqMap.put(1, freqList);
        }
    }

    //This fn must increase frequency for this node, and remove the node from the current freq DLL to next freq DLL, also, if after removal, no of elements is 0 then update
    //minFrequency
    public void update(DLLNode node){
        int freq = node.freq;
        //get freq list and remove node from it
        DoublyLinkedList freqList = freqMap.get(freq);
        freqList.removeNode(node);

        node.freq += 1;
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
