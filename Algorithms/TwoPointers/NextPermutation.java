package Algorithms.TwoPointers;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2, j = n - 1;
        while(i >= 0){
            if(nums[i] < nums[i + 1]){
                //we found the i such that arr[i] < arr[i + 1]
                while(j > i){
                    if(nums[j] > nums[i]){
                        //means we found an element just bigger than ith
                        //since till i, the array is descending order, so this element is the first element greater than i
                        //now swap
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;

                        //sort array from i+1 to n-1
                        Arrays.sort(nums, i + 1, n);
                        return;
                    }
                    j--;
                }
            }
            i--;
        }
        //we reach here means, array is in descending order, return sorted array
        Arrays.sort(nums);
    }
    public static void main(String[] args) {

    }
}
