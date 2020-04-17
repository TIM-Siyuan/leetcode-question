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

public class ColoringABorder{
    public static void main(String[] args) {
       Solution solution = new ColoringABorder().new Solution();
       
    }
//  tips: 使用队列, while只压入四向联通的点, 被孤立断开的点不会继续遍历;
//  使用两个for循环则会遍历所有的点, floodfill即使断开了也会遍历; 因为if不能屏蔽断开的
//  此题while, 需要设立isBorder标识, 标记边界的点，所以即使孤立了最后遍历时也会被改; 最后使用for循环再遍历所有的点;
//  用两个for循环，也需要标记;

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
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
            for(int d = 0; d < dirs.length; d++){
                int nextx = x + dirs[d][0]; int nexty = y + dirs[d][1];
                if(inArea(nextx, nexty) && grid[nextx][nexty] == oldColor && !visited[nextx][nexty]){
                    queue.add(new int[] {nextx, nexty});
                    visited[nextx][nexty] = true;
                }
                if(checkBorder(nextx, nexty) || grid[nextx][nexty] != oldColor) isBorder = true;
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
    }
    private boolean checkBorder(int x, int y){
        return x < 0 || y < 0 || x >= grid.length || y >= grid[0].length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}