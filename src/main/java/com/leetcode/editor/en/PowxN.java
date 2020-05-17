//Implement pow(x, n), which calculates x raised to the power n (xn). 
//
// Example 1: 
//
// 
//Input: 2.00000, 10
//Output: 1024.00000
// 
//
// Example 2: 
//
// 
//Input: 2.10000, 3
//Output: 9.26100
// 
//
// Example 3: 
//
// 
//Input: 2.00000, -2
//Output: 0.25000
//Explanation: 2-2 = 1/22 = 1/4 = 0.25
// 
//
// Note: 
//
// 
// -100.0 < x < 100.0 
// n is a 32-bit signed integer, within the range [−231, 231 − 1] 
// 
// Related Topics Math Binary Search


package com.leetcode.editor.en;

public class PowxN{
    public static void main(String[] args) {
       Solution solution = new PowxN().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //递归
    /*public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n < 0){
            //因为溢出问题所以先+1再取反, 同时要先乘一个x才能匹配
            return 1 / (x*myPow(x, -(n + 1)));
        }
        //如果是奇数先乘一个x将power变为偶数再二分
        return (n % 2 == 0) ? myPow(x*x, n / 2) : x*myPow(x*x, n / 2);
    }*/

    public double myPow(double x, int n) {
        if(n == 0 || x == 1) return 1;
        if(n == 1) return x;
        if(n < 0) return 1 / (x * myPow(x, -(n + 1)));
        double res = 1;
        while (n > 1){
            if(n % 2 == 1){
                res *= x;
            }
            x *= x;
            n /= 2;
        }
        //将x赋值给结果; 假如n为奇数则res已经先乘了一个x, 剩下的按偶次幂计算
        res *= x;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}