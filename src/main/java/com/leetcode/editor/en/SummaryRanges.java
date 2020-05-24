//Given a sorted integer array without duplicates, return the summary of its ran
//ges. 
//
// Example 1: 
//
// 
//Input:  [0,1,2,4,5,7]
//Output: ["0->2","4->5","7"]
//Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
// 
//
// Example 2: 
//
// 
//Input:  [0,2,3,4,6,8,9]
//Output: ["0","2->4","6","8->9"]
//Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
// 
// Related Topics Array


package com.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges{
    public static void main(String[] args) {
       Solution solution = new SummaryRanges().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //two pointers: 寻找重复元素个数相似题; LC 443
    /*public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int start = 0, end = 0;
        while (end < nums.length){
            while (end + 1 < nums.length && nums[end] + 1 == nums[end + 1]){
                end++;
            }
            if(start == end) res.add(String.valueOf(nums[start]));
            else res.add(nums[start] + "->" + nums[end]);
            end++;
            start = end;
        }
        return res;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)


}