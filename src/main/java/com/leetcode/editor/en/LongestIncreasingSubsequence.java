//Given an unsorted array of integers, find the length of longest increasing sub
//sequence. 
//
// Example: 
//
// 
//Input: [10,9,2,5,3,7,101,18]
//Output: 4 
//Explanation: The longest increasing subsequence is [2,3,7,101], therefore the 
//length is 4. 
//
// Note: 
//
// 
// There may be more than one LIS combination, it is only necessary for you to r
//eturn the length. 
// Your algorithm should run in O(n2) complexity. 
// 
//
// Follow up: Could you improve it to O(n log n) time complexity? 
// Related Topics Binary Search Dynamic Programming


package com.leetcode.editor.en;

import java.util.Arrays;

public class LongestIncreasingSubsequence{
    public static void main(String[] args) {
       Solution solution = new LongestIncreasingSubsequence().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
   /* public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int[] memo = new int[n + 1];
        Arrays.fill(memo, 1);
        int result = 1;
        // memo[i] 表示以 nums[i] 为结尾的最长上升子序列的长度
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i])
                    memo[i] = Math.max(memo[i], 1 + memo[j]);
            }
        }
       *//* for(int k = 0; k < n; k++){
            if(result < memo[k])
                result = memo[k];
        }
        return result;*//*

        int res = memo[0];
        for(int i = 1 ; i < nums.length ; i ++)
            res = Math.max(res, memo[i]);

        return res;
    }*/

    //O(NlogN) 纸牌
    public int lengthOfLIS(int[] nums){
        int[] top = new int[nums.length];
        int piles = 0;
        for(int i = 0; i < nums.length; i++){
            int poker = nums[i];

            int left = 0, right = piles;
            while(left < right){
                int mid = (left + right) / 2;
                if(top[mid] > poker){
                    right = mid;
                }else if(top[mid] < poker){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }

            if(left == piles) piles++;
            top[left] = poker;
        }
        return piles;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}