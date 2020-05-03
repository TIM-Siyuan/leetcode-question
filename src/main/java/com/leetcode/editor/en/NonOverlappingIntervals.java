//Given a collection of intervals, find the minimum number of intervals you need
// to remove to make the rest of the intervals non-overlapping. 
//
// 
// 
//
// 
//
// Example 1: 
//
// 
//Input: [[1,2],[2,3],[3,4],[1,3]]
//Output: 1
//Explanation: [1,3] can be removed and the rest of intervals are non-overlappin
//g.
// 
//
// Example 2: 
//
// 
//Input: [[1,2],[1,2],[1,2]]
//Output: 2
//Explanation: You need to remove two [1,2] to make the rest of intervals non-ov
//erlapping.
// 
//
// Example 3: 
//
// 
//Input: [[1,2],[2,3]]
//Output: 0
//Explanation: You don't need to remove any of the intervals since they're alrea
//dy non-overlapping.
// 
//
// 
//
// Note: 
//
// 
// You may assume the interval's end point is always bigger than its start point
//. 
// Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap
// each other. 
// 
// Related Topics Greedy


package com.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals{
    public static void main(String[] args) {
       Solution solution = new NonOverlappingIntervals().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0) return 0;
        //贪心算法: 按照结尾排序, 每次选择结尾最早的
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int end = intervals[0][1];
        int count = 0;

        for(int i = 1; i < intervals.length; i++){
            //如果下一个数组的开头大于上一个数组的结尾, 留下最短的数组(这样后续不被overlap的可能性最大)
            if(end > intervals[i][0]){
                intervals[i][1] = Math.min(end, intervals[i][1]);
                count++;
            }
            end = intervals[i][1];
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}