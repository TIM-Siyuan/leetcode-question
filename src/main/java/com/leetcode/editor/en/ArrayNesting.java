//A zero-indexed array A of length N contains all integers from 0 to N-1. Find a
//nd return the longest length of set S, where S[i] = {A[i], A[A[i]], A[A[A[i]]], 
//... } subjected to the rule below. 
//
// Suppose the first element in S starts with the selection of element A[i] of i
//ndex = i, the next element in S should be A[A[i]], and then A[A[A[i]]]… By that 
//analogy, we stop adding right before a duplicate element occurs in S. 
//
// 
//
// Example 1: 
//
// 
//Input: A = [5,4,0,3,1,6,2]
//Output: 4
//Explanation: 
//A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
//
//One of the longest S[K]:
//S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
// 
//
// 
//
// Note: 
//
// 
// N is an integer within the range [1, 20,000]. 
// The elements of A are all distinct. 
// Each element of A is an integer within the range [0, N-1]. 
// 
// Related Topics Array


package com.leetcode.editor.en;

public class ArrayNesting{
    public static void main(String[] args) {
       Solution solution = new ArrayNesting().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //使用快慢指针有自环的情况难处理, 所以还是用交换法
    public int arrayNesting(int[] nums) {
        int n = nums.length, res = 0;
        for(int i = 0; i < n; i++){
            int cnt = 1; //假如只有一个数, 结果至少为1
            while (i != nums[i]){
                swap(nums, i, nums[i]);
                cnt++;
            }
            res = Math.max(res, cnt);
        }
        return res;
    }

    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}