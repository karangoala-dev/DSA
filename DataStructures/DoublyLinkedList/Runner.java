package DataStructures.DoublyLinkedList;

public class Runner {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        DoublyLinkedList dll = new DoublyLinkedList();
        for(int i: arr){
            dll.insert(i);
        }
        dll.show();

    }
}