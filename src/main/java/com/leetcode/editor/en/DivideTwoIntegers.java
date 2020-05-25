//Given two integers dividend and divisor, divide two integers without using mul
//tiplication, division and mod operator. 
//
// Return the quotient after dividing dividend by divisor. 
//
// The integer division should truncate toward zero, which means losing its frac
//tional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2. 
//
// Example 1: 
//
// 
//Input: dividend = 10, divisor = 3
//Output: 3
//Explanation: 10/3 = truncate(3.33333..) = 3.
// 
//
// Example 2: 
//
// 
//Input: dividend = 7, divisor = -3
//Output: -2
//Explanation: 7/-3 = truncate(-2.33333..) = -2.
// 
//
// Note: 
//
// 
// Both dividend and divisor will be 32-bit signed integers. 
// The divisor will never be 0. 
// Assume we are dealing with an environment which could only store integers wit
//hin the 32-bit signed integer range: [−231, 231 − 1]. For the purpose of this pr
//oblem, assume that your function returns 231 − 1 when the division result overfl
//ows. 
// 
// Related Topics Math Binary Search


package com.leetcode.editor.en;

public class DivideTwoIntegers{
    public static void main(String[] args) {
       Solution solution = new DivideTwoIntegers().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //考点: int是否overflow; 除法的本质是最多有多少个相加小于dividend(相加也可认为divisor乘个数)
    //类似贪心: 不能用乘法, divisor不断右移乘2, 找到小于dividend的最大数(记录乘数即divisor扩大的倍数 && dividend相减最大数之后剩下的部分)
    /*public int divide(int dividend, int divisor) {
        //只有一种情况会溢出, 特判
        if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        int res = 0;

        //dividend还有剩余就继续循环
        while (a - b >= 0){
            //x记录右移次数
            int x = 0; //2^0 = 1
            //找到小于dividend的最大数
            while (a - (b << 1 << x) >= 0){
                x++;
            }
            //记录乘数即divisor扩大的倍数
            res += 1 << x;
            //记录dividend相减最大数之后剩下的部分
            a -= b << x;
        }
        //处理正负问题
        return (dividend >= 0) == (divisor > 0) ? res : -res;
    }*/

    //递归 -- TLE
    public int divide(int dividend, int divisor){
        if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        int m = Math.abs(dividend), n = Math.abs(divisor), res = 0;
        if(m < n) return 0;
        int t = n, x = 1;
        while (m > (t << 1)){
            t <<= 1;
            x <<= 1;
        }
        res += x + divide(m - t, n);
        return ((dividend < 0) ^ (divisor < 0)) ? res : -res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}