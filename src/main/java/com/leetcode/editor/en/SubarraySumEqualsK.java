//Given an array of integers and an integer k, you need to find the total number
// of continuous subarrays whose sum equals to k. 
//
// Example 1: 
//
// 
//Input:nums = [1,1,1], k = 2
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// The length of the array is in range [1, 20,000]. 
// The range of numbers in the array is [-1000, 1000] and the range of the integ
//er k is [-1e7, 1e7]. 
// 
// Related Topics Array Hash Table


package com.leetcode.editor.en;

import java.util.HashMap;

public class SubarraySumEqualsK{
    public static void main(String[] args) {
       Solution solution = new SubarraySumEqualsK().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        sum[0] = 0;
        for(int i = 0; i < n; i++){
            sum[i + 1] = sum[i] + nums[i];
        }

        int res = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                if(sum[i] - sum[j] == k){
                    res++;
                }
            }
        }
        return res;
    }*/

    //前缀和: 到了某一个位置, 计算要得到k需要减的区间和 --> 前缀和中等于此区间和的个数已经记录在HashMap中, res+=即可
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> preSum = new HashMap<Integer, Integer>();
        preSum.put(0, 1);

        int res = 0, sum0_i  = 0;
        for(int i = 0; i <n; i++){
            sum0_i += nums[i];
            int sum0_j = sum0_i - k;
            if(preSum.containsKey(sum0_j))
                res += preSum.get(sum0_j);
            preSum.put(sum0_i, preSum.getOrDefault(sum0_i, 0) + 1);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}