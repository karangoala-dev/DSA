package Algorithms;

public class RecursiveBinarySearch {
    public static int binarySearch(int[] arr, int l, int h, int target){
        if(l > h){
            return -1;
        }

        int m = (l + h) / 2;
        if(arr[m] == target){
            return m;
        }
        else if(arr[m] > target){
            return binarySearch(arr, l, m - 1, target);
        }
        else{
            return binarySearch(arr, m + 1, h, target);
        }
    }
    public static void main(String[] args){
        int[] arr = {1, 12, 13, 14, 15, 100};
        System.out.println(binarySearch(arr, 0, 5, 16));
    }
}
