//
//Given a circular array (the next element of the last element is the first elem
//ent of the array), print the Next Greater Number for every element. The Next Gre
//ater Number of a number x is the first greater number to its traversing-order ne
//xt in the array, which means you could search circularly to find its next greate
//r number. If it doesn't exist, output -1 for this number.
// 
//
// Example 1: 
// 
//Input: [1,2,1]
//Output: [2,-1,2]
//Explanation: The first 1's next greater number is 2; The number 2 can't find n
//ext greater number; The second 1's next greater number needs to search circularl
//y, which is also 2.
// 
// 
//
// Note:
//The length of given array won't exceed 10000.
// Related Topics Stack


package com.leetcode.editor.en;

import java.util.Stack;

public class NextGreaterElementIi{
    public static void main(String[] args) {
       Solution solution = new NextGreaterElementIi().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> s = new Stack<Integer>();
        int n = nums.length;
        for(int i = 2 * nums.length - 1 ; i >= 0; i++){
            while(!s.isEmpty() && s.peek() <= nums[i % n]){
                s.pop();
            }
            res[i % n] = s.isEmpty() ? -1 : s.peek();
            s.push(nums[i % n]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}