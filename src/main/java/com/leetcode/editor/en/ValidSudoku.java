//Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be val
//idated according to the following rules: 
//
// 
// Each row must contain the digits 1-9 without repetition. 
// Each column must contain the digits 1-9 without repetition. 
// Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without r
//epetition. 
// 
//
// 
//A partially filled sudoku which is valid. 
//
// The Sudoku board could be partially filled, where empty cells are filled with
// the character '.'. 
//
// Example 1: 
//
// 
//Input:
//[
//  ["5","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//Output: true
// 
//
// Example 2: 
//
// 
//Input:
//[
//  ["8","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//Output: false
//Explanation: Same as Example 1, except with the 5 in the top left corner being
// 
//    modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is 
//invalid.
// 
//
// Note: 
//
// 
// A Sudoku board (partially filled) could be valid but is not necessarily solva
//ble. 
// Only the filled cells need to be validated according to the mentioned rules. 
//
// The given board contain only digits 1-9 and the character '.'. 
// The given board size is always 9x9. 
// 
// Related Topics Hash Table


package com.leetcode.editor.en;

public class ValidSudoku{
    public static void main(String[] args) {
       Solution solution = new ValidSudoku().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            int[] row_map = new int[9];
            int[] col_map = new int[9];
            int[] box_map = new int[9];
            for(int j = 0; j < 9; j++){
                char row = board[i][j];
                char col = board[j][i];
                //row: j / 3; col: j % 3 --> 遍历大方框内行列;
                char box = board[j / 3 + 3 * (i / 3)][j % 3 + 3 * (i % 3)];
                if(row != '.'){
                    if(row_map[row - '1'] > 0) return false;
                    else row_map[row - '1']++;
                }
                if(col != '.'){
                    if(col_map[col - '1'] > 0) return false;
                    else col_map[col - '1']++;
                }
                if(box != '.'){
                    if(box_map[box - '1'] > 0) return false;
                    else box_map[box - '1']++;
                }
            }
        }
        return true;
        /* for(int box = 0; box < 9; box++){
            int[] map = new int[9];
            for(int row = 0; row < 3; row++){
                for (int col = 0; col < 3; col++){
                    char c = board[row + 3 * (box / 3)][col + 3 * (box % 3)];
                    if(c != '.'){
                        if(map[c - '1'] > 0) return false;
                        else map[c - '1']++;
                    }
                }
            }
        }*/
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}