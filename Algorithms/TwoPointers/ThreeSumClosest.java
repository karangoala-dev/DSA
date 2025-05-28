package Algorithms.TwoPointers;

import java.util.*;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        //res is result sum, resDiff is minimum diff between target and sum
        int res = -1;
        int resDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0; i < n; i++){
            int l = i + 1, r = n - 1;
            while(l < r){
                int currSum = nums[i] + nums[l] + nums[r];
                int currDiff = Math.abs(currSum - target);
                if(currDiff == 0){
                    return currSum;
                }
                if(currDiff < resDiff){
                    //update res
                    res = currSum;
                    resDiff = currDiff;
                }

                if(currSum > target){
                    //move it closer to target
                    //so we need to decrease currSum
                    r--;
                }
                else{
                    //move it closer to target
                    //so we need to increase currSum
                    l++;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
