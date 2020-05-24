//Given a triangle, find the minimum path sum from top to bottom. Each step you 
//may move to adjacent numbers on the row below. 
//
// For example, given the following triangle 
//
// 
//[
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11). 
//
// Note: 
//
// Bonus point if you are able to do this using only O(n) extra space, where n i
//s the total number of rows in the triangle. 
// Related Topics Array Dynamic Programming


package com.leetcode.editor.en;

import java.util.List;

public class Triangle{
    public static void main(String[] args) {
       Solution solution = new Triangle().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // top - bottom: value triangle itself
    public int minimumTotal(List<List<Integer>> triangle){
        if(triangle.size() == 0) return 0;

        for(int i = triangle.size() - 2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                List<Integer> nextRow = triangle.get(i + 1);
                int sum = Math.min(nextRow.get(j), nextRow.get(j + 1)) + triangle.get(i).get(j);
                triangle.get(i).set(j, sum);
            }
        }
        return triangle.get(0).get(0);
    }

    // bottom - top
    /*public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            dp[i] = triangle.get(n - 1).get(i);
        }
        for(int i = triangle.size() - 2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)


}