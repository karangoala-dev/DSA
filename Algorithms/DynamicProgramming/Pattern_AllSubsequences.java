package Algorithms.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class Pattern_AllSubsequences {
    public static void helper(int[] arr, int ind, List<Integer> curr){
        if(ind == arr.length){
            //means we reached end, so print subarray
            System.out.println(curr);
            return;
        }

        //take
        int prevSize = curr.size();
        curr.add(arr[ind]);
        helper(arr, ind + 1, curr);
        curr.remove(prevSize);

        //not-take
        helper(arr, ind + 1, curr);
    }
    public static void main(String[] args) {
        int[] arr = {3,1,2};
        helper(arr, 0, new ArrayList<>());
    }
}
