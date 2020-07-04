//Balanced strings are those who have equal quantity of 'L' and 'R' characters. 
//
//
// Given a balanced string s split it in the maximum amount of balanced strings.
// 
//
// Return the maximum amount of splitted balanced strings. 
//
// 
// Example 1: 
//
// 
//Input: s = "RLRRLLRLRL"
//Output: 4
//Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring cont
//ains same number of 'L' and 'R'.
// 
//
// Example 2: 
//
// 
//Input: s = "RLLLLRRRLR"
//Output: 3
//Explanation: s can be split into "RL", "LLLRRR", "LR", each substring contains
// same number of 'L' and 'R'.
// 
//
// Example 3: 
//
// 
//Input: s = "LLLLRRRR"
//Output: 1
//Explanation: s can be split into "LLLLRRRR".
// 
//
// Example 4: 
//
// 
//Input: s = "RLRRRLLRLL"
//Output: 2
//Explanation: s can be split into "RL", "RRRLLRLL", since each substring contai
//ns an equal number of 'L' and 'R'
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s[i] = 'L' or 'R' 
// 
// Related Topics String Greedy 
// 👍 509 👎 349


package com.leetcode.editor.en;

import java.util.Stack;

public class SplitAStringInBalancedStrings{
    public static void main(String[] args) {
       Solution solution = new SplitAStringInBalancedStrings().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*public int balancedStringSplit(String s) {
        int res = 0;
        if(s == null || s.length() == 0){
            return res;
        }
        Stack<Character> stk = new Stack<>();
        stk.push(s.charAt(0));
        for(int i = 1; i < s.toCharArray().length; i++){
            if(stk.peek() == s.charAt(i)){
                stk.push(s.charAt(i));
            }else {
                stk.pop();
            }
            if(stk.isEmpty()){
                res++;
                i++;
                if(i < s.toCharArray().length){
                    stk.push(s.charAt(i));
                }else{
                    break;
                }
            }
        }
        return res;
    }*/

    public int balancedStringSplit(String s){
        int res = 0, cnt = 0;
        for (int i = 0; i < s.length(); ++i) {
            cnt += s.charAt(i) == 'L' ? 1 : -1;
            if (cnt == 0) {
                ++res;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}