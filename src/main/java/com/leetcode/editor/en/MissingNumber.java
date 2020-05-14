//Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find 
//the one that is missing from the array. 
//
// Example 1: 
//
// 
//Input: [3,0,1]
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: [9,6,4,2,3,5,7,0,1]
//Output: 8
// 
//
// Note: 
//Your algorithm should run in linear runtime complexity. Could you implement it
// using only constant extra space complexity? Related Topics Array Math Bit Manip
//ulation


package com.leetcode.editor.en;

public class MissingNumber{
    public static void main(String[] args) {
       Solution solution = new MissingNumber().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //因为只缺失一个数, [0...n-1]所以可以认为用n, 顶替了前面的某一个数的位置, xor后会剩下缺失数a与n
    //所以res初始为n, 这样可找到缺失的数a; res = n ^ a ^ n; 如果res初始为0, 则返回res ^ i, 此时i == n - 1;
    /*public int missingNumber(int[] nums) {
        int n = nums.length;
        int res = n;
        for(int i = 0; i < n; i++){
            res = res ^ i ^ nums[i]; // a^b^b = a

        }
        return res;
    }*/

    //与上面逻辑相同
    public int missingNumber(int[] nums){
        int n = nums.length;
        int res = n;
        //i是正常序, nums中为用n替换了数字的数组; 所以res初始为n, 则 n + a - n
        for (int i = 0; i < n; i++){
            res += i - nums[i];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}