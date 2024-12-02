package Algorithms.Recursion;

public class BasicPowerOfANumber {
    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }

        return x * myPow(x, n - 1);
    }
    public static void main(String[] args) {
        BasicPowerOfANumber powerCalculator = new BasicPowerOfANumber();
        //Here N cant be negative
        // Test cases
        System.out.println("2^3 = " + powerCalculator.myPow(2.0, 3));  // Expected: 8.0
        System.out.println("5^0 = " + powerCalculator.myPow(5.0, 0));  // Expected: 1.0
        System.out.println("(-2)^3 = " + powerCalculator.myPow(-2.0, 3)); // Expected: -8.0
        System.out.println("10^1 = " + powerCalculator.myPow(10.0, 1)); // Expected: 10.0

        // Edge case: n is large
        System.out.println("2^10 = " + powerCalculator.myPow(2.0, 10)); // Expected: 1024.0

        // Additional cases
        System.out.println("1^100 = " + powerCalculator.myPow(1.0, 100)); // Expected: 1.0
        System.out.println("0^5 = " + powerCalculator.myPow(0.0, 5));     // Expected: 0.0

    }
}
