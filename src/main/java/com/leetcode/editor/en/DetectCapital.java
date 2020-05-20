//Given a word, you need to judge whether the usage of capitals in it is right o
//r not. 
//
// We define the usage of capitals in a word to be right when one of the followi
//ng cases holds: 
//
// 
// All letters in this word are capitals, like "USA". 
// All letters in this word are not capitals, like "leetcode". 
// Only the first letter in this word is capital, like "Google". 
// 
//Otherwise, we define that this word doesn't use capitals in a right way.
//
// 
//
// Example 1: 
//
// 
//Input: "USA"
//Output: True
// 
//
// 
//
// Example 2: 
//
// 
//Input: "FlaG"
//Output: False
// 
//
// 
//
// Note: The input will be a non-empty word consisting of uppercase and lowercas
//e latin letters. 
// Related Topics String


package com.leetcode.editor.en;

public class DetectCapital{
    public static void main(String[] args) {
       Solution solution = new DetectCapital().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*public boolean detectCapitalUse(String word) {
        return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
    }*/

    /*public boolean detectCapitalUse(String word){
        //记录大写字母的个数
        int cnt = 0;
        for(int i = 0; i < word.length(); i++){
            if(Character.isUpperCase(word.charAt(i))) cnt++;
        }
        if(cnt == 1) return Character.isUpperCase(word.charAt(0));
        return cnt == 0 || cnt == word.length();
    }*/

    public boolean detectCapitalUse(String word){
        //不用Character, 利用ascii中大写字母更小
        int cnt = 0;
        for (char c : word.toCharArray()) {
            if(c <= 'Z') {
                cnt++;
            }
        }
        if(word.length() == cnt || (word.charAt(0)<= 'Z' && cnt == 1) || (cnt == 0))
            return true;
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}