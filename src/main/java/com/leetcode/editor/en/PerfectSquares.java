//Given a positive integer n, find the least number of perfect square numbers (f
//or example, 1, 4, 9, 16, ...) which sum to n. 
//
// Example 1: 
//
// 
//Input: n = 12
//Output: 3 
//Explanation: 12 = 4 + 4 + 4. 
//
// Example 2: 
//
// 
//Input: n = 13
//Output: 2
//Explanation: 13 = 4 + 9. Related Topics Math Dynamic Programming Breadth-first
// Search


package com.leetcode.editor.en;

import javafx.util.Pair;

import java.util.LinkedList;

public class PerfectSquares{
    public static void main(String[] args) {
       Solution solution = new PerfectSquares().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSquares(int n) {
        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<Pair<Integer, Integer>>();
        queue.addLast(new Pair<>(n, 0));
        boolean[] visited = new boolean[n+1];
        visited[n] = true;

        while (!queue.isEmpty()){
            Pair<Integer, Integer> front = queue.removeFirst();
            int num = front.getKey();
            int step = front.getValue();

            if(num == 0)
                return step;
            for(int i = 1; num - i * i >= 0; i++){
                int a = num - i * i;
                if(!visited[a]){
                    if(a == 0) return step + 1;
                    queue.add(new Pair<>(num - i * i, step + 1));
                    visited[num - i * i] = true;
                }
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}