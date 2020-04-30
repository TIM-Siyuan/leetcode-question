//Given a collection of numbers that might contain duplicates, return all possib
//le unique permutations. 
//
// Example: 
//
// 
//Input: [1,1,2]
//Output:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//]
// 
// Related Topics Backtracking


package com.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsIi{
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
        int[] nums = {1, 2, 3};
        solution.permuteUnique(nums);
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private ArrayList<List<Integer>> res;
    private boolean[] used; //判断是否使用了这个数字，因为不可重复使用

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();

        if(nums == null || nums.length == 0) return res;
        List<Integer> list = new ArrayList<Integer>();
        used = new boolean[nums.length];
        Arrays.sort(nums); //排序, 可对比相邻两数是否相等
        backtrack(nums, list);

        return res;
    }

    private void backtrack(int[] nums, List<Integer> list){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            // i > 0 表明跳回上一层 && 相邻两数相等 && 前一个数被遍历过 --> 跳过这个数
            // 排列问题元素顺序不同则子集不同, 所以用used, 表明这层这个位置有没有用过这个数, 树较平衡
            // 组合问题元素顺序不同子集想同, 所以可以用start索引排除之前的参数, 越往右子树节点越少
            // used[i]默认为false; 假如 used[i] == true --> 遍历过这个数 --> 跳过这个数
            if((i > 0 && nums[i] == nums[i-1] && !used[i-1]) || used[i]) continue;
            used[i] = true;
            list.add(nums[i]);
            backtrack(nums, list);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}