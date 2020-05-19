//Given two non-negative integers num1 and num2 represented as string, return th
//e sum of num1 and num2. 
//
// Note:
// 
// The length of both num1 and num2 is < 5100. 
// Both num1 and num2 contains only digits 0-9. 
// Both num1 and num2 does not contain any leading zero. 
// You must not use any built-in BigInteger library or convert the inputs to int
//eger directly. 
// 
// Related Topics String


package com.leetcode.editor.en;

public class AddStrings{
    public static void main(String[] args) {
       Solution solution = new AddStrings().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuffer sb = new StringBuffer();
        int m = num1.length() - 1, n = num2.length() - 1, carry = 0;
        //把carry放入条件则可以不用特判; 使用sb比String res 相加效率高很多
        while (m >= 0 || n >= 0 || carry >= 1){
            int p = m >= 0 ? num1.charAt(m) - '0' : 0;
            int q = n >= 0 ? num2.charAt(n) - '0' : 0;
            m--; n--;
            int sum = p + q + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}