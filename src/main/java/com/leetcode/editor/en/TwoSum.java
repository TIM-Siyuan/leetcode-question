//Given an array of integers, return indices of the two numbers such that they a
//dd up to a specific target. 
//
// You may assume that each input would have exactly one solution, and you may n
//ot use the same element twice. 
//
// Example: 
//
// 
//Given nums = [2, 7, 11, 15], target = 9,
//
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return [0, 1].
// 
// Related Topics Array Hash Table


package com.leetcode.editor.en;

public class TwoSum{
    public static void main(String[] args) {
       Solution solution = new TwoSum().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums.length < 2) throw new IllegalArgumentException("Illegal argument numbers");
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    int[] res = {i, j};
                    return res;
                }
            }
        }
        throw new IllegalArgumentException("The input has no solution");
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}