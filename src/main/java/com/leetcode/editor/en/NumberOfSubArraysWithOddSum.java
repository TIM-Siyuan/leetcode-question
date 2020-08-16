//Given an array of integers arr. Return the number of sub-arrays with odd sum. 
//
//
// As the answer may grow large, the answer must be computed modulo 10^9 + 7. 
//
// 
// Example 1: 
//
// 
//Input: arr = [1,3,5]
//Output: 4
//Explanation: All sub-arrays are [[1],[1,3],[1,3,5],[3],[3,5],[5]]
//All sub-arrays sum are [1,4,9,3,8,5].
//Odd sums are [1,9,3,5] so the answer is 4.
// 
//
// Example 2: 
//
// 
//Input: arr = [2,4,6]
//Output: 0
//Explanation: All sub-arrays are [[2],[2,4],[2,4,6],[4],[4,6],[6]]
//All sub-arrays sum are [2,6,12,4,10,6].
//All sub-arrays have even sum and the answer is 0.
// 
//
// Example 3: 
//
// 
//Input: arr = [1,2,3,4,5,6,7]
//Output: 16
// 
//
// Example 4: 
//
// 
//Input: arr = [100,100,99,99]
//Output: 4
// 
//
// Example 5: 
//
// 
//Input: arr = [7]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 10^5 
// 1 <= arr[i] <= 100 
// Related Topics Array Math 
// 👍 187 👎 11


package com.leetcode.editor.en;

public class NumberOfSubArraysWithOddSum{
    public static void main(String[] args) {
       Solution solution = new NumberOfSubArraysWithOddSum().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numOfSubarrays(int[] arr) {
        //记录奇数个数
        int sum = 0;
        for (int i = 0, odd = 0; i < arr.length; ++i) {
            // 如果下一个数是奇数, 则odd = previous even + 1; 因为even + odd = odd
            if (arr[i] % 2 == 1)
                odd = (i - odd) + 1;
            // sum + odd 记录的是上一层奇数个数 + 此层新添的sub array中的奇数个数
            sum = (sum + odd)  % 1000000007;
        }
        return sum;
    }

    /*public int numOfSubarrays(int[] arr) {
        int odd = 0, even = 0, sum = 0;
        for (int n : arr) {
            if (n % 2 == 1) {
                int temp = odd;
                odd = even + 1;
                even = temp;
            }
            else
                ++even;
            sum = (sum + odd) % 1000000007;
        }
        return sum;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)


}