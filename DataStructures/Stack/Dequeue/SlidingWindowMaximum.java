package DataStructures.Stack.Dequeue;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int resPtr = 0;
        int[] res = new int[n - k + 1];
        //This deque stores the index of the elements and not value
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            if(!dq.isEmpty() && dq.peekFirst() < i+1-k){
                //remove larger element from front if outside window
                dq.pollFirst();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                //remove elements smaller than current element as they will never be max
                dq.pollLast();
            }

            //add current element index to deque regardless
            dq.addLast(i);

            if(i >= k - 1){
                //if window width is reached, add max(deque front) to result
                res[resPtr] = nums[dq.peekFirst()];
                resPtr++;
            }
        }

        return res;
    }
    public static void main(String[] args) {

    }
}
