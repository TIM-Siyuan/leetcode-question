//Given an integer array nums, find the contiguous subarray within an array (con
//taining at least one number) which has the largest product. 
//
// Example 1: 
//
// 
//Input: [2,3,-2,4]
//Output: 6
//Explanation: [2,3] has the largest product 6.
// 
//
// Example 2: 
//
// 
//Input: [-2,0,-1]
//Output: 0
//Explanation: The result cannot be 2, because [-2,-1] is not a subarray. 
// Related Topics Array Dynamic Programming


package com.leetcode.editor.en;

public class MaximumProductSubarray{
    public static void main(String[] args) {
       Solution solution = new MaximumProductSubarray().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 存在负数所以滑动窗口没有用, tips学到了dp可以记录两个状态
   /* public int maxProduct(int[] nums) {
        int n = nums.length;
        int res = nums[0];

        for(int i = 1, imax = res, imin = res; i < n; ++i){
            if(nums[i] < 0){
                int temp = imin;
                imin = imax;
                imax = temp;
            }
            // max/min product for the current number is either the current number itself
            // or the max/min by the previous number times the current one
            imax = Math.max(nums[i], nums[i] * imax);
            imin = Math.min(nums[i], nums[i] * imin);

            res = Math.max(res, imax);
        }
        return res;
    }*/

    // Kadene's Algorithm: 本质将数组分段, 求出每段的最大值并记录 —— 知道何时分段
    // 与加法不同, 乘法无法知道遇到负号时是否可以分段 —— 有可能可以加进去, 有可能不行
    // 所以乘法哪段最大通过prefix和suffix共同判断(重合时), 所以需要两个参数, 遇到0自然分段只取自己;
    public int maxProduct(int[] nums){
        int prefix = 0, suffix = 0, cur = nums[0], n = nums.length;
        for(int i = 0; i < n; ++i){
            prefix = (prefix == 0 ? 1 : prefix)  * nums[i];
            suffix = (suffix == 0 ? 1 : suffix)  * nums[n - 1 - i];
            cur = Math.max(cur, Math.max(prefix, suffix));
        }
        return cur;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}