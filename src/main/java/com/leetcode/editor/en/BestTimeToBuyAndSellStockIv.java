//Say you have an array for which the i-th element is the price of a given stock
// on day i. 
//
// Design an algorithm to find the maximum profit. You may complete at most k tr
//ansactions. 
//
// Note: 
//You may not engage in multiple transactions at the same time (ie, you must sel
//l the stock before you buy again). 
//
// Example 1: 
//
// 
//Input: [2,4,1], k = 2
//Output: 2
//Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 
//4-2 = 2.
// 
//
// Example 2: 
//
// 
//Input: [3,2,6,5,0,3], k = 2
//Output: 7
//Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 
//6-2 = 4.
//             Then buy on day 5 (price = 0) and sell on day 6 (price = 3), prof
//it = 3-0 = 3.
// 
// Related Topics Dynamic Programming


package com.leetcode.editor.en;

public class BestTimeToBuyAndSellStockIv{
    public static void main(String[] args) {
       Solution solution = new BestTimeToBuyAndSellStockIv().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int max_k, int[] prices) {
        int n = prices.length;
        if(max_k > n / 2) return maxProfit_k_inf(prices);
        int[][][] dp = new int[n][max_k + 1][2];
        for(int i = 0; i < n; i++){
            for(int k = max_k; k >= 1; k--){
                if(i - 1 == -1){
                    dp[i][k][0] = 0;
                    //使用Integer.MIN_VALUES 则 1 [1,2]报错;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][max_k][0];
    }

    private int maxProfit_k_inf(int[] prices){
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
        }
        return dp_i_0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}