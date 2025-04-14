package Algorithms.BinarySearch;

public class FindPeakInGrid {
    public int findPeakElement(int[] nums) {
        int n = nums.length, l = 0, h = nums.length - 1;
        while(l <= h){
            int mid = (l + (h - l) / 2);
            if((mid == 0 || nums[mid] > nums[mid - 1])&&(mid == n - 1 || nums[mid] > nums[mid + 1])){
                return mid;
            }

            if(mid != 0 && nums[mid] < nums[mid - 1]){
                //go left
                h = mid - 1;
            }
            else{
                //else go right (no need to check if l is n-1 since l <= h always and we are always decrementing h)
                l = mid + 1;
            }
        }
        return -1;
    }

    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int l = 0, h = n - 1;
        int[] row = {0, -1, 0, 1};
        int[] col = {-1, 0, 1, 0};
        while(l <= h){
            int mid = (l + (h-l)/2);
            int peakCol = findPeakElement(mat[mid]);
            //check if this peak is valid
            boolean res = true;
            System.out.println(mat[mid][peakCol]);
            for(int i = 0; i < 4; i++){
                int r = row[i] + mid;
                int c = col[i] + peakCol;

                //if row or column is valid
                if(r >= 0 && c >= 0 && r < n && c < m){
                    //accumulate the result boolean
                    res = res && mat[mid][peakCol] > mat[r][c];
                    //if any adjacent cell is larger(no 2 adjacent cells are equal, it is mentioned)
                    //move towards that adjacent cell
                    if(mat[r][c] > mat[mid][peakCol]){
                        //if row is above, mark h as r(mid - 1)
                        if(r < mid){
                            h = mid - 1;
                        }
                        else{
                            //else mark l as r(mid + 1)
                            l = mid + 1;
                        }
                        //if any adjacent node is larger than current peak then break the loop
                        break;
                    }
                }
            }
            if(res == true){
                //if we find a peak, return it
                return new int[]{mid, peakCol};
            }
        }
        return new int[] {-1, -1};
    }
    public static void main(String[] args) {

    }
}
