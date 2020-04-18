//Given a 2d grid map of '1's (land) and '0's (water), count the number of islan
//ds. An island is surrounded by water and is formed by connecting adjacent lands 
//horizontally or vertically. You may assume all four edges of the grid are all su
//rrounded by water. 
//
// Example 1: 
//
// 
//Input:
//11110
//11010
//11000
//00000
//
//Output: 1
// 
//
// Example 2: 
//
// 
//Input:
//11000
//11000
//00100
//00011
//
//Output: 3
// Related Topics Depth-first Search Breadth-first Search Union Find


package com.leetcode.editor.en;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands{
    public static void main(String[] args) {
       Solution solution = new NumberOfIslands().new Solution();
       char[][] g = {{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}};
       char[][] g1 = {};
       solution.numIslands(g1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//  DFS
    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private boolean[][] visited;
    private char[][] grid;
    public int numIslands(char[][] grid) {
        int res = 0;
        if(grid.length == 0) return res;
        int R = grid.length;
        if(grid[0].length == 0) return res;
        int C = grid[0].length;
        if(R == 0 && C == 0) return res;
        this.grid = grid;
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[R][C];

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(grid[i][j] - '0' == 1 && !visited[i][j]){
                    res++;
                    visited[i][j] = true;
                    queue.add(new int[] {i, j});
                    while (!queue.isEmpty()){
                        int[] temp = queue.poll();
                        int r = temp[0];
                        int c = temp[1];
                        for(int[] dir : dirs){
                            int rNew = r + dir[0]; int cNew = c + dir[1];
                            if(inArea(rNew, cNew) && grid[rNew][cNew] - '0' == 1 && !visited[rNew][cNew]) {
                                visited[rNew][cNew] = true;
                                queue.add(new int[] {rNew, cNew});
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    private boolean inArea(int x, int y){
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}