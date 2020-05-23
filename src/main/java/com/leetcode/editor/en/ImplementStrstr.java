//Implement strStr(). 
//
// Return the index of the first occurrence of needle in haystack, or -1 if need
//le is not part of haystack. 
//
// Example 1: 
//
// 
//Input: haystack = "hello", needle = "ll"
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: haystack = "aaaaa", needle = "bba"
//Output: -1
// 
//
// Clarification: 
//
// What should we return when needle is an empty string? This is a great questio
//n to ask during an interview. 
//
// For the purpose of this problem, we will return 0 when needle is an empty str
//ing. This is consistent to C's strstr() and Java's indexOf(). 
// Related Topics Two Pointers String


package com.leetcode.editor.en;

public class ImplementStrstr{
    public static void main(String[] args) {
       Solution solution = new ImplementStrstr().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {
        /*if(needle.length() == 0) return 0;
        int h = 0, n = 0;
        char[] ch = haystack.toCharArray();
        char[] cn = needle.toCharArray();
        while (h < haystack.length()){
            if(ch[h] == cn[n]) n++;
            else{
                //h退回最开始匹配的位置, 从最开始匹配的下一个字符开始重新check
                h = h - n;
                n = 0;
            }
            h++;
            if(n == needle.length()) return h - n;
        }
        return -1;*/

        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }

        /*String s = haystack, t = needle;
        if (t.isEmpty()) return 0; // edge case: "",""=>0  "a",""=>0
        for (int i = 0; i <= s.length() - t.length(); i++) {
            for (int j = 0; j < t.length() && s.charAt(i + j) == t.charAt(j); j++)
                if (j == t.length() - 1) return i;
        }
        return -1;*/
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}