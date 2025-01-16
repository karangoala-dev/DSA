package DataStructures.LinkedList;

public class MergeTwoLL {
    public Node mergeTwoLists(Node list1, Node list2) {
        Node head = new Node(-1);
        Node dummy = head;
        Node ptrA = list1;
        Node ptrB = list2;
        while(ptrA != null && ptrB != null){
            if(ptrA.data <= ptrB.data){
                dummy.next = ptrA;
                ptrA = (Node) ptrA.next;
            }
            else{
                dummy.next = ptrB;
                ptrB = (Node) ptrB.next;
            }
            dummy = (Node) dummy.next;
        }
        if(ptrA != null){
            dummy.next = ptrA;
        }
        else if(ptrB != null){
            dummy.next = ptrB;
        }
        return head.next;
    }
}
