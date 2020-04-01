//Given an array of integers and an integer k, find out whether there are two di
//stinct indices i and j in the array such that nums[i] = nums[j] and the absolute
// difference between i and j is at most k. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,1], k = 3
//Output: true
// 
//
// 
// Example 2: 
//
// 
//Input: nums = [1,0,1,1], k = 1
//Output: true
// 
//
// 
// Example 3: 
//
// 
//Input: nums = [1,2,3,1,2,3], k = 2
//Output: false
// 
// 
// 
// 
// Related Topics Array Hash Table


package com.leetcode.editor.en;

import java.util.HashMap;
import java.util.HashSet;

public class ContainsDuplicateIi{
    public static void main(String[] args) {
       Solution solution = new ContainsDuplicateIi().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> record = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(record.contains(nums[i]))
                return true;
            record.add(nums[i]);
            if(record.size() == k+1)
                record.remove(nums[i-k]);
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}