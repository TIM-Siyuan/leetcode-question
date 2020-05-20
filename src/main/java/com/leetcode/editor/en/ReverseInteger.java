//Given a 32-bit signed integer, reverse digits of an integer. 
//
// Example 1: 
//
// 
//Input: 123
//Output: 321
// 
//
// Example 2: 
//
// 
//Input: -123
//Output: -321
// 
//
// Example 3: 
//
// 
//Input: 120
//Output: 21
// 
//
// Note: 
//Assume we are dealing with an environment which could only store integers with
//in the 32-bit signed integer range: [−231, 231 − 1]. For the purpose of this pro
//blem, assume that your function returns 0 when the reversed integer overflows. 
// Related Topics Math


package com.leetcode.editor.en;

public class ReverseInteger{
    public static void main(String[] args) {
       Solution solution = new ReverseInteger().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        int res = 0;
        while (x != 0){
            int tail = x % 10;
            int temp = 10 * res + tail;
            //防止翻转后溢出
            if(res != temp / 10) return 0;
            res = temp;
            x /= 10;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}