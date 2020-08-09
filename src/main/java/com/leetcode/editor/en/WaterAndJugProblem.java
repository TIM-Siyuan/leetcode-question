//You are given two jugs with capacities x and y litres. There is an infinite am
//ount of water supply available. You need to determine whether it is possible to 
//measure exactly z litres using these two jugs. 
//
// If z liters of water is measurable, you must have z liters of water contained
// within one or both buckets by the end. 
//
// Operations allowed: 
//
// 
// Fill any of the jugs completely with water. 
// Empty any of the jugs. 
// Pour water from one jug into another till the other jug is completely full or
// the first jug itself is empty. 
// 
//
// Example 1: (From the famous "Die Hard" example) 
//
// 
//Input: x = 3, y = 5, z = 4
//Output: True
// 
//
// Example 2: 
//
// 
//Input: x = 2, y = 6, z = 5
//Output: False
// 
// 
// Constraints: 
//
// 
// 0 <= x <= 10^6 
// 0 <= y <= 10^6 
// 0 <= z <= 10^6 
// 
// Related Topics Math 
// 👍 315 👎 759


package com.leetcode.editor.en;

public class WaterAndJugProblem{
    public static void main(String[] args) {
       Solution solution = new WaterAndJugProblem().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if(x + y < z) return false;
        if(x == z || y == z || x + y == z) return true;
        return z % GCD(x, y) == 0;
    }

    //辗转相除求最大公约数
    //裴蜀定理 ax + by = z 优解, 当且仅当 z 是 x，y 的最大公约数的倍数
    private int GCD(int a, int b){
        int r;
        while (b > 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}