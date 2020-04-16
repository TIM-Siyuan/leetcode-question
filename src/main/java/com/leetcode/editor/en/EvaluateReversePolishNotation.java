//Evaluate the value of an arithmetic expression in Reverse Polish Notation. 
//
// Valid operators are +, -, *, /. Each operand may be an integer or another exp
//ression. 
//
// Note: 
//
// 
// Division between two integers should truncate toward zero. 
// The given RPN expression is always valid. That means the expression would alw
//ays evaluate to a result and there won't be any divide by zero operation. 
// 
//
// Example 1: 
//
// 
//Input: ["2", "1", "+", "3", "*"]
//Output: 9
//Explanation: ((2 + 1) * 3) = 9
// 
//
// Example 2: 
//
// 
//Input: ["4", "13", "5", "/", "+"]
//Output: 6
//Explanation: (4 + (13 / 5)) = 6
// 
//
// Example 3: 
//
// 
//Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
//Output: 22
//Explanation: 
//  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
//= ((10 * (6 / (12 * -11))) + 17) + 5
//= ((10 * (6 / -132)) + 17) + 5
//= ((10 * 0) + 17) + 5
//= (0 + 17) + 5
//= 17 + 5
//= 22
// 
// Related Topics Stack


package com.leetcode.editor.en;

import java.util.Stack;

public class EvaluateReversePolishNotation{
    public static void main(String[] args) {
       Solution solution = new EvaluateReversePolishNotation().new Solution();
       String[] s = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
       solution.evalRPN(s);
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        if(tokens.length == 1) return Integer.parseInt(tokens[0]);
        int res = 0;
        for(String c:tokens){
            if(c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")){
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                if(c.equals("+")){
                    res = num2 + num1;
                }else if(c.equals("-")){
                    res = num2 - num1;
                }else if(c.equals("*")){
                    res = num2 * num1;
                }else if(c.equals("/")){
                    res = num2 / num1;
                }
                stack.push(Integer.toString(res));
            }else{
                stack.push(c);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}