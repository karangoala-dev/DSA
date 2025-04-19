package Algorithms.RecursionAndBacktracking;

public class VImpGoodNumbers {
    private long MOD = 1_000_000_007;
    public int countGoodNumbers(long n) {
        long even = power(5, ((n + 1) / 2)) % MOD;
        long odd = power(4, (n / 2)) % MOD;

        return (int) ((even * odd) % MOD);
    }

    private long power(long x, long n){
        if(n == 0){
            return 1;
        }

        long temp = power(x, n / 2);

        if(n % 2 == 0){
            return (temp * temp) % MOD;
        }
        else{
            return (x * temp * temp) % MOD;
        }
    }

    public static void main(String[] args) {

    }
}
