//Your are given an array of positive integers nums. 
// Count and print the number of (contiguous) subarrays where the product of all
// the elements in the subarray is less than k. 
//
// Example 1: 
// 
//Input: nums = [10, 5, 2, 6], k = 100
//Output: 8
//Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [
//2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
//Note that [10, 5, 2] is not included as the product of 100 is not strictly les
//s than k.
// 
// 
//
// Note:
// 0 < nums.length <= 50000. 
// 0 < nums[i] < 1000. 
// 0 <= k < 10^6. 
// Related Topics Array Two Pointers


package com.leetcode.editor.en;

public class SubarrayProductLessThanK{
    public static void main(String[] args) {
       Solution solution = new SubarrayProductLessThanK().new Solution();
       int[] nums = {10, 5, 2, 6};
       solution.numSubarrayProductLessThanK(nums, 100);
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k == 0) return 0;
        int res = 0, product = 1;
        for(int l = 0, r = 0; r < nums.length; r++){
            product *= nums[r];
            while (l <= r && product >= k){
                product /= nums[l];
                l++;
            }
            res += r - l + 1;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}