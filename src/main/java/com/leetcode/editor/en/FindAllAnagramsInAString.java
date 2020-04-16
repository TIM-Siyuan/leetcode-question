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


import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString{
    public static void main(String[] args) {
       Solution solution = new FindAllAnagramsInAString().new Solution();
       solution.findAnagrams("cbaebabacd", "abc");
    }

//   https://blog.csdn.net/yy254117440/article/details/53025142
//   https://www.jianshu.com/p/bfb990b4ba22

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        /*List<Integer> list = new ArrayList<Integer>();
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
        return list;*/

        List<Integer> list = new ArrayList<Integer>();
        if (s == null || s.length() == 0 || s.length() < p.length()) {
            return list;
        }
        int[] arr = new int[256];
        for (char ch : p.toCharArray()) {
            arr[ch]++;
        }
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            if (arr[s.charAt(right++)]-- >= 1) {
                count--;
            }
            if (count == 0) {
                list.add(left);
            }
            if (arr[s.charAt(left++)]++ >= 0 && right - left == p.length() ) {
                count++;
            }
        }
        return list;
    }
}
//leetcode submit r
// .egion end(Prohibit modification and deletion)


}