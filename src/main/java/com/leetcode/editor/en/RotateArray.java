//Given an array, rotate the array to the right by k steps, where k is non-negat
//ive. 
//
// Follow up: 
//
// 
// Try to come up as many solutions as you can, there are at least 3 different w
//ays to solve this problem. 
// Could you do it in-place with O(1) extra space? 
// 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,4,5,6,7], k = 3
//Output: [5,6,7,1,2,3,4]
//Explanation:
//rotate 1 steps to the right: [7,1,2,3,4,5,6]
//rotate 2 steps to the right: [6,7,1,2,3,4,5]
//rotate 3 steps to the right: [5,6,7,1,2,3,4]
// 
//
// Example 2: 
//
// 
//Input: nums = [-1,-100,3,99], k = 2
//Output: [3,99,-1,-100]
//Explanation: 
//rotate 1 steps to the right: [99,-1,-100,3]
//rotate 2 steps to the right: [3,99,-1,-100]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2 * 10^4 
// It's guaranteed that nums[i] fits in a 32 bit-signed integer. 
// k >= 0 
// 
// Related Topics Array


package com.leetcode.editor.en;

import java.util.Arrays;

public class RotateArray{
    public static void main(String[] args) {
       Solution solution = new RotateArray().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //空间复杂度为O(n)
    /*public void rotate(int[] nums, int k) {
        int[] temp = Arrays.copyOf(nums, nums.length);
        for(int i = 0; i < nums.length; i++){
            nums[(i + k) % nums.length] = temp[i];
        }
    }*/

    //三次翻转
    public void rotate(int[] nums, int k){
        if(nums == null || k == 0) return;
        int n = nums.length;
        k %= nums.length;

        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);
    }

    private void reverse(int[] nums, int start, int end){
        for(int i = start, j = end; i < j; i++, j--){
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}