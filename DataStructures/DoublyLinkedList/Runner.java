package DataStructures.DoublyLinkedList;

public class Runner {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        DataStructures.DoublyLinkedList.LFUCache.DoublyLinkedList dll = new DataStructures.DoublyLinkedList.LFUCache.DoublyLinkedList();
        for(int i: arr){
            dll.insert(i);
        }
        dll.show();

    }
}
