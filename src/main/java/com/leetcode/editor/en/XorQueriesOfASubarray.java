//Given the array arr of positive integers and the array queries where queries[i
//] = [Li, Ri], for each query i compute the XOR of elements from Li to Ri (that i
//s, arr[Li] xor arr[Li+1] xor ... xor arr[Ri] ). Return an array containing the r
//esult for the given queries.
// 
// Example 1: 
//
// 
//Input: arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
//Output: [2,7,14,8] 
//Explanation: 
//The binary representation of the elements in the array are:
//1 = 0001 
//3 = 0011 
//4 = 0100 
//8 = 1000 
//The XOR values for queries are:
//[0,1] = 1 xor 3 = 2 
//[1,2] = 3 xor 4 = 7 
//[0,3] = 1 xor 3 xor 4 xor 8 = 14 
//[3,3] = 8
// 
//
// Example 2: 
//
// 
//Input: arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
//Output: [8,0,4,4]
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 3 * 10^4 
// 1 <= arr[i] <= 10^9 
// 1 <= queries.length <= 3 * 10^4 
// queries[i].length == 2 
// 0 <= queries[i][0] <= queries[i][1] < arr.length 
// Related Topics Bit Manipulation


package com.leetcode.editor.en;

public class XorQueriesOfASubarray{
    public static void main(String[] args) {
       Solution solution = new XorQueriesOfASubarray().new Solution();
       int[] nums = {4,8,2,10};
       int[][] queries = {{2,3}, {1,3}, {0,0}, {0,3}};
       solution.xorQueries(nums, queries);
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] res = new int[queries.length];
        for(int i = 1; i < arr.length; i++){
            arr[i] ^= arr[i - 1];
        }
        for(int j = 0; j < queries.length; j++){
            int start = queries[j][0], end = queries[j][1];
            if(start > 0){
                res[j] = arr[end] ^ arr[start - 1];
            }
            else {
                res[j] = arr[end];
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}