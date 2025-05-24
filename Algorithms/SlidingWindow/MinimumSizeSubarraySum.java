package Algorithms.SlidingWindow;

public class MinimumSizeSubarraySum {
    //using sliding window -> TC O(n)
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int i = 0, j = 0, res = Integer.MAX_VALUE, currSum = 0;
        while(j < n){
            currSum += nums[j];
            while(i <= j && currSum >= target){
                //means currSum is >= target, we need to minimise the window to find smallest possible subarray
                res = Math.min(res, j - i + 1);
                currSum -= nums[i];
                i++;
            }
            j++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    //using prefix sum -> TC O(n log n)
    public int binarySearch(int[] arr, int l, int h, int diff_target){
        //we need to find a arr[i] such that arr[i] <= diff_target
        int ans = -1;
        while(l <= h){
            int mid = l + ((h - l) / 2);
            if(arr[mid] <= diff_target){
                //store potential ans
                ans = mid;
                //go right to find a larger index where condition holds
                l = mid + 1;
            }
            else{
                //go left since arr[mid] > diff_target
                h = mid - 1;
            }
        }
        return ans;
    }
    public int minSubArrayLen_prefixSum(int target, int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        int res =Integer.MAX_VALUE, currSum = 0;
        for(int j = 0; j < n; j++){
            currSum += nums[j];
            prefixSum[j] = currSum;

            if(prefixSum[j] - target >= 0){
                //means we may have some value prefixSum[i] such that
                //prefixSum[j] - prefixSum[i] >= target
                //i.e. prefixSum[i] <= prefixSum[j] - target
                int ind = binarySearch(prefixSum, 0, j - 1, prefixSum[j] - target);

                if (ind != -1) {
                    //if we have found some index such that prefixSum[i] <= diff_target
                    //so consider it for res
                    res = Math.min(res, j - ind);
                } else if (prefixSum[j] >= target) {
                    //means 0->j can be an ans
                    res = Math.min(res, j + 1);
                }

            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
    public static void main(String[] args) {

    }
}
