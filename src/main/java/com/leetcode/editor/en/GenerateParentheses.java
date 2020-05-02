//
//Given n pairs of parentheses, write a function to generate all combinations of
// well-formed parentheses.
// 
//
// 
//For example, given n = 3, a solution set is:
// 
// 
//[
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// Related Topics String Backtracking


package com.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses{
    public static void main(String[] args) {
       Solution solution = new GenerateParentheses().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<String>();
        backtrack(n, n, "", res);
        return res;
    }

    public void backtrack(int left, int right, String track, List<String> res){
        if(right < left) return;
        if(left < 0 || right < 0) return;
        if(left == 0 && right == 0){
            res.add(track);
            return;
        }

        backtrack(left - 1, right, track + "(", res);
        backtrack(left, right - 1, track + ")", res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}