package Revision;

import Revision.utils.Trio;

import java.util.PriorityQueue;

public class PathWithMinimumEffort {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        PriorityQueue<Trio> pq = new PriorityQueue<>((o1, o2) -> o1.third - o2.third);
        int[] rows = {0, -1, 0, 1};
        int[] cols = {-1, 0, 1, 0};
        pq.add(new Trio(0,0,0));
        int[][] visited = new int[n][m];
        visited[0][0] = 1;
        while(!pq.isEmpty()){
            Trio curr = pq.poll();
            if(curr.first == n - 1 && curr.second == m - 1){
                //reached destination
                return curr.third;
            }
            if(visited[curr.first][curr.second] == 1){
                continue;
            }

            visited[curr.first][curr.second] = 1;
            for(int i = 0; i < 4; i++){
                int r = rows[i] + curr.first, c = cols[i] + curr.second;
                if(r >= 0 && c >= 0 && r < n && c < m && visited[r][c] == 0){
                    int diff = Math.abs(heights[r][c] - heights[curr.first][curr.second]);
                    //put the max diff for this path so far in pq
                    pq.add(new Trio(r, c, Math.max(diff, curr.third)));
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {

    }
}
