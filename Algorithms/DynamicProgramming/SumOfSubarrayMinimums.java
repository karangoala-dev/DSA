package Algorithms.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class SumOfSubarrayMinimums {

    //Brute force : TC: O(N^2)
    public int sumSubarrayMins(int[] arr) {
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

    public static void main(String[] args) {
        SumOfSubarrayMinimums sumOfSubarrayMinimums = new SumOfSubarrayMinimums();
        System.out.println(sumOfSubarrayMinimums.sumSubarrayMins(new int[]{3,1,2,4}));

    }
}
