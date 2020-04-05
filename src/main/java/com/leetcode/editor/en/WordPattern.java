//Given a pattern and a string str, find if str follows the same pattern. 
//
// Here follow means a full match, such that there is a bijection between a lett
//er in pattern and a non-empty word in str. 
//
// Example 1: 
//
// 
//Input: pattern = "abba", str = "dog cat cat dog"
//Output: true 
//
// Example 2: 
//
// 
//Input:pattern = "abba", str = "dog cat cat fish"
//Output: false 
//
// Example 3: 
//
// 
//Input: pattern = "aaaa", str = "dog cat cat dog"
//Output: false 
//
// Example 4: 
//
// 
//Input: pattern = "abba", str = "dog dog dog dog"
//Output: false 
//
// Notes: 
//You may assume pattern contains only lowercase letters, and str contains lower
//case letters that may be separated by a single space. 
// Related Topics Hash Table


package com.leetcode.editor.en;

import java.util.HashMap;

public class WordPattern{
    public static void main(String[] args) {
       Solution solution = new WordPattern().new Solution();
       solution.wordPattern("abba", "dog dog dog dog");
    }
    // String比较用equals; 考虑key相同，value不同 和 key不同，value相同两种情况; 都为空为true，一空为负
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordPattern(String pattern, String str) {
        if(pattern.length() == 0 || str.length() == 0)
            return pattern == str;
        HashMap<Character, String> map = new HashMap<Character, String>();
        char[] p = pattern.toCharArray();
        String[] s = str.split("\\s+");
        if(p.length != s.length)
            return false;
        for(int i = 0; i < p.length; i++){
            if(map.containsKey(p[i])){
                if(!map.get(p[i]).equals(s[i]))
                    return false;
            }else{
                if(i >= 1 && (s[i-1]).equals(s[i])){
                    System.out.println("False");
                    return false;
                }
                map.put(p[i], s[i]);
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}