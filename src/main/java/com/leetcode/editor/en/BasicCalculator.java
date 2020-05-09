//Implement a basic calculator to evaluate a simple expression string. 
//
// The expression string may contain open ( and closing parentheses ), the plus 
//+ or minus sign -, non-negative integers and empty spaces . 
//
// Example 1: 
//
// 
//Input: "1 + 1"
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: " 2-1 + 2 "
//Output: 3 
//
// Example 3: 
//
// 
//Input: "(1+(4+5+2)-3)+(6+8)"
//Output: 23 
//Note:
//
// 
// You may assume that the given expression is always valid. 
// Do not use the eval built-in library function. 
// 
// Related Topics Math Stack


package com.leetcode.editor.en;

import java.util.Stack;

public class BasicCalculator{
    public static void main(String[] args) {
       Solution solution = new BasicCalculator().new Solution();
       solution.calculate("(1-(4+5+2)-3)+(6+8)");
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
   /* public int calculate(String s) {
        if(s == null) return 0;
        Stack<Integer> stack = new Stack<>();
        int res = 0, sign = 1, num = 0;
        //默认初始符号为'+'
        stack.push(sign);
        //循环中没有处理empty space, 相当于遇到empty space不进行任何更改操作
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c >= '0' && c <= '9'){
                num = num * 10 + (c - '0');
            }
            else if(c == '+' || c == '-'){
                //相当于压入数值与其符号; 每一个数值只与其前面的符号有关
                res += sign * num;
                //stack.peek()是影响这段括号内的元素, 相当于去括号; 假如括号前为负, 相当于-1, 则去括号后, sign翻转
                sign = stack.peek() * (c == '+' ? 1 : -1);
                num = 0;
            }
            else if(c == '('){
                //遇到左括号则压入; 表明左括号后续元素都与左括号前元素有关
                stack.push(sign);
            }
            else if(c == ')'){
                stack.pop();
            }
        }
        //加上最后一个数字; 因为最后一个数字之后不会再有'+' or '-'
        res += sign * num;
        return res;
    }*/

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int res = 0;
        int num = 0;
        int sign = 1;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = 10 * num + (c - '0');
            }else if(c == '+'){
                //直接使用res+=, 就无需将带符号数压入栈最后统一求和, 节省空间; 栈只处理有括号的情况
                res += sign * num;
                num = 0;
                sign = 1;
            }else if(c == '-'){
                res += sign * num;
                num = 0;
                sign = -1;
            }
            //另外一种处理括号的方式, 更容易理解; 即将括号内的数算完, 返回整体返回一个数(也可用递归)
            else if(c == '('){
                //we push the result first, then sign;
                stack.push(res);
                stack.push(sign);
                //reset the sign and result for the value in the parenthesis
                sign = 1;
                res = 0;
            }else if(c == ')'){
                //算上括号前最后一个数
                res += sign * num;
                num = 0;
                res *= stack.pop();    //stack.pop() is the sign before the parenthesis
                res += stack.pop();   //stack.pop() now is the result calculated before the parenthesis
            }
        }
        //假如最后一个数后面不包含括号, 算上最后一个数;
        if(num != 0) res += sign * num;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}