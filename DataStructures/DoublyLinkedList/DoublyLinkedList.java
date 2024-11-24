package DataStructures.DoublyLinkedList;

public class DoublyLinkedList {
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
            node.prev = ptr;
        }
    }

    public void show(){
        Node ptr = head;
        while(ptr != null){
            System.out.print(ptr.data + "-");
            ptr = ptr.next;
        }
        System.out.println();
    }
}
