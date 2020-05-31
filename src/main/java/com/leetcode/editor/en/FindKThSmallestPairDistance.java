//Given an integer array, return the k-th smallest distance among all the pairs.
// The distance of a pair (A, B) is defined as the absolute difference between A a
//nd B. 
//
// Example 1: 
// 
//Input:
//nums = [1,3,1]
//k = 1
//Output: 0 
//Explanation:
//Here are all the pairs:
//(1,3) -> 2
//(1,1) -> 0
//(3,1) -> 2
//Then the 1st smallest distance pair is (1,1), and its distance is 0.
// 
// 
//
// Note: 
// 
// 2 <= len(nums) <= 10000. 
// 0 <= nums[i] < 1000000. 
// 1 <= k <= len(nums) * (len(nums) - 1) / 2. 
// 
// Related Topics Array Binary Search Heap


package com.leetcode.editor.en;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FindKThSmallestPairDistance{
    public static void main(String[] args) {
       Solution solution = new FindKThSmallestPairDistance().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //Bucket sort: 数据量不大且有可能有大量重复的情况下; 假如数据量很稀疏, 效率约等于暴力 O(n^2)
    /*public int smallestDistancePair(int[] nums, int k) {
        int len = nums.length;
        int bucket = 1000000;
        int[] dp = new int[bucket];
        for(int i = 1; i < len; i++){
            for(int j = 0; j < i; j++){
                int dist = Math.abs(nums[i] - nums[j]);
                dp[dist]++;
            }
        }
        int sum = 0;
        for(int i = 0; i < bucket; i++){
            sum += dp[i];
            if(sum >= k) return i;
        }
        return 0;
    }*/

    //Binary search O(nlogn) 利用二分思想, 已知target是个数, 而非数字大小, l, r表示的是距离; 类比桶排序之后二分查找桶直到找到桶内元素个数相加等于target k
    //count(A, x): the number of pairs that are smaller than x;
    //right interval: (number of distance pairs <= m) >= k
    public int smallestDistancePair(int[] nums, int k){
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0, r = nums[n - 1] - nums[0];
        while (l < r){
            int count = 0, j = 0;
            int m = l + (r - l) / 2;
            // CountPair: Returns number of pairs with absolute difference less than or equal to mid.
            for(int i = 0; i < n; i++){
                //slide window 计算count pair更快 --> 利用排序特性, 只需要遍历一次 O(n)
                while (j < n && nums[j] - nums[i] <= m) j++;
                //满足条件时j++, 所以需要j - 1 - i;
                count += j - i - 1;

                //二分单次更快, 整体更慢: 每一次i更新, 二分都要从最尾开始重新搜寻 O(nlogn)
                //count += upperBound(nums, i, n - 1, nums[i] + m) - i - 1;
            }
            if(count >= k) r = m;
            else l = m + 1;
        }
        return l;
    }

    //follow up: CountPair也用Binary Search
    private int upperBound(int[] nums, int l, int r, int key){
        if(nums[r] <= key) return r + 1;
        while (l < r){
            int m = l + (r - l) / 2;
            if(key >= nums[m]){
                l = m + 1;
            }
            else {
                r = m;
            }
        }
        return l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}