package DataStructures.PriorityQueueHeaps;

import DataStructures.LinkedList.Node;

import java.util.PriorityQueue;

public class MergeKSortedLists {
    public Node mergeTwoLists(Node a, Node b){
        Node dummy = new Node(-1);
        Node head = dummy;
        Node ptrA = a;
        Node ptrB = b;
        while(ptrA != null && ptrB != null){
            if(ptrA.data < ptrB.data){
                dummy.next = ptrA;
                ptrA = ptrA.next;
            }
            else{
                dummy.next = ptrB;
                ptrB = ptrB.next;
            }
            dummy = dummy.next;
        }
        if(ptrA != null){
            dummy.next = ptrA;
        }
        else if(ptrB != null){
            dummy.next = ptrB;
        }

        return head.next;
    }
    //APPROACH #1
    public Node mergeKLists_TC_O_KN(Node[] lists) {
        int n = lists.length;
        if(n == 1){
            return lists[0];
        }
        int i = 0, limit = n / 2, j = 1;
        Node res = null;
        while(i < n){
            res = mergeTwoLists(res, lists[i]);
            i++;
        }
        return res;
    }

    public Node mergeHelper(Node[] lists, int l, int r){
        if(l == r){
            return lists[l];
        }

        int mid = ((r - l) / 2) + l;
        Node left = mergeHelper(lists, l, mid);
        Node right = mergeHelper(lists, mid + 1, r);

        return mergeTwoLists(left, right);
    }

    //APPROACH #2
    //Explanation of the O(N Log K) solution. For a list of LL as shown below
    //lists = [L1, L2, L3, L4]
    //    mergeHelper(lists, 0, 3)
    //    |
    //    |-- mergeHelper(lists, 0, 1)   → Merges L1 and L2
    //    |   |
    //    |   |-- mergeHelper(lists, 0, 0) → Returns L1 (base case)
    //    |   |-- mergeHelper(lists, 1, 1) → Returns L2 (base case)
    //    |
    //    |-- mergeHelper(lists, 2, 3)   → Merges L3 and L4
    //    |   |
    //    |   |-- mergeHelper(lists, 2, 2) → Returns L3 (base case)
    //    |   |-- mergeHelper(lists, 3, 3) → Returns L4 (base case)
    //    |
    //    |-- mergeTwoLists(result of L1 & L2, result of L3 & L4) → Final merged list
    //
    public Node mergeKLists_TC_O_NLogK(Node[] lists) {
        if(lists.length == 0){
            return null;
        }
        if(lists.length == 1){
            return lists[0];
        }

        return mergeHelper(lists, 0, lists.length - 1);
    }

    //APPROACH #3
    public Node mergeKLists_TC_O_NLogK_PriorityQueue(Node[] lists) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.data > o2.data ? 1 : -1);
        Node dummy = new Node(Integer.MIN_VALUE);
        Node ptr = dummy;

        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null){
                pq.add(lists[i]);
            }
        }

        while(pq.size() != 0){
            Node current = pq.poll();
            if(current.next != null){
                pq.add(current.next);
            }
            ptr.next = current;
            ptr = ptr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
