//Given a string, determine if it is a palindrome, considering only alphanumeric
// characters and ignoring cases. 
//
// Note: For the purpose of this problem, we define empty string as valid palind
//rome. 
//
// Example 1: 
//
// 
//Input: "A man, a plan, a canal: Panama"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: "race a car"
//Output: false
// 
// Related Topics Two Pointers String


package com.leetcode.editor.en;

public class ValidPalindrome{
    public static void main(String[] args) {
       Solution solution = new ValidPalindrome().new Solution();
       solution.isPalindrome("0P");
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) return true;
        int l = 0, r = s.length() - 1;
        char[] cs = s.toCharArray();
        while (l < r){
            char cl = cs[l];
            char cr = cs[r];
            if(!Character.isLetterOrDigit(cl)){
                l++;
                continue;
            }
            if(!Character.isLetterOrDigit(cr)) {
                r--;
                continue;
            }
            if(Character.toLowerCase(cl) != Character.toLowerCase(cr)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}