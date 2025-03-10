package DataStructures.Graphs;

import java.util.*;

class Pixel{
    int r;
    int c;
    Pixel(int _r, int _c){
        this.r = _r;
        this.c = _c;
    }
}
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length, m = image[0].length;
        Queue<Pixel> q = new LinkedList<>();
        q.add(new Pixel(sr, sc));
        int[] row = {0, -1, 0, 1};
        int[] col = {-1, 0, 1, 0};
        int prevColor = image[sr][sc];
        if(color == prevColor){
            return image;
        }
        while(!q.isEmpty()){
            Pixel current = q.poll();
            int r = current.r, c = current.c;
            image[r][c] = color;
            for(int i = 0; i < 4; i++){
                int nRow = r + row[i];
                int nCol = c + col[i];
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && image[nRow][nCol] == prevColor){
                    image[nRow][nCol] = color;
                    q.add(new Pixel(nRow, nCol));
                }
            }
        }
        return image;
    }

    public static void main(String[] args) {

    }
}
