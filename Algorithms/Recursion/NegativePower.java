package Algorithms.Recursion;

public class NegativePower {
    public double helper(double x, long n){
        if(n == 0){
            return 1;
        }
        if(n % 2 == 1){
            return x * helper(x, n - 1);
        }
        return helper(x * x, n / 2);
    }


    public double myPow(double x, int n) {
        boolean isNegative = false;
        long nn = n;                //nn is created to pass n as a long. Since the value of n is int, it can be -2147483648 to 2147483647.
        if(n < 0){                  //when converting -int to int, if it's value is 2147483648 then it will overflow for positive value. So this long is taken.
            isNegative = true;
            nn = -1 * nn;
        }
        double res = helper(x, nn);
        if(isNegative){
            return 1.0 / res;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
