//Given two strings s1 and s2, write a function to return true if s2 contains th
//e permutation of s1. In other words, one of the first string's permutations is t
//he substring of the second string. 
//
// 
//
// Example 1: 
//
// 
//Input: s1 = "ab" s2 = "eidbaooo"
//Output: True
//Explanation: s2 contains one permutation of s1 ("ba").
// 
//
// Example 2: 
//
// 
//Input:s1= "ab" s2 = "eidboaoo"
//Output: False
// 
//
// 
//
// Note: 
//
// 
// The input strings only contain lower case letters. 
// The length of both given strings is in range [1, 10,000]. 
// 
// Related Topics Two Pointers Sliding Window


package com.leetcode.editor.en;

import com.sun.javafx.logging.JFRInputEvent;

public class PermutationInString{
    public static void main(String[] args) {
       Solution solution = new PermutationInString().new Solution();
       solution.checkInclusion("ab", "eidboaoo");
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //用HashMap更方便
    public boolean checkInclusion(String s1, String s2) {
        int[] window = new int[26];
        int[] needs = new int[26];
        //记录一共有多少字母需要匹配
        int key = 0;
        for(int i = 0; i < s1.length(); i++){
            if(needs[s1.charAt(i) - 'a'] == 0) key++;
            needs[s1.charAt(i) - 'a']++;
        }
        int l = 0, r = 0, match = 0;
        while (r < s2.length()){
            char c1 = s2.charAt(r);
            if(needs[c1 - 'a'] != 0){
                window[c1 - 'a']++;
                if(window[c1 - 'a'] == needs[c1 - 'a'])
                    match++;
            }
            r++;
            //字母个数匹配上, 才能算这个字母匹配完成
            while (match == key){
                if(r - l == s1.length()) return true;
                char c2 = s2.charAt(l);
                if(needs[c2 - 'a'] != 0){
                    window[c2 - 'a']--;
                    if(window[c2 - 'a'] < needs[c2 - 'a'])
                        match--;
                }
                l++;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}