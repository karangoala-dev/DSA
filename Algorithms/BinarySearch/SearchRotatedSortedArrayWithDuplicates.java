package Algorithms.BinarySearch;

public class SearchRotatedSortedArrayWithDuplicates {

    public static boolean search(int[] nums, int t) {
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            int mid = l + ((h - l) / 2);
            if (nums[mid] == t) {
                return true;
            }

            if (nums[l] < nums[mid]) {//left
                if (nums[l] <= t && t < nums[mid]) {//if target between l and mid
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else if (nums[l] > nums[mid]) {//right
                if (nums[mid] < t && t <= nums[h]) {//if target between mid and h
                    l = mid + 1;
                } else {
                    h = mid - 1;
                }
            } else {
                l++;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[] arr1 = {2, 5, 6, 0, 0, 1, 2};
        int target1 = 0;
        System.out.println("Does " + target1 + " exist : " + search(arr1, target1)); // Expected: true

        int target2 = 3;
        System.out.println("Does " + target2 + " exist : " + search(arr1, target2)); // Expected: false
    }
}
