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

    public Node reverseLinkedListUsingStack() {
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

    public void reverseLinkedListIterative() {
        Node prev = null;
        Node ptr = head;
        while(ptr != null){
            Node nextPtr = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = nextPtr;
        }
        head = prev;
    }

    public void printReverseRecursive(Node head){
        if(head == null){
            return;
        }
        printReverseRecursive(head.next);
        System.out.print(head.data + "<-");
    }

    public Node findStartPointOfLoop(Node head) {
        if(head == null || head.next == null){
            return null;
        }
        Node s = head;
        Node f = head;
        Node h = head;
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

    public int countNodesinLoop(Node head) {
        int res = 0;

        Node f = head;
        Node s = head;
        Node h = head;

        while(s != null && f != null && f.next != null){
            s = s.next;
            f = f.next.next;
            if(s == f){
                while(s != h){
                    s = s.next;
                    h = h.next;
                }
                res++;
                s = s.next;
                while(s != h){
                    res++;
                    s = s.next;
                }
                break;
            }
        }

        return res;
    }
    public boolean isPalindrome(Node head) {
        Node s = head;
        Node f = head;
        while(f != null && f.next != null){
            s = s.next;
            f = f.next.next;
        }

        //Now, s is at midpoint
        Node prev = null;
        while(s != null){
            Node nextPtr = s.next;
            s.next = prev;
            prev = s;
            s = nextPtr;
        }

        //Now, right half of LL is reversed. Prev pointer has the last node.
        Node left = head;
        Node right = prev;

        while(right != null){
            // System.out.println(left.next.val + "," + right.next.val);
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
}
