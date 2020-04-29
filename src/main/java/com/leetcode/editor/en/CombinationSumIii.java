//
// Find all possible combinations of k numbers that add up to a number n, given 
//that only numbers from 1 to 9 can be used and each combination should be a uniqu
//e set of numbers. 
//
// Note: 
//
// 
// All numbers will be positive integers. 
// The solution set must not contain duplicate combinations. 
// 
//
// Example 1: 
//
// 
//Input: k = 3, n = 7
//Output: [[1,2,4]]
// 
//
// Example 2: 
//
// 
//Input: k = 3, n = 9
//Output: [[1,2,6], [1,3,5], [2,3,4]]
// 
// Related Topics Array Backtracking


package com.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIii{
    public static void main(String[] args) {
       Solution solution = new CombinationSumIii().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(k <= 0 || n <= 0) return res;
        res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(k, n, 1, list);
        return res;
    }

    private void backtrack(int k, int n, int start, List<Integer> list){
        if(k < 0) return;

        if(k == 0 && n == 0){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = start; i <= 9; i++){
            list.add(i);
            //k限制层数; n确定路径; start确保子集没有重复元素
            backtrack(k - 1, n - i, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}