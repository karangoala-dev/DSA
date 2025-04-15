package DataStructures.PriorityQueueHeaps;

import java.util.*;

public class MedianOf2SortedArrays_O_n_logn {
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

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

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //This part TC: n*log n
        for(int i: nums1){
            addNum(i);
        }
        //This part TC: m*log m
        for(int i: nums2){
            addNum(i);
        }
        return findMedian();
    }
    public static void main(String[] args) {

    }
}
