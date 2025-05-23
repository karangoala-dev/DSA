package Algorithms.PrefixSum;

public class RangeSumQuery {
    int[] arr;
    int[] prefixSum;
    public RangeSumQuery(int[] nums) {
        int n = nums.length;
        arr = nums;
        prefixSum = new int[n + 1];

        for(int i = 1; i < n + 1; i++){
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return prefixSum[right + 1] - prefixSum[left];
    }
    public static void main(String[] args) {

    }
}
