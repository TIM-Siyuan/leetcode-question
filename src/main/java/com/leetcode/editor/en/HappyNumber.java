//Write an algorithm to determine if a number is "happy". 
//
// A happy number is a number defined by the following process: Starting with an
//y positive integer, replace the number by the sum of the squares of its digits, 
//and repeat the process until the number equals 1 (where it will stay), or it loo
//ps endlessly in a cycle which does not include 1. Those numbers for which this p
//rocess ends in 1 are happy numbers. 
//
// Example: 
//
// 
//Input: 19
//Output: true
//Explanation: 
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1
// Related Topics Hash Table Math


package com.leetcode.editor.en;

import java.util.HashSet;

public class HappyNumber{
    public static void main(String[] args) {
       Solution solution = new HappyNumber().new Solution();
       solution.isHappy(19);
    }
    //非快乐数循环中一定有4, 所以可以不用HashSet
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> record = new HashSet<Integer>();
        while(!record.contains(1)){
            int sum = 0;
            while(n != 0){
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            if(record.contains(sum)){
                return false;
            }
            record.add(sum);
            n = sum;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}