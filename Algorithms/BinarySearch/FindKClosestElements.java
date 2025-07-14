package Algorithms.BinarySearch;

import java.util.*;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //initialise l to 0 and r to len - l, such that r se we have k elements
        int l = 0, r = arr.length - k;
        while (l < r){
            int mid = (l + r) / 2;
            if(x - arr[mid] > arr[mid + k] - x){
                //go right
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        //now l will be the left bound, take k elements from l
        List<Integer> res = new ArrayList<>();
        for (int i = l; i < l + k; i++){
            res.add(arr[i]);
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
