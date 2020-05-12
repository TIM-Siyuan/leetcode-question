//Implement next permutation, which rearranges numbers into the lexicographicall
//y next greater permutation of numbers. 
//
// If such arrangement is not possible, it must rearrange it as the lowest possi
//ble order (ie, sorted in ascending order). 
//
// The replacement must be in-place and use only constant extra memory. 
//
// Here are some examples. Inputs are in the left-hand column and its correspond
//ing outputs are in the right-hand column. 
//
// 1,2,3 → 1,3,2 
//3,2,1 → 1,2,3 
//1,1,5 → 1,5,1 
// Related Topics Array


package com.leetcode.editor.en;

import com.sun.org.apache.xerces.internal.impl.xs.util.XIntPool;

public class NextPermutation{
    public static void main(String[] args) {
       Solution solution = new NextPermutation().new Solution();
       int[] nums = {1,2,3};
       solution.nextPermutation(nums);
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length < 2) return;
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
        if(i >= 0){
            int j = nums.length - 1;
            int l = i + 1, r = nums.length;
            while (nums[j] <= nums[i]) j--;
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);
    }

    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private void reverse(int[] nums, int i, int j){
        while (i < j) swap(nums, i++, j--);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}