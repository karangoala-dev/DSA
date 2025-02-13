package Algorithms.SlidingWindow;

import java.util.*;

public class MaximumSumOfSubArrayOfSizeK {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = 0;
        long curr = 0, res = 0;

        for(int r = 0; r < nums.length; r++){
            curr += nums[r];
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            //This step checks and ensures that the window size is k and hence no need to check freq for all enntries in the map
            if(r - l + 1 > k){
                map.put(nums[l], map.get(nums[l]) - 1);
                if(map.get(nums[l]) == 0){
                    map.remove(nums[l]);
                }
                curr -= nums[l];
                l++;
            }

            if(map.size() == k && r - l + 1 == k){
                res = Math.max(res, curr);
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
