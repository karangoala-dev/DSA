package Algorithms.BinarySearch;

public class FirstBadVersion {
    //dummy fn, actual isBadVersion fn present in leetcode
    public boolean isBadVersion(int n){
        return true;
    }

    public int firstBadVersion(int n) {
        int l = 0, h = n - 1, ans = -1;
        while(l <= h){
            int mid = l + ((h - l)/2);
            if(isBadVersion(mid + 1) == true){
                //go left
                ans = mid + 1;
                h = mid - 1;
            }
            else{
                //go right
                l = mid + 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
