//Given four lists A, B, C, D of integer values, compute how many tuples (i, j, 
//k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero. 
//
// To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ 
//N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guar
//anteed to be at most 231 - 1. 
//
// Example: 
//
// 
//Input:
//A = [ 1, 2]
//B = [-2,-1]
//C = [-1, 2]
//D = [ 0, 2]
//
//Output:
//2
//
//Explanation:
//The two tuples are:
//1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
//2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
// 
//
// 
// Related Topics Hash Table Binary Search


package com.leetcode.editor.en;

import java.util.HashMap;

public class FourSumIi{
    public static void main(String[] args) {
        Solution solution = new FourSumIi().new Solution();
        int[] a = {1, 2};
        int[] b = {-2, -1};
        int[] c = {-1, 2};
        int[] d = {0, 2};
        System.out.println((solution).fourSumCount(a, b, c, d));
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if(A == null || B == null || C == null || D == null)
            throw new IllegalArgumentException("Illegal argument");

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < C.length ; i++){
            for(int j = 0; j < D.length; j++){
                int sum = C[i] + D[j];
                if(map.containsKey(sum))
                    map.put(sum, map.get(sum) + 1);
                else
                    map.put(sum, 1);
            }
        }

        int res = 0;
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B.length; j++){
                if(map.containsKey(-A[i]-B[j]))
                    res += map.get(-A[i]-B[j]);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}