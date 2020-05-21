//Determine whether an integer is a palindrome. An integer is a palindrome when 
//it reads the same backward as forward. 
//
// Example 1: 
//
// 
//Input: 121
//Output: true
// 
//
// Example 2: 
//
// 
//Input: -121
//Output: false
//Explanation: From left to right, it reads -121. From right to left, it becomes
// 121-. Therefore it is not a palindrome.
// 
//
// Example 3: 
//
// 
//Input: 10
//Output: false
//Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
// 
//
// Follow up: 
//
// Coud you solve it without converting the integer to a string? 
// Related Topics Math


package com.leetcode.editor.en;

public class PalindromeNumber{
    public static void main(String[] args) {
       Solution solution = new PalindromeNumber().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int div = 1;
        while (x / div >= 10) div *= 10;
        //while条件x>9不行, 即只有个位数不一定就是回文 --> 去掉开头结尾的1后, 数字开头为0的则会判断错误; test case: "1000021"
        while (x > 0){
            int left = x / div;
            int right = x % 10;
            if(left != right) return false;
            //去掉首部
            x %= div;
            //去掉结尾
            x /= 10;
            //去掉首部结尾 --> /100
            div /= 100;
        }
        return true;
    }*/

    //特判: 除0之外, 假如是回文正数首部不可能为0, 所以尾部也不可能为0 --> 翻转对比
    /*public boolean isPalindrome(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)) return false;
        int revNum = 0;
        while (x > revNum){
            revNum = revNum * 10 + x % 10;
            x /= 10;
        }
        //奇数回文 x == revNum / 10
        return x == revNum || x == revNum / 10;
    }*/

    //回文整个翻转仍然是原数字, 不可能溢出
    public boolean isPalindrome(int x) {
       if(x < 0 || (x % 10 == 0 && x != 0)) return false;
       return reverse(x) == x;
    }

    private int reverse(int x){
        int res = 0;
        while (x != 0){
            int tail = x % 10;
            //此处因为有回文限制所以只需要考虑除个位外即可; 严格考虑边界需要加上 (res == Integer.MAX_VALUE / 10 && tail > 7)
            if(res > Integer.MAX_VALUE / 10) return -1;
            res = res * 10 + tail;
            x /= 10;
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


}