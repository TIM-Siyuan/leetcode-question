//Given a set of non-overlapping intervals, insert a new interval into the inter
//vals (merge if necessary). 
//
// You may assume that the intervals were initially sorted according to their st
//art times. 
//
// Example 1: 
//
// 
//Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
//Output: [[1,5],[6,9]]
// 
//
// Example 2: 
//
// 
//Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//Output: [[1,2],[3,10],[12,16]]
//Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10]. 
//
//
// NOTE: input types have been changed on April 15, 2019. Please reset to defaul
//t code definition to get new method signature. 
// Related Topics Array Sort


package com.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval{
    public static void main(String[] args) {
       Solution solution = new InsertInterval().new Solution();
       int[][] nums = {{1, 3}, {6, 9}};
       int[] num = {2, 5};
       solution.insert(nums, num);
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        /*int start = newInterval[0], end = newInterval[1];
        List<int[]> res = new ArrayList<int[]>();
        int index = 0;
        //left
        while(index < intervals.length && intervals[index][1] < start){
            res.add(intervals[index++]);
        }
        //Merger overlapping
        while(index < intervals.length && intervals[index][0] <= end){
            int[] curr = intervals[index++];
            start = Math.min(curr[0], start);
            end = Math.max(curr[1], end);
        }
        res.add(new int[]{start, end});

        //right
        while(index < intervals.length){
            res.add(intervals[index++]);
        }

        return res.toArray(new int[res.size()][]);*/

        int start = newInterval[0], end = newInterval[1];
        List<int[]> res = new ArrayList<int[]>();
        List<int[]> left = new ArrayList<int[]>();
        List<int[]> right = new ArrayList<int[]>();
        for(int i = 0; i < intervals.length; i++){
            int[] curr = intervals[i];
            if(curr[1] < start) left.add(curr);
            else if(curr[0] > end) right.add(curr);
            else{
                start = Math.min(start, curr[0]);
                end = Math.max(end, curr[1]);
            }
        }

        res.addAll(left);
        res.add(new int[]{start, end});
        res.addAll(right);

        return res.toArray(new int[res.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}