//Implement a basic calculator to evaluate a simple expression string. 
//
// The expression string contains only non-negative integers, +, -, *, / operato
//rs and empty spaces . The integer division should truncate toward zero. 
//
// Example 1: 
//
// 
//Input: "3+2*2"
//Output: 7
// 
//
// Example 2: 
//
// 
//Input: " 3/2 "
//Output: 1 
//
// Example 3: 
//
// 
//Input: " 3+5 / 2 "
//Output: 5
// 
//
// Note: 
//
// 
// You may assume that the given expression is always valid. 
// Do not use the eval built-in library function. 
// 
// Related Topics String


package com.leetcode.editor.en;

import java.util.Stack;

public class BasicCalculatorIi{
    public static void main(String[] args) {
       Solution solution = new BasicCalculatorIi().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //与calculatorI 不同, 不能直接用res+=, 因为乘除法需要取得前一个数进行处理而非直接相加减
    public int calculate(String s) {
        if(s.length() == 0) return 0;
        Stack<Integer> stk = new Stack<>();
        int num = 0, sign = '+';
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + (c - '0');
            }
            //如果遇到empty space, 不能让他进入if因为会修改sign和num; 但是假如遇到最后一步, 后面的条件保证其能被压入栈
            if((!Character.isDigit(c) && !Character.isSpace(c)) || i == s.length() - 1){
                int pre = 0;
                switch (sign){
                    case '+':
                        stk.push(num); break;
                    case '-':
                        stk.push(-num); break;
                    case '*':
                        pre = stk.pop();
                        stk.push(pre * num);
                        break;
                    case '/':
                        pre = stk.pop();
                        stk.push(pre / num);
                        break;
                }
                sign = c;
                num = 0;
            }
        }
        int res = 0;
        while (!stk.isEmpty()){
            res += stk.pop();
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}