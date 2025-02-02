package DataStructures.PriorityQueueHeaps;

import DataStructures.LinkedList.Node;

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

    public static void main(String[] args) {

    }
}
