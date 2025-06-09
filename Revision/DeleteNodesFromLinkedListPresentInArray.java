package Revision;

import Revision.utils.*;

import java.util.HashSet;

public class DeleteNodesFromLinkedListPresentInArray {
    ListNode dummy;
    HashSet<Integer> set;
    public ListNode modifiedList(int[] nums, ListNode head) {
        dummy = new ListNode(Integer.MIN_VALUE);
        set = new HashSet<>();
        dummy.next = head;
        for(int i: nums){
            set.add(i);
        }

        ListNode prev = dummy;
        ListNode curr = dummy.next;
        while(curr != null){
            if(set.contains(curr.val)){
                //delete
                prev.next = curr.next;
            }
            else {
                prev = prev.next;
            }
            curr = curr.next;
        }

        return dummy.next;
    }
    public static void main(String[] args) {

    }
}
