//You are given an n x n 2D matrix representing an image. 
//
// Rotate the image by 90 degrees (clockwise). 
//
// Note: 
//
// You have to rotate the image in-place, which means you have to modify the inp
//ut 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation. 
//
// Example 1: 
//
// 
//Given input matrix = 
//[
//  [1,2,3],
//  [4,5,6],
//  [7,8,9]
//],
//
//rotate the input matrix in-place such that it becomes:
//[
//  [7,4,1],
//  [8,5,2],
//  [9,6,3]
//]
// 
//
// Example 2: 
//
// 
//Given input matrix =
//[
//  [ 5, 1, 9,11],
//  [ 2, 4, 8,10],
//  [13, 3, 6, 7],
//  [15,14,12,16]
//], 
//
//rotate the input matrix in-place such that it becomes:
//[
//  [15,13, 2, 5],
//  [14, 3, 4, 1],
//  [12, 6, 8, 9],
//  [16, 7,10,11]
//]
// 
// Related Topics Array


package com.leetcode.editor.en;

import com.sun.org.apache.xalan.internal.xsltc.trax.SmartTransformerFactoryImpl;
import sun.security.krb5.internal.crypto.HmacMd5ArcFourCksumType;

public class RotateImage{
    public static void main(String[] args) {
       Solution solution = new RotateImage().new Solution();
       
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*
     * clockwise rotate
     * 1. first reverse up to down, then swap the symmetry
     * 1 2 3     7 8 9     7 4 1
     * 4 5 6  => 4 5 6  => 8 5 2
     * 7 8 9     1 2 3     9 6 3
     *
     * 2. first swap the symmetry, then reverse left to right
     * 1 2 3     1 4 7     7 4 1
     * 4 5 6  => 2 5 8  => 8 5 2
     * 7 8 9     3 6 9     9 6 3
     *
     * 3.clockwise 先外层再里层 top = left = 0; bot = right = 3;
     *  #1 四角先顺时针 [top][left] = [bot][left] tmp <- 1 / 1 <- 13 / 13 <- 16 / 16 <- 4 / 4 <- tmp
     *  #2 下一个数顺时针 [top][left + i] => [top + i][right - i] (i ∈ [0, n-1))
     *  #3 外层结束后内层 top++, left++; bot--, right--
     * 1  2  3  4      13 2  3  1     13 9  3  1
     * 5  6  7  8   => 5  6  7  8  => 5  6  7  2
     * 9  10 11 12     9  10 11 12    15 10 11 12
     * 13 14 15 16     16 14 15 4     16 14 8 4
     *
     *
     */

    /*
     * anticlockwise rotate
     * first swap the symmetry, then reverse left to right
     * 1 2 3     1 4 7     3 6 9
     * 4 5 6  => 2 5 8  => 2 5 8
     * 7 8 9     3 6 9     1 4 7
     */

    //法1
   /* public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int rows = matrix.length;
        int cols = matrix[0].length;
        //reverse up to down
        for(int first = 0, last = rows - 1; first < last; first++, last--) {
            int[] tmp = matrix[first];
            matrix[first] = matrix[last];
            matrix[last] = tmp;
        }
        // swap the symmetry
        for(int i = 0; i < rows; i++){
            for(int j = i + 1; j < cols; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }*/

    public void rotate(int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int rows = matrix.length;
        int cols = matrix[0].length;
        // swap the symmetry
        for(int i = 0; i < rows; i++){
            for(int j = i + 1; j < cols; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        //reverse left to right
        int n = 0;
        while (n < rows){
            for(int left = 0, right = cols - 1; left < right; left++, right--) {
                //Java数组是reference, 所以不能int temp传数组
                int tmp = matrix[n][left];
                matrix[n][left] = matrix[n][right];
                matrix[n][right] = tmp;
            }
            n++;
        }
    }

    //法3
    /*public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int top = 0, left = 0, bottom = matrix.length - 1, right = matrix.length -1;
        int n = matrix.length; //number of cells in one line
        while (n > 1){
            for(int i = 0; i < n - 1; i++){
                //没有±i的就是固定部分, 先外围再向内
                int tmp = matrix[top][left + i];
                matrix[top][left + i] = matrix[bottom - i][left];    // left -> top
                matrix[bottom - i][left] = matrix[bottom][right - i];// bottom -> left
                matrix[bottom][right - i] = matrix[top + i][right];  // right -> bottom
                matrix[top + i][right] = tmp;                        // top -> right
            }
            top++; left++;
            bottom--; right--;
            n -= 2;
        }
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)


}