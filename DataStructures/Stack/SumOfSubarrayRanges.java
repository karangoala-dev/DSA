package DataStructures.Stack;

import java.util.Stack;

public class SumOfSubarrayRanges {

    public long subArrayRanges_BruteForce(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        long minSum = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                min = Math.min(min, nums[j]);
                minSum = minSum + min;
            }
            min = Integer.MAX_VALUE;
        }

        int max = Integer.MIN_VALUE;
        long maxSum = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                max = Math.max(max, nums[j]);
                maxSum = maxSum + max;
            }
            max = Integer.MIN_VALUE;
        }

        return maxSum - minSum;
    }

    //incorrect for some testcases
//    public long subArrayRanges_incorrect(int[] nums) {
//        //we need 4 arrays , 2 for prev and next subarray minimum element index and 2 for prev and next subarray maximum element
//        int n = nums.length;
//
//        //Please note, we are storing indices of prev/next smaller/greater element in the below arrays
//        int[] nse = new int[n];
//        int[] pse = new int[n];
//        int[] nge = new int[n];
//        int[] pge = new int[n];
//
//        //these stacks store [value, index] of prev/next smaller/greater value
//        Stack<int[]> smaller = new Stack<>();
//        Stack<int[]> greater = new Stack<>();
//
//        //find previous smaller and greater elements
//        for(int i = 0; i < n; i++){
//            //smaller
//            while(!smaller.isEmpty() && smaller.peek()[0] > nums[i]){
//                smaller.pop();
//            }
//            if(smaller.isEmpty()){
//                //no previous smaller
//                pse[i] = -1;
//            }
//            else {
//                pse[i] = smaller.peek()[1];
//            }
//            smaller.push(new int[]{nums[i], i});
//
//            //greater
//            while(!greater.isEmpty() && greater.peek()[0] < nums[i]){
//                greater.pop();
//            }
//            if(greater.isEmpty()){
//                //no previous greater
//                pge[i] = -1;
//            }
//            else {
//                pge[i] = greater.peek()[1];
//            }
//            greater.push(new int[]{nums[i], i});
//        }
//
//        //reset smaller and greater stacks
//        smaller.clear();
//        greater.clear();
//
//        //find next smaller and greater elements
//        for(int i = n - 1; i >= 0; i--){
//            //smaller
//            while(!smaller.isEmpty() && smaller.peek()[0] > nums[i]){
//                smaller.pop();
//            }
//            if(smaller.isEmpty()){
//                //no next smaller
//                nse[i] = n;
//            }
//            else {
//                nse[i] = smaller.peek()[1];
//            }
//            smaller.push(new int[]{nums[i], i});
//
//            //greater
//            while(!greater.isEmpty() && greater.peek()[0] < nums[i]){
//                greater.pop();
//            }
//            if(greater.isEmpty()){
//                //no next greater
//                nge[i] = n;
//            }
//            else {
//                nge[i] = greater.peek()[1];
//            }
//            greater.push(new int[]{nums[i], i});
//        }
//
//        //now calculate sum
//        long res = 0;
//        for(int i = 0; i < n; i++){
//            int leftItemsSmaller = pse[i] == -1 ? i + 1 : i - pse[i];
//            int leftItemsGreater = pge[i] == -1 ? i + 1 : i - pge[i];
//            int rightItemsSmaller = nse[i] == n ? n - i : nse[i] - i;
//            int rightItemsGreater = nge[i] == n ? n - i : nge[i] - i;
//
//            //add max to res
//            res = res + (nums[i] * leftItemsGreater * rightItemsGreater);
//            //subtract min from res
//            res = res - (nums[i] * leftItemsSmaller * rightItemsSmaller);
//        }
//
//        return res;
//    }

    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();

        //calculate contribution of each element as minimum value. N is also considered as n is the de-limited here to process remaining elements in the stack
        long minSum = 0;
        for(int right = 0; right <= n; right++){
            while(!stack.isEmpty() && (right == n || nums[stack.peek()] >= nums[right])){
                //here we calculate contribution of the topmost element in the stack to the ans, instead of ith element
                int mid = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                minSum += (long)nums[mid] * (mid - left) * (right - mid);
            }
            if(right < n){
                stack.push(right);
            }
        }

        stack.clear();

        //calculate contribution of each element as maximum value. N is also considered as n is the de-limited here to process remaining elements in the stack
        long maxSum = 0;
        for(int right = 0; right <= n; right++){
            while(!stack.isEmpty() && (right == n || nums[stack.peek()] <= nums[right])){
                int mid = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                maxSum += (long)nums[mid] * (mid - left) * (right - mid);
            }
            if(right < n){
                stack.push(right);
            }
        }

        return maxSum - minSum;
    }
    public static void main(String[] args) {

    }
}
