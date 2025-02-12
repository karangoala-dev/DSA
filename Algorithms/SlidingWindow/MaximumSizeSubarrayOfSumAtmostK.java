package Algorithms.SlidingWindow;

public class MaximumSizeSubarrayOfSumAtmostK {
    public static int naiveApproach(int arr[], int k){
        int res = 0;
        for(int i = 0; i < arr.length; i++){
            int curr = 0;
            for(int j = i; j < arr.length; j++){
                curr += arr[j];
                if(curr <= k){
                   res = Math.max(res, j - i + 1);
                }
                else{
                    break;
                }
            }
        }
        return res;
    }

    public static int slidingWindow(int[] arr, int k){
        int res = 0;
        int l = 0, r = 0, curr = 0;
        while(r < arr.length){
            curr += arr[r];
            if(curr <= k){
                res = Math.max(res, r - l + 1);
                r++;
            }
            else {
                while(l < r && curr > k){
                    curr -= arr[l];
                    l++;
                }
                r++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] testArrays = {
                {1, 2, 1, 0, 1, 1, 0},
                {3, 1, 2, 1, 4},
                {5, 1, 2, 3, 4, 1},
                {10, 5, 2, 7, 1, 9},
                {1, 2, 3, 4, 5},
                {4, 4, 4, 4, 4},
                {1, 1, 1, 1, 1, 1, 1},
                {10},
                {}
        };

        int[] testKValues = {4, 4, 5, 8, 6, 10, 3, 5, 2};

        System.out.println("Comparing naive and sliding window approach:");
        System.out.println("-----------------------------------------------------");
        for (int i = 0; i < testArrays.length; i++) {
            int[] arr = testArrays[i];
            int k = testKValues[i];

            int naiveRes = naiveApproach(arr, k);
            int slidingRes = slidingWindow(arr, k);

            System.out.println("Test Case " + (i + 1) + ": k=" + k);
            System.out.println("Array: " + java.util.Arrays.toString(arr));
            System.out.println("Naive Approach Result: " + naiveRes + " | Sliding Window Result: " + slidingRes);
            System.out.println("-----------------------------------------------------");
        }
    }
}
