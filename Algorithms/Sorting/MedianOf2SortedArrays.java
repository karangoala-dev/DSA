package Algorithms.Sorting;

public class MedianOf2SortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[] merged = new int[n + m];
        int i = 0, j = 0, k = 0;
        while(i < n && j < m){
            if(nums1[i] < nums2[j]){
                merged[k++] = nums1[i++];
            }
            else{
                merged[k++] = nums2[j++];
            }
        }
        while(i < n){
            merged[k++] = nums1[i++];
        }
        while(j < m){
            merged[k++] = nums2[j++];
        }
        //now we find median in the resultant array
        int len = merged.length;
        int half = len / 2;
        double res = 0;
        if(len % 2 == 0){
            System.out.println(merged[half] + " " + merged[half - 1]);
            res = (merged[half] + merged[half - 1]) / 2.0;
        }
        else{
            res = (double) merged[half];
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
