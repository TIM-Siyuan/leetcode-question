//Given two non-negative integers num1 and num2 represented as strings, return t
//he product of num1 and num2, also represented as a string. 
//
// Example 1: 
//
// 
//Input: num1 = "2", num2 = "3"
//Output: "6" 
//
// Example 2: 
//
// 
//Input: num1 = "123", num2 = "456"
//Output: "56088"
// 
//
// Note: 
//
// 
// The length of both num1 and num2 is < 110. 
// Both num1 and num2 contain only digits 0-9. 
// Both num1 and num2 do not contain any leading zero, except the number 0 itsel
//f. 
// You must not use any built-in BigInteger library or convert the inputs to int
//eger directly. 
// 
// Related Topics Math String


package com.leetcode.editor.en;

import java.util.Arrays;

public class MultiplyStrings{
    public static void main(String[] args) {
       Solution solution = new MultiplyStrings().new Solution();
       solution.multiply("123", "456");
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        // 结果最多为 m + n 位数
        int[] res = new int[m + n];
        Arrays.fill(res, 0);
        // 从个位数开始逐位相乘
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                //此时的res[p2]为上一次计算的res[p1];
                int sum = mul + res[p2];
                res[p2] = sum % 10;
                //+=所以有进位都存在res[p1]中, 等待下一次循环中res[p2]处理, 相当于carry
                res[p1] += sum / 10;
            }
        }
//        // 结果前缀可能存的 0（未使用的位）
//        int i = 0;
//        while (i < res.length && res[i] == 0){
//            i++;
//        }
//        // 将计算结果转化成字符串
//        StringBuffer str = new StringBuffer();
//        for(; i < res.length; i++){
//            str.append(res[i]);
//        }
        //另一种写法: 去除首位0并转换为字符串
        StringBuffer str = new StringBuffer();
        for(int p : res) if(!(str.length() == 0 && p == 0)) str.append(p);

        return str.length() == 0 ? "0" : str.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}