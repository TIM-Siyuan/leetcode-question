//Count the number of prime numbers less than a non-negative number, n. 
//
// Example: 
//
// 
//Input: 10
//Output: 4
//Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
// 
// Related Topics Hash Table Math


package com.leetcode.editor.en;

import java.util.Arrays;

public class CountPrimes{
    public static void main(String[] args) {
       Solution solution = new CountPrimes().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //O(N * loglogN) : Sieve of Eratosthenes
    public int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);

        //follow up: i < n --> i * i < n; sqrt(n)因子的重复性 --> 3 * 4 / 4 * 3
        for(int i = 2; i * i < n; i++){
            if(isPrim[i]){
                //j = 2 * i --> j = i * i; 例: n = 25; i = 4 会重复标记 2 * 4/ 3 * 4; 实际i = 2, i = 3时已标记 -- 实质是因子的重复性
                for(int j = i * i; j < n; j += i){
                    isPrim[j] = false;
                }
            }
        }
        int count = 0;
        for(int i = 2; i < n; i++){
            if(isPrim[i]) count++;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}