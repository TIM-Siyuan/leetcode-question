//Given an input string (s) and a pattern (p), implement regular expression matc
//hing with support for '.' and '*'. 
//
// 
//'.' Matches any single character.
//'*' Matches zero or more of the preceding element.
// 
//
// The matching should cover the entire input string (not partial). 
//
// Note: 
//
// 
// s could be empty and contains only lowercase letters a-z. 
// p could be empty and contains only lowercase letters a-z, and characters like
// . or *. 
// 
//
// Example 1: 
//
// 
//Input:
//s = "aa"
//p = "a"
//Output: false
//Explanation: "a" does not match the entire string "aa".
// 
//
// Example 2: 
//
// 
//Input:
//s = "aa"
//p = "a*"
//Output: true
//Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, 
//by repeating 'a' once, it becomes "aa".
// 
//
// Example 3: 
//
// 
//Input:
//s = "ab"
//p = ".*"
//Output: true
//Explanation: ".*" means "zero or more (*) of any character (.)".
// 
//
// Example 4: 
//
// 
//Input:
//s = "aab"
//p = "c*a*b"
//Output: true
//Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, i
//t matches "aab".
// 
//

// Example 5: 
//
// 
//Input:
//s = "mississippi"
//p = "mis*is*p*."
//Output: false
// 
// Related Topics String Dynamic Programming Backtracking


package com.leetcode.editor.en;

import java.util.Arrays;

public class RegularExpressionMatching{
    public static void main(String[] args) {
       Solution solution = new RegularExpressionMatching().new Solution();
       //solution.isMatch("sippi", "s*p*.");
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*public boolean isMatch(String s, String p) {
        //判断都为空的情况
        if(p.isEmpty()) return s.isEmpty();

        //不能先赋值, 这样的话当s为空且p.charAt(1) != '*'时, out of bound; 此条判断无需first_match;
        //boolean first_match = (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        //p只剩一个数的情况, 可以直接判断
        if(p.length() == 1) return s.length() == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        //假如p的第二位不为*, 则意味着不可能可能重复0次
        if(p.charAt(1) != '*'){
            //s为空则错
            if(s.isEmpty()) return false;
            //s不为空, 且第一位相等继续比较
            return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1));
        }
        //第二位为*, 需要在第一位不为空且相等前提下比较;
        while (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')){
            //因为不知道*号代表的s的重复个数; 所以需要不断变化s字符; 进入while不断变化s, 直到比较完毕s重复的字符与p*前的字符;
            //s:"aaaab", p:"a*b"; 只有轮到b的时候不改变s返回true, 此时s:"b" p:"a*b" --> 上一轮的不进入while, 直接进行最后的判断判断*号后面的字符是否相等
            if(isMatch(s, p.substring(2))) return true;
            //探究下一个s字符, 因为*可表示的重复次数不为1; p不变
            s = s.substring(1);
        }

        return isMatch(s, p.substring(2));
    }*/

    //暴力递归
    /*public boolean isMatch(String s, String p){
        if(p.isEmpty()) return s.isEmpty();
        //判断*号
        if(p.length() > 1 && p.charAt(1) == '*'){
            // 最后判断*号后的字符 || 递归判断*号前的字符, isMatch(s.substring(1),p) 代替循环
            return isMatch(s, p.substring(2)) || (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p));
        }
        else {
            //一一判断字符是否相等, 并进入下一字符的判断
            return !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1));
        }
    }*/

    public boolean isMatch(String s, String p){
        if(s == null || p == null) return false;
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        for(int i = 0; i <= m; i++){
            if(p.charAt(i) == '*' && dp[0][i - 1]){
                dp[0][i + 1] = true;
            }
//            Arrays.fill(dp[i], false);
        }
        dp[0][0] = true; //base case

        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                /*if (j > 1 && p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2] || (i > 0 && s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.' && dp[i - 1][j]);
                }
                else {
                    dp[i][j] = i > 0 && dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 2) == '.');
                }*/
                if(p.charAt(j) == '.'){
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if(p.charAt(j) == s.charAt(i)){
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if(p.charAt(j) == '*'){
                    if(p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.'){
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    }
                    else {
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                    }
                }
            }
        }
        return dp[m][n];
    }

}
//leetcode submit region end(Prohibit modification and deletion)


}