//Given a string s that consists of only uppercase English letters, you can perf
//orm at most k operations on that string. 
//
// In one operation, you can choose any character of the string and change it to
// any other uppercase English character. 
//
// Find the length of the longest sub-string containing all repeating letters yo
//u can get after performing the above operations. 
//
// Note: 
//Both the string's length and k will not exceed 104. 
//
// Example 1: 
//
// 
//Input:
//s = "ABAB", k = 2
//
//Output:
//4
//
//Explanation:
//Replace the two 'A's with two 'B's or vice versa.
// 
//
// 
//
// Example 2: 
//
// 
//Input:
//s = "AABABBA", k = 1
//
//Output:
//4
//
//Explanation:
//Replace the one 'A' in the middle with 'B' and form "AABBBBA".
//The substring "BBBB" has the longest repeating letters, which is 4.
// 
//
// 
// Related Topics Two Pointers Sliding Window


package com.leetcode.editor.en;

public class LongestRepeatingCharacterReplacement{
    public static void main(String[] args) {
       Solution solution = new LongestRepeatingCharacterReplacement().new Solution();
       solution.characterReplacement("ABAB", 2);
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int l = 0, r = 0, res = 0, maxCnt = 0;
        //for(int r = 0; r < s.length(); r++) {
        while (r < s.length()) {
            // i++是先使用i再++; ++i为先++再使用i;
            // 使用count[]++则程序错, 则maxCnt比较的是count[], 需要下一次循环的时候maxCnt才更新为count[]++;
            // 导致maxCnt比正确的小就进入if, l++, 使窗口没到真正的最大值就结束了, 导致最后结果小
            maxCnt = Math.max(maxCnt, count[s.charAt(r) - 'A']++);
            if (r - l + 1 - maxCnt > k) {
                count[s.charAt(l) - 'A']--;
                l++;
            }

            res = Math.max(res, r - l + 1);
            r++;
        }
        //}
        return res;
    }
}

   /* int len = s.length();
    int[] count = new int[26];
    int l = 0, maxCount = 0, res = 0;
        for (int r = 0; r < len; r++) {
        maxCount = Math.max(maxCount, ++count[s.charAt(r) - 'A']);
        if (r - l + 1 - maxCount > k) {
            count[s.charAt(l) - 'A']--;
            l++;
        }
        res = Math.max(res, r - l + 1);
    }
        return res;*/
//leetcode submit region end(Prohibit modification and deletion)


}