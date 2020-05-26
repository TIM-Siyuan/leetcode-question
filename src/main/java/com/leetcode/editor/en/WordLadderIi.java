//Given two words (beginWord and endWord), and a dictionary's word list, find al
//l shortest transformation sequence(s) from beginWord to endWord, such that: 
//
// 
// Only one letter can be changed at a time 
// Each transformed word must exist in the word list. Note that beginWord is not
// a transformed word. 
// 
//
// Note: 
//
// 
// Return an empty list if there is no such transformation sequence. 
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
//Output:
//[
//  ["hit","hot","dot","dog","cog"],
//  ["hit","hot","lot","log","cog"]
//]
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
//Output: []
//
//Explanation: The endWord "cog" is not in wordList, therefore no possible trans
//formation.
// 
//
// 
// 
// Related Topics Array String Backtracking Breadth-first Search


package com.leetcode.editor.en;

import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;
import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

import java.util.*;

public class WordLadderIi{
    public static void main(String[] args) {
       Solution solution = new WordLadderIi().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
//BFS-->buildGraph; DFS-->find shortest path
class Solution{
    //与一相同求最短路径, 但是需要输出所有可能的结果, 所以尝试用BFS并一层层记录
    //BFS 1: 1230ms 51MB
    /*public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList){
        HashSet<String> dict = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        //Queue中存放的是路径, 与LC 127不同, 需要知道到了哪一个字母且需要记录其转换过程的路径
        Queue<List<String>> q = new ArrayDeque<>();
        //初始化存入beginWord路径
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        q.offer(path);

        while (!q.isEmpty()){
            //可能有多种长度不一的结果, 所以假如res已经有结果直接返回(存入的是最短结果集)
            if(!res.isEmpty()) return res;
            int size = q.size();
            for(int i = 0; i < size; i++){
                //q存储的是每一条路径
                List<String> curList = q.poll();
                //需要依据路径最后一个元素, 遍历寻找下一个元素
                String curWord = curList.get(curList.size() - 1);
                //因为要输出所有结果, 所以不能在遍历下一层元素时删除, 否则同层元素遍历下一层元素时则可能缺少此结果
                dict.remove(curWord);
                //存在则存入结果
                if(curWord.equals(endWord)){
                    res.add(new ArrayList<>(curList));
                }
                else {
                    StringBuilder sb = new StringBuilder(curWord);
                    for(int j = 0; j < curWord.length(); j++){
                        for(char c = 'a'; c <= 'z'; c++){
                            if(c == curWord.charAt(j)) continue;
                            sb.setCharAt(j, c);
                            //backtracking
                            if(dict.contains(sb.toString())){
                                curList.add(sb.toString());
                                //deep copy
                                q.offer(new ArrayList<>(curList));
                                curList.remove(curList.size() - 1);
                            }
                        }
                        sb.setCharAt(j, curWord.charAt(j));
                    }
                }
            }
        }
        return res;
    }*/

    //BFS 2: Using BFS(Set but not Queue) to build Graph && Using DFS to generate result list.
    //follow up: 使用Set提升搜寻效率, 使用Map记录每一段路径提升搜寻效率和降低空间 -- 69ms 43.4MB
    //main
    /*public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList){
        //初始化 res,dict; 特判解不存在情况
        List<List<String>> res = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord)) return res;

        //初始化 每个点的路径图; Set存放点; bfs建图
        Map<String, List<String>> map = new HashMap<>();
        Set<String> startSet = new HashSet<>();
        startSet.add(beginWord);
        bfs(startSet, endWord, map, dict);

        //初始化 起点集合; dfs输出路径
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        //通过beginWord在map中寻找下一层的元素
        dfs(res, list, beginWord, endWord, map);
        return res;
    }*/
    //bfs
    /*private void bfs(Set<String> startSet, String endWord, Map<String, List<String>> map, Set<String> dict){
        //说明遍历完还没找到
        if(startSet.size() == 0) return;

        //新建Set暂存下一层遍历结果
        Set<String> tmp = new HashSet<>();
        //起点可删除, 不会走回头路;
        dict.removeAll(startSet);
        boolean finish = false;

        for(String s : startSet){
            char[] chs = s.toCharArray();
            for(int i = 0; i < chs.length; i++){
                //backtracking
                char old = chs[i];
                for(char c = 'a'; c <= 'z'; c++){
                    chs[i] = c;
                    String word = new String(chs);
                    if(dict.contains(word)){
                        if(word.equals(endWord)){
                            // 找到结果, 法1此处直接加入结果, 根据res中已有结果确保找到的是最短路径;
                            // 法2根据找到结果后不再继续bfs, 同理确保后续dfs输出的全部结果为最短路径;
                            finish = true;
                        } else {
                            //暂存下一层结果 == 推入queue
                            tmp.add(word);
                        }
                        //法1使用Queue存储每条路径, 即记录一条长路径(初始节点有多个下一路径, 每一条初始节点分开单独记录, 所以空间消耗更大), 路径初始化后一定存在;
                        //法2使用Set记录每个节点, 并通过Map记录初始节点可到的下一个节点(一对多), 即只记录路径的一段, 所以需要判断Map是否有此初始节点
                        if(map.get(s) == null){
                            map.put(s, new ArrayList<>());
                        }
                        map.get(s).add(word);
                    }
                }
                //backtracking
                chs[i] = old;
            }
        }
        //没到终点继续下一层bfs
        if(!finish){
            bfs(tmp, endWord, map, dict);
        }
    }*/
    //dfs
    /*private void dfs(List<List<String>> res, List<String> list, String word, String endWord, Map<String, List<String>> map){
        if(word.equals(endWord)){
            //遍历到一条路径则添加进res; deep copy
            res.add(new ArrayList<>(list));
        }
        //遍历到底无结果返回结果
        if(map.get(word) == null) return;
        for(String next : map.get(word)){
            //backtracking
            list.add(next);
            dfs(res, list, next, endWord, map);
            list.remove(list.size() - 1);
        }
    }*/

    //Bi-BFS 12ms 40.4MB
    //main -- add endSet
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList){
        //初始化 res,dict; 特判解不存在情况
        List<List<String>> res = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord)) return res;

        //初始化 每个点的路径图; Set存放点; bfs建图
        Map<String, List<String>> map = new HashMap<>();
        Set<String> startSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        startSet.add(beginWord);
        endSet.add(endWord);
        biBfs(startSet, endSet, map, dict, false);

        //初始化 起点集合; dfs输出路径
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        //通过beginWord在map中寻找下一层的元素
        dfs(res, list, beginWord, endWord, map);
        return res;
    }

    private void biBfs(Set<String> startSet, Set<String> endSet, Map<String, List<String>> map, Set<String> dict, boolean reverse){
        if(startSet.isEmpty()){
            return;
        }

        if(startSet.size() > endSet.size()){
            //size小的遍历下一层元素少 --> 效率高; reverse反转
            biBfs(endSet, startSet, map, dict, !reverse);
            return;
        }

        boolean finish = false;
        //因为一次遍历只从一个方向作为起点, 只需删除startSet方向的元素(换方向时endSet变为startSet)
        dict.removeAll(startSet);

        //新建Set暂存下一层遍历结果
        Set<String> tmp = new HashSet<>();
        for(String s : startSet){
            char[] chs = s.toCharArray();
            for(int i = 0; i < chs.length; i++){
                //backtracking
                char old = chs[i];
                for(char c = 'a'; c <= 'z'; c++){
                    chs[i] = c;
                    String word = new String(chs);
                    if(dict.contains(word)){
                        //此处修改, 相交即可
                        if(endSet.contains(word)){
                            finish = true;
                        } else {
                            tmp.add(word);
                        }

                        //此处修改, 因为Bi-BFS是两边走, 但map只记录一个指向, 所以需要看是哪边走向哪边, 变动key, val的指向
                        //正常应该是 s -> word, 加入翻转了则 word -> s
                        String key = reverse ? word : s;
                        String val = reverse ? s : word;

                        if(map.get(key) == null){
                            map.put(key, new ArrayList<>());
                        }
                        map.get(key).add(val);
                    }
                }
                //backtracking
                chs[i] = old;
            }
        }
        //没到终点继续下一层bfs, 反转
        if(!finish){
            //结果放在startSet, 因为size更大, 所以下一层遍历上面的代码会反转从endSet遍历
            biBfs(tmp, endSet, map, dict, reverse);
        }
    }

    //dfs
    private void dfs(List<List<String>> res, List<String> list, String word, String endWord, Map<String, List<String>> map){
        if(word.equals(endWord)){
            //遍历到一条路径则添加进res; deep copy
            res.add(new ArrayList<>(list));
        }
        //遍历到底无结果返回结果
        if(map.get(word) == null) return;
        for(String next : map.get(word)){
            //backtracking
            list.add(next);
            dfs(res, list, next, endWord, map);
            list.remove(list.size() - 1);
        }
    }
}

//leetcode submit region end(Prohibit modification and deletion)


}