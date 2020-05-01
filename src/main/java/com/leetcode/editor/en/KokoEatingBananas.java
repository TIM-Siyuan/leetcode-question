//Koko loves to eat bananas. There are N piles of bananas, the i-th pile has pil
//es[i] bananas. The guards have gone and will come back in H hours. 
//
// Koko can decide her bananas-per-hour eating speed of K. Each hour, she choose
//s some pile of bananas, and eats K bananas from that pile. If the pile has less 
//than K bananas, she eats all of them instead, and won't eat any more bananas dur
//ing this hour. 
//
// Koko likes to eat slowly, but still wants to finish eating all the bananas be
//fore the guards come back. 
//
// Return the minimum integer K such that she can eat all the bananas within H h
//ours. 
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
//Input: piles = [3,6,7,11], H = 8
//Output: 4
// 
//
// 
// Example 2: 
//
// 
//Input: piles = [30,11,23,4,20], H = 5
//Output: 30
// 
//
// 
// Example 3: 
//
// 
//Input: piles = [30,11,23,4,20], H = 6
//Output: 23
// 
//
// 
//
// Note: 
//
// 
// 1 <= piles.length <= 10^4 
// piles.length <= H <= 10^9 
// 1 <= piles[i] <= 10^9 
// 
// 
// 
// 
// Related Topics Binary Search


package com.leetcode.editor.en;

import com.sun.xml.internal.ws.model.wsdl.WSDLPortProperties;

public class KokoEatingBananas{
    public static void main(String[] args) {
       Solution solution = new KokoEatingBananas().new Solution();
       int[] piles = {332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077, 337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728, 941802184};
       solution.minEatingSpeed(piles,  823855818);
    }

    //不能用for循环, 从1开始测试speed, 测试大数据时会导致time溢出, 结果错误
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int max = getMax(piles);
        int left = 1, right = max + 1; //speed最小为1, left从1开始, 开区间所以right = max + 1
        // 寻找左边边界;
        while (left < right){
            int mid = left + (right - left) / 2;
            if(canFinish(piles, mid, H)){
                right = mid; //左闭右开; 所以到mid
            }
            else{ // canFinish == false;
                left = mid + 1;
            }
        }
        return left;
    }

    private int timeOf(int n, int speed){
        return (n / speed) + ((n % speed) > 0 ? 1 : 0);
    }

    private boolean canFinish(int[] piles, int speed, int H){
        int time = 0;
        for(int n : piles){
            time += timeOf(n, speed);
        }
        return time <= H;
    }

    private int getMax(int[] piles){
        int max = 0;
        for(int n : piles){
            max = Math.max(n, max);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}