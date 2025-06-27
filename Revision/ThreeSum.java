package Revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1])
                continue;

            int target = -1 * nums[i];
            int l = i + 1, r = nums.length - 1;
            while (l < r){
                int sum = nums[l] + nums[r];
                if(sum == target){
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r])));
                    //also check further for any more pairs but skip dupes
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1])
                        l++;
                    while (l < r && nums[r] == nums[r + 1])
                        r--;
                }
                else if(sum < target){
                    l++;
                }
                else {
                    r--;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
