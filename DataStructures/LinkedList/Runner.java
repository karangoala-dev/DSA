package DataStructures.LinkedList;

public class Runner {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        LinkedList ll = new LinkedList();
        for(int i: arr){
            ll.insert(i);
        }
        ll.show();
        ll.deleteByValue(4);
        ll.show();
//        ll.reverseLinkedListIterative();
//        ll.show();
        ll.printReverseRecursive(ll.head);
    }
}
