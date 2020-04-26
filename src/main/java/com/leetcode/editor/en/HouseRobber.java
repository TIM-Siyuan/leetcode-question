//You are a professional robber planning to rob houses along a street. Each hous
//e has a certain amount of money stashed, the only constraint stopping you from r
//obbing each of them is that adjacent houses have security system connected and i
//t will automatically contact the police if two adjacent houses were broken into 
//on the same night. 
//
// Given a list of non-negative integers representing the amount of money of eac
//h house, determine the maximum amount of money you can rob tonight without alert
//ing the police. 
//
// Example 1: 
//
// 
//Input: [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//             Total amount you can rob = 1 + 3 = 4. 
//
// Example 2: 
//
// 
//Input: [2,7,9,3,1]
//Output: 12
//Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 
//(money = 1).
//             Total amount you can rob = 2 + 9 + 1 = 12.
// 
// Related Topics Dynamic Programming


package com.leetcode.editor.en;

import java.util.Arrays;

public class HouseRobber{
    public static void main(String[] args) {
       Solution solution = new HouseRobber().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int[] memo;
    /* 递归
    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return tryRob(nums, 0);
    }

    private int tryRob(int[] nums, int index){
        if(index >= nums.length) return 0;

        if(memo[index] != -1) return memo[index];

        int res = 0;
        for(int i = index; i < nums.length; i++){
            res = Math.max(res, nums[i] + tryRob(nums, i + 2));
        }
        memo[index] = res;

        return res;
    }*/

   /* DP
   public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        memo = new int[n];
        Arrays.fill(memo, -1);

        memo[n-1] = nums[n-1];
        for(int i = n - 2; i >= 0; i--){
            //memo[i]
            for(int j = i; j < n; j++){
                memo[i] = Math.max(memo[i], nums[j] + (j + 2 < n ? memo[j + 2] : 0));
            }
        }
        return memo[0];
    }*/

    //DP优化
    public int rob(int[] nums) {
       int n = nums.length;
       if(n == 0) return 0;
       int dp_i_1 = 0, dp_i_2 = 0;
       int dp_i = 0;
       for(int i = n - 1; i >= 0; i--){
           dp_i = Math.max(dp_i_1, nums[i] + dp_i_2);
           dp_i_2 = dp_i_1;
           dp_i_1 = dp_i;
       }
       return dp_i;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}