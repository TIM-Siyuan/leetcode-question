//In an alien language, surprisingly they also use english lowercase letters, bu
//t possibly in a different order. The order of the alphabet is some permutation o
//f lowercase letters. 
//
// Given a sequence of words written in the alien language, and the order of the
// alphabet, return true if and only if the given words are sorted lexicographical
//y in this alien language. 
// 
// Example 1: 
//
// 
//Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
//Output: true
//Explanation: As 'h' comes before 'l' in this language, then the sequence is so
//rted.
// 
//
// Example 2: 
//
// 
//Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
//Output: false
//Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1]
//, hence the sequence is unsorted.
// 
//
// Example 3: 
//
// 
//Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
//Output: false
//Explanation: The first three characters "app" match, and the second string is 
//shorter (in size.) According to lexicographical rules "apple" > "app", because '
//l' > '∅', where '∅' is defined as the blank character which is less than any oth
//er character (More info).
// 
//
// 
// Constraints: 
//
// 
// 1 <= words.length <= 100 
// 1 <= words[i].length <= 20 
// order.length == 26 
// All characters in words[i] and order are English lowercase letters. 
// 
// Related Topics Hash Table


package com.leetcode.editor.en;

public class VerifyingAnAlienDictionary{
    public static void main(String[] args) {
       Solution solution = new VerifyingAnAlienDictionary().new Solution();
       String[] words = {"word","world","row"};
       String order = "worldabcefghijkmnpqstuvxyz";
       solution.isAlienSorted(words, order);
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        //用数组存储字母的index
        int[] dict = new int[26];
        for(int i = 0; i < 26; i++){
            dict[order.charAt(i) - 'a'] = i;
        }
        //word的每个字符依次比较; 全部字符都符合要求返回true; 中间有一个不匹配返回false退出
        for(int i = 1; i < words.length; i++){
            if(compare(words[i - 1], words[i], dict) > 0) return false;
        }
        return true;
    }

    private int compare(String s1, String s2, int[] dict){
        int i = 0;
        while (i < Math.min(s1.length(), s2.length())){
            int c1 = dict[s1.charAt(i) - 'a'];
            int c2 = dict[s2.charAt(i) - 'a'];
            if(c1 != c2)
                return c1 - c2;
            i++;
        }
        return i == s1.length() ? -1 : 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}