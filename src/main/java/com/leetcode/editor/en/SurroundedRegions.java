//Given a 2D board containing 'X' and 'O' (the letter O), capture all regions su
//rrounded by 'X'. 
//
// A region is captured by flipping all 'O's into 'X's in that surrounded region
//. 
//
// Example: 
//
// 
//X X X X
//X O O X
//X X O X
//X O X X
// 
//
// After running your function, the board should be: 
//
// 
//X X X X
//X X X X
//X X X X
//X O X X
// 
//
// Explanation: 
//
// Surrounded regions shouldn’t be on the border, which means that any 'O' on th
//e border of the board are not flipped to 'X'. Any 'O' that is not on the border 
//and it is not connected to an 'O' on the border will be flipped to 'X'. Two cell
//s are connected if they are adjacent cells connected horizontally or vertically.
// 
// Related Topics Depth-first Search Breadth-first Search Union Find


package com.leetcode.editor.en;

public class SurroundedRegions{
    public static void main(String[] args) {
       Solution solution = new SurroundedRegions().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void solve(char[][] board) {
        if(board.length == 0) return;
        int m = board.length;
        int n = board[0].length;
        // 给 dummy 留一个额外位置
        UnionFind uf = new UnionFind(m * n + 1);
        int dummy = m * n;

        // 将首列和末列的 O 与 dummy 连通
        for(int i = 0; i < m; i++){
            if(board[i][0] == 'O')
                // i * n + 0
                uf.union(i * n, dummy);
            if(board[i][n - 1] == 'O')
                uf.union(i * n + n - 1, dummy);
        }
        // 将首行和末行的 O 与 dummy 连通
        for(int j = 0; j < n; j++){
            if(board[0][j] == 'O')
                // 0 * (m - 1) + j
                uf.union(j, dummy);
            if(board[m - 1][j] == 'O')
                uf.union(n * (m - 1) + j, dummy);
        }

        int[][] d = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        //遍历非四边的格子
        for(int i = 1; i < m - 1; i++){
            for(int j = 1; j < n - 1; j++){
                if(board[i][j] == 'O'){
                    //找到一个遍历其四个方向, 将其连通
                    for(int k = 0; k < 4; k++){
                        int x = i + d[k][0];
                        int y = j + d[k][1];
                        //假如跟边界有连通, 则同样会跟dummy连通, 所以只会留下完全没有连通的
                        if(board[x][y] == 'O')
                            uf.union(x * n + y, i * n + j);
                    }
                }
            }
        }

        // 所有不和 dummy 连通的 O，都要被替换
        for(int i = 1; i < m - 1; i++){
            for(int j = 1; j < n - 1; j++){
                if(!uf.connected(dummy, i * n + j))
                    board[i][j] = 'X';
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}