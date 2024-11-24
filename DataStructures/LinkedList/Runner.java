package DataStructures.LinkedList;

public class Runner {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        LinkedList ll = new LinkedList();
        for(int i: arr){
            ll.insert(i);
        }
        ll.show();
        ll.insert(6);
        ll.insert(7);
        ll.show();
    }
}
