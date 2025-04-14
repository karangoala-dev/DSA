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
    public int findMax(int[] arr){
        int res = Integer.MAX_VALUE;
        for(int i: arr){
            res = Math.max(res, i);
        }
        return res;
    }
    public int getTimeTaken(int[] piles, int k){
        int res = 0;
        for(int i = 0; i < piles.length; i++){
            res += Math.ceil((double) piles[i] / k);
        }
        return res;
    }
    public int minEatingSpeed(int[] piles, int hrs) {
        int l = 0, h = findMax(piles);
        int res = Integer.MAX_VALUE;
        while(l <= h){
            int mid = (l + (h - l) / 2);
            //find resultant time for this value of k
            int timeTaken = getTimeTaken(piles, mid);
            if(timeTaken > hrs){
                //not acceptable, need to increase k
                //go right
                l = mid + 1;
            }
            else{
                //acceptable, but need to find most optimal, so go left
                res = Math.min(res, mid);
                h = mid - 1;
            }
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
