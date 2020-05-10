//Given a string, find the length of the longest substring without repeating cha
//racters. 
//
// 
// Example 1: 
//
// 
//Input: "abcabcbb"
//Output: 3 
//Explanation: The answer is "abc", with the length of 3. 
// 
//
// 
// Example 2: 
//
// 
//Input: "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// 
// Example 3: 
//
// 
//Input: "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3. 
//             Note that the answer must be a substring, "pwke" is a subsequence
// and not a substring.
// 
// 
// 
// 
// Related Topics Hash Table Two Pointers String Sliding Window


package com.leetcode.editor.en;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args) {
       Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
       solution.lengthOfLongestSubstring("abcabcbb");
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //freq[]相当于window, 此时用数组, 运行速度会更快; 但是只有一个while, 所以一次只可能更改一个值(left or right); 所以window内的值不会超条件, 但又要包含窗口长度, 所以差值还要再+1, 算上左指针那一格;
        //下面模板使用HashMap, 使用两个while, 可能同时更改两个值; 所以是当window超出条件时再移动left, 此时right已经多加一格了; 所以r-l
        int[] freq = new int[256];
        int l = 0, r = -1;
        int res = 0;
        //因为r初始为-1, 所以使用l判断; 实际上当右指针到边界的时候, 只会增加l使结果变小, 相当于多循环了使得左右指针都到最右边, 但是不影响结果; 下面的模板则无这个问题
        while(l < s.length()){
            if(r+1 < s.length() && freq[s.charAt(r+1)] == 0)
                freq[s.charAt(++r)]++;
            else //freq[s.charAt(r+1)] != 0 相当于下面的window.get(c1) > 1; left移动
                freq[s.charAt(l++)]--;
            //window的长度为差值+1, 因为0在数值计算时不算值, 但实际上占一格; 所以r-l+1
            res = Math.max(res, r-l+1);
        }
        return res;
    }

    /*public int lengthOfLongestSubstring(String s){
        int left = 0, right = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        int res = 0;

        while(right < s.length()){
            char c1 = s.charAt(right);
            window.put(c1, window.getOrDefault(c1, 0) + 1);
            right++;

            while (window.get(c1) > 1){
                char c2 = s.charAt(left);
                window.put(c2, window.getOrDefault(c2, 0) - 1);
                left++;
            }

            res = Math.max(res, right - left);
        }
        return res;
    }*/

}
//leetcode submit region end(Prohibit modification and deletion)


}