//A robot is located at the top-left corner of a m x n grid (marked 'Start' in t
//he diagram below). 
//
// The robot can only move either down or right at any point in time. The robot 
//is trying to reach the bottom-right corner of the grid (marked 'Finish' in the d
//iagram below). 
//
// Now consider if some obstacles are added to the grids. How many unique paths 
//would there be? 
//
// 
//
// An obstacle and empty space is marked as 1 and 0 respectively in the grid. 
//
// Note: m and n will be at most 100. 
//
// Example 1: 
//
// 
//Input:
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//Output: 2
//Explanation:
//There is one obstacle in the middle of the 3x3 grid above.
//There are two ways to reach the bottom-right corner:
//1. Right -> Right -> Down -> Down
//2. Down -> Down -> Right -> Right
// 
// Related Topics Array Dynamic Programming 
// 👍 1836 👎 245


package com.leetcode.editor.en;

public class UniquePathsIi{
    public static void main(String[] args) {
       Solution solution = new UniquePathsIi().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if(m == 0){
            return 0;
        }

        int n = obstacleGrid[0].length;
        if(n == 0){
            return 0;
        }

        int[][] f = new int[m][n];
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                // 有阻碍则设为0
                if(obstacleGrid[i][j] == 1){
                    f[i][j] = 0;
                } else{
                    if(i == 0 && j == 0){
                        f[i][j] = 1;
                    } else {
                        //方便同时处理第一行与第一列
                        f[i][j] = 0;
                        if(i - 1 >= 0){
                            f[i][j] += f[i - 1][j];
                        }
                        if(j - 1 >= 0){
                            f[i][j] += f[i][j - 1];
                        }
                    }
                }
            }
        }
        return f[m - 1][n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}