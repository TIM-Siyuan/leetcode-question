//Given a non-empty array containing only positive integers, find if the array c
//an be partitioned into two subsets such that the sum of elements in both subsets
// is equal. 
//
// Note: 
//
// 
// Each of the array element will not exceed 100. 
// The array size will not exceed 200. 
// 
//
// 
//
// Example 1: 
//
// 
//Input: [1, 5, 11, 5]
//
//Output: true
//
//Explanation: The array can be partitioned as [1, 5, 5] and [11].
// 
//
// 
//
// Example 2: 
//
// 
//Input: [1, 2, 3, 5]
//
//Output: false
//
//Explanation: The array cannot be partitioned into equal sum subsets.
// 
//
// 
// Related Topics Dynamic Programming


package com.leetcode.editor.en;

import java.util.Arrays;

public class PartitionEqualSubsetSum{
    public static void main(String[] args) {
       Solution solution = new PartitionEqualSubsetSum().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
   /* private int[][] memo;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            assert (nums[i] > 0);
            sum += nums[i];
        }
        if(sum % 2 != 0) return false;
        memo = new int[nums.length][sum / 2 + 1];
        for(int i = 0; i < nums.length; i++){
            Arrays.fill(memo[i], -1);
        }
        return tryPartition(nums, nums.length - 1, sum / 2);
    }

    private boolean tryPartition(int[] nums, int index, int sum){
        if(sum == 0) return true;
        if(sum < 0 || index < 0) return false;
        if(memo[index][sum] != -1) return memo[index][sum] == 1;
        memo[index][sum] = (tryPartition(nums, index - 1, sum) ||
                tryPartition(nums, index - 1, sum - nums[index])) ? 1 : 0;
        return memo[index][sum] == 1;
    }*/

    public boolean canPartition(int[] nums){
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            assert (nums[i] < 0);
            sum += nums[i];
        }
        if(sum % 2 != 0) return false;
        int n = nums.length;
        int C = sum / 2;
        boolean[] memo = new boolean[C + 1];
        Arrays.fill(memo, false);

        //刷表, 填充第一行-->看能否放进第一个物品; i此时表示容量; 因为这是0-1背包问题, 所以看能否填满背包
        for(int i = 0; i <= C; i++){
           memo[i] = (nums[0] == i);
        }

        //i表示物品, j表示容量
        //第0行已经被遍历过, 开始考虑其他物品
        for(int i = 1; i < n; i++){
            //刷表因为下一行只考虑上一行他本身和上一行左边的参数; 所以只有一行的表从右边开始计算, 不会再被更改;
            //同时要保证剩余空间大于物品的重量, 如果小于的话直接考虑不能放入i物品了, 沿用memo[j];
            for(int j = C; j >= nums[i]; j--){
                //不用物品i: 假如memo[j] == 1, 说明物品i-1已经可以填满背包;
                //使用物品i: 假如memo[j-nums[i]] == 1, 考虑去除物品i的容量, 容量是否已经被填满了; 假如填满, 说明加入物品i容量能填满;
                memo[j] = memo[j] || memo[j - nums[i]];
            }
        }
        // 结果需要看最后的C列，即sum/2能否被填满
        return memo[C];
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}