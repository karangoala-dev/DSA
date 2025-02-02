package DataStructures.PriorityQueueHeaps;

public class Main {
    public static void main(String[] args) {
        System.out.println("Testing minHeap");
        MinHeap minHeap = new MinHeap();
        minHeap.insert(-1);
        minHeap.insert(10);
        minHeap.insert(-5);
        minHeap.insert(20);
        minHeap.insert(2);
        minHeap.insert(8);
        minHeap.insert(-20);
        minHeap.insert(-2);
        minHeap.insert(88);
        minHeap.insert(20);
        System.out.println("Printing minHeap");
        minHeap.printHeap();
        System.out.println("Printing min element");
        System.out.println(minHeap.getMin());
        System.out.println("Removing min element");
        System.out.println(minHeap.extractMin());
        minHeap.printHeap();

    }
}
