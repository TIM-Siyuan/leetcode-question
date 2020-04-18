//Given a 2-dimensional grid of integers, each value in the grid represents the 
//color of the grid square at that location. 
//
// Two squares belong to the same connected component if and only if they have t
//he same color and are next to each other in any of the 4 directions. 
//
// The border of a connected component is all the squares in the connected compo
//nent that are either 4-directionally adjacent to a square not in the component, 
//or on the boundary of the grid (the first or last row or column). 
//
// Given a square at location (r0, c0) in the grid and a color, color the border
// of the connected component of that square with the given color, and return the 
//final grid. 
//
// 
//
// Example 1: 
//
// 
//Input: grid = [[1,1],[1,2]], r0 = 0, c0 = 0, color = 3
//Output: [[3, 3], [3, 2]]
// 
//
// 
// Example 2: 
//
// 
//Input: grid = [[1,2,2],[2,3,2]], r0 = 0, c0 = 1, color = 3
//Output: [[1, 3, 3], [2, 3, 3]]
// 
//
// 
// Example 3: 
//
// 
//Input: grid = [[1,1,1],[1,1,1],[1,1,1]], r0 = 1, c0 = 1, color = 2
//Output: [[2, 2, 2], [2, 1, 2], [2, 2, 2]] 
// 
// 
//
// 
//
// Note: 
//
// 
// 1 <= grid.length <= 50 
// 1 <= grid[0].length <= 50 
// 1 <= grid[i][j] <= 1000 
// 0 <= r0 < grid.length 
// 0 <= c0 < grid[0].length 
// 1 <= color <= 1000 
// Related Topics Depth-first Search


package com.leetcode.editor.en;

import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Math.abs;

public class ColoringABorder{
    public static void main(String[] args) {
       Solution solution = new ColoringABorder().new Solution();
       int[][] g = {{1,1,1,1,2,2},{3,3,3,3,3,2},{3,3,3,2,3,3},{3,3,2,3,3,3},{3,2,2,2,3,3},{3,2,2,2,3,3},{3,3,2,2,3,3}};
       solution.colorBorder(g, 5,1, 4);
    }
//  tips: 使用队列, while只压入四向联通的点, 被孤立断开的点不会继续遍历;
//  使用两个for循环则会遍历所有的点, floodfill即使断开了也会遍历; 因为if不能屏蔽断开的
//  1.while, 需要设立isBorder标识, 标记边界的点，所以即使孤立了最后遍历时也会被改; 最后使用for循环再遍历所有的点;
//  2.用两个for循环，也需要标记;
//  先获取联通点，假如是边界则改色：DFS+判断是否边界

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//  法一
    /*private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private boolean[][] visited;
    private int[][] grid;
    private boolean[][] border;
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int oldColor = grid[r0][c0];
        if(oldColor == color) return grid;
        this.grid = grid;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {r0, c0});
        visited = new boolean[grid.length][grid[0].length];
        border = new boolean[grid.length][grid[0].length];
        visited[r0][c0] = true;

        while (!queue.isEmpty()){
            int[] temp = queue.remove();
            int x = temp[0];
            int y = temp[1];
            boolean isBorder = false;
            //先判断是否联通
            for(int d = 0; d < dirs.length; d++){
                int nextx = x + dirs[d][0]; int nexty = y + dirs[d][1];
                if(inArea(nextx, nexty) && grid[nextx][nexty] == oldColor && !visited[nextx][nexty]){
                    queue.add(new int[] {nextx, nexty});
                    visited[nextx][nexty] = true;
                }
                //因为压入的点已判断了属于联通区域；所以处于grid边界或者处于不同颜色边界；OR判断两个条件
                //判断是否边界: 1.移动后不在边界，则原来的点在边界上; 2.移动后颜色不同，说明不是四联通的点，则在联通区域边界
                if(!inArea(nextx, nexty) || grid[nextx][nexty] != oldColor) isBorder = true;
            }

            if(isBorder) border[x][y] = isBorder;
        }

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(border[i][j]) grid[i][j] = color;
            }
        }
        return grid;
    }

    private boolean inArea(int x, int y){
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }*/

//  简洁写法：时间复杂度O(M*N) 空间复杂度(1)
    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        dfs(grid, r0, c0, grid[r0][c0]);
        //遍历所有点，根据-1改色;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] < 0){
                    grid[i][j] = color;
                }
            }
        }
        return grid;
    }
    private void dfs(int[][] grid, int r, int c, int oldColor){
        grid[r][c] = -oldColor;
        //寻找联通点：联通设为-1

        for(int[] dir : dirs){
            int rNew = r + dir[0];
            int cNew = c + dir[1];
            if(rNew >= 0 && rNew < grid.length && cNew >= 0 && cNew < grid[0].length){
                if(grid[rNew][cNew] == oldColor){
                    dfs(grid, rNew, cNew, oldColor);
                }
            }
        }

        //判断是否边界
        if(r > 0 && r < grid.length - 1 && c > 0 && c < grid[0].length - 1){
            //都联通，不是边界则不改变颜色
            if(abs(grid[r - 1][c]) == oldColor &&
               abs(grid[r + 1][c]) == oldColor &&
               abs(grid[r][c - 1]) == oldColor &&
               abs(grid[r][c + 1]) == oldColor){
                grid[r][c] = oldColor;
            }
        }
        return;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}