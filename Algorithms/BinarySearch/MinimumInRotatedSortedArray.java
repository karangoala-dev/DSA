package Algorithms.BinarySearch;

import java.util.Arrays;

public class MinimumInRotatedSortedArray {
    public static int findMin(int[] nums) {
        int res = Integer.MAX_VALUE;
        int l = 0, h = nums.length - 1;
        while(l <= h){
            int mid = l + ((h - l) / 2);
            if(nums[mid] < res){
                res = nums[mid];
            }
            if(nums[mid] < nums[h]){//look left
                h = mid - 1;
            }
            else{//look right noww
                l = mid + 1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr1 = {6, 7, 1, 2, 3, 4, 5};
        System.out.println("Min value in : " + Arrays.toString(arr1) + " is " + findMin(arr1)); // Expected: 1
    }
}
