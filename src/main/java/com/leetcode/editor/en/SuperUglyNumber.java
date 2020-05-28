//Write a program to find the nth super ugly number. 
//
// Super ugly numbers are positive numbers whose all prime factors are in the gi
//ven prime list primes of size k. 
//
// Example: 
//
// 
//Input: n = 12, primes = [2,7,13,19]
//Output: 32 
//Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12 
//
//             super ugly numbers given primes = [2,7,13,19] of size 4. 
//
// Note: 
//
// 
// 1 is a super ugly number for any given primes. 
// The given numbers in primes are in ascending order. 
// 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000. 
// The nth super ugly number is guaranteed to fit in a 32-bit signed integer. 
// 
// Related Topics Math Heap


package com.leetcode.editor.en;

import java.util.PriorityQueue;

public class SuperUglyNumber{
    public static void main(String[] args) {
       Solution solution = new SuperUglyNumber().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //O(log(k)N)
    /*public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Long> q = new PriorityQueue<>();
        q.offer(1L);
        for(int i = 1; i < n; i++){
            long tmp = q.poll();
            while (!q.isEmpty() && q.peek() == tmp) tmp = q.poll();
            for(int prime : primes){
                q.offer(tmp * prime);
            }
        }
        return q.poll().intValue();
    }*/

    //O(kN) 15ms
    public int nthSuperUglyNumber(int n, int[] primes){
        int[] res = new int[n];
        //记录指针的位置
        int[] cur = new int[primes.length];
        res[0] = 1;

        for(int i = 1; i < n; i++){
            res[i] = Integer.MAX_VALUE;
            for(int j = 0; j < primes.length; j++){
                if(primes[j] * res[cur[j]] == res[i - 1]){
                    cur[j]++;
                }
                res[i] = Math.min(res[i], primes[j] * res[cur[j]]);
            }
        }
        return res[n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}