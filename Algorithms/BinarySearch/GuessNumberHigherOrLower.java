package Algorithms.BinarySearch;

public class GuessNumberHigherOrLower {
    int guess(int num){
        //some implementation
        return -1;
    }
    public int guessNumber(int n) {
        int l = 0, r = n;
        while(l <= r){
            int mid = l + ((r - l) / 2);
            if(guess(mid) == 0){
                return mid;
            }
            else if (guess(mid) == -1) {
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {

    }
}
