//Given a non-empty string s and a dictionary wordDict containing a list of non-
//empty words, determine if s can be segmented into a space-separated sequence of 
//one or more dictionary words. 
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
//Input: s = "leetcode", wordDict = ["leet", "code"]
//Output: true
//Explanation: Return true because "leetcode" can be segmented as "leet code".
// 
//
// Example 2: 
//
// 
//Input: s = "applepenapple", wordDict = ["apple", "pen"]
//Output: true
//Explanation: Return true because "applepenapple" can be segmented as "apple pe
//n apple".
//             Note that you are allowed to reuse a dictionary word.
// 
//
// Example 3: 
//
// 
//Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//Output: false
// 
// Related Topics Dynamic Programming


package com.leetcode.editor.en;

import com.sun.org.apache.xerces.internal.impl.XMLEntityManager;

import java.util.*;

public class WordBreak{
    public static void main(String[] args) {
       Solution solution = new WordBreak().new Solution();
       List<String> list = new ArrayList<String>(){{this.add("Leet"); this.add("code");}};
       String s = "Leetcode";
       solution.wordBreak(s, list);
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //暴力解法大O计算证明:O(2^n) https://leetcode.com/problems/word-break/discuss/169383/The-Time-Complexity-of-The-Brute-Force-Method-Should-Be-O(2n)-and-Prove-It-Below
    //递归+记忆化(用HashMap)
   /* public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<String>(wordDict);
        Map<String, Boolean> mem = new HashMap<String, Boolean>();
        return wordBreak(s, mem, dict);
    }
    private boolean wordBreak(String s, Map<String, Boolean> mem, Set<String> dict){
        if(mem.containsKey(s)) return mem.get(s);
        if(dict.contains(s)){
            mem.put(s, true);
            return true;
        }
        for(int i = 1; i < s.length(); ++i){
            if(dict.contains(s.substring(i)) && wordBreak(s.substring(0, i), mem, dict)){
                mem.put(s, true);
                return true;
            }
        }
        mem.put(s, false);
        return false;
    }*/

    //记忆化递归(用数组) 9ms
    /*public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<String>(wordDict);
        //memo[i]定义为从[i, n]的数组能否被拆分;
        //此处用Boolean, 初始化为null; boolean初始化为false(无法判断是否已访问过)
        Boolean[] memo = new Boolean[s.length() + 1];
        return wordBreak(s, memo, dict, 0);
    }

    private boolean wordBreak(String s, Boolean[] memo, Set<String> dict, int start){
        //使用start作为标识分割字符, 已经遍历完返回true
        if(start >= s.length()) return true;
        //递归到底, 相当于从右到左查看是否右边的可分; 所以右边一定有已经计算过是否可分的, 可直接返回; --> 其实下面的循环每次只需要重新查start,end即可, 递归部分已经计算过
        //s:"aaaaaaaaab" dict:[a, aa, aaa, aaaa] --> 不用重复计算[b, ab, aab..] 是否可分
        if(memo[start] != null) return memo[start];
        //因为substring前闭后开, end = start + 1, start最大为s.length(), 所以需要<=
        for(int end = start + 1; end <= s.length(); end++){
            if(dict.contains(s.substring(start, end)) && wordBreak(s, memo, dict, end)){
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }*/

    //DP 15ms
    /*public boolean wordBreak(String s, List<String> wordDict){
        if(s == null || wordDict == null) return false;
        HashSet<String> dict = new HashSet<String>(wordDict);
        //长度为i的str能否被分隔, 因为考虑空串所以数组大小+1
        boolean[] breakable = new boolean[s.length() + 1];
        breakable[0] = true; //base case
        //没有递归所以需要遍历所有子串,
        for(int i = 1; i <= s.length(); i++){
            for(int j = i; j > 0; j--){
                String sub = s.substring(i - j, i);
                if(dict.contains(sub)){
                    if(breakable[i - j]){ //breakable[i-j] 之前计算过
                        breakable[i] = true; //breakable[i] = breakable[i - j] + s.substring(i-j, i);
                        break;
                    }
                }
            }
        }
        return breakable[s.length()];
    }*/

    //BFS 队列用visited来标记是否计算过 效率最低24ms
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);
        boolean[] visited = new boolean[s.length()];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0); //base case
        while (!q.isEmpty()){
            int start = q.poll();
            if(!visited[start]){
                for(int i = start + 1; i <= s.length(); i++){
                    if(dict.contains(s.substring(start, i))){
                        //记录所有从start开始可以分隔的字符位置, 下一次从可分隔的位置再开始遍历
                        q.offer(i); // [start, i];
                        //遍历到底则说明可分隔范围包括整个str, 返回true
                        if(i == s.length()) return true;
                    }
                }
                //说明[start, ...]的已经计算过, 下一次从[i,...]开始
                visited[start] = true;
            }
        }
        return false;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


}