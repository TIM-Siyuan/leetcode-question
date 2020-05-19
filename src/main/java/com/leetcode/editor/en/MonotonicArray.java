//An array is monotonic if it is either monotone increasing or monotone decreasi
//ng. 
//
// An array A is monotone increasing if for all i <= j, A[i] <= A[j]. An array A
// is monotone decreasing if for all i <= j, A[i] >= A[j]. 
//
// Return true if and only if the given array A is monotonic. 
//
// 
//
// 
// 
//
// 
// Example 1: 
//
// 
//Input: [1,2,2,3]
//Output: true
// 
//
// 
// Example 2: 
//
// 
//Input: [6,5,4,4]
//Output: true
// 
//
// 
// Example 3: 
//
// 
//Input: [1,3,2]
//Output: false
// 
//
// 
// Example 4: 
//
// 
//Input: [1,2,4,5]
//Output: true
// 
//
// 
// Example 5: 
//
// 
//Input: [1,1,1]
//Output: true
// 
//
// 
//
// Note: 
//
// 
// 1 <= A.length <= 50000 
// -100000 <= A[i] <= 100000 
// 
// 
// 
// 
// 
// 
// Related Topics Array


package com.leetcode.editor.en;

import java.util.Stack;

public class MonotonicArray{
    public static void main(String[] args) {
       Solution solution = new MonotonicArray().new Solution();
       int[] A = {1, 2, 2, 4};
       solution.isMonotonic(A);
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*public boolean isMonotonic(int[] A) {
        boolean inc = true, dec = true;
        for(int i = 1; i < A.length; i++){
            inc &= A[i] >= A[i - 1];
            dec &= A[i] <= A[i - 1];
        }
        return inc || dec;
    }*/

    public boolean isMonotonic(int[] A) {
        boolean inc = true, dec = true;
        for(int i = 1; i < A.length; i++){
            if(A[i] > A[i - 1]){
                dec = false;
            }
            if(A[i] < A[i - 1]){
                inc = false;
            }
        }
        return inc || dec;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


}