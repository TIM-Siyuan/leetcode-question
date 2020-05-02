//Given a non-empty array of integers, every element appears twice except for on
//e. Find that single one. 
//
// Note: 
//
// Your algorithm should have a linear runtime complexity. Could you implement i
//t without using extra memory? 
//
// Example 1: 
//
// 
//Input: [2,2,1]
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: [4,1,2,1,2]
//Output: 4
// 
// Related Topics Hash Table Bit Manipulation


package com.leetcode.editor.en;

import java.util.HashMap;
import java.util.HashSet;

public class SingleNumber{
    public static void main(String[] args) {
       Solution solution = new SingleNumber().new Solution();
       int[] nums = {2,2,1};
       solution.singleNumber(nums);
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            //当set添加一个元素的时候，会判断是否已经加入set; 可以加入set则返回true, 表明set中没有相同元素
            //不可以加入, 说明set中有重复元素, 则去除, 留下的就是只出现一次的元素
            if(!set.add(num)) set.remove(num);
        }
        return set.iterator().next();
    }*/

    //利用异或, 相同元素得0; 将每个数字, 每个元素异或;
    //成对的数字会得0; 别的元素与0异或, 元素不变，则可得到只有一次的元素
    public int singleNumber(int[] nums){
        int res = 0;
        for(int num : nums)
            res ^= num;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}