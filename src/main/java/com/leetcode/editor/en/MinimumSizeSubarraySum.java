//Given an array of n positive integers and a positive integer s, find the minim
//al length of a contiguous subarray of which the sum ≥ s. If there isn't one, ret
//urn 0 instead. 
//
// Example: 
//
// 
//Input: s = 7, nums = [2,3,1,2,4,3]
//Output: 2
//Explanation: the subarray [4,3] has the minimal length under the problem const
//raint. 
//
// Follow up: 
//
// If you have figured out the O(n) solution, try coding another solution of whi
//ch the time complexity is O(n log n). 
// Related Topics Array Two Pointers Binary Search


package com.leetcode.editor.en;

public class MinimumSizeSubarraySum{
    public static void main(String[] args) {
       Solution solution = new MinimumSizeSubarraySum().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(s <= 0 || nums == null)
            throw new IllegalArgumentException("Illegal Arguments");
        int l = 0, r = -1;
        int sum = 0;
        int res = nums.length + 1;
        while(r+1 < nums.length){
            while(r+1 < nums.length && sum < s)
                sum += nums[++r];
            if(sum >= s)
                res = Math.min(res, r-l+1);
            while(l < nums.length && sum >= s){
                sum -= nums[l++];
                if(sum >= s)
                    res = Math.min(res, r-l+1);
            }
        }
        if(res == nums.length+1)
            return 0;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}