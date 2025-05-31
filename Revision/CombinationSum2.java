package Revision;

import java.util.*;

public class CombinationSum2 {
    List<List<Integer>> res = new ArrayList<>();
    public void helper(int[] nums, int target, int ind, List<Integer> curr, int currSum){
        if(ind >= nums.length || currSum >= target){
            if(currSum == target){
                res.add(new ArrayList<>(curr));
            }
            return;
        }
        //take and move to next
        curr.add(nums[ind]);
        helper(nums, target, ind + 1, curr, currSum + nums[ind]);

        //skip dupes
        while(ind < nums.length - 1 && nums[ind] == nums[ind + 1]){
            ind++;
        }
        //now backtrack and recurse further
        curr.remove(curr.size() - 1);
        helper(nums, target, ind + 1, curr, currSum);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, target, 0, new ArrayList<>(), 0);
        return res;
    }
    public static void main(String[] args) {

    }
}
