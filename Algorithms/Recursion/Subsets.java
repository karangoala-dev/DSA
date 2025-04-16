package Algorithms.Recursion;

import java.util.*;
import java.util.stream.Collectors;

public class Subsets {
    List<List<Integer>> res = new ArrayList<>();
    public void helper(List<Integer> nums, List<Integer> curr, int ind){
        if(ind == nums.size()){
            res.add(new ArrayList<>(curr));
            return;
        }

        //take
        int prevSize = curr.size();
        curr.add(nums.get(ind));
        helper(nums, curr, ind + 1);

        //not take
        curr.remove(prevSize);
        helper(nums, curr, ind + 1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        helper(numsList, new ArrayList<>(), 0);
        return res;
    }
    public static void main(String[] args) {

    }
}
