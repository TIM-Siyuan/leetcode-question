//A conveyor belt has packages that must be shipped from one port to another wit
//hin D days. 
//
// The i-th package on the conveyor belt has a weight of weights[i]. Each day, w
//e load the ship with packages on the conveyor belt (in the order given by weight
//s). We may not load more weight than the maximum weight capacity of the ship. 
//
// Return the least weight capacity of the ship that will result in all the pack
//ages on the conveyor belt being shipped within D days. 
//
// 
//
// Example 1: 
//
// 
//Input: weights = [1,2,3,4,5,6,7,8,9,10], D = 5
//Output: 15
//Explanation: 
//A ship capacity of 15 is the minimum to ship all the packages in 5 days like t
//his:
//1st day: 1, 2, 3, 4, 5
//2nd day: 6, 7
//3rd day: 8
//4th day: 9
//5th day: 10
//
//Note that the cargo must be shipped in the order given, so using a ship of cap
//acity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8)
//, (9), (10) is not allowed. 
// 
//
// Example 2: 
//
// 
//Input: weights = [3,2,2,4,1,4], D = 3
//Output: 6
//Explanation: 
//A ship capacity of 6 is the minimum to ship all the packages in 3 days like th
//is:
//1st day: 3, 2
//2nd day: 2, 4
//3rd day: 1, 4
// 
//
// Example 3: 
//
// 
//Input: weights = [1,2,3,1,1], D = 4
//Output: 3
//Explanation: 
//1st day: 1
//2nd day: 2
//3rd day: 3
//4th day: 1, 1
// 
//
// 
//
// Note: 
//
// 
// 1 <= D <= weights.length <= 50000 
// 1 <= weights[i] <= 500 
// Related Topics Array Binary Search


package com.leetcode.editor.en;

import com.sun.scenario.effect.impl.sw.java.JSWPerspectiveTransformPeer;

import javax.swing.*;

public class CapacityToShipPackagesWithinDDays{
    public static void main(String[] args) {
       Solution solution = new CapacityToShipPackagesWithinDDays().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int left = getMax(weights), right = sumMax(weights);
        while (left < right){
            int mid = left + (right - left) / 2;
            if(canFinish(weights, mid, D)){ //如果可以运完, 则缩小运送量
                right = mid;
            }
            else{ // canFinish == false;
                left = mid + 1;
            }
        }
        return left;
    }

    // 如果载重为cap, 是否能在D天内运完货物
    private boolean canFinish(int[] weights, int cap, int D){
        int i = 0;
        for(int d = 0; d < D; d++){
            int maxCap = cap;
            while((maxCap -= weights[i]) >= 0){
                //从0开始计数, 当maxCap = 0的时候, i == weights.length - 1;
                //进入循环i++, 此时 i = weights.length; return true
                i++;
                if(i == weights.length)
                    return true;
            }
        }
        return false;
    }

    private int getMax(int[] weights){
        int res = 0;
        for(int w : weights){
            res = Math.max(res, w);
        }
        return res;
    }

    private int sumMax(int[] weights){
        int res = 0;
        for(int w : weights){
            res += w;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}