package Algorithms.BinarySearch;

public class FindInsertIndex {
    //Basically, find lower bound in this qn
    public static int searchInsert(int[] nums, int target) {
        int l = 0, h = nums.length - 1, res = -1;
        if(nums.length == 0){
            return 0;
        }
        if(target < nums[l]){
            return l;
        }
        if(target > nums[h]){
            return h + 1;
        }
        while(l <= h){
            int mid = (l + h) / 2;
            if(nums[mid] >= target){
                res = mid;
                //Check the left side further
                h = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] testCaseArrays = {
                {1, 3, 5, 6},        // Case 1: Normal array
                {1, 3, 5, 6, 8},     // Case 2: Larger array
                {1, 2, 3, 4, 5, 6},  // Case 3: Consecutive numbers
                {},                  // Case 4: Empty array
                {10, 20, 30, 40},    // Case 5: All values greater than target
                {10, 20, 30, 40},    // Case 6: All values smaller than target
                {1}                  // Case 7: Single-element array
        };

        int[] testCaseTargets = {5, 2, 7, 3, 15, 5, 1}; // Targets to test

        System.out.println("Testing searchInsert function:");
        for (int i = 0; i < testCaseArrays.length; i++) {
            int[] arr = testCaseArrays[i];
            int target = testCaseTargets[i];
            System.out.println("Array: " + java.util.Arrays.toString(arr) + ", Target: " + target);
            int result = searchInsert(arr, target);
            System.out.println("Result: " + result + "\n");
        }
    }
}
