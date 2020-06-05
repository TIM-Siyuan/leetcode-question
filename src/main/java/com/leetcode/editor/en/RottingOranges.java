//In a given grid, each cell can have one of three values: 
//
// 
// the value 0 representing an empty cell; 
// the value 1 representing a fresh orange; 
// the value 2 representing a rotten orange. 
// 
//
// Every minute, any fresh orange that is adjacent (4-directionally) to a rotten
// orange becomes rotten. 
//
// Return the minimum number of minutes that must elapse until no cell has a fre
//sh orange. If this is impossible, return -1 instead. 
//
// 
//
// 
// Example 1: 
//
// 
//
// 
//Input: [[2,1,1],[1,1,0],[0,1,1]]
//Output: 4
// 
//
// 
// Example 2: 
//
// 
//Input: [[2,1,1],[0,1,1],[1,0,1]]
//Output: -1
//Explanation:  The orange in the bottom left corner (row 2, column 0) is never 
//rotten, because rotting only happens 4-directionally.
// 
//
// 
// Example 3: 
//
// 
//Input: [[0,2]]
//Output: 0
//Explanation:  Since there are already no fresh oranges at minute 0, the answer
// is just 0.
// 
//
// 
//
// Note: 
//
// 
// 1 <= grid.length <= 10 
// 1 <= grid[0].length <= 10 
// grid[i][j] is only 0, 1, or 2. 
// 
// 
// 
// 
// Related Topics Breadth-first Search


package com.leetcode.editor.en;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges{
    public static void main(String[] args) {
       Solution solution = new RottingOranges().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        private int[][] grid;
        public int orangesRotting(int[][] grid) {
            if(grid == null || grid.length == 0) {
                return -1;
            }
            this.grid = grid;
            int m = grid.length, n = grid[0].length, count = 0, fresh = 0;
            Queue<Integer> q = new LinkedList<>();
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(grid[i][j] == 2){
                        q.offer(i * n + j); //二维转一维
                    }
                    if(grid[i][j] == 1){
                        //使用fresh记录freshOranges的个数, 这样bfs之后无需再次遍历查看是否还有fresh无法被rotten
                        fresh++;
                    }
                }
            }
            //假如0min就没有fresh, 直接返回 or while循环中设置条件if(fresh > 0), 否则count++; 例:[[0,2]]
            /*if(fresh == 0){
                return 0;
            }*/
            while(!q.isEmpty()){
                if(fresh > 0){
                    int size = q.size();
                    for(int i = 0; i < size; i++){
                        int cur = q.poll();
                        int x = cur / n;
                        int y = cur % n;
                        for(int[] dir : dirs){
                            int nextX = x + dir[0];
                            int nextY = y + dir[1];
                            if(inArea(nextX, nextY) && grid[nextX][nextY] == 1){
                                grid[nextX][nextY] = 2;
                                q.offer(nextX * n + nextY);
                                fresh--;
                            }
                        }
                    }
                    count++;
                }
                //无fresh及时退出
                if(fresh == 0){
                    break;
                }
            }
            return fresh == 0 ? count : -1;
        }

        private boolean inArea(int x, int y){
            return x >= 0 && x <= grid.length - 1 && y >= 0 && y <= grid[0].length - 1;
        }
}
//leetcode submit region end(Prohibit modification and deletion)


}