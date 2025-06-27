package Revision;

public class TwoSum2 {
    public int binarySearch(int[] arr, int l, int r, int target){
        while (l <= r){
            int mid = l + ((r - l) / 2);
            if(arr[mid] == target)
                return mid;

            if(arr[mid] > target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }
    public int[] twoSum(int[] numbers, int target) {
        for(int i = 0; i < numbers.length; i++){
            int diff = target - numbers[i];
            int ind = binarySearch(numbers, i + 1, numbers.length - 1, diff);
            if(ind != -1){
                return new int[]{i + 1, ind + 1};
            }
        }
        return new int[0];
    }
    public static void main(String[] args) {

    }
}
