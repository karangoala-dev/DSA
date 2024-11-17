package Algorithms.BinarySearch;

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
    public static void main(String[] args){
        // Test cases
        int[] test1 = {1, 3, 5, 7, 9}; // Sorted array
        System.out.println(lowerBound(test1, 5)); // Expected: 2
        System.out.println(lowerBound(test1, 6)); // Expected: 3
        System.out.println(lowerBound(test1, 0)); // Expected: 0
        System.out.println(lowerBound(test1, 10)); // Expected: -1

        int[] test2 = {2, 2, 2, 2, 2}; // Array with all elements equal
        System.out.println(lowerBound(test2, 2)); // Expected: 0
        System.out.println(lowerBound(test2, 3)); // Expected: -1

        int[] test3 = {}; // Empty array
        System.out.println(lowerBound(test3, 1)); // Expected: -1

        int[] test4 = {1, 1, 1, 1, 1}; // Array with identical elements smaller than target
        System.out.println(lowerBound(test4, 2)); // Expected: -1

        int[] test5 = {-10, -5, 0, 5, 10}; // Array with negative and positive numbers
        System.out.println(lowerBound(test5, -5)); // Expected: 1
        System.out.println(lowerBound(test5, 0)); // Expected: 2
        System.out.println(lowerBound(test5, 6)); // Expected: 4

        int[] test6 = {1}; // Single element array
        System.out.println(lowerBound(test6, 0)); // Expected: 0
        System.out.println(lowerBound(test6, 2)); // Expected: -1

        int[] test7 = {1, 3, 3, 3, 7}; // Array with duplicate elements
        System.out.println(lowerBound(test7, 3)); // Expected: 1
        System.out.println(lowerBound(test7, 4)); // Expected: 4
    }
}
