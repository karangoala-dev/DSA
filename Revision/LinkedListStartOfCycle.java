package Revision;

import Revision.utils.ListNode;

public class LinkedListStartOfCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode s = head;
        ListNode f = head;
        ListNode h = head;
        while(s != null && f != null && f.next != null){
            s = s.next;
            f = f.next.next;
            if(s == f){
                while(s != h){
                    s = s.next;
                    h = h.next;
                }
                return s;
            }
        }
        return null;
    }
    public static void main(String[] args) {

    }
}
