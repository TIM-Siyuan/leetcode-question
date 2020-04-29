//Given a set of candidate numbers (candidates) (without duplicates) and a targe
//t number (target), find all unique combinations in candidates where the candidat
//e numbers sums to target. 
//
// The same repeated number may be chosen from candidates unlimited number of ti
//mes. 
//
// Note: 
//
// 
// All numbers (including target) will be positive integers. 
// The solution set must not contain duplicate combinations. 
// 
//
// Example 1: 
//
// 
//Input: candidates = [2,3,6,7], target = 7,
//A solution set is:
//[
//  [7],
//  [2,2,3]
//]
// 
//
// Example 2: 
//
// 
//Input: candidates = [2,3,5], target = 8,
//A solution set is:
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//]
// 
// Related Topics Array Backtracking


package com.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum{
    public static void main(String[] args) {
       Solution solution = new CombinationSum().new Solution();
       int[] c = {2, 3, 6, 7};
       solution.combinationSum(c, 7);
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length == 0 || target <= 0) return res;
        res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(candidates, 0, target, list);
        return res;
    }

    private void backtrack(int[] nums, int start, int target, List<Integer> list){
        if(target < 0) return;
        if(target == 0){
            //Java添加的是引用, 所以需要new数组对象, 相当于传入list的copy, 后续list更改时因为是引用, 会一起变化
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = start; i < nums.length; i++){
            list.add(nums[i]);
            backtrack(nums, i, target - nums[i], list);
            list.remove(list.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}