//Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle c
//ontaining only 1's and return its area. 
//
// Example: 
//
// 
//Input:
//[
//  ["1","0","1","0","0"],
//  ["1","0","1","1","1"],
//  ["1","1","1","1","1"],
//  ["1","0","0","1","0"]
//]
//Output: 6
// 
// Related Topics Array Hash Table Dynamic Programming Stack


package com.leetcode.editor.en;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximalRectangle{
    public static void main(String[] args) {
       Solution solution = new MaximalRectangle().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[] heights = new int[col];
        int max = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j] == '1') heights[j]++;
                else heights[j] = 0;
            }
            int area = largestRectangleArea(heights);
            max = Math.max(max, area);
        }
        return max;
    }

    public int largestRectangleArea(int[] heights){
        int n = heights.length;
        Deque<Integer> stk = new ArrayDeque<>();
        stk.push(-1); //为了最后计算index=0的宽度
        int max = 0;
        for(int i = 0; i < n; i++){
            while (stk.peek() != -1 && heights[stk.peek()] >= heights[i]){
                max = Math.max(max, heights[stk.pop()] * (i - stk.peek() - 1));
            }
            stk.push(i);
        }

        while (stk.peek() != -1){
            max = Math.max(max, heights[stk.pop()] * (n - stk.peek() - 1));
        }

        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}