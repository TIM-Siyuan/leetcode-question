//Write a program to find the n-th ugly number. 
//
// Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
//
// Example: 
//
// 
//Input: n = 10
//Output: 12
//Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ug
//ly numbers. 
//
// Note: 
//
// 
// 1 is typically treated as an ugly number. 
// n does not exceed 1690. 
// Related Topics Math Dynamic Programming Heap


package com.leetcode.editor.en;

import java.util.Arrays;
import java.util.PriorityQueue;

public class UglyNumberIi{
    public static void main(String[] args) {
       Solution solution = new UglyNumberIi().new Solution();
       solution.nthUglyNumber(10);
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //ugly number = x * 2 / y * 3 / z * 5 -> 所以找sequence就是计算当前可得的最小的数(2,3,5的进度不一样)
    /*public int nthUglyNumber(int n) {
        int[] nums = new int[n];
        nums[0] = 1;
        int idx2 = 0, idx3 = 0, idx5 = 0;
        for(int i = 1; i < nums.length; i++){
            int m2 = nums[idx2] * 2, m3 = nums[idx3] * 3, m5 = nums[idx5] * 5;
            int mn = Math.min(m2, Math.min(m3, m5));
            if(mn == m2) idx2++;
            if(mn == m3) idx3++;
            if(mn == m5) idx5++;
            nums[i] = mn;
        }
        return nums[n - 1];
    }*/

    //维护最小堆 -> 用TreeSet可以不用处理duplicate
    public int nthUglyNumber(int n){
        if(n == 1) return 1;
        PriorityQueue<Long> queue = new PriorityQueue<>();
        //Long类型1L = 1
        queue.add(1L);
        for(long i = 1; i < n; i++){
            long num = queue.poll();
            //防止duplicate number
            while (!queue.isEmpty() && queue.peek() == num) num = queue.poll();
            queue.add(num * 2);
            queue.add(num * 3);
            queue.add(num * 5);
        }
        return queue.poll().intValue();
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}