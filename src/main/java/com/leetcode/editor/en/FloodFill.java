//
//An image is represented by a 2-D array of integers, each integer representing 
//the pixel value of the image (from 0 to 65535).
// 
//Given a coordinate (sr, sc) representing the starting pixel (row and column) o
//f the flood fill, and a pixel value newColor, "flood fill" the image.
// 
//To perform a "flood fill", consider the starting pixel, plus any pixels connec
//ted 4-directionally to the starting pixel of the same color as the starting pixe
//l, plus any pixels connected 4-directionally to those pixels (also with the same
// color as the starting pixel), and so on. Replace the color of all of the aforem
//entioned pixels with the newColor.
// 
//At the end, return the modified image.
// 
// Example 1: 
// 
//Input: 
//image = [[1,1,1],[1,1,0],[1,0,1]]
//sr = 1, sc = 1, newColor = 2
//Output: [[2,2,2],[2,2,0],[2,0,1]]
//Explanation: 
//From the center of the image (with position (sr, sc) = (1, 1)), all pixels con
//nected 
//by a path of the same color as the starting pixel are colored with the new col
//or.
//Note the bottom corner is not colored 2, because it is not 4-directionally con
//nected
//to the starting pixel.
// 
// 
//
// Note:
// The length of image and image[0] will be in the range [1, 50]. 
// The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < im
//age[0].length. 
// The value of each color in image[i][j] and newColor will be an integer in [0,
// 65535]. 
// Related Topics Depth-first Search


package com.leetcode.editor.en;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill{
    public static void main(String[] args) {
       Solution solution = new FloodFill().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//  法一: 使用queue,所以不是四联通的不会入队；使用双重for循环会遍历所有，将不是四联通的也改了
    private int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private boolean[][] visited;
    private int[][] image;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        this.image = image;
        if(oldColor == newColor) return image;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {sr, sc});
        visited = new boolean[image.length][image[0].length];
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int x = temp[0]; int y = temp[1];
            image[x][y] = newColor;
            for(int d = 0; d < dirs.length; d++){
                int nextx = x + dirs[d][0], nexty = y + dirs[d][1];
                /*if(!inArea(nextx, nexty) || image[nextx][nexty] != oldColor) {
                    continue;
                }*/
                if(inArea(nextx, nexty) && image[nextx][nexty] == oldColor && !visited[nextx][nexty]){
                    visited[nextx][nexty] = true;
                    queue.add(new int[]{nextx, nexty});
                }
            }
        }
        return image;
    }

    private boolean inArea(int x, int y){
        return x >= 0 && x < image.length && y >= 0 && y < image[0].length;
    }
/*
//  法二：递归，用for循环效率比四个if低
//    private int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
//    private int[][] image;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
//        this.image = image;
        int oldColor = image[sr][sc];
        if(oldColor != newColor){
            helper(image, sr, sc, newColor, oldColor);
        }
        return image;
    }

  *//*  private boolean inArea(int x, int y){
        return x >= 0 && x < image.length && y >= 0 && y < image[0].length;
    }*//*

    private void helper(int[][] image, int sr, int sc, int newColor, int oldColor){
        if(image[sr][sc] == oldColor){
            image[sr][sc] = newColor;
            *//*for(int d = 0; d < dirs.length; d++){
                int x = sr + dirs[d][0]; int y = sc + dirs[d][1];
                if(inArea(x, y)){
                    helper(image, x, y, newColor, oldColor);
                }
            }*//*
            if(sr-1 >= 0) helper(image, sr-1, sc, newColor, oldColor);
            if(sc-1 >= 0) helper(image, sr, sc-1, newColor, oldColor);
            if(sr+1 < image.length) helper(image, sr+1, sc, newColor, oldColor); //此处要用小于号，因为从0计数，sr+1 < length
            if(sc+1 < image[0].length) helper(image, sr, sc+1, newColor, oldColor);
        }
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)


}