//On a 2x3 board, there are 5 tiles represented by the integers 1 through 5, and
// an empty square represented by 0. 
//
// A move consists of choosing 0 and a 4-directionally adjacent number and swapp
//ing it. 
//
// The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]
//]. 
//
// Given a puzzle board, return the least number of moves required so that the s
//tate of the board is solved. If it is impossible for the state of the board to b
//e solved, return -1. 
//
// Examples: 
//
// 
//Input: board = [[1,2,3],[4,0,5]]
//Output: 1
//Explanation: Swap the 0 and the 5 in one move.
// 
//
// 
//Input: board = [[1,2,3],[5,4,0]]
//Output: -1
//Explanation: No number of moves will make the board solved.
// 
//
// 
//Input: board = [[4,1,2],[5,0,3]]
//Output: 5
//Explanation: 5 is the smallest number of moves that solves the board.
//An example path:
//After move 0: [[4,1,2],[5,0,3]]
//After move 1: [[4,1,2],[0,5,3]]
//After move 2: [[0,1,2],[4,5,3]]
//After move 3: [[1,0,2],[4,5,3]]
//After move 4: [[1,2,0],[4,5,3]]
//After move 5: [[1,2,3],[4,5,0]]
// 
//
// 
//Input: board = [[3,2,4],[1,5,0]]
//Output: 14
// 
//
// Note: 
//
// 
// board will be a 2 x 3 array as described above. 
// board[i][j] will be a permutation of [0, 1, 2, 3, 4, 5]. 
// 
// Related Topics Breadth-first Search


package com.leetcode.editor.en;

import java.util.*;

public class SlidingPuzzle{
    public static void main(String[] args) {
       Solution solution = new SlidingPuzzle().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*private int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int slidingPuzzle(int[][] board) {
        Queue<String> queue = new LinkedList<>();
        HashMap<String, Integer> visited = new HashMap<>();
        String initState = boardToString(board);
        if(initState.equals("123450")) return 0;

        queue.add(initState);
        visited.put(initState, 0);
        while(!queue.isEmpty()){
            String cur = queue.remove();
            ArrayList<String> nexts = getNexts(cur);

            for(String next:nexts){
                if(!visited.containsKey(next)){
                    queue.add(next);
                    visited.put(next, visited.get(cur) + 1);
                    if(next.equals("123450"))
                        return visited.get(next);
                }
            }
        }
        return -1;
    }

    private ArrayList<String> getNexts(String s){
        int[][] cur = stringToBoard(s);
        int zero;
        for(zero = 0; zero < 6; zero++){
            if(cur[zero / 3][zero % 3] == 0){
                break;
            }
        }
        ArrayList<String> res = new ArrayList<>();
        int zx = zero / 3, zy = zero % 3;
        for(int d = 0; d < 4; d++){
            int nextx = zx + dirs[d][0];
            int nexty = zy + dirs[d][1];
            if(inArea(nextx, nexty)){
                swap(cur, zx, zy, nextx, nexty);
                res.add(boardToString(cur));
                swap(cur, zx, zy, nextx, nexty);
            }
        }
        return res;
    }

    private void swap(int[][] board, int x1, int y1, int x2, int y2){
        int t = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = t;
    }

    private boolean inArea(int x, int y){
        return x >= 0 && x < 2 && y >= 0 && y < 3;
    }

    private String boardToString(int[][] board){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 3; j++){
                sb.append(board[i][j]);
            }
        }
        return sb.toString();
    }

    private int[][] stringToBoard(String s){
        int[][] board = new int[2][3];
        for(int i = 0; i < 6; i++){
            board[i / 3][i % 3] = s.charAt(i) - '0';
        }
        return board;
    }*/

    public int slidingPuzzle(int[][] board){
        String target = "123450";
        String start = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                start += board[i][j];
            }
        }
        HashSet<String> visited = new HashSet<>();
        // all the positions 0 can be swapped to
        int[][] dirs = new int[][] { { 1, 3 }, { 0, 2, 4 },
                { 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 } };
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);
        int res = 0;
        while (!queue.isEmpty()) {
            // level count, has to use size control here, otherwise not needed
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(target)) {
                    return res;
                }
                int zero = cur.indexOf('0');
                // swap if possible
                for (int dir : dirs[zero]) {
                    String next = swap(cur, zero, dir);
                    if (visited.contains(next)) {
                        continue;
                    }
                    visited.add(next);
                    queue.offer(next);

                }
            }
            res++;
        }
        return -1;
    }

    private String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}