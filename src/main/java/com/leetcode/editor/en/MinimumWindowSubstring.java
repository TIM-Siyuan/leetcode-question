//Given a string S and a string T, find the minimum window in S which will conta
//in all the characters in T in complexity O(n). 
//
// Example: 
//
// 
//Input: S = "ADOBECODEBANC", T = "ABC"
//Output: "BANC"
// 
//
// Note: 
//
// 
// If there is no such window in S that covers all characters in T, return the e
//mpty string "". 
// If there is such window, you are guaranteed that there will always be only on
//e unique minimum window in S. 
// 
// Related Topics Hash Table Two Pointers String Sliding Window


package com.leetcode.editor.en;

import java.util.HashMap;

public class MinimumWindowSubstring{
    public static void main(String[] args) {
       Solution solution = new MinimumWindowSubstring().new Solution();
       solution.minWindow("ADOBECODEBANC", "ABC");
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0) return null;
        if (t == null || t.length() == 0) return null;
        int left = 0, right = 0;
        int start = 0, minLen = Integer.MAX_VALUE;
        String res = s;

        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> needs = new HashMap<>();
        for (char c : t.toCharArray())
            needs.put(c, needs.getOrDefault(c, 0) + 1);

        int match = 0;

        while (right < s.length()) {
            char c1 = s.charAt(right);
            if (needs.containsKey(c1)) {
                window.put(c1, window.getOrDefault(c1, 0) + 1);
                // numbers object 用equals, 不用 ==
                if (window.get(c1).equals(needs.get(c1)))
                    match++;
            }
            right++;

            while (match == needs.size()) {
                if(right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }
                char c2 = s.charAt(left);
                if (needs.containsKey(c2)) {
                    window.put(c2, window.getOrDefault(c2, 0) - 1);
                    if (window.get(c2) < needs.get(c2))
                        match--;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}