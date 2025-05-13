package DataStructures.Stack;

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

    }

    public static void main(String[] args) {
        SumOfSubarrayMinimums sumOfSubarrayMinimums = new SumOfSubarrayMinimums();
        System.out.println(sumOfSubarrayMinimums.sumSubarrayMins_BruteForce(new int[]{3,1,2,4}));

    }
}
