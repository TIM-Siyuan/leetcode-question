//A robot is located at the top-left corner of a m x n grid (marked 'Start' in t
//he diagram below). 
//
// The robot can only move either down or right at any point in time. The robot 
//is trying to reach the bottom-right corner of the grid (marked 'Finish' in the d
//iagram below). 
//
// How many possible unique paths are there? 
//
// 
//Above is a 7 x 3 grid. How many possible unique paths are there? 
//
// 
// Example 1: 
//
// 
//Input: m = 3, n = 2
//Output: 3
//Explanation:
//From the top-left corner, there are a total of 3 ways to reach the bottom-righ
//t corner:
//1. Right -> Right -> Down
//2. Right -> Down -> Right
//3. Down -> Right -> Right
// 
//
// Example 2: 
//
// 
//Input: m = 7, n = 3
//Output: 28
// 
//
// 
// Constraints: 
//
// 
// 1 <= m, n <= 100 
// It's guaranteed that the answer will be less than or equal to 2 * 10 ^ 9. 
// 
// Related Topics Array Dynamic Programming 
// 👍 3380 👎 211


package com.leetcode.editor.en;

public class UniquePaths{
    public static void main(String[] args) {
       Solution solution = new UniquePaths().new Solution();
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        for(int i = 0; i < m; ++i){ // row : up to down
            for(int j = 0; j < n; ++j){ // column: left to right
                // 初始值, 放在循环中可不需要额外判断结果不存在的情况
                if(i == 0 || j == 0){
                    f[i][j] = 1;
                }
                // 递推方程
                else{
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                }
            }
        }
        return f[m - 1][n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}