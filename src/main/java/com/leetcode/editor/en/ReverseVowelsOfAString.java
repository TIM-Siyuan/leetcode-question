//Write a function that takes a string as input and reverse only the vowels of a
// string. 
//
// Example 1: 
//
// 
//Input: "hello"
//Output: "holle"
// 
//
// 
// Example 2: 
//
// 
//Input: "leetcode"
//Output: "leotcede" 
// 
//
// Note: 
//The vowels does not include the letter "y". 
//
// 
// Related Topics Two Pointers String


package com.leetcode.editor.en;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfAString{
    public static void main(String[] args) {
       Solution solution = new ReverseVowelsOfAString().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //follow up: s.indexOf 2ms = char[] 2ms < set 6ms; new String(ch[]) < StringBuilder;
    //Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    //static final String vowels = "aeiouAEIOU";
    public String reverseVowels(String s) {
        if(s == null || s.length() == 0) return "";
        int l = 0, r = s.length() - 1;
        char[] ch = s.toCharArray();
        while (l < r){
            if(isVowels(ch[l]) && isVowels(ch[r])){
                char temp = ch[l];
                ch[l] = ch[r];
                ch[r] = temp;
                l++;
                r--;
            }
            else if(isVowels(ch[l])) r--;
            else l++;
        }
        return new String(ch);
        /*StringBuilder sb = new StringBuilder();
        for(char c : ch) sb.append(c);
        return sb.toString();*/
    }

    private boolean isVowels(char c){
        return c == 'a' || c =='e' || c == 'i' || c == 'o' || c == 'u'
            || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}