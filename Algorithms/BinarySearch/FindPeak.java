package Algorithms.BinarySearch;

public class FindPeak {
    public int findPeakElement(int[] nums) {
        int n = nums.length, l = 0, h = nums.length - 1;
        while(l <= h){
            int mid = (l + (h - l) / 2);
            if((mid == 0 || nums[mid] > nums[mid - 1])&&(mid == n - 1 || nums[mid] > nums[mid + 1])){
                return mid;
            }

            if(mid != 0 && nums[mid] < nums[mid - 1]){
                //go left
                h = mid - 1;
            }
            else{
                //else go right (no need to check if l is n-1 since l <= h always and we are always decrementing h)
                l = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {

    }
}
