//Given an integer array arr and an integer k, modify the array by repeating it 
//k times. 
//
// For example, if arr = [1, 2] and k = 3 then the modified array will be [1, 2,
// 1, 2, 1, 2]. 
//
// Return the maximum sub-array sum in the modified array. Note that the length 
//of the sub-array can be 0 and its sum in that case is 0. 
//
// As the answer can be very large, return the answer modulo 10^9 + 7. 
//
// 
// Example 1: 
//
// 
//Input: arr = [1,2], k = 3
//Output: 9
// 
//
// Example 2: 
//
// 
//Input: arr = [1,-2,1], k = 5
//Output: 2
// 
//
// Example 3: 
//
// 
//Input: arr = [-1,-2], k = 7
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 10^5 
// 1 <= k <= 10^5 
// -10^4 <= arr[i] <= 10^4 
// 
// Related Topics Dynamic Programming 
// 👍 320 👎 33


package com.leetcode.editor.en;

public class KConcatenationMaximumSum{
    public static void main(String[] args) {
       Solution solution = new KConcatenationMaximumSum().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*
    *you only need to consider three cases:
    *1. Kadane's algo on a single array or double array —— sum(arr) < 0
    *   case1.1: single array -5 2 -1 3 -4 | -5 2 -1 3 -4 ans: 2 -1 3
    *   case1.2: double array 2 -5 1 1 | 2 -5 1 1  ans : 1 1 2 在代码中为 pre + suf + 0
    *2. Multiply the array (k-2) times (the inner arrays) + the outer two arrays (which can be suffixed or prefixed, find the max for each)
    *   sum(arr) < 0
    * */
    public int kConcatenationMaxSum(int[] arr, int k) {
        int mod= (int)Math.pow(10, 9) + 7;
        int n = arr.length;
        long presum = 0, premax = 0, sufsum = 0, sufmax = 0, cursum = 0, curmax = 0;
        for(int i = 0; i < n; ++i){

            // prefix
            presum += arr[i];
            premax = Math.max(premax, presum);

            // suffix
            sufsum += arr[n - 1 - i];
            sufmax = Math.max(sufmax, sufsum);

            //Kadane's algo
            cursum = Math.max(0, cursum) + arr[i];
            curmax = Math.max(curmax, cursum);
        }
        // prefix sum(presum) will be the sum of the complete array after entire traversal...
        long max = Math.max(curmax, premax + sufmax + Math.max(0, presum*(k - 2)));
        return (int)((k == 1 ? curmax : max) % mod);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}