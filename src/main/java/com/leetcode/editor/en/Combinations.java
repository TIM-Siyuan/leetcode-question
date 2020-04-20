//Given two integers n and k, return all possible combinations of k numbers out 
//of 1 ... n. 
//
// Example: 
//
// 
//Input: n = 4, k = 2
//Output:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
// 
// Related Topics Backtracking


package com.leetcode.editor.en;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations{
    public static void main(String[] args) {
       Solution solution = new Combinations().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private ArrayList<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<List<Integer>>();
        if(n <= 0 || k <= 0 || n < k) return res;

        LinkedList<Integer> p = new LinkedList<>();
        generateCombine(n, k, 1, p);

        return res;
    }

    private void generateCombine(int n, int k, int start, LinkedList<Integer> p){
        if(p.size() == k){
            res.add((LinkedList<Integer>)p.clone());
            return;
        }

        for(int i = start; i <= n-(k-p.size())+1; i++){
            p.add(i);
            generateCombine(n, k, i+1, p);
            p.removeLast();
        }
        return;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}