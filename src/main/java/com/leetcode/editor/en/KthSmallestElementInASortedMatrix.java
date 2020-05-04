//Given a n x n matrix where each of the rows and columns are sorted in ascendin
//g order, find the kth smallest element in the matrix. 
//
// 
//Note that it is the kth smallest element in the sorted order, not the kth dist
//inct element.
// 
//
// Example:
// 
//matrix = [
//   [ 1,  5,  9],
//   [10, 11, 13],
//   [12, 13, 15]
//],
//k = 8,
//
//return 13.
// 
// 
//
// Note: 
//You may assume k is always valid, 1 ≤ k ≤ n2. Related Topics Binary Search Hea
//p


package com.leetcode.editor.en;

public class KthSmallestElementInASortedMatrix{
    public static void main(String[] args) {
       Solution solution = new KthSmallestElementInASortedMatrix().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix.length == 0) return 0;
        if(matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int left = matrix[0][0], right = matrix[m - 1][n - 1];
        //因为寻找右侧边界
        while(left < right){
            int mid = left + (right - left) / 2;
            //因为并不是蛇形排列, 有可能一行尾数比下一行首要大, 所以不能直接二分排序
            //利用二分的思想计算mid的位置, 再使用二分选择k所在的部分, 最后夹逼到k
            //count记录当前的数是第几小的数, 跟k比较从而更新binary search的左右边界
            int count = search_less_equal(matrix, mid);
            if(count < k){
                left = mid + 1;
            }
            //可能会有重复的元素;
            else if(count >= k){
                right = mid;
            }
        }
        return left;
    }
    //每列也是有序的, 所以从左下角开始, 减少需要计算的个数, 不用每行都二分
    private int search_less_equal(int[][] matrix, int target){
        int n = matrix.length, i = n - 1, j = 0, res = 0;
        while (i >= 0 && j < n){
            if(matrix[i][j] <= target){
                res += i + 1;
                j++;
            }
            else {
                i--;
            }
        }
        return res;
    }
    /*//upper_bound == 寻找右侧边界; 所以mid相等时left = mid + 1向右逼近
    private int binarySearch(int[][] matrix, int target, int n){
        int ret = 0;
        for(int[] mx : matrix){
            int left = 0, right = n - 1;
            while (left <= right){
                //也可以写成 int mid = (left + right) >>> 1 无符号右移相当于除2
                int mid = left + (right - left) / 2;
                if(mx[mid] > target){
                    right = mid - 1;
                }
                else{ //mx[mid] <= target
                    left = mid + 1;
                }
            }
            ret += left;
        }
        return ret;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)


}