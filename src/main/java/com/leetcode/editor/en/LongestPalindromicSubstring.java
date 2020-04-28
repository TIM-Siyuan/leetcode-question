//Given a string s, find the longest palindromic substring in s. You may assume 
//that the maximum length of s is 1000. 
//
// Example 1: 
//
// 
//Input: "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: "cbbd"
//Output: "bb"
// 
// Related Topics String Dynamic Programming


package com.leetcode.editor.en;

import java.util.Arrays;

public class LongestPalindromicSubstring{
    public static void main(String[] args) {
       Solution solution = new LongestPalindromicSubstring().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n == 0) return s;
        boolean[][] dp = new boolean[n][n];
        int max = 0;
        String res = s.substring(0, 1);
        for(int i = n - 1; i >= 0; i--){
            for(int j = i; j < n; j++){
                if(s.charAt(i) == s.charAt(j) && ((j - i <= 2) || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (max < j - i + 1) {
                        max = j - i + 1;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}