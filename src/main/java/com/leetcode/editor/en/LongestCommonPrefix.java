//Write a function to find the longest common prefix string amongst an array of 
//strings. 
//
// If there is no common prefix, return an empty string "". 
//
// Example 1: 
//
// 
//Input: ["flower","flow","flight"]
//Output: "fl"
// 
//
// Example 2: 
//
// 
//Input: ["dog","racecar","car"]
//Output: ""
//Explanation: There is no common prefix among the input strings.
// 
//
// Note: 
//
// All given inputs are in lowercase letters a-z. 
// Related Topics String


package com.leetcode.editor.en;

import java.util.Arrays;

public class LongestCommonPrefix{
    public static void main(String[] args) {
       Solution solution = new LongestCommonPrefix().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //暴力解法: 遍历每个字符串的每个字符
   /* public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        StringBuilder res = new StringBuilder();
        for(int j = 0; j < strs[0].length(); j++){
            for(int i = 1; i < strs.length; i++){
                if(j >= strs[i].length() || strs[i].charAt(j) != strs[i - 1].charAt(j)){
                    return res.toString();
                }
            }
            res.append(strs[0].charAt(j));
        }
        return res.toString();
    }*/

    /*public String longestCommonPrefix(String[] strs){
        if (strs == null || strs.length == 0) return "";
        for(int j = 0; j < strs[0].length(); j++){
            for (int i = 1; i < strs.length; i++){
                if(j >= strs[i].length() || strs[0].charAt(j) != strs[i].charAt(j)){
                    return strs[0].substring(0, j);
                }
            }
        }
        return strs[0];
    }*/

    //利用indexOf, 效率最高
    public String longestCommonPrefix(String[] strs){
        if(strs == null || strs.length == 0) return "";
        String res = strs[0];
        for(int i = 0; i < strs.length; i++){
            String prefix = strs[i];
            //假如前缀和不匹配则不断修改前缀和; 这样当找到了最短的前缀和的时候节省了后续匹配的时间;
            while (prefix.indexOf(res) != 0){
                res = res.substring(0, res.length() - 1);
            }
        }
        return res;
    }

    //先排序, 则其实相同字母越多的越排在一起; 这样排序完成后只需考虑两个差异最大的元素(首尾)
    /*public String longestCommonPrefix(String[] strs){
        if(strs == null || strs.length == 0) return "";
        Arrays.sort(strs);
        int n = strs.length;
        //遍历长度最短的字符串;
        int len = Math.min(strs[0].length(), strs[n - 1].length());
        int i = 0;
        while(i < len){
            if(strs[0].charAt(i) != strs[n - 1].charAt(i)) return strs[0].substring(0, i);
            i++;
        }
        return strs[0];
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)


}