package DataStructures.Stack;

import java.util.Stack;

public class SumOfSubarrayMinimums {

    //Brute force : TC: O(N^2)
    public int sumSubarrayMins_BruteForce(int[] arr) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            for(int j = i; j < arr.length; j++){
                if(arr[j] < min){
                    min = arr[j];
                }
                sum = (sum + min) % 1_000_000_007;
            }
            min = Integer.MAX_VALUE;
        }
        return sum;
    }

    //Optimised approach using monotonic stack
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        //How many elements can be chosen to the right where arr[i] stays the minimum.
        int[] nse = new int[n];
        //How many elements can be chosen to the left where arr[i] stays the minimum.
        int[] pse = new int[n];
        //for these stacks, 0 index has the index for element in the arr and 1 has the value
        Stack<int[]> nseStack = new Stack<>();
        Stack<int[]> pseStack = new Stack<>();
        for(int i = 0; i < n; i++){
            //generate nse
            int ant_ind = n - 1 - i;

            // For NSE: We want the **first element strictly smaller** than arr[ant_ind]
            // Hence we use **> comparison** to allow equal elements to be part of arr[ant_ind]'s zone.
            // Equal elements on the right should NOT stop arr[ant_ind] from being minimum.
            while(!nseStack.isEmpty() && nseStack.peek()[1] > arr[ant_ind]){
                nseStack.pop();
            }

            if(nseStack.isEmpty()){
                //means no element on right is smaller than this
                nse[ant_ind] = n;
            }
            else {
                //thing is , we store the index and not value since we need the no of elements smaller
                nse[ant_ind] = nseStack.peek()[0];
            }
            nseStack.push(new int[] {ant_ind, arr[ant_ind]});

            //generate pse
            //we want previous smaller or equal elements. so not > and >= we use
            //or else we will get incorrect sum by counting the same subarray twice, this is done for cases with duplicate elements.
            //if all are unique, this issue won't come.
            while(!pseStack.isEmpty() && pseStack.peek()[1] >= arr[i]){
                pseStack.pop();
            }

            if(pseStack.isEmpty()){
                //means no element on left is smaller than this
                pse[i] = -1;
            }
            else {
                //thing is , we store the index and not value since we need the no of elements smaller
                pse[i] = pseStack.peek()[0];
            }
            pseStack.push(new int[]{i, arr[i]});
        }

        int res = 0;
        //now iterate from 0 to n - 1 and keep track of sum
        for(int i = 0; i < n; i++){
            //contribution of arr[i] = arr[i] * count of subarrays where arr[i] is minimum

            //if no element smaller on left, then no. of elements = i + 1, else i - pse[i]
            int leftElements = pse[i] == -1 ? i + 1 : i - pse[i];
            //if no element smaller on right, then no. of elements = n - i, else nse[i] - i
            int rightElements = nse[i] == n ? n - i : nse[i] - i;
            long curr = (long) arr[i] * leftElements % 1_000_000_007 * rightElements % 1_000_000_007;
            res = (int)((res + curr) % 1_000_000_007);
        }

        return res;
    }

    //See this code, more concise than above and same TC
    public int sumSubarrayMins_Concise(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        long res = 0;
        int n = arr.length;

        //n is added as a delimited to know when to process all elements, after we reached end
        for(int right = 0; right <= n; right++){
            while(!stack.isEmpty() && (right == n || arr[stack.peek()] >= arr[right])){
                int mid = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                int leftCount = mid - left;
                int rightCount = right - mid;
                long contribution = ((long)arr[mid] * leftCount % 1_000_000_007) * rightCount % 1_000_000_007;
                res = (res + contribution) % 1_000_000_007;
            }
            if(right < n){
                stack.push(right);
            }
        }

        return (int)res;
    }

    public static void main(String[] args) {
        SumOfSubarrayMinimums sumOfSubarrayMinimums = new SumOfSubarrayMinimums();
        System.out.println(sumOfSubarrayMinimums.sumSubarrayMins(new int[]{11,81,3,43,3}));

    }
}
