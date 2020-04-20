//Given a 2D board and a word, find if the word exists in the grid. 
//
// The word can be constructed from letters of sequentially adjacent cell, where
// "adjacent" cells are those horizontally or vertically neighboring. The same let
//ter cell may not be used more than once. 
//
// Example: 
//
// 
//board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//Given word = "ABCCED", return true.
//Given word = "SEE", return true.
//Given word = "ABCB", return false.
// 
//
// 
// Constraints: 
//
// 
// board and word consists only of lowercase and uppercase English letters. 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 1 <= word.length <= 10^3 
// 
// Related Topics Array Backtracking


package com.leetcode.editor.en;

public class WordSearch{
    public static void main(String[] args) {
       Solution solution = new WordSearch().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private char[][] board;
    private int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1, 0}};
    private boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        if(board == null || word == null) return false;
        if(board.length == 0) return false;
        if(board[0].length == 0) return false;
        this.board = board;
        visited = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(searchWord(board, i, j,0, word))
                    return true;
            }
        }
        return false;
    }

    private boolean searchWord(char[][] board, int x, int y, int index, String word){
        if(index == word.length() - 1){
            return board[x][y] == word.charAt(index);
        }

        if(board[x][y] == word.charAt(index)){
            visited[x][y] = true;

            for(int d = 0; d < dirs.length; d++){
                int nx = x + dirs[d][0]; int ny = y + dirs[d][1];
                if(inArea(nx, ny) && !visited[nx][ny] && searchWord(board, nx, ny, index + 1, word)){
                        return true;
                }
            }

            visited[x][y] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y){
        return x >= 0 && x < board.length && y >=0 && y < board[0].length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}