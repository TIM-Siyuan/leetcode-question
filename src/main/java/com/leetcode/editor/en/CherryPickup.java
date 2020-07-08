//In a N x N grid representing a field of cherries, each cell is one of three po
//ssible integers. 
//
// 
//
// 
// 0 means the cell is empty, so you can pass through; 
// 1 means the cell contains a cherry, that you can pick up and pass through; 
// -1 means the cell contains a thorn that blocks your way. 
// 
//
// 
//
// Your task is to collect maximum number of cherries possible by following the 
//rules below: 
//
// 
//
// 
// Starting at the position (0, 0) and reaching (N-1, N-1) by moving right or do
//wn through valid path cells (cells with value 0 or 1); 
// After reaching (N-1, N-1), returning to (0, 0) by moving left or up through v
//alid path cells; 
// When passing through a path cell containing a cherry, you pick it up and the 
//cell becomes an empty cell (0); 
// If there is no valid path between (0, 0) and (N-1, N-1), then no cherries can
// be collected. 
// 
//
// 
//
// 
//
// Example 1: 
//
// 
//Input: grid =
//[[0, 1, -1],
// [1, 0, -1],
// [1, 1,  1]]
//Output: 5
//Explanation: 
//The player started at (0, 0) and went down, down, right right to reach (2, 2).
//
//4 cherries were picked up during this single trip, and the matrix becomes [[0,
//1,-1],[0,0,-1],[0,0,0]].
//Then, the player went left, up, up, left to return home, picking up one more c
//herry.
//The total number of cherries picked up is 5, and this is the maximum possible.
//
// 
//
// 
//
// Note: 
//
// 
// grid is an N by N 2D array, with 1 <= N <= 50. 
// Each grid[i][j] is an integer in the set {-1, 0, 1}. 
// It is guaranteed that grid[0][0] and grid[N-1][N-1] are not -1. 
// 
// 
// 
// 
// Related Topics Dynamic Programming 
// 👍 941 👎 71


package com.leetcode.editor.en;

import java.util.Arrays;

public class CherryPickup{
    public static void main(String[] args) {
       Solution solution = new CherryPickup().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*private int[][] grid;
    private int[][][] memo;
    public int cherryPickup(int[][] grid) {
        this.grid = grid;
        int m = grid.length;
        int n = grid[0].length;
        memo = new int[m][n][n];
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                Arrays.fill(memo[i][j], Integer.MIN_VALUE);
        return Math.max(0, dp(n - 1, m - 1, n - 1));
    }

    private int dp(int x1, int y1, int x2) {
        final int y2 = x1 + y1 - x2;
        if (x1 < 0 || y1 < 0 || x2 < 0 || y2 < 0) return -1;
        if (grid[y1][x1] < 0 || grid[y2][x2] < 0) return -1;
        if (x1 == 0 && y1 == 0) return grid[y1][x1];
        if (memo[y1][x1][x2] != Integer.MIN_VALUE) return memo[y1][x1][x2];
        memo[y1][x1][x2] = Math.max(Math.max(dp(x1 - 1, y1, x2 - 1), dp(x1, y1 - 1, x2)),
                Math.max(dp(x1, y1 - 1, x2 - 1), dp(x1 - 1, y1, x2)));

        if (memo[y1][x1][x2] >= 0) {
            memo[y1][x1][x2] += grid[y1][x1];
            if (x1 != x2) memo[y1][x1][x2] += grid[y2][x2];
        }

        return memo[y1][x1][x2];
    }*/

    public int cherryPickup(int[][] grid){
        int N = grid.length, M = (N << 1) - 1;
        int[][] dp = new int[N][N];
        dp[0][0] = grid[0][0];
        for(int n = 1; n < M; n++){
            for(int i = N - 1; i >= 0; i--){
                for(int p = N - 1; p >= 0; p--){
                    int j = n - i, q = n - p;

                    if(j < 0 || j >= N || q < 0 || q >= N || grid[i][j] < 0 || grid[p][q] < 0){
                        dp[i][p] = -1;
                        continue;
                    }

                    if(i > 0) dp[i][p] = Math.max(dp[i][p], dp[i - 1][p]);
                    if(p > 0) dp[i][p] = Math.max(dp[i][p], dp[i][p - 1]);
                    if(i > 0 && p > 0) dp[i][p] = Math.max(dp[i][p], dp[i -1][p - 1]);

                    if(dp[i][p] >= 0) dp[i][p] += grid[i][j] + (i != p ? grid[p][q] : 0);
                }
            }
        }
        return Math.max(dp[N - 1][N - 1], 0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}