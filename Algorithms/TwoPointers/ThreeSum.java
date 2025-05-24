package Algorithms.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < n; i++){
            //skip dupes
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            int target = nums[i] * -1;
            //since array is sorted, we can do 2 pointer approach
            int l = i + 1, r = n - 1;
            while(l < r){
                int sum = nums[l] + nums[r];
                if(sum < target){
                    //increase by moving left
                    l++;
                }
                else if(sum > target){
                    //decrese by moving right
                    r--;
                }
                else{
                    //means match found
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r])));
                    //move l and r
                    l++;
                    r--;
                    //skip duplicate l and r
                    while(l < r && nums[l] == nums[l - 1]){
                        l++;
                    }
                    while(l < r && nums[r] == nums[r + 1]){
                        r--;
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
