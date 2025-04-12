package Algorithms.BinarySearch;

public class FindMinimumElement {
    public int findMin(int[] nums) {
        int l = 0, h = nums.length - 1;
        int res = Integer.MAX_VALUE;
        while(l <= h){
            int mid = (l + (h - l) / 2);

            if(nums[mid] < res){
                res = nums[mid];
            }

            //if array is already sorted, check if we found a smaller value, and do break
            //since current array is already sorted and no num will be smaller than leftmost
            if(nums[l] < nums[h]){
                res = Math.min(res, nums[l]);
                break;
            }
            else{
                //array is sorted and rotated,
                //if we are on left side
                if(nums[mid] >= nums[l]){
                    //go right
                    l = mid + 1;
                }
                //else if we are on right side
                else{
                    //go left
                    h = mid - 1;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        FindMinimumElement solution = new FindMinimumElement();
        System.out.println(solution.findMin(new int[]{3, 4, 5, 1, 2})); // 1
        System.out.println(solution.findMin(new int[]{4, 5, 6, 7, 0, 1, 2})); // 0
        System.out.println(solution.findMin(new int[]{11, 13, 15, 17})); // 11
        System.out.println(solution.findMin(new int[]{2, 3, 4, 5, 1})); // 1
        System.out.println(solution.findMin(new int[]{1})); // 1

    }
}
