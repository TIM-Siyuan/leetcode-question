//Given n points in the plane that are all pairwise distinct, a "boomerang" is a
// tuple of points (i, j, k) such that the distance between i and j equals the dis
//tance between i and k (the order of the tuple matters). 
//
// Find the number of boomerangs. You may assume that n will be at most 500 and 
//coordinates of points are all in the range [-10000, 10000] (inclusive). 
//
// Example: 
//
// 
//Input:
//[[0,0],[1,0],[2,0]]
//
//Output:
//2
//
//Explanation:
//The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
// 
//
// 
// Related Topics Hash Table


package com.leetcode.editor.en;

import java.util.HashMap;

public class NumberOfBoomerangs{
    public static void main(String[] args) {
       Solution solution = new NumberOfBoomerangs().new Solution();
        int[][] points = {{0, 0}, {1, 0}, {2, 0}};
        System.out.println((solution).numberOfBoomerangs(points));
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for(int i = 0; i < points.length; i++){
            HashMap<Integer, Integer> record = new HashMap<Integer, Integer>();
            for(int j = 0; j < points.length; j++){
                if(j != i){
                    int dis = dis(points[i], points[j]);
                    if(record.containsKey(dis))
                        record.put(dis, record.get(dis) + 1);
                    else
                        record.put(dis, 1);
                }
            }
            for(Integer dis:record.keySet())
                res += record.get(dis) * (record.get(dis)-1);
        }
        return res;
    }

    private int dis(int[] pa, int[] pb) {
        return (pa[0] - pb[0]) * (pa[0] - pb[0]) + (pa[1] - pb[1]) * (pa[1] - pb[1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}