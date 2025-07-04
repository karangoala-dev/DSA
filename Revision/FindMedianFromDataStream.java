package Revision;

import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    int total;
    public FindMedianFromDataStream() {
        total = 0;
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((i1, i2)->Integer.compare(i2, i1));
    }

    public void addNum(int num) {
        //we only add value smaller than minHeap top to maxHeap
        if(minHeap.isEmpty() || minHeap.peek() > num){
            maxHeap.add(num);
        }
        else {
            minHeap.add(num);
        }

        //resizing
        if(minHeap.size() > maxHeap.size()){
            maxHeap.add(minHeap.poll());
        }
        else if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        }
        total++;
    }

    public double findMedian() {
        if(total % 2 == 0){
            return (double) (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        else {
            return (double) maxHeap.peek();
        }
    }

    public static void main(String[] args) {

    }
}
