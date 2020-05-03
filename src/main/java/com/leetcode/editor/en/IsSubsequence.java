//
//Given a string s and a string t, check if s is subsequence of t.
// 
//
// 
//You may assume that there is only lower case English letters in both s and t. 
//t is potentially a very long (length ~= 500,000) string, and s is a short string
// (<=100).
// 
//
// 
//A subsequence of a string is a new string which is formed from the original st
//ring by deleting some (can be none) of the characters without disturbing the rel
//ative positions of the remaining characters. (ie, "ace" is a subsequence of "abc
//de" while "aec" is not).
// 
//
// Example 1: 
//s = "abc", t = "ahbgdc"
// 
// 
//Return true.
// 
//
// Example 2: 
//s = "axc", t = "ahbgdc"
// 
// 
//Return false.
// 
//
// Follow up: 
//If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you w
//ant to check one by one to see if T has its subsequence. In this scenario, how w
//ould you change your code? 
//
// Credits: Special thanks to @pbrother for adding this problem and creating all
// test cases. Related Topics Binary Search Dynamic Programming Greedy


package com.leetcode.editor.en;

public class IsSubsequence{
    public static void main(String[] args) {
       Solution solution = new IsSubsequence().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s == null || s.length() == 0) return true;
        int si = 0, ti = 0;
        while(si < s.length() && ti < t.length()){
            if(s.charAt(si) == t.charAt(ti)){
                si++;
            }
            ti++;
        }
        return si == s.length();

        /*int i = 0;
        for (int j = 0; j < t.length() && i < s.length(); ++j) {
            if (s.charAt(i) == t.charAt(j)) ++i;
        }
        return i == s.length();*/
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}