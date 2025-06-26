package Revision;

import java.util.*;

public class CombinationSum {
    List<List<Integer>> res = new ArrayList<>();
    public void helper(int[] arr, int target, int currSum, int ind, List<Integer> curr){
        if(currSum > target){
            return;
        }
        if(ind >= arr.length){
            if(currSum == target){
                res.add(new ArrayList<>(curr));
            }
            return;
        }
        //take and stay there
        curr.add(arr[ind]);
        helper(arr, target, currSum + arr[ind], ind, curr);
        //not take and move ahead
        curr.remove(curr.size() - 1);
        helper(arr, target, currSum, ind + 1, curr);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates, target, 0, 0, new ArrayList<>());
        return res;
    }
    public static void main(String[] args) {

    }
}
