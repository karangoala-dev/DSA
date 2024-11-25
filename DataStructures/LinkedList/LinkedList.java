package DataStructures.LinkedList;

import java.util.Stack;

public class LinkedList {
    Node head;

    public void insert(int data){
        Node node = new Node(data);
        if(head == null){
            head = node;
        }
        else{
            Node ptr = head;
            while(ptr.next != null){
                ptr = ptr.next;
            }
            ptr.next = node;
        }
    }

    public void show(){
        Node ptr = head;
        while(ptr != null){
            System.out.print(ptr.data + "->");
            ptr = ptr.next;
        }
        System.out.println();
    }

    public void deleteByValue(int data){
        Node ptr = head;
        while(ptr.next != null){
            if(ptr.next.data == data){
                ptr.next = ptr.next.next;
                break;
            }
            ptr = ptr.next;
        }
    }

    public Node middleNode() {
        Node f = head;
        Node s = head;
        while(f != null && f.next != null){
            f = f.next.next;
            s= s.next;
        }
        return s;
    }

    public Node reverseLinkedListUsingStack(Node head) {
        Stack<Integer> st = new Stack<>();
        Node ptr = head;
        while(ptr != null){
            st.push(ptr.data);
            ptr = ptr.next;
        }
        ptr = head;
        while(!st.isEmpty()){
            ptr.data = st.peek();
            st.pop();
            ptr = ptr.next;
        }
        return head;
    }
}
