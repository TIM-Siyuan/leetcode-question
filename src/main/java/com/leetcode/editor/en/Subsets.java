//Given a set of distinct integers, nums, return all possible subsets (the power
// set). 
//
// Note: The solution set must not contain duplicate subsets. 
//
// Example: 
//
// 
//Input: nums = [1,2,3]
//Output:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics Array Backtracking Bit Manipulation


package com.leetcode.editor.en;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets{
    public static void main(String[] args) {
       Solution solution = new Subsets().new Solution();
       int[] nums = {1,2,3};
       solution.subsets(nums);
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private ArrayList<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if(nums.length == 0) return res;
        backtrack(nums, 0, list);
        return res;
    }

    //相当于前序遍历
    private void backtrack(int[] nums, int start, List<Integer> list){
        res.add(new ArrayList<Integer>(list)); //Java传入的是引用, 每次新建立一个list, 传入list的备份

        for(int i = start; i < nums.length; i++){
            list.add(nums[i]);
            backtrack(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}