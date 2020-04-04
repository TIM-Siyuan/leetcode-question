//Given a string s and a non-empty string p, find all the start indices of p's a
//nagrams in s. 
//
// Strings consists of lowercase English letters only and the length of both str
//ings s and p will not be larger than 20,100. 
//
// The order of output does not matter. 
//
// Example 1:
// 
//Input:
//s: "cbaebabacd" p: "abc"
//
//Output:
//[0, 6]
//
//Explanation:
//The substring with start index = 0 is "cba", which is an anagram of "abc".
//The substring with start index = 6 is "bac", which is an anagram of "abc".
// 
// 
//
// Example 2:
// 
//Input:
//s: "abab" p: "ab"
//
//Output:
//[0, 1, 2]
//
//Explanation:
//The substring with start index = 0 is "ab", which is an anagram of "ab".
//The substring with start index = 1 is "ba", which is an anagram of "ab".
//The substring with start index = 2 is "ab", which is an anagram of "ab".
// 
// Related Topics Hash Table


package com.leetcode.editor.en;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString{
    public static void main(String[] args) {
       Solution solution = new FindAllAnagramsInAString().new Solution();
       solution.findAnagrams("cbaebabacd", "abc");
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<Integer>();
        if(s == null || p == null || s.length() < p.length())
           return list;
        int[] ap = new int[26];
        int[] as = new int[26];
        for(char c : p.toCharArray()){
            ap[c-'a']++;
        }
        for(int i = 0; i < s.length(); i++){
            if(i >= p.length()) --as[s.charAt(i-p.length()) - 'a'];
            ++as[s.charAt(i) - 'a'];
            if(Arrays.equals(ap, as)) list.add(i+1-p.length());
        }
        return list;
    }
}
//leetcode submit r
// .egion end(Prohibit modification and deletion)


}