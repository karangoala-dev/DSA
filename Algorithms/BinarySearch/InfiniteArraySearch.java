package Algorithms.BinarySearch;

public class InfiniteArraySearch {
    // TC is O(Log n) + O(Log n) = O(Log n) / one log n for finding high value and one log n for binary search
    public static int binarySearch(int[] arr, int target, int l, int h){
        while(l <= h){
            int mid = l + ((h - l) / 2);
            if(arr[mid] == target){
                return mid;
            }

            if(arr[mid] < target){
                l = mid + 1;
            }
            else{
                h = mid - 1;
            }
        }
        return -1;
    }
    public static int searchInfiniteArray(int[] arr, int target){
        int l = 0;
        int h = 1;
        while(arr[h] < target && h < arr.length){
            l = h;
            h = 2 * h;
        }
        return binarySearch(arr, target, l, h);
    }
    public static void main(String[] args) {
        // Test case: Simulated infinite array
        int[] arr = {2, 3, 5, 7, 9, 14, 18, 21, 25, 30, 35, 40, 45, 50};
        int target = 18;

        // Call the searchInfiniteArray function
        int result = searchInfiniteArray(arr, target);

        // Print the result
        if (result != -1) {
            System.out.println("Target " + target + " found at index: " + result);
        } else {
            System.out.println("Target " + target + " not found in the array.");
        }
    }
}
