//Given two words (beginWord and endWord), and a dictionary's word list, find th
//e length of shortest transformation sequence from beginWord to endWord, such tha
//t: 
//
// 
// Only one letter can be changed at a time. 
// Each transformed word must exist in the word list. Note that beginWord is not
// a transformed word. 
// 
//
// Note: 
//
// 
// Return 0 if there is no such transformation sequence. 
// All words have the same length. 
// All words contain only lowercase alphabetic characters. 
// You may assume no duplicates in the word list. 
// You may assume beginWord and endWord are non-empty and are not the same. 
// 
//
// Example 1: 
//
// 
//Input:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//Output: 5
//
//Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog
//" -> "cog",
//return its length 5.
// 
//
// Example 2: 
//
// 
//Input:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//Output: 0
//
//Explanation: The endWord "cog" is not in wordList, therefore no possible trans
//formation.
// 
//
// 
// 
// Related Topics Breadth-first Search


package com.leetcode.editor.en;

import java.util.*;

public class WordLadder{
    public static void main(String[] args) {
       Solution solution = new WordLadder().new Solution();
       ArrayList<String> list = new ArrayList<String>();
       ArrayList<String> list2 = new ArrayList<String>();
       Collections.addAll(list, "hot","dot","dog","lot","log","cog");
       Collections.addAll(list2, "hot","dot","dog","lot","log");
//       solution.getNexts("dog", list);
       solution.ladderLength("hit", "cog", list2);
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        HashMap<String, Integer> visited = new HashMap<>();
        if(beginWord.equals(endWord)) return 1;

        queue.add(beginWord);
        visited.put(beginWord, 1);

        while (!queue.isEmpty()) {
            String cur = queue.remove();
            ArrayList<String> nexts = getNexts(cur, wordList);
            if(nexts == null) return 0;
            for(String next:nexts){
                if(!visited.containsKey(next)){
                    queue.add(next);
                    visited.put(next, visited.get(cur) + 1);
                    if(next.equals(endWord))
                        return visited.get(next);
                }
            }
        }
        return 0;
    }

    private ArrayList<String> getNexts(String s, List<String> wordList){
        ArrayList<String> list = new ArrayList<String>();
        char[] ch1 = s.toCharArray();
        for(String word: wordList){
            int count = 0;
            char[] ch2 = word.toCharArray();
            if(ch2 == null) return null;
            for(int i = 0; i < s.length(); i++){
                if(ch1[i] == ch2[i])
                    count++;
            }
            if(count == s.length()-1){
                list.add(word);
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}