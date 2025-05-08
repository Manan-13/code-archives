package lc;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlantic {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.pacificAtlantic(new int[][]{
                {1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}
        });
    }
}

class Solution {
    int[][] dirs = new int[][]{{0,1},{0,-1},{1, 0},{-1, 0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        Boolean[][] pacific = new Boolean[rows][cols];
        Boolean[][] atlantic = new Boolean[rows][cols];

        for(int i=0; i<rows; i++){
            dfs(i, 0, pacific, heights);
            dfs(i, cols-1, atlantic, heights);
        }
        for(int j=0; j<cols; j++){
            dfs(0, j, pacific, heights);
            dfs(rows-1, j, atlantic, heights);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(pacific[i][j] != null && pacific[i][j].equals(true)
                        && atlantic[i][j]!=null && atlantic[i][j].equals(true)){
                    ans.add(List.of(i, j));
                }
            }
        }
        return ans;
    }

    void dfs(int x, int y, Boolean[][] ocean, int[][] heights){
        if(ocean[x][y] == true) return;
        ocean[x][y] = true;
        for(int[] dir: dirs){
            int nextX = x+dir[0];
            int nextY = y+dir[1];

            if(nextX >= 0 && nextY >=0 &&
                    nextX < heights.length && nextY < heights[0].length &&
                    heights[x+dir[0]][y+dir[1]] >= heights[x][y]){

                dfs(x+dir[0], y+dir[1], ocean, heights);
            }
        }
    }
}