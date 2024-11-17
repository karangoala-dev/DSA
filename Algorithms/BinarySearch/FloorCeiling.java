package Algorithms.BinarySearch;

import java.util.Arrays;

public class FloorCeiling {
    public static int[] getFloorAndCeil(int[] a, int n, int x) {
        // Write your code here.
        int[] res = {-1, -1};
        int l = 0, h = a.length - 1;
        while(l <= h){
            int mid = (l + h) / 2;
            if(a[mid] == x){
                res[0] = a[mid];
                res[1] = a[mid];
                return res;
            }
            else if(x < a[mid]){
                res[1] = a[mid];
                h = mid - 1;
            }
            else{
                res[0] = a[mid];
                l = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[][] testArrays = {
                {1, 2, 8, 10, 10, 12, 19},   // Case 1: General case
                {5, 7, 9, 12, 15},           // Case 2: Larger numbers
                {2, 4, 6, 8, 10},            // Case 3: Even numbers
                {1, 3, 5, 7, 9},             // Case 4: Odd numbers
                {},                          // Case 5: Empty array
                {10},                        // Case 6: Single element array
                {1, 2, 3, 4, 5, 6}           // Case 7: Consecutive numbers
        };

        int[] targets = {5, 20, 0, 10, 7, 3, 8}; // Corresponding targets to test

        System.out.println("Testing getFloorAndCeil function:");
        for (int i = 0; i < testArrays.length; i++) {
            int[] arr = testArrays[i];
            int target = targets[i];
            int[] result = getFloorAndCeil(arr, arr.length, target);
            System.out.println("Array: " + Arrays.toString(arr) + ", Target: " + target);
            System.out.println("Floor and Ceiling: " + Arrays.toString(result) + "\n");
        }
    }
}
