package Algorithms.RecursionAndBacktracking;

public class climbingStairs {
    public int climbStairs(int n) {
        if(n <= 2){
            //if n == 2 then no of ways = 2
            //if n == 1 then no of ways = 1
            return n;
        }

        //we need summation of no of ways
        //so, at each level choice is to take either one or two steps
        //so, summation of those choices
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
    public static void main(String[] args) {

    }
}
