//You are given a map in form of a two-dimensional integer grid where 1 represen
//ts land and 0 represents water. 
//
// Grid cells are connected horizontally/vertically (not diagonally). The grid i
//s completely surrounded by water, and there is exactly one island (i.e., one or 
//more connected land cells). 
//
// The island doesn't have "lakes" (water inside that isn't connected to the wat
//er around the island). One cell is a square with side length 1. The grid is rect
//angular, width and height don't exceed 100. Determine the perimeter of the islan
//d. 
//
// 
//
// Example: 
//
// 
//Input:
//[[0,1,0,0],
// [1,1,1,0],
// [0,1,0,0],
// [1,1,0,0]]
//
//Output: 16
//
//Explanation: The perimeter is the 16 yellow stripes in the image below:
//
//
// 
// Related Topics Hash Table


package com.leetcode.editor.en;

public class IslandPerimeter{
    public static void main(String[] args) {
       Solution solution = new IslandPerimeter().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*public int islandPerimeter(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length, res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0) continue;
                //特判++res
                if(i == 0 || grid[i - 1][j] == 0) ++res;     //top
                if(i == m - 1 || grid[i + 1][j] == 0) ++res; //bottom
                if(j == 0 || grid[i][j - 1] == 0) ++res;     //left
                if(j == n - 1 || grid[i][j + 1] == 0) ++res; //right
            }
        }
        return res;
    }*/

    public int islandPerimeter(int[][] grid){
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length, res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0) continue;
                //默认+4, 假如左上有岛屿格子, 分别-2;
                res += 4;
                if(i > 0 && grid[i - 1][j] == 1) res -= 2;
                if(j > 0 && grid[i][j - 1] == 1) res -= 2;
            }
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


}