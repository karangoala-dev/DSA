package Algorithms.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class Pattern_AllSubArrays {
    public static void helper_iterative(int[] arr){
        for(int i = 0; i < arr.length; i++){
            List<Integer> curr = new ArrayList<>();
            for(int j = i; j < arr.length; j++){
                curr.add(arr[j]);
                System.out.println(curr);
            }
        }
    }

    public static void helper_recursive(int[] arr, int i, int j, List<Integer> curr){
        if(j == arr.length){
            //end reached, exit
            return;
        }

        //add current end index to curr and print as it is a new subarray
        curr.add(arr[j]);
        System.out.println(curr);
        //recurse further using this subarray
        helper_recursive(arr, i, j + 1, curr);
        //backtrack
        curr.remove(curr.size() - 1);

        //now, if end is reached, move to next i
        if(i == j){
            helper_recursive(arr, i + 1, i + 1, new ArrayList<>());
        }
    }
    public static void main(String[] args) {
        int[] arr = {3,1,2};
        helper_recursive(arr, 0, 0, new ArrayList<>());
    }
}
