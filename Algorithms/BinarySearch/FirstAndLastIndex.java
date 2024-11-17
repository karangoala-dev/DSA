package Algorithms.BinarySearch;

public class FirstAndLastIndex {
    public static int binarySearch(int[] arr, int t, boolean left){
        int i = -1;
        int l = 0, h = arr.length - 1;
        while(l <= h){
            int mid = (l + h) / 2;
            if(arr[mid] == t){
                i = mid;
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
        return i;
    }
    public static int[] searchRange(int[] nums, int target) {
        if(nums.length < 1){
            return new int[]{-1, -1};
        }
        int leftIndex = binarySearch(nums, target, true);
        int rightIndex = binarySearch(nums, target, false);
        return new int[]{leftIndex, rightIndex};
    }
    public static void main(String[] args){
        int[] nums1 = {5, 7, 7, 8, 8, 10};
        int target1 = 8;
        System.out.println("Input: nums = " + java.util.Arrays.toString(nums1) + ", target = " + target1);
        System.out.println("Output: " + java.util.Arrays.toString(searchRange(nums1, target1))); // Expected: [3, 4]

        // Test case 2: Target doesn't exist
        int[] nums2 = {5, 7, 7, 8, 8, 10};
        int target2 = 6;
        System.out.println("Input: nums = " + java.util.Arrays.toString(nums2) + ", target = " + target2);
        System.out.println("Output: " + java.util.Arrays.toString(searchRange(nums2, target2))); // Expected: [-1, -1]
    }
}
