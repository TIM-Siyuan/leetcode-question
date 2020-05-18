//
//Given a non-empty string s, you may delete at most one character. Judge whethe
//r you can make it a palindrome.
// 
//
// Example 1: 
// 
//Input: "aba"
//Output: True
// 
// 
//
// Example 2: 
// 
//Input: "abca"
//Output: True
//Explanation: You could delete the character 'c'.
// 
// 
//
// Note: 
// 
// The string will only contain lowercase characters a-z.
//The maximum length of the string is 50000. 
// 
// Related Topics String


package com.leetcode.editor.en;

public class ValidPalindromeIi{
    public static void main(String[] args) {
       Solution solution = new ValidPalindromeIi().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //判断要删除哪边
    /*public boolean validPalindrome(String s) {
        if(s == null || s.length() == 0) return true;
        int l = 0, r = s.length() - 1, count = 1;
        while (l < r){
            if(s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }
            else
                return isPalindrome(s, l, r - 1) || isPalindrome(s, l + 1, r);
        }
        return true;
    }

    private boolean isPalindrome(String str, int l, int r){
        while (l < r){
            if(str.charAt(l) == str.charAt(r)){
                l++;
                r--;
            }
            else
                return false;
        }
        return true;
    }*/

    //用两个while不新建另一个函数
    public boolean validPalindrome(String s){
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if(s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }
            else {
                //remove right
                int left = l, right = r - 1;
                while (left < right){
                    if(s.charAt(left) != s.charAt(right)) break;
                    left++; right--;
                    if(left >= r) return true;
                }
                //remove left
                l++;
                while (l < r){
                    if(s.charAt(l) != s.charAt(r)) return false;
                    l++; r--;
                }
            }
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


}