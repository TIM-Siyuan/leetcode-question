//Given a collection of intervals, merge all overlapping intervals. 
//
// Example 1: 
//
// 
//Input: [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
// 
//
// Example 2: 
//
// 
//Input: [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping. 
//
// NOTE: input types have been changed on April 15, 2019. Please reset to defaul
//t code definition to get new method signature. 
// Related Topics Array Sort


package com.leetcode.editor.en;

import java.util.*;

public class MergeIntervals{
    public static void main(String[] args) {
       Solution solution = new MergeIntervals().new Solution();
       int[][] intv = {{1,3}, {2, 6}, {8,10}, {15,18}};
       solution.merge(intv);
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0) return intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> res = new ArrayList<int[]>();
        res.add(intervals[0]);

        for(int i = 0; i < intervals.length; i++){
            int[] curr = intervals[i];
            int[] last = res.get(res.size() - 1);
            if(curr[0] <= last[1]){
                //找到最大的end
                last[1] = Math.max(last[1], curr[1]);
            }else {
                res.add(curr);
            }
        }
        return res.toArray(new int[0][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}