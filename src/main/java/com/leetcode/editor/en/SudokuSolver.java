//Write a program to solve a Sudoku puzzle by filling the empty cells. 
//
// A sudoku solution must satisfy all of the following rules: 
//
// 
// Each of the digits 1-9 must occur exactly once in each row. 
// Each of the digits 1-9 must occur exactly once in each column. 
// Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-b
//oxes of the grid. 
// 
//
// Empty cells are indicated by the character '.'. 
//
// 
//A sudoku puzzle... 
//
// 
//...and its solution numbers marked in red. 
//
// Note: 
//
// 
// The given board contain only digits 1-9 and the character '.'. 
// You may assume that the given Sudoku puzzle will have a single unique solutio
//n. 
// The given board size is always 9x9. 
// 
// Related Topics Hash Table Backtracking


package com.leetcode.editor.en;

public class SudokuSolver{
    public static void main(String[] args) {
       Solution solution = new SudokuSolver().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    private boolean backtrack(char[][] board, int i, int j){
        int m = 9, n = 9;

        if(j == n){
            return backtrack(board, i + 1, 0);
        }

        //找到一个可行解，触发 base case; 0-8, 遍历到m说明已经全部遍历完
        if(i == m) return true;

        if(board[i][j] != '.'){
            return backtrack(board, i, j + 1);
        }

        for(char ch = '1'; ch <= '9'; ch++){
            if(!isValid(board, i, j, ch)) continue;
            board[i][j] = ch;
            if(backtrack(board, i, j + 1)) return true;
            board[i][j] = '.';
        }
        return false;
    }

    private boolean isValid(char[][] board, int r, int c, char n){
        for(int i = 0; i < 9; i++){
            if(board[r][i] == n) return false;
            if(board[i][c] == n) return false;
            if(board[(r / 3) * 3 + i / 3][(c / 3) * 3 + i % 3] == n) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}