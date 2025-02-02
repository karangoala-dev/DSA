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

        System.out.println("Testing maxHeap");
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(-1);
        maxHeap.insert(10);
        maxHeap.insert(-5);
        maxHeap.insert(20);
        maxHeap.insert(2);
        maxHeap.insert(8);
        maxHeap.insert(-20);
        maxHeap.insert(-2);
        maxHeap.insert(88);
        maxHeap.insert(20);
        System.out.println("Printing maxHeap");
        maxHeap.printHeap();
        System.out.println("Printing max element");
        System.out.println(maxHeap.getMax());
        System.out.println("Removing max element");
        System.out.println(maxHeap.extractMax());
        maxHeap.printHeap();

    }
}
