 //Given a positive integer n, break it into the sum of at least two positive int
//egers and maximize the product of those integers. Return the maximum product you
// can get. 
//
// Example 1: 
//
// 
// 
//Input: 2
//Output: 1
//Explanation: 2 = 1 + 1, 1 × 1 = 1. 
//
// 
// Example 2: 
//
// 
//Input: 10
//Output: 36
//Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36. 
//
// Note: You may assume that n is not less than 2 and not larger than 58. 
// 
// Related Topics Math Dynamic Programming


package com.leetcode.editor.en;

 import java.util.Arrays;

 public class IntegerBreak{
    public static void main(String[] args) {
       Solution solution = new IntegerBreak().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*private int[] memo;
    public int integerBreak(int n) {
        assert(n >= 2);
        memo = new int[n+1];
        Arrays.fill(memo, -1);
        return breakInteger(n);
    }

    private int breakInteger(int n){
        if(n == 1) return 1;

        if(memo[n] != -1) return memo[n];

        int res = -1;
        for(int i = 1; i <= n - 1; i++)
            res = max3(res, i *(n - i), i * breakInteger(n - i));
        memo[n] = res;
        return res;
    }

    private int max3(int a, int b, int c){
        return Math.max(a, Math.max(b, c));
    }*/

    public int integerBreak(int n){
        assert(n >= 2);
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        memo[1] = 1;
        for(int i = 2; i <= n; i++)
            // 求解memo[i]
            for(int j = 1; j <= i - 1; j++)
                // j + (i - j) 求解分隔成这两部分的最大乘积
                memo[i] = max3(memo[i], j * (i - j), j * memo[i - j]);
        return memo[n];
    }

    private int max3(int a, int b, int c){
        return Math.max(a, Math.max(b, c));
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}