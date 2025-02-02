package DataStructures.PriorityQueueHeaps;

import java.util.ArrayList;

public class MaxHeap {
    ArrayList<Integer> maxHeap;

    public MaxHeap(){
        maxHeap = new ArrayList<>();
    }

    public void insert(int num){
        maxHeap.add(num);
        int index = maxHeap.size() - 1;
        heapifyUp(index);
    }

    public int extractMax(){
        if(maxHeap.size() == 0){
            throw new IllegalArgumentException("Max heap is empty fren");
        }
        int max = maxHeap.get(0);
        int lastElement = maxHeap.get(maxHeap.size() - 1);
        maxHeap.remove(maxHeap.size() - 1);
        if(!maxHeap.isEmpty()){
            maxHeap.set(0, lastElement);
            heapifyDown();
        }
        return max;
    }

    public int getMax(){
        return maxHeap.get(0);
    }

    public void heapifyUp(int index){
        while(index > 0){
            int parent = (index - 1) / 2;
            if(maxHeap.get(parent) < maxHeap.get(index)){
                swap(parent, index);
            }
            else {
                break;
            }
            index = parent;
        }
    }

    public void heapifyDown(){
        int index = 0, N = maxHeap.size();
        while (true){
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            int largest = index;

            if(leftChild < N && maxHeap.get(leftChild) < maxHeap.get(largest)){
                largest = leftChild;
            }
            if(rightChild < N && maxHeap.get(rightChild) < maxHeap.get(largest)){
                largest = rightChild;
            }
            if(index == largest){
                break;
            }

            index = largest;
            swap(largest, index);
        }
    }

    public void swap(int i, int j){
        int dummy = maxHeap.get(i);
        maxHeap.set(i, maxHeap.get(j));
        maxHeap.set(j, dummy);
    }

    public void printHeap(){
        System.out.println(maxHeap);
    }
}
