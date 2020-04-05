//Given two strings s and t , write a function to determine if t is an anagram o
//f s. 
//
// Example 1: 
//
// 
//Input: s = "anagram", t = "nagaram"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s = "rat", t = "car"
//Output: false
// 
//
// Note: 
//You may assume the string contains only lowercase alphabets. 
//
// Follow up: 
//What if the inputs contain unicode characters? How would you adapt your soluti
//on to such case? 
// Related Topics Hash Table Sort


package com.leetcode.editor.en;

public class ValidAnagram{
    public static void main(String[] args) {
       Solution solution = new ValidAnagram().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        int[] as = new int[26];
        int[] at = new int[26];
        for(char cs : s.toCharArray()){
            as[cs-'a']++;
        }
        for(char ts : t.toCharArray()){
            at[ts-'a']++;
        }
        for(int i = 0; i < 26; i++){
            if(as[i] != at[i]) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}