package Algorithms.BinarySearch;

public class FindTotalOccurences {
    public static int binarySearch(int[] arr, int t, boolean left){
        int ind = -1;
        int l = 0, h = arr.length - 1;
        while(l <= h){
            int mid = (l + h) / 2;
            if(arr[mid] == t){
                ind = mid;
                if(left){
                    h = mid - 1;
                }
                else{
                    l = mid + 1;
                }
            }
            else if(arr[mid] > t){
                h = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return ind;
    }
    static int countFreq(int[] arr, int target) {
        // code here
        int left = binarySearch(arr, target, true);
        int right = binarySearch(arr, target, false);
        if(left != -1 && right != -1){
            return right - left + 1;
        }
        return 0;
    }
    public static void main(String[] args) {

        // Test case 1: Target exists multiple times
        int[] nums1 = {1, 2, 2, 2, 3, 4, 5};
        int target1 = 2;
        System.out.println("Input: nums = " + java.util.Arrays.toString(nums1) + ", target = " + target1);
        System.out.println("Total Occurrences: " + countFreq(nums1, target1)); // Expected: 3

        // Test case 2: Target exists only once
        int[] nums2 = {1, 2, 3, 4, 5};
        int target2 = 3;
        System.out.println("Input: nums = " + java.util.Arrays.toString(nums2) + ", target = " + target2);
        System.out.println("Total Occurrences: " + countFreq(nums2, target2)); // Expected: 1
    }
}
