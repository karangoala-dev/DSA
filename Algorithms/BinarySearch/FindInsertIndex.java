package Algorithms.BinarySearch;

public class FindInsertIndex {
    //Basically, find lower bound in this qn
    public static int searchInsert(int[] nums, int target) {
        int l = 0, h = nums.length - 1, ans = -1;
        if(target < nums[l])
            return 0;
        if(target > nums[h])
            return nums.length;

        //we need to find lower bound, i.e. first element greater than or equal to target
        while(l <= h){
            int mid = l + ((h - l)/2);
            if(nums[mid] >= target){
                //go left as there might be a smaller number greater than target
                ans = mid;
                h = mid - 1;
            }
            else{
                //go right to look for a bigger no
                l = mid + 1;
            }
        }
        return ans;
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
