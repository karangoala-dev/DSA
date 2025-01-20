package Algorithms.BinarySearch;

public class KokoEatingBananas {
    //Brute Force approach : TC = O(n(max(n)))
//    public int minEatingSpeed(int[] piles, int h) {
//        int maxPiles = Integer.MIN_VALUE;
//        for (int pile : piles) {
//            maxPiles = Math.max(maxPiles, pile);
//        }
//
//        for(int i = 1; i <= maxPiles; i++){
//            int time = 0;
//            for(int j = 0; j < piles.length; j++){
//                time += (int) Math.ceil((double)piles[j] / i);
//                if(time > h){
//                    break;
//                }
//            }
//            if(time <= h){
//                return i;
//            }
//        }
//        return 0;
//    }
    //Efficient approach, TC is O(n(log(max(n))))
    public int minEatingSpeed(int[] piles, int h) {
        int maxPiles = Integer.MIN_VALUE;
        for (int pile : piles) {
            maxPiles = Math.max(maxPiles, pile);
        }

        //     }
        int l = 1, r = maxPiles, res = maxPiles;
        while(l <= r){
            int mid = ((r - l) / 2) + l;
            int time = 0;
            for(int j = 0; j < piles.length; j++){
                time += (int) Math.ceil((double) piles[j] / mid);
                if(time > h){
                    // Time taken is large so need to increase speed so go to right
                    l = mid + 1;
                    break;
                }
            }
            if(time <= h){
                //Time taken is less but need to know most efficient rate, so need to check left still.
                res = Math.min(res, mid);
                r = mid - 1;
            }
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
