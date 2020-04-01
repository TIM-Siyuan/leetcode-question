//Given an array of integers, find if the array contains any duplicates. 
//
// Your function should return true if any value appears at least twice in the a
//rray, and it should return false if every element is distinct. 
//
// Example 1: 
//
// 
//Input: [1,2,3,1]
//Output: true 
//
// Example 2: 
//
// 
//Input: [1,2,3,4]
//Output: false 
//
// Example 3: 
//
// 
//Input: [1,1,1,3,3,4,3,2,4,2]
//Output: true 
// Related Topics Array Hash Table


package com.leetcode.editor.en;

import java.util.HashSet;

public class ContainsDuplicate{
    public static void main(String[] args) {
       Solution solution = new ContainsDuplicate().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> record = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(record.contains(nums[i]))
                return true;
            record.add(nums[i]);
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}