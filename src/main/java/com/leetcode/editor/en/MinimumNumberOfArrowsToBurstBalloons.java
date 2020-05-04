//There are a number of spherical balloons spread in two-dimensional space. For 
//each balloon, provided input is the start and end coordinates of the horizontal 
//diameter. Since it's horizontal, y-coordinates don't matter and hence the x-coor
//dinates of start and end of the diameter suffice. Start is always smaller than e
//nd. There will be at most 104 balloons. 
//
// An arrow can be shot up exactly vertically from different points along the x-
//axis. A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x 
//≤ xend. There is no limit to the number of arrows that can be shot. An arrow onc
//e shot keeps travelling up infinitely. The problem is to find the minimum number
// of arrows that must be shot to burst all balloons. 
//
// Example: 
//
// 
//Input:
//[[10,16], [2,8], [1,6], [7,12]]
//
//Output:
//2
//
//Explanation:
//One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8
//] and [1,6]) and another arrow at x = 11 (bursting the other two balloons).
// 
//
// 
// Related Topics Greedy


package com.leetcode.editor.en;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBalloons{
    public static void main(String[] args) {
       Solution solution = new MinimumNumberOfArrowsToBurstBalloons().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int count = 1;
        int x_end = points[0][1];
        for(int[] point : points){
            int start = point[0];
            if(x_end < start){
                count++;
                x_end = point[1];
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}