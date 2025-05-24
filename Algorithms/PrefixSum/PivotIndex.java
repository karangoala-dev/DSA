package Algorithms.PrefixSum;

import java.util.Arrays;

public class PivotIndex {
    public int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int currSum = 0;
        for(int i = 0; i < nums.length; i++){
            int minusPivot = sum - nums[i];
            if(minusPivot % 2 == 0){
                //can be divided into two
                if(currSum == minusPivot / 2){
                    return i;
                }
            }

            currSum += nums[i];
        }
        return -1;
    }
    public static void main(String[] args) {

    }
}
