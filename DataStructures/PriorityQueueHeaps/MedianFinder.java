package DataStructures.PriorityQueueHeaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        if(minHeap.isEmpty() || minHeap.peek() >= num){
            maxHeap.add(num);
        }
        else{
            minHeap.add(num);
        }

        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        // System.out.println(minHeap);
        // System.out.println(maxHeap);
        // System.out.println("-----");
        int n = minHeap.size() + maxHeap.size();
        double res;
        if(n % 2 == 0){
            res = (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        else{
            res = maxHeap.peek();
        }
        return res;
    }
}
