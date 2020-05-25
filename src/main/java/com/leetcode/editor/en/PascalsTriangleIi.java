//Given a non-negative index k where k ≤ 33, return the kth index row of the Pas
//cal's triangle. 
//
// Note that the row index starts from 0. 
//
// 
//In Pascal's triangle, each number is the sum of the two numbers directly above
// it. 
//
// Example: 
//
// 
//Input: 3
//Output: [1,3,3,1]
// 
//
// Follow up: 
//
// Could you optimize your algorithm to use only O(k) extra space? 
// Related Topics Array


package com.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangleIi{
    public static void main(String[] args) {
       Solution solution = new PascalsTriangleIi().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> getRow(int rowIndex){
        Integer[] ans = new Integer[rowIndex + 1];
        Arrays.fill(ans, 0);
        ans[0] = 1;
        for(int i = 1; i <= rowIndex; i++){
            for(int k = i; k > 0; k--){
                ans[k] = ans[k] + ans[k - 1];
            }
        }
        return Arrays.asList(ans);
    }

    //from end to start
    /*public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        for(int i = 0; i <= rowIndex; i++){
            for(int j = row.size() - 1; j >= 1; j--){
                //自身更新
                row.set(j, row.get(j) + row.get(j - 1));
            }
            row.add(1);
        }
        return row;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)


}