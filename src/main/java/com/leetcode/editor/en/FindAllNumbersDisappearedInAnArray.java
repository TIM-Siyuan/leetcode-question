//Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elemen
//ts appear twice and others appear once. 
//
// Find all the elements of [1, n] inclusive that do not appear in this array. 
//
// Could you do it without extra space and in O(n) runtime? You may assume the r
//eturned list does not count as extra space. 
//
// Example:
// 
//Input:
//[4,3,2,7,8,2,3,1]
//
//Output:
//[5,6]
// 
// Related Topics Array


package com.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray{
    public static void main(String[] args) {
       Solution solution = new FindAllNumbersDisappearedInAnArray().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        //将数字放到符合(index + 1 = nums[index])的位置上, 重复的数字占了缺失数字的位置, 其已满足条件不进入循环仍然在原来位置;
        for(int i = 0; i < nums.length; i++){
            while (nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
            }
        }
        //i表示数字, 遍历对比, 不符合条件的那个i则是缺失的数字
        for(int i = 1; i <= nums.length; i++){
            if(i != nums[i - 1]){
                res.add(i);
            }
        }
        return res;
    }

    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}