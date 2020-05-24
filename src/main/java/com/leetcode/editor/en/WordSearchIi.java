//Given a 2D board and a list of words from the dictionary, find all words in th
//e board. 
//
// Each word must be constructed from letters of sequentially adjacent cell, whe
//re "adjacent" cells are those horizontally or vertically neighboring. The same l
//etter cell may not be used more than once in a word. 
//
// 
//
// Example: 
//
// 
//Input: 
//board = [
//  ['o','a','a','n'],
//  ['e','t','a','e'],
//  ['i','h','k','r'],
//  ['i','f','l','v']
//]
//words = ["oath","pea","eat","rain"]
//
//Output: ["eat","oath"]
// 
//
// 
//
// Note: 
//
// 
// All inputs are consist of lowercase letters a-z. 
// The values of words are distinct. 
// 
// Related Topics Backtracking Trie


package com.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class WordSearchIi{
    public static void main(String[] args) {
       Solution solution = new WordSearchIi().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    class TrieNode{
        char val;
        TrieNode[] children;
        String word;

        public TrieNode(char x){
            children = new TrieNode[26];
            word = null;
        }
    }
    //预处理board, 为搜索提速 --> 转换为字典树
    private void buildTrie(TrieNode root, String[] words){
        for(String s : words){
            TrieNode cur = root;
            for(char c : s.toCharArray()){
                if(cur.children[c - 'a'] == null){
                    cur.children[c - 'a'] = new TrieNode(c);
                }
                cur = cur.children[c - 'a'];
            }
            cur.word = s;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if(board == null || board.length == 0) return res;
        //char字符'\0'表示为空
        TrieNode root = new TrieNode('\0');
        buildTrie(root, words);
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                char c = board[i][j];
                if(root.children[c - 'a'] != null){
                    dfs(board, i, j, root, res);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] board, int i, int j, TrieNode cur, List<String> res){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;

        char c = board[i][j];
        if(c == '*') return;
        if(cur.children[c - 'a'] == null) return;

        cur = cur.children[c - 'a'];
        if(cur.word != null){
            res.add(cur.word);
            //找到一个word之后String要设置为null; 否则如'car'在'card'时会被重复加
            cur.word = null;
        }

        board[i][j] = '*';
        dfs(board, i + 1, j, cur, res);
        dfs(board, i - 1, j, cur, res);
        dfs(board, i, j + 1, cur, res);
        dfs(board, i, j - 1, cur, res);
        board[i][j] = c;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}