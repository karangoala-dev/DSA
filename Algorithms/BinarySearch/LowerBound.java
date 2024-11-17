package Algorithms.BinarySearch;

import java.util.Arrays;

public class LowerBound {
    //Smallest index such that arr[index] >= number
    public static int lowerBound(int[] arr, int target){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] >= target){
                return i;
            }
        }
        return -1;
    }
    //Using Binary Search
    public static int lowerBoundOptimised(int[] arr, int target){
        int l = 0, h = arr.length - 1;
        int res = -1;
        while(l <= h){
            int mid = (l + h) / 2;
            if(arr[mid] >= target){
                res = mid;
                //Look further left for even smaller index
                h = mid - 1;
            }
            else{
                //Look right
                l = mid + 1;
            }
        }
        return res;
    }
    public static void main(String[] args){
        int[][] testCases = {
                {1, 3, 5, 7, 9},        // Case 1: Sorted array
                {2, 2, 2, 2, 2},        // Case 2: Array with all elements equal
                {},                     // Case 3: Empty array
                {1, 1, 1, 1, 1},        // Case 4: Array with identical elements smaller than target
                {-10, -5, 0, 5, 10},    // Case 5: Array with negative and positive numbers
                {1},                    // Case 6: Single element array
                {1, 3, 3, 3, 7}         // Case 7: Array with duplicate elements
        };
        int[] targets = {5, 6, 0, 10, 3, -1, 2, -5, 0, 6, 0, 2, 3, 3, 4};

        // Run tests and measure execution time
        System.out.println("Testing lowerBound:");
        long start = System.currentTimeMillis();
        for (int i = 0; i < testCases.length; i++) {
            int[] arr = testCases[i];
            for (int target : targets) {
                System.out.println("lowerBound([" + Arrays.toString(arr) + "], " + target + ") = " + lowerBound(arr, target));
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Execution time for lowerBound: " + (end - start) + " ms\n");

        System.out.println("Testing lowerBoundOptimised:");
        start = System.currentTimeMillis();
        for (int i = 0; i < testCases.length; i++) {
            int[] arr = testCases[i];
            for (int target : targets) {
                System.out.println("lowerBoundOptimised([" + Arrays.toString(arr) + "], " + target + ") = " + lowerBoundOptimised(arr, target));
            }
        }
        end = System.currentTimeMillis();
        System.out.println("Execution time for lowerBoundOptimised: " + (end - start) + " ms");
    }
}
