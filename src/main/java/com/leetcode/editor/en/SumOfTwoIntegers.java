//Calculate the sum of two integers a and b, but you are not allowed to use the 
//operator + and -. 
//
// 
// Example 1: 
//
// 
//Input: a = 1, b = 2
//Output: 3
// 
//
// 
// Example 2: 
//
// 
//Input: a = -2, b = 3
//Output: 1
// 
// 
// 
// Related Topics Bit Manipulation


package com.leetcode.editor.en;

public class SumOfTwoIntegers{
    public static void main(String[] args) {
       Solution solution = new SumOfTwoIntegers().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //不考虑进位的加 == 异或
    //只考虑进位的加 == 与
    //递归不断将两者相加, 当没有进位的时候得到结果
    public int getSum(int a, int b) {
        // 当carry == 0时, 结束返回sum
        if(b == 0) return a;
        int sum = a ^ b;
        int carry = (a & b & Integer.MAX_VALUE) << 1;
        return getSum(sum, carry);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}