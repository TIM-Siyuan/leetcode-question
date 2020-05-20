//Given a non-empty string s and a dictionary wordDict containing a list of non-
//empty words, add spaces in s to construct a sentence where each word is a valid 
//dictionary word. Return all such possible sentences. 
//
// Note: 
//
// 
// The same word in the dictionary may be reused multiple times in the segmentat
//ion. 
// You may assume the dictionary does not contain duplicate words. 
// 
//
// Example 1: 
//
// 
//Input:
//s = "catsanddog"
//wordDict = ["cat", "cats", "and", "sand", "dog"]
//Output:
//[
//  "cats and dog",
//  "cat sand dog"
//]
// 
//
// Example 2: 
//
// 
//Input:
//s = "pineapplepenapple"
//wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
//Output:
//[
//  "pine apple pen apple",
//  "pineapple pen apple",
//  "pine applepen apple"
//]
//Explanation: Note that you are allowed to reuse a dictionary word.
// 
//
// Example 3: 
//
// 
//Input:
//s = "catsandog"
//wordDict = ["cats", "dog", "sand", "and", "cat"]
//Output:
//[] 
// Related Topics Dynamic Programming Backtracking


package com.leetcode.editor.en;

import sun.awt.image.ImageWatched;

import java.util.*;

public class WordBreakIi{
    public static void main(String[] args) {
       Solution solution = new WordBreakIi().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*//将word break的所有可能情况记录: 所以不能用DP(DP只能看某一时的状态); 求所有情况用遍历(递归+记忆化)
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);
        //used记录[i, n]的字符串有多少可分的结果;
        HashMap<String, List<String>> used = new HashMap<>();
        return helper(s, dict, used);
    }

    //递归: 从1开始计算左边是否可分, 可分递归求解右边是否可分并返回所有结果, 左边可分的再添加上右边返回的结果
    private List<String> helper(String s, HashSet<String> dict, HashMap<String, List<String>> used){
        if(s.length() == 0) return null;
        if(used.containsKey(s)) return used.get(s);
        List<String> sub_res = new LinkedList<>();
        for(int i = 1; i <= s.length(); i++){
            String sub = s.substring(0, i);
            List<String> partRes = null;
            //左边[0, i) 可分隔
            if(dict.contains(sub)){
                //获取右边可分的所有结果
                partRes = helper(s.substring(i), dict, used);
                //前提:sub可分隔, partRes为null时, 说明i == s.length表明i到底了, 即整个子串在dict中, 右边没有再可分割的;
                if(partRes == null){
                    sub_res.add(sub);
                }
                else {
                    for(String str : partRes){
                        sub_res.add(sub + " " + str);
                    }
                }
            }
        }
        //此时的s是递归的s.substring(i), 每一层不同;
        used.put(s, sub_res);
        return sub_res;
    }*/

    //先对wordDict进行分析, 当for循环长度不合适的时候直接退出不继续, 相当于剪枝提升效率
    public List<String> wordBreak(String s, List<String> wordDict) {
    /*
    "applecatapple", ["apple", "cat", "catapple", applecat", "app", "tapple"]

    => "apple cat apple"
    => "applecat apple"
    => "apple catapple"

    applecatapple

    1) Divide the word into two parts
    a pplecatapple
    ap plecatapple
    app lecatapple
    appl ecatapple
    apple catapple
    ...

    2) If the first part (or "prefix") is in the list of words, check if the second part ("suffix") can be formed by the words in the list

    apple catapple
    => "apple" is in the list of the words. Check if "catapple" can be formed by the words in the list

    catapple
    => "catapple" is in the list of words. Add "apple catapple" to the result
    c atapple
    ..
    cat apple
    => "cat" is in the list of words. Check if "apple" can be formed by the words in the list
    ...

    Observations:
    1) We can reduce the number of "breaks" by checking the length of the shortest and the longest words in the list
    a pplecatapple <-- "a" won't exist in the list of words, since the shortest word has length of 3

    app lecatapple
    appl ecatapple
    apple catapple
    ...
    applecata pple <-- "applecata" won't exist in the list of words, since the longest word has length of 8

    2) We can use memoization to reduce the # of recursive calls
    01234 567 89..
    apple cat apple <-- we already know that the last "apple", or s[8..end] can be formed.
    => Use HashMap to store this information. 8: ["apple"]
    */

        Set<String> wordSet = new HashSet<>(wordDict);

        int minLength = Integer.MAX_VALUE, maxLength = Integer.MIN_VALUE;
        for (String word : wordDict) {
            minLength = Math.min(minLength, word.length());
            maxLength = Math.max(maxLength, word.length());
        }

        return breakWord(0, minLength, maxLength, new HashMap<>(), s, wordSet);
    }

    private List<String> breakWord(int startIndex, int minLength, int maxLength, Map<Integer, List<String>> map, String s, Set<String> wordSet) {
        if (map.containsKey(startIndex)) {
            return map.get(startIndex);
        }
        List<String> res = new ArrayList<>();
        for (int length = minLength; length <= maxLength && startIndex + length <= s.length(); length++) {
            String prefix = s.substring(startIndex, startIndex + length);
            if (wordSet.contains(prefix)) {
                if (startIndex + length == s.length()) {
                    res.add(prefix);
                } else {
                    List<String> suffix = breakWord(startIndex + length, minLength, maxLength, map, s, wordSet);
                    for (String nextWord : suffix) {
                        res.add(new StringBuilder(prefix).append(" ").append(nextWord).toString());
                    }
                }
            }
        }
        map.put(startIndex, res);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}