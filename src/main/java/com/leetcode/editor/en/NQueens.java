//The n-queens puzzle is the problem of placing n queens on an n×n chessboard su
//ch that no two queens attack each other. 
//
// 
//
// Given an integer n, return all distinct solutions to the n-queens puzzle. 
//
// Each solution contains a distinct board configuration of the n-queens' placem
//ent, where 'Q' and '.' both indicate a queen and an empty space respectively. 
//
// Example: 
//
// 
//Input: 4
//Output: [
// [".Q..",  // Solution 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // Solution 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//Explanation: There exist two distinct solutions to the 4-queens puzzle as show
//n above.
// 
// Related Topics Backtracking


package com.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NQueens{
    public static void main(String[] args) {
       Solution solution = new NQueens().new Solution();
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private ArrayList<List<String>> res;
    private boolean[] col;
    private boolean[] dia1;
    private boolean[] dia2;

    public List<List<String>> solveNQueens(int n) {
        if(n == 0) return res;
        res = new ArrayList<List<String>>();
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];

        LinkedList<Integer> row = new LinkedList<Integer>();
        putQueens(n, 0, row);

        return res;
    }

    private void putQueens(int n, int index, LinkedList<Integer> row){
        if(index == n){
            res.add(generateBoard(n, row));
            return;
        }

        for(int i = 0 ; i < n ; i ++){
            // 尝试将第index行的皇后摆放在第i列
            if(!col[i] && !dia1[index + i] && !dia2[index - i + n - 1]){
                row.addLast(i);
                col[i] = true;
                dia1[index + i] = true;
                dia2[index - i + n - 1] = true;

                putQueens(n, index + 1, row);

                col[i] = false;
                dia1[index + i] = false;
                dia2[index - i + n - 1] = false;
                row.removeLast();
            }
        }
        return;
    }

    private List<String> generateBoard(int n, LinkedList<Integer> row){

        assert row.size() == n;

        ArrayList<String> board = new ArrayList<String>();
        for(int i = 0; i < n; i++){
            char[] charArray = new char[n];
            Arrays.fill(charArray, '.');
            charArray[row.get(i)] = 'Q';
            board.add(new String(charArray));
        }

        return board;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}