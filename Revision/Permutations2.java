package Revision;

import Algorithms.RecursionAndBacktracking.Permutations;

import java.util.*;

public class Permutations2 {
    //NOOB approach
//    List<List<Integer>> res = new ArrayList<>();
//    HashSet<String> set = new HashSet<>();
//    HashSet<Integer> currentSet = new HashSet<>();
//
//    public void helper(int[] nums, List<Integer> curr){
//        if(curr.size() == nums.length){
//            String s = curr.toString();
//            if(!set.contains(s)){
//                res.add(new ArrayList<>(curr));
//                set.add(s);
//                return;
//            }
//        }
//
//        for(int i = 0; i < nums.length; i++){
//            if(currentSet.contains(i)){
//                continue;
//            }
//            curr.add(nums[i]);
//            currentSet.add(i);
//            helper(nums, curr);
//
//            curr.remove(curr.size() - 1);
//            currentSet.remove(i);
//        }
//    }
//
//    public List<List<Integer>> permuteUnique(int[] nums) {
//        helper(nums, new ArrayList<>());
//        return res;
//    }

    //Efficient approach
    List<List<Integer>> res = new ArrayList<>();
    public void helper(int[] nums, List<Integer> curr, HashMap<Integer, Integer> map){
        if(curr.size() == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        //for each entry, if count is > 0 then add to current list and continue
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue() > 0){
                //take and recurse
                curr.add(entry.getKey());
                entry.setValue(entry.getValue() - 1);
                helper(nums, curr, map);

                //backtrack
                curr.remove(curr.size() - 1);
                entry.setValue(entry.getValue() + 1);
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        //store element and frequency
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int e : nums){
            map.put(e, map.getOrDefault(e, 0) + 1);
        }
        helper(nums, new ArrayList<>(), map);

        return res;
    }
    public static void main(String[] args) {
        Permutations2 permutations2 = new Permutations2();
        System.out.println(permutations2.permuteUnique(new int[]{1,1,2}));;
    }
}
