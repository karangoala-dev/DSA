package Algorithms.BinarySearch;

public class TwoSum2 {
    public int binSearch(int[] arr, int l, int r, int target){
        while(l <= r){
            int mid = l + ((r - l) / 2);
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] < target){
                //go right
                l = mid + 1;
            }
            else{
                //go left
                r = mid - 1;
            }
        }
        return -1;
    }
    public int[] twoSum(int[] arr, int target) {
        for(int i = 0; i < arr.length; i++){
            int diff = target - arr[i];
            //now search for diff target on the right side of array(i + 1 -> n - 1)
            int ind = binSearch(arr, i + 1, arr.length - 1, diff);
            if(ind != -1){
                //we found a match
                return new int[]{i + 1, ind + 1};
            }
        }
        return new int[0];
    }
    public static void main(String[] args) {

    }
}
