//
//You have 4 cards each containing a number from 1 to 9. You need to judge wheth
//er they could operated through *, /, +, -, (, ) to get the value of 24.
// 
//
// Example 1: 
// 
//Input: [4, 1, 8, 7]
//Output: True
//Explanation: (8-4) * (7-1) = 24
// 
// 
//
// Example 2: 
// 
//Input: [1, 2, 1, 2]
//Output: False
// 
// 
//
// Note: 
// 
// The division operator / represents real division, not integer division. For e
//xample, 4 / (1 - 2/3) = 12. 
// Every operation done is between two numbers. In particular, we cannot use - a
//s a unary operator. For example, with [1, 1, 1, 1] as input, the expression -1 -
// 1 - 1 - 1 is not allowed. 
// You cannot concatenate numbers together. For example, if the input is [1, 2, 
//1, 2], we cannot write this as 12 + 12. 
// 
// 
// Related Topics Depth-first Search


package com.leetcode.editor.en;

public class Two4Game{
    public static void main(String[] args) {
       Solution solution = new Two4Game().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean judgePoint24(int[] nums) {
        double[] a = new double[]{nums[0], nums[1], nums[2], nums[3]};
        return helper(a);
    }

    private boolean helper(double[] a){
        if(a.length == 1){
            return Math.abs(a[0] - 24) < 0.001;
        }

        for(int i = 0; i < a.length; i++){
            for(int j = i + 1; j < a.length; j++){
                double[] b= new double[a.length - 1];

                for(int k = 0, index = 0; k < a.length; k++){
                    if(k != i && k != j){
                        b[index++] = a[k];
                    }
                }

                for(double d : compute(a[i], a[j])){
                    b[b.length - 1] = d;
                    if(helper(b)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private double[] compute(double x, double y){
        return new double[]{x+y, x-y, y-x, x*y, x/y, y/x};
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}