//Given n points on a 2D plane, find the maximum number of points that lie on th
//e same straight line. 
//
// Example 1: 
//
// 
//Input: [[1,1],[2,2],[3,3]]
//Output: 3
//Explanation:
//^
//|
//|        o
//|     o
//|  o  
//+------------->
//0  1  2  3  4
// 
//
// Example 2: 
//
// 
//Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
//Output: 4
//Explanation:
//^
//|
//|  o
//|     o        o
//|        o
//|  o        o
//+------------------->
//0  1  2  3  4  5  6
// 
//
// NOTE: input types have been changed on April 15, 2019. Please reset to defaul
//t code definition to get new method signature. 
// Related Topics Hash Table Math


package com.leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine{
    public static void main(String[] args) {
       Solution solution = new MaxPointsOnALine().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*public int maxPoints(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; ++i) {
            Map<Map<Integer, Integer>, Integer> m = new HashMap<>();
            int duplicate = 1;
            for (int j = i + 1; j < points.length; ++j) {
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    ++duplicate;
                    continue;
                }
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                int d = gcd(dx, dy);
                Map<Integer, Integer> t = new HashMap<>();
                t.put(dx / d, dy / d);
                m.put(t, m.getOrDefault(t, 0) + 1);
            }
            res = Math.max(res, duplicate);
            for (Map.Entry<Map<Integer, Integer>, Integer> e : m.entrySet()){
                res = Math.max(res, e.getValue() + duplicate);
            }
        }
        return res;
    }

    private int gcd(int a, int b){
        return (b == 0) ? a : gcd(b, a % b);
    }*/

    public int maxPoints(int[][] points) {
        int res = 0, n = points.length;
        for (int i = 0; i < n; ++i) {
            int duplicate = 1;
            for (int j = i + 1; j < n; ++j) {
                int cnt = 0;
                long x1 = points[i][0], y1 = points[i][1];
                long x2 = points[j][0], y2 = points[j][1];
                if (x1 == x2 && y1 == y2) {
                    ++duplicate;
                    continue;
                }
                for (int k = 0; k < n; ++k) {
                    int x3 = points[k][0], y3 = points[k][1];
                    if (x1*y2 + x2*y3 + x3*y1 - x3*y2 - x2*y1 - x1 * y3 == 0) {
                        ++cnt;
                    }
                }
                res = Math.max(res, cnt);
            }
            res = Math.max(res, duplicate);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}