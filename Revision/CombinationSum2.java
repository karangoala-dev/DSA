package Revision;

import java.util.*;

public class CombinationSum2 {
    List<List<Integer>> res = new ArrayList<>();
    HashSet<String> set = new HashSet<>();

    public void helper(int[] nums, int target, int ind, int currSum, List<Integer> curr){
        if(ind >= nums.length || currSum >= target){
            List<Integer> dummy = new ArrayList<>(curr);
            Collections.sort(dummy);
            String s = dummy.toString();
            if(currSum == target && ! set.contains(s)){
                set.add(s);
                res.add(new ArrayList<>(curr));
            }
            return;
        }

        //take and move ahead
        currSum += nums[ind];
        curr.add(nums[ind]);
        helper(nums, target, ind + 1, currSum, curr);

        //backtrack, not take and move ahead
        currSum -= nums[ind];
        curr.remove(curr.size() - 1);
        helper(nums, target, ind + 1, currSum, curr);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        helper(candidates, target, 0, 0, new ArrayList<>());
        return res;
    }
    public static void main(String[] args) {

    }
}
