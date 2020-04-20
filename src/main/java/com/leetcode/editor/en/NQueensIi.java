//The n-queens puzzle is the problem of placing n queens on an n×n chessboard su
//ch that no two queens attack each other. 
//
// 
//
// Given an integer n, return the number of distinct solutions to the n-queens p
//uzzle. 
//
// Example: 
//
// 
//Input: 4
//Output: 2
//Explanation: There are two distinct solutions to the 4-queens puzzle as shown 
//below.
//[
// [".Q..",  // Solution 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // Solution 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
// 
// Related Topics Backtracking


package com.leetcode.editor.en;

import sun.plugin.dom.exception.BrowserNotSupportedException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueensIi{
    public static void main(String[] args) {
       Solution solution = new NQueensIi().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int res;
    private boolean[] col;
    private boolean[] dia1;
    private boolean[] dia2;

    public int totalNQueens(int n) {
        if(n == 0) return 0;
        res = 0;
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];

        countQueens(n, 0);

        return res;
    }

    private int countQueens(int n, int index) {
        if (index == n) {
            res += 1;
            return res;
        }

        for (int i = 0; i < n; i++) {
            // 尝试将第index行的皇后摆放在第i列
            if (!col[i] && !dia1[index + i] && !dia2[index - i + n - 1]) {
                col[i] = true;
                dia1[index + i] = true;
                dia2[index - i + n - 1] = true;

                countQueens(n, index + 1);

                col[i] = false;
                dia1[index + i] = false;
                dia2[index - i + n - 1] = false;
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}