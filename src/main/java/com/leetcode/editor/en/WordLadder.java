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
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // BFS
    /*    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
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
        }*/

    // BFS
    /*public int ladderLength(String beginWord, String endWord, List<String> wordList){
        //变HashSet, O(1)查找速度
        HashSet<String> dict = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int level = 0;

        //整个过程的搜索-->里面有许多层
        while (!q.isEmpty()){
            //记录此层层数, 下面遍历的也是这一层; Bi-BFS初始为1
            level++;

            //每一层每一个字符的搜索; q.size是这一层字符的数量
            int size = q.size();
            for(int i = 0; i < size; i++){
                String cur = q.poll();
                //如果此层中有需要的结果, 返回层数
                if(cur.equals(endWord)) return level;

                //假如没有, 更改字母的字符并检测是否可组成正确字符: backtracking --> 构建下一层元素
                StringBuilder sb = new StringBuilder(cur);
                for(int j = 0; j < cur.length(); j++){
                    for(char c = 'a'; c <= 'z'; c++){
                        if(c == cur.charAt(j)) continue;
                        sb.setCharAt(j, c);
                        if(dict.contains(sb.toString())){
                            q.offer(sb.toString());
                            //不走回头路 --> 假如在后面的搜寻中找到相同字符, 其所需要的路径必然更长, 所以可删去, 无需重复计算
                            //相当于visited;
                            dict.remove(sb.toString());
                        }
                    }
                    sb.setCharAt(j, cur.charAt(j));
                }
            }
        }
        //如果整个搜索都没有找到结果说明endWord不在dict中, 返回0;
        return 0;
    }*/

    //Bi-BFS
    public int ladderLength(String beginWord, String endWord, Set<String> wordList){
        HashSet<String> dict = new HashSet<>(wordList);
        //因为Bi-BFS只遍历到相交, 却无法判定相交时是否含有endWord; 所以需要判断dict中没有endWord的情况返回0
        if(!dict.contains(endWord)) return 0;
        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();
        //初始为1, 因为存在beginWord, 循环中直接遍历下一层元素
        int level = 1;

        set1.add(beginWord);
        set2.add(endWord);
        //默认每次都是set1往前走; 在每次循环的最后交换set1, set2位置, 这样复用了代码, 两边各往中间搜索;
        while (!set1.isEmpty() && !set2.isEmpty()){
            //优化效率: 用较小的扩散, 需要遍历的元素少, 效率更高
            if(set1.size() > set2.size()){
                HashSet<String> set = set1;
                set1 = set2;
                set2 = set;
            }

            HashSet<String> temp = new HashSet<>();
            //使用char[]数组效率更高
            /*for(String word : set1){
                StringBuilder sb = new StringBuilder(word);
                for(int j = 0; j < word.length(); j++){
                    for(char c = 'a'; c <= 'z'; c++){
                        sb.setCharAt(j, c);
                        //因为在下一层的遍历中找到结果, 所以返回level+1
                        if(set2.contains(sb.toString())) return level + 1;
                        if(dict.contains(sb.toString())) {
                            temp.add(sb.toString());
                            dict.remove(sb.toString());
                        }
                    }
                    sb.setCharAt(j, word.charAt(j));
                }
            }*/

            for (String w : set1) {
                char[] chs = w.toCharArray();
                for (int i = 0; i < chs.length; ++i) {
                    char ch = chs[i];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        chs[i] = c;
                        String t = new String(chs);
                        if (set2.contains(t)) return level + 1;
                        if (!dict.contains(t)) continue;
                        dict.remove(t);
                        temp.add(t);
                    }
                    chs[i] = ch;
                }
            }

            //set1.size()此时肯定比set2.size()大, 所以在循环开头则会交换set1, set2, 无需此时set1 = set2; set2 = temp;
            set1 = temp;
            //记录此层层数, 循环继续遍历下一层
            level++;
        }

        return 0;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


}