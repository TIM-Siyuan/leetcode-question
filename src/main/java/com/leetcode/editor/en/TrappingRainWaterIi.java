//Given an m x n matrix of positive integers representing the height of each uni
//t cell in a 2D elevation map, compute the volume of water it is able to trap aft
//er raining. 
//
// Example: 
//
// 
//Given the following 3x6 height map:
//[
//  [1,4,3,1,3,2],
//  [3,2,1,3,2,4],
//  [2,3,3,2,3,1]
//]
//
//Return 4.
// 
//
// 
//
// The above image represents the elevation map [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,
//3,3,2,3,1]] before the rain. 
//
// 
//
// 
//
// After the rain, water is trapped between the blocks. The total volume of wate
//r trapped is 4. 
//
// 
// Constraints: 
//
// 
// 1 <= m, n <= 110 
// 0 <= heightMap[i][j] <= 20000 
// 
// Related Topics Heap Breadth-first Search


package com.leetcode.editor.en;

import java.util.PriorityQueue;

public class TrappingRainWaterIi{
    public static void main(String[] args) {
       Solution solution = new TrappingRainWaterIi().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //BFS + 最小堆
    //能储水的面积由四周最矮的柱子决定
    private int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    class Cell implements Comparable<Cell>{
        int row, col, height;
        public Cell(int r, int c, int h){
            this.row = r;
            this.col = c;
            this.height = h;
        }

        public int compareTo(Cell otherCell){
            if(this.height == otherCell.height) return 0;
            if(this.height > otherCell.height) return 1;
            return -1;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        if(heightMap.length < 1) return 0;
        int m = heightMap.length, n = heightMap[0].length;
        PriorityQueue<Cell> heap = new PriorityQueue<>();
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < n; i++){
            visited[0][i] = true;
            visited[m - 1][i] = true;
            heap.offer(new Cell(0, i, heightMap[0][i]));
            heap.offer(new Cell(m - 1, i, heightMap[m - 1][i]));
        }

        for(int i = 0; i < m; i++){
            visited[i][0] = true;
            visited[i][n - 1] = true;
            heap.offer(new Cell(i, 0, heightMap[i][0]));
            heap.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
        }

        int res = 0;
        while (!heap.isEmpty()){
            Cell cur = heap.poll();
            int row = cur.row, col = cur.col, h = cur.height;

            for(int[] d : dirs){
                int r = d[0] + row;
                int c = d[1] + col;
                if(r > 0 && c > 0 && r < m - 1 && c < n - 1 && !visited[r][c]){
                    visited[r][c] = true;
                    res += Math.max(0, h - heightMap[r][c]);
                    heap.offer(new Cell(r, c, Math.max(h, heightMap[r][c])));
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}