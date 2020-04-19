//Given a collection of distinct integers, return all possible permutations. 
//
// Example: 
//
// 
//Input: [1,2,3]
//Output:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// 
// Related Topics Backtracking


package com.leetcode.editor.en;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations{
    public static void main(String[] args) {
       Solution solution = new Permutations().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private ArrayList<List<Integer>> res;
    private boolean[] used; //判断是否使用了这个数字，因为不可重复使用
    public ArrayList<List<Integer>> permute(int[] nums) {
        res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) return res;

        used = new boolean[nums.length];
        LinkedList<Integer> p = new LinkedList<>();
        generatePermutation(nums, 0, p);

        return res;
    }

    private void generatePermutation(int[] nums, int index, LinkedList<Integer> p){
        if(index == nums.length){
            res.add((LinkedList<Integer>)p.clone());
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!used[i]){
                p.add(nums[i]);
                used[i] = true;
                generatePermutation(nums, index + 1, p);
                //因为回溯，所以每一层需要归还使用过的数字
                p.removeLast();
                used[i] = false;
            }
        }
        return;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}