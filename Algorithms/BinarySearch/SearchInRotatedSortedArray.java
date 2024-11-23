package Algorithms.BinarySearch;

//There is an integer array nums sorted in ascending order (with distinct values).
//Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array
// is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and
// become [4,5,6,7,0,1,2].
//Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
//You must write an algorithm with O(log n) runtime complexity.
//
//Example 1:
//Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4

//Example 2:
//Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1

//Example 3:
//Input: nums = [1], target = 0
//Output: -1

class Solution {
    public int search(int[] arr, int t) {
        int l = 0, r = arr.length - 1;
        while(l <= r){
            int m = (l + r) / 2;
            boolean left = arr[m] >= arr[l]; //Check if we are on left sorted array or right sorted array
            if(arr[m] == t){
                return m;
            }
            if(left){
                if(t > arr[m]){
                    l = m + 1;
                }
                else{
                    if(t < arr[l]){
                        l = m + 1;
                    }
                    else{
                        r = m - 1;
                    }
                }
            }
            else{
                if(t < arr[m]){
                    r = m - 1;
                }
                else{
                    if(t > arr[r]){
                        r = m - 1;
                    }
                    else{
                        l = m + 1;
                    }
                }
            }
        }
        return -1;
    }
}

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0;
        System.out.println("Index of " + target1 + ": " + solution.search(arr1, target1)); // Expected: 4

        int[] arr2 = {4, 5, 6, 7, 0, 1, 2};
        int target2 = 3;
        System.out.println("Index of " + target2 + ": " + solution.search(arr2, target2)); // Expected: -1
    }
}
