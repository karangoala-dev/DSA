package DataStructures.PriorityQueueHeaps;

import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    //Priority queue approach
    public int[] maxSlidingWindow_pq(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int resPtr = 0;
        //pq stores, [value, index]
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        for(int i = 0; i < n; i++){
            //not reached window width
            pq.add(new int[]{nums[i], i});
            if(i >= k - 1){
                int[] top = pq.peek();
                //if top is within range of the current window
                if(top[1] >= i+1-k){
                    //consider this top value
                    res[resPtr] = top[0];
                }
                else{
                    while(!pq.isEmpty() && pq.peek()[1] < i+1-k){
                        pq.poll();
                    }
                    res[resPtr] = pq.peek()[0];
                }
                resPtr++;
            }
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
