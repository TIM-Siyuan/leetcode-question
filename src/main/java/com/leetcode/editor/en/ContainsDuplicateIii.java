//Given an array of integers, find out whether there are two distinct indices i 
//and j in the array such that the absolute difference between nums[i] and nums[j]
// is at most t and the absolute difference between i and j is at most k. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,1], k = 3, t = 0
//Output: true
// 
//
// 
// Example 2: 
//
// 
//Input: nums = [1,0,1,1], k = 1, t = 2
//Output: true
// 
//
// 
// Example 3: 
//
// 
//Input: nums = [1,5,9,1,5,9], k = 2, t = 3
//Output: false
// 
// 
// 
// Related Topics Sort Ordered Map


package com.leetcode.editor.en;

import java.util.TreeSet;

public class ContainsDuplicateIii{
    public static void main(String[] args) {
       Solution solution = new ContainsDuplicateIii().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> record = new TreeSet<Long>();
        for(int i = 0; i < nums.length; i++){
            if(record.ceiling((long)nums[i] - (long)t) != null &&
                    record.ceiling((long)nums[i] - (long)t) <= (long)nums[i] + (long)t)
                return true;
            record.add((long)nums[i]);
            if(record.size() == k+1)
                record.remove((long)nums[i-k]);
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}