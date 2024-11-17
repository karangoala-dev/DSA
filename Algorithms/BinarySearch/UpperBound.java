package Algorithms.BinarySearch;

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
    public static void main(String[] args){
        int[] test1 = {1, 3, 5, 7, 9}; // Sorted array
        System.out.println(upperBound(test1, 5)); // Expected: 3
        System.out.println(upperBound(test1, 6)); // Expected: 3
        System.out.println(upperBound(test1, 9)); // Expected: -1
        System.out.println(upperBound(test1, 0)); // Expected: 0

        int[] test2 = {2, 2, 2, 2, 2}; // Array with all elements equal
        System.out.println(upperBound(test2, 2)); // Expected: -1
        System.out.println(upperBound(test2, 1)); // Expected: 0

        int[] test3 = {}; // Empty array
        System.out.println(upperBound(test3, 1)); // Expected: -1

        int[] test4 = {1, 1, 1, 1, 1}; // Array with identical elements smaller than target
        System.out.println(upperBound(test4, 2)); // Expected: -1

        int[] test5 = {-10, -5, 0, 5, 10}; // Array with negative and positive numbers
        System.out.println(upperBound(test5, -5)); // Expected: 2
        System.out.println(upperBound(test5, 0)); // Expected: 3
        System.out.println(upperBound(test5, 10)); // Expected: -1

        int[] test6 = {1}; // Single element array
        System.out.println(upperBound(test6, 0)); // Expected: 0
        System.out.println(upperBound(test6, 1)); // Expected: -1

        int[] test7 = {1, 3, 3, 3, 7}; // Array with duplicate elements
        System.out.println(upperBound(test7, 3)); // Expected: 4
        System.out.println(upperBound(test7, 4)); // Expected: 4
    }
}
