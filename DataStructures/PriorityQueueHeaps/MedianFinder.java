package DataStructures.PriorityQueueHeaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
    //Here main concept is
    //1-> we need middlemost elements, if odd array then one middle element and if even then average of 2.
    //2-> we ensure that we have separated the entire data into 2 heaps, one maxHeap(left side) and one minHeap(right)
    //3-> while adding any data to the data structure, we also ensure that only one(any one) of the heaps is atmost 1 element larger than the other
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        //let's assume we keep maxHeap with one extra element if odd number of items present
        //add the num to maxHeap only if minHeap is empty or num not greater than top of minHeap
        if(minHeap.isEmpty() || num <= minHeap.peek()){
            maxHeap.add(num);
        }
        else{
            minHeap.add(num);
        }

        //resizing
        if(minHeap.size() > maxHeap.size()){
            maxHeap.add(minHeap.poll());
        }
        else if(maxHeap.size() > minHeap.size() + 1){
            minHeap.add(maxHeap.poll());
        }
    }

    public double findMedian() {
        int n = minHeap.size() + maxHeap.size();
        if(n % 2 == 0){
            //if even then return average
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        else{
            //if odd then return the maxHeap.peek() since maxHeap is 1 more than min in odd size scenarios
            return (double) maxHeap.peek();
        }
    }
}
