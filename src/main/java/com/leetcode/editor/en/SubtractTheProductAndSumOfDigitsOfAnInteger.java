//Given an integer number n, return the difference between the product of its di
//gits and the sum of its digits.
// 
// Example 1: 
//
// 
//Input: n = 234
//Output: 15 
//Explanation: 
//Product of digits = 2 * 3 * 4 = 24 
//Sum of digits = 2 + 3 + 4 = 9 
//Result = 24 - 9 = 15
// 
//
// Example 2: 
//
// 
//Input: n = 4421
//Output: 21
//Explanation: 
//Product of digits = 4 * 4 * 2 * 1 = 32 
//Sum of digits = 4 + 4 + 2 + 1 = 11 
//Result = 32 - 11 = 21
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10^5 
// 
// Related Topics Math 
// 👍 278 👎 94


package com.leetcode.editor.en;

public class SubtractTheProductAndSumOfDigitsOfAnInteger{
    public static void main(String[] args) {
       Solution solution = new SubtractTheProductAndSumOfDigitsOfAnInteger().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subtractProductAndSum(int n) {
        /*String str = "" + n;
        int product = 1, sum = 0;
        for(int i = 0; i < str.toCharArray().length; i++){
            product *= str.charAt(i) - '0';
            sum += str.charAt(i) - '0';
        }
        return product - sum;*/

        int sum = 0, product = 1;
        while (n > 0) {
            sum += n % 10;
            product *= n % 10;
            n /= 10;
        }
        return product - sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}