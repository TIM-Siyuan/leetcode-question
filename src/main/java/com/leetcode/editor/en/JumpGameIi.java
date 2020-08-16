//Given an array of non-negative integers, you are initially positioned at the f
//irst index of the array. 
//
// Each element in the array represents your maximum jump length at that positio
//n. 
//
// Your goal is to reach the last index in the minimum number of jumps. 
//
// Example: 
//
// 
//Input: [2,3,1,1,4]
//Output: 2
//Explanation: The minimum number of jumps to reach the last index is 2.
//    Jump 1 step from index 0 to 1, then 3 steps to the last index. 
//
// Note: 
//
// You can assume that you can always reach the last index. 
// Related Topics Array Greedy


package com.leetcode.editor.en;

public class JumpGameIi{
    public static void main(String[] args) {
       Solution solution = new JumpGameIi().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // Greedy ≈ implicit BFS, 每一层找到能跳的最远的点
    public int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0, end = 0, farthest = 0;
        // 最后一个index不用计算所以n-1
        for(int i = 0; i < n - 1; i++){
            farthest = Math.max(nums[i] + i, farthest);
            // 每一层找到能跳的最远的点
            // i == curEnd means you visited all the items on the current level
            if (end == i) {
                jumps++;
                // curEnd = curFarthest is like getting the queue size (level size) for the next level you are traversing.
                end = farthest;
            }
        }
        return jumps;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}