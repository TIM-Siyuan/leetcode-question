//Given two binary strings, return their sum (also a binary string). 
//
// The input strings are both non-empty and contains only characters 1 or 0. 
//
// Example 1: 
//
// 
//Input: a = "11", b = "1"
//Output: "100" 
//
// Example 2: 
//
// 
//Input: a = "1010", b = "1011"
//Output: "10101" 
//
// 
// Constraints: 
//
// 
// Each string consists only of '0' or '1' characters. 
// 1 <= a.length, b.length <= 10^4 
// Each string is either "0" or doesn't contain any leading zero. 
// 
// Related Topics Math String


package com.leetcode.editor.en;

public class AddBinary{
    public static void main(String[] args) {
       Solution solution = new AddBinary().new Solution();
       solution.addBinary("1010", "1011");
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        int m = a.length() - 1, n = b.length() - 1, carry = 0;
        String res = "";
        while (m >= 0 || n >= 0){
            int p = m >= 0 ? a.charAt(m) - '0' : 0;
            int q = n >= 0 ? b.charAt(n) - '0' : 0;
            m--; n--;
            int sum = p + q + carry;
            //此处不用+=, 因为个位开始下一循环(sum % 2)是十位要在前
            res = (sum % 2) + res;
            carry = sum / 2;
        }
        String str = String.valueOf(res);
        return carry == 1 ? "1" + str : str;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}