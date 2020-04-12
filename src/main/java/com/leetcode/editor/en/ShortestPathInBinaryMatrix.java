//In an N by N square grid, each cell is either empty (0) or blocked (1). 
//
// A clear path from top-left to bottom-right has length k if and only if it is 
//composed of cells C_1, C_2, ..., C_k such that: 
//
// 
// Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are d
//ifferent and share an edge or corner) 
// C_1 is at location (0, 0) (ie. has value grid[0][0]) 
// C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1]) 
// If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0). 
//
// 
//
// Return the length of the shortest such clear path from top-left to bottom-rig
//ht. If such a path does not exist, return -1. 
//
// 
//
// Example 1: 
//
// 
//Input: [[0,1],[1,0]]
//
//
//Output: 2
//
// 
//
// 
// Example 2: 
//
// 
//Input: [[0,0,0],[1,1,0],[1,1,0]]
//
//
//Output: 4
//
// 
//
// 
// 
//
// Note: 
//
// 
// 1 <= grid.length == grid[0].length <= 100 
// grid[r][c] is 0 or 1 
// 
// Related Topics Breadth-first Search


package com.leetcode.editor.en;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix{
    public static void main(String[] args) {
       Solution solution = new ShortestPathInBinaryMatrix().new Solution();
       int[][] graph = {{0,1}, {1,0}};
       solution.shortestPathBinaryMatrix(graph);
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int R, C;
    private int[][] dirs ={{-1, 0}, {-1, 1}, {0, 1}, {0, -1},
                        {1, 0}, {1, 1}, {1, -1}, {-1, -1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        R = grid.length;
        C = grid[0].length;

        boolean[][] visited = new boolean[R][C];
        int[][] dis = new int[R][C];

        if(grid[0][0] == 1) return -1;
        if(R == 1 && C == 1) return 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0][0] = true;
        dis[0][0] = 1;
        while (!queue.isEmpty()){
            int cur = queue.remove();
            int curx = cur / C, cury = cur % C;
            for(int d = 0; d < 8; d++){
                int nextx = curx + dirs[d][0];
                int nexty = cury + dirs[d][1];
                if(inArea(nextx, nexty) && !visited[nextx][nexty] && grid[nextx][nexty] == 0){
                    queue.add(nextx * C + nexty);
                    visited[nextx][nexty] = true;
                    dis[nextx][nexty] = dis[curx][cury] + 1;
                    if(nextx == R - 1 && nexty == C - 1){
                        return dis[nextx][nexty];
                    }
                }
            }
        }
        return -1;
    }

    private boolean inArea(int x, int y){
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}