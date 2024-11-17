package Algorithms.BinarySearch;

import java.util.Arrays;

public class UpperBound {
    //Find the first position strictly greater than the target
    public static int upperBound(int[] arr, int target){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > target){
                return i;
            }
        }
        return -1;
    }

    //Optimised approach using Binary Search
    public static int upperBoundOptimised(int[] arr, int target){
        int res = -1;
        int l = 0, h = arr.length - 1;
        while(l <= h){
            int mid = (l + h) / 2;
            if(arr[mid] > target){
                res = mid;
                //Look further left
                h = mid - 1;
            }
            else{
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

        int[] targets = {5, 6, 9, 0, 2, 3, -5, 10, 1, 4}; // Targets to test

        // Measure and test upperBound
        System.out.println("Testing upperBound:");
        long start = System.currentTimeMillis();
        for (int[] testCase : testCases) {
            for (int target : targets) {
                System.out.println("upperBound([" + Arrays.toString(testCase) + "], " + target + ") = " +
                        upperBound(testCase, target));
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Execution time for upperBound: " + (end - start) + " ms\n");

        // Measure and test upperBoundOptimised
        System.out.println("Testing upperBoundOptimised:");
        start = System.currentTimeMillis();
        for (int[] testCase : testCases) {
            for (int target : targets) {
                System.out.println("upperBoundOptimised([" + Arrays.toString(testCase) + "], " + target + ") = " +
                        upperBoundOptimised(testCase, target));
            }
        }
        end = System.currentTimeMillis();
        System.out.println("Execution time for upperBoundOptimised: " + (end - start) + " ms");
    }
}
