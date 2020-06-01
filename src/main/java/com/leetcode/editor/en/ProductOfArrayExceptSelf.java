//Given an array nums of n integers where n > 1, return an array output such tha
//t output[i] is equal to the product of all the elements of nums except nums[i]. 
//
//
// Example: 
//
// 
//Input:  [1,2,3,4]
//Output: [24,12,8,6]
// 
//
// Constraint: It's guaranteed that the product of the elements of any prefix or
// suffix of the array (including the whole array) fits in a 32 bit integer. 
//
// Note: Please solve it without division and in O(n). 
//
// Follow up: 
//Could you solve it with constant space complexity? (The output array does not 
//count as extra space for the purpose of space complexity analysis.) 
// Related Topics Array


package com.leetcode.editor.en;

public class ProductOfArrayExceptSelf{
    public static void main(String[] args) {
       Solution solution = new ProductOfArrayExceptSelf().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //设定两个数组计算i之前的乘积与i之后的乘积, 但是这样空间复杂度高
    /*public int[] productExceptSelf(int[] nums) {
        if(nums.length == 0) return new int[0];
        int n = nums.length;
        int[] res = new int[n];
        int[] pre = new int[n];
        int[] suf = new int[n];
        pre[0] = nums[0]; suf[n - 1] = nums[n - 1];
        for(int i = 0, j = n - 1; i < n - 1 && j > 1; i++, j--){
            pre[i + 1] = pre[i] * nums[i + 1];
            suf[j - 1] = suf[j] * nums[j - 1];
        }
        res[0] = suf[1]; res[n - 1] = pre[n - 2];
        for(int i = 1; i < n - 1; i++){
            res[i] = pre[i - 1] * suf[i + 1];
        }
        return res;
    }*/

    //follow up: 直接存入res, 降低空间复杂度; 右边用一个指针计算
    public int[] productExceptSelf(int[] nums){
        if(nums.length == 0) return new int[0];
        int right = 1, n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for(int i = 1; i < n; i++){
            res[i] = res[i - 1] * nums[i - 1];
        }
        for(int i = n - 1; i >= 0; i--){
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}