//Given a collection of integers that might contain duplicates, nums, return all
// possible subsets (the power set). 
//
// Note: The solution set must not contain duplicate subsets. 
//
// Example: 
//
// 
//Input: [1,2,2]
//Output:
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//]
// 
// Related Topics Array Backtracking


package com.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SubsetsIi{
    public static void main(String[] args) {
       Solution solution = new SubsetsIi().new Solution();
        int[] nums = {1,2,2};
        solution.subsetsWithDup(nums);
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if(nums.length == 0) return res;
        Arrays.sort(nums);
        backtrack(nums, 0, list);
        return res;
    }

    private void backtrack(int[] nums, int start, List<Integer> list){

        res.add(new ArrayList<>(list));

        for(int i = start; i < nums.length; i++){
            //跳过重复的数字, 因为之前数组已经排序, 所以与前一个数字相比较的条件可行;
            //回溯相当于前序遍历 == DFS, 当遍历完一种选择, 进行下一个选择的时候, 即生成另外一叉树时 如果加入了重复的数字, 则产生重复的子集;
            //但是这不会影响一个子集中出现重复的元素, 因为 递归是不断往下走的, 属于一种选择同一叉的下一层, 是不同的选择;
            //i > start 表示退回到了上一层; 说明重新回溯到上层, start数值不变, i++, 则i > start;
            if(i > start && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            backtrack(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}