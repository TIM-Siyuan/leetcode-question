//Given an integer array nums, find the contiguous subarray (containing at least
// one number) which has the largest sum and return its sum. 
//
// Example: 
//
// 
//Input: [-2,1,-3,4,-1,2,1,-5,4],
//Output: 6
//Explanation: [4,-1,2,1] has the largest sum = 6.
// 
//
// Follow up: 
//
// If you have figured out the O(n) solution, try coding another solution using 
//the divide and conquer approach, which is more subtle. 
// Related Topics Array Divide and Conquer Dynamic Programming


package com.leetcode.editor.en;

public class MaximumSubarray{
    public static void main(String[] args) {
       Solution solution = new MaximumSubarray().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //法一: 暴力解法: 双重for循环, 每遍历一个数字, 就计算这个数字为首的所有子数组和 O(n^2) --> 太多重复计算, DP利用记忆化优化
    //法二: Kadane Algorithm: 求最大子数组和 --> 计算并记录一个区间能到的最大值, 只需要遍历一遍, 不满足增长条件则重新开始计算区间和
    //curSum选择是否包含之前的区间, 还是选nums[i]为新的区间首部; --> curSum为负的时候, 不包含前区间才更大, 所以也可用 if (currSum < 0) currSum = 0; currSum += num;
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int res = Integer.MIN_VALUE, curSum = 0;
        for(int i = 0; i < n; i++){
            curSum = Math.max(curSum + nums[i], nums[i]);
            res = Math.max(res, curSum);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}