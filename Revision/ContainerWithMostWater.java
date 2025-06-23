package Revision;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int res = 0;
        while (l < r){
            int curr = Math.min(height[l], height[r]) * (r - l);
            res = Math.max(curr, res);

            if(height[l] < height[r]){
                l++;
            }
            else {
                r--;
            }
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
