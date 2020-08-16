//There is a one-dimensional garden on the x-axis. The garden starts at the poin
//t 0 and ends at the point n. (i.e The length of the garden is n). 
//
// There are n + 1 taps located at points [0, 1, ..., n] in the garden. 
//
// Given an integer n and an integer array ranges of length n + 1 where ranges[i
//] (0-indexed) means the i-th tap can water the area [i - ranges[i], i + ranges[i
//]] if it was open. 
//
// Return the minimum number of taps that should be open to water the whole gard
//en, If the garden cannot be watered return -1. 
//
// 
// Example 1: 
//
// 
//Input: n = 5, ranges = [3,4,1,1,0,0]
//Output: 1
//Explanation: The tap at point 0 can cover the interval [-3,3]
//The tap at point 1 can cover the interval [-3,5]
//The tap at point 2 can cover the interval [1,3]
//The tap at point 3 can cover the interval [2,4]
//The tap at point 4 can cover the interval [4,4]
//The tap at point 5 can cover the interval [5,5]
//Opening Only the second tap will water the whole garden [0,5]
// 
//
// Example 2: 
//
// 
//Input: n = 3, ranges = [0,0,0,0]
//Output: -1
//Explanation: Even if you activate all the four taps you cannot water the whole
// garden.
// 
//
// Example 3: 
//
// 
//Input: n = 7, ranges = [1,2,1,0,2,1,0,1]
//Output: 3
// 
//
// Example 4: 
//
// 
//Input: n = 8, ranges = [4,0,0,0,0,0,0,0,4]
//Output: 2
// 
//
// Example 5: 
//
// 
//Input: n = 8, ranges = [4,0,0,0,4,0,0,0,4]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10^4 
// ranges.length == n + 1 
// 0 <= ranges[i] <= 100 
// Related Topics Dynamic Programming Greedy 
// 👍 272 👎 42


package com.leetcode.editor.en;

import java.util.Arrays;

public class MinimumNumberOfTapsToOpenToWaterAGarden{
    public static void main(String[] args) {
       Solution solution = new MinimumNumberOfTapsToOpenToWaterAGarden().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // Greedy
    /*public int minTaps(int n, int[] ranges) {
        // construct the arr 构建jump game II 数组
        int[] arr = new int[n + 1];
        for(int i = 0; i < ranges.length; ++i){
            if(ranges[i] == 0) continue;
            //left记录i能到的最左的点
            int left = Math.max(0, i - ranges[i]);
            //将其转换为index=left的点, 能走到最右value=right的最少步数
            arr[left] = Math.max(arr[left], i + ranges[i]);
        }

        // Jump Game II
        int end = 0, farthest = 0, steps = 0;
        // 需要计算最后一个index, 所以end <= n - 1
        for(int i = 0; end <= n - 1; end = farthest){
            steps++;
            while (i < n && i <= end){
                farthest = Math.max(farthest, arr[i]);
                i++;
            }
            if(end == farthest) return -1;
        }

        return steps;
    }*/

    // DP dp[i] is the minimum number of taps to water [0, i].
    public int minTaps(int n, int[] A){
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 2);
        //initialized
        dp[0] = 0;
        for(int i = 0; i <= n; ++i){
            // if you set j = max(i - A[i], 0), the first iteration will be dp[j] = min(dp[j], dp[j] + 1);, which is redundant.
            for(int j = Math.max(i - A[i] + 1, 0); j <= Math.min(i + A[i], n); ++j){
                //
                dp[j] = Math.min(dp[j], dp[Math.max(0, i - A[i])] + 1);
            }
        }
        return dp[n] < n + 2 ? dp[n] : -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}