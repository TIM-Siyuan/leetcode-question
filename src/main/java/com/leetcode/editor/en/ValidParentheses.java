//Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
// determine if the input string is valid. 
//
// An input string is valid if: 
//
// 
// Open brackets must be closed by the same type of brackets. 
// Open brackets must be closed in the correct order. 
// 
//
// Note that an empty string is also considered valid. 
//
// Example 1: 
//
// 
//Input: "()"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: "()[]{}"
//Output: true
// 
//
// Example 3: 
//
// 
//Input: "(]"
//Output: false
// 
//
// Example 4: 
//
// 
//Input: "([)]"
//Output: false
// 
//
// Example 5: 
//
// 
//Input: "{[]}"
//Output: true
// 
// Related Topics String Stack


package com.leetcode.editor.en;

import java.util.Stack;

public class ValidParentheses{
    public static void main(String[] args) {
       Solution solution = new ValidParentheses().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                stack.push(s.charAt(i));
            else{
                if(stack.size() == 0)
                    return false;
                Character c = stack.pop();
                Character match;
                if(s.charAt(i) == ')')
                    match = '(';
                else if(s.charAt(i) == ']')
                    match = '[';
                else{
                    assert s.charAt(i) == '}';
                    match = '{';
                }
                if(c != match)
                    return false;
            }
        }
        if(stack.size() != 0)
            return false;
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}