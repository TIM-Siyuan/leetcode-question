//Given an unsorted array return whether an increasing subsequence of length 3 e
//xists or not in the array. 
//
// Formally the function should: 
//
// Return true if there exists i, j, k 
//such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false
//. 
//
// Note: Your algorithm should run in O(n) time complexity and O(1) space comple
//xity. 
//
// 
// Example 1: 
//
// 
//Input: [1,2,3,4,5]
//Output: true
// 
//
// 
// Example 2: 
//
// 
//Input: [5,4,3,2,1]
//Output: false
// 
// 
//


package com.leetcode.editor.en;

import java.util.Arrays;

public class IncreasingTripletSubsequence{
    public static void main(String[] args) {
       Solution solution = new IncreasingTripletSubsequence().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if(n < 3) return false;
        int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE;
        for(int num : nums){
           if(m1 >= num) m1 = num;
           else if(m2 >= num) m2 = num;
           else return true;
        }
        return false;
    }*/

    // 建立forward, backward两个数组; 如果最大最小值之间都找不到匹配的, 返回false
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if(n < 3) return false;
        int[] front = new int[n]; int[] back = new int[n];
        Arrays.fill(front, nums[0]);
        Arrays.fill(back, nums[n-1]);
        for(int i = 1; i < n; ++i){
            front[i] = Math.min(front[i-1], nums[i]);
        }
        for(int i = n - 2; i >= 0; --i){
            back[i] = Math.max(back[i + 1], nums[i]);
        }
        for(int i = 0; i < n; ++i){
            if(nums[i] > front[i] && nums[i] < back[i]) return true;
        }
        return false;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


}