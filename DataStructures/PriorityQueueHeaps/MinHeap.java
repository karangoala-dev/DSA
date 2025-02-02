package DataStructures.PriorityQueueHeaps;

import java.util.ArrayList;

public class MinHeap {
    private ArrayList<Integer> minHeap;
    public MinHeap(){
        this.minHeap = new ArrayList<>();
    }

    public int getMin(){
        return minHeap.get(0);
    }

    public void insert(int num){
        minHeap.add(num);
        int index = minHeap.size() - 1;
        heapifyUp(index);
    }

    public int extractMin(){
        if(minHeap.isEmpty()){
            throw new IllegalArgumentException("Min Heap is Empty fren");
        }
        int min = minHeap.get(0);
        int lastElement = minHeap.get(minHeap.size() - 1);
        minHeap.remove(minHeap.size() - 1);

        if (!minHeap.isEmpty()) {
            minHeap.set(0, lastElement);
            heapifyDown();
        }

        return min;
    }

    public void heapifyUp(int index){
        while(index > 0){
            int parent = (index - 1) / 2;
            if(minHeap.get(parent) > minHeap.get(index)){
                swap(parent, index);
                index = parent;
            }
            else {
                break;
            }
        }
    }

    public void heapifyDown(){
        int index = 0, N = minHeap.size();
        while(true){
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            int smallest = index;

            if(leftChild < N && minHeap.get(leftChild) < minHeap.get(smallest)){
                smallest = leftChild;
            }
            if(rightChild < N && minHeap.get(rightChild) < minHeap.get(smallest)){
                smallest = rightChild;
            }
            if(smallest == index){
                break;
            }
            swap(index, smallest);
            index = smallest;
        }
    }

    public void swap(int i, int j){
        int dummy = minHeap.get(i);
        minHeap.set(i, minHeap.get(j));
        minHeap.set(j, dummy);
    }

    public void printHeap(){
        System.out.println(this.minHeap);
    }
}
