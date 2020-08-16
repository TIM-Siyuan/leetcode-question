//You are given a series of video clips from a sporting event that lasted T seco
//nds. These video clips can be overlapping with each other and have varied length
//s. 
//
// Each video clip clips[i] is an interval: it starts at time clips[i][0] and en
//ds at time clips[i][1]. We can cut these clips into segments freely: for example
//, a clip [0, 7] can be cut into segments [0, 1] + [1, 3] + [3, 7]. 
//
// Return the minimum number of clips needed so that we can cut the clips into s
//egments that cover the entire sporting event ([0, T]). If the task is impossible
//, return -1. 
//
// 
//
// Example 1: 
//
// 
//Input: clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], T = 10
//Output: 3
//Explanation: 
//We take the clips [0,2], [8,10], [1,9]; a total of 3 clips.
//Then, we can reconstruct the sporting event as follows:
//We cut [1,9] into segments [1,2] + [2,8] + [8,9].
//Now we have segments [0,2] + [2,8] + [8,10] which cover the sporting event [0,
// 10].
// 
//
// Example 2: 
//
// 
//Input: clips = [[0,1],[1,2]], T = 5
//Output: -1
//Explanation: 
//We can't cover [0,5] with only [0,1] and [1,2].
// 
//
// Example 3: 
//
// 
//Input: clips = [[0,1],[6,8],[0,2],[5,6],[0,4],[0,3],[6,7],[1,3],[4,7],[1,4],[2
//,5],[2,6],[3,4],[4,5],[5,7],[6,9]], T = 9
//Output: 3
//Explanation: 
//We can take clips [0,4], [4,7], and [6,9].
// 
//
// Example 4: 
//
// 
//Input: clips = [[0,4],[2,8]], T = 5
//Output: 2
//Explanation: 
//Notice you can have extra video after the event ends.
// 
//
// 
// Constraints: 
//
// 
// 1 <= clips.length <= 100 
// 0 <= clips[i][0] <= clips[i][1] <= 100 
// 0 <= T <= 100 
// 
// Related Topics Dynamic Programming 
// 👍 496 👎 25


package com.leetcode.editor.en;

import java.util.Arrays;

public class VideoStitching{
    public static void main(String[] args) {
       Solution solution = new VideoStitching().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // Greedy 类似LC45 Jump Game II O(NlogN)
    public int videoStitching(int[][] clips, int T) {
        int res = 0;
        Arrays.sort(clips, (a, b) -> a[0] - b[0]);
        //st = stitching ≈ curFarthest
        for(int i = 0, st = 0, end = 0; st < T; st = end, ++res){
            for(; i < clips.length && clips[i][0] <= st; ++i){
                end = Math.max(end, clips[i][1]);
            }
            if(end == st){
                return -1;
            }
        }
        return res;
    }

    // DP dp[i] is the min number of clips to cover video
    /*public int videoStitching(int[][] clips, int T){
        int[] dp = new int[T + 1];
        Arrays.fill(dp, T + 1);
        dp[0] = 0;
        for(int i = 1; i <= T && dp[i - 1] < T; ++i){
            for(int[] c : clips){
                // i in [c[0], c[1]]
                if(c[0] <= i && i <= c[1]){
                    // check if this video can be covered using less clips
                    dp[i] = Math.min(dp[i], dp[c[0]] + 1);
                }
            }
        }
        return dp[T] == T + 1 ? -1 : dp[T];
    }*/


}
//leetcode submit region end(Prohibit modification and deletion)


}