//You are given a list of non-negative integers, a1, a2, ..., an, and a target, 
//S. Now you have 2 symbols + and -. For each integer, you should choose one from 
//+ and - as its new symbol. 
//
// Find out how many ways to assign symbols to make sum of integers equal to tar
//get S. 
//
// Example 1: 
//
// 
//Input: nums is [1, 1, 1, 1, 1], S is 3. 
//Output: 5
//Explanation: 
//
//-1+1+1+1+1 = 3
//+1-1+1+1+1 = 3
//+1+1-1+1+1 = 3
//+1+1+1-1+1 = 3
//+1+1+1+1-1 = 3
//
//There are 5 ways to assign symbols to make the sum of nums be target 3.
// 
//
// 
// Constraints: 
//
// 
// The length of the given array is positive and will not exceed 20. 
// The sum of elements in the given array will not exceed 1000. 
// Your output answer is guaranteed to be fitted in a 32-bit integer. 
// 
// Related Topics Dynamic Programming Depth-first Search 
// 👍 2627 👎 110


package com.leetcode.editor.en;

import java.util.HashMap;

public class TargetSum{
    public static void main(String[] args) {
       Solution solution = new TargetSum().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*private int result = 0;
    public int findTargetSumWays(int[] nums, int S) {
        if(nums.length == 0){
            return 0;
        }
        backtracking(nums, 0, S);
        return result;
    }
    //O(2^N)
    public void backtracking(int[] nums, int i, int rest){
        if(i == nums.length){
            // 如何凑出target = 如何把target减到0;
            // 这样少传一个参数, 所以-时相当于减一个负数用+=
            if(rest == 0){
                result++;
            }
            return;
        }

        // 给 nums[i] 选择 - 号
        rest += nums[i];
        backtracking(nums, i + 1, rest);
        rest -= nums[i];

        // 给 nums[i] 选择 + 号
        rest -= nums[i];
        backtracking(nums, i + 1, rest);
        rest += nums[i];
    }*/

    //dp + 备忘录
    /*public int findTargetSumWays(int[] nums, int S){
        if(nums.length == 0) {
            return 0;
        }
        return dp(nums, 0, S);
    }

    HashMap<String, Integer> memo = new HashMap<>();
    private int dp(int[] nums, int i, int rest){
        //base case
        if(i == nums.length){
            if(rest == 0) {
                return 1;
            }
            return 0;
        }
        // 转成字符串才能作为哈希表的键
        String key = i + "," + rest;
        // 避免重复计算
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        //穷举
        int result = dp(nums, i + 1, rest - nums[i]) + dp(nums, i + 1, rest + nums[i]);
        //记录备忘录
        memo.put(key, result);
        return result;
    }*/

    //dp 转换为01背包问题
    public int findTargetSumWays(int[] nums, int target){
        int sum = 0;
        for(int n : nums) {
            sum += n;
        }
        if(sum < target || (sum + target) % 2 == 1){
            return 0;
        }
        return subsets(nums, (sum + target) / 2);
    }

    private int subsets(int[] nums, int sum){
        int n = nums.length;
        int[] dp = new int[sum + 1];
        //base case
        dp[0] = 1;

        for(int i = 1; i <= n; i++){
            for(int j = sum; j >= 0; j--){
                if(j >= nums[i - 1]){
                    //两种选择的结果之和
                    dp[j] = dp[j] + dp[j - nums[i - 1]];
                }else {
                    dp[j] = dp[j];
                }
            }
        }
        return dp[sum];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}