//Given a non-empty array of integers, every element appears three times except 
//for one, which appears exactly once. Find that single one. 
//
// Note: 
//
// Your algorithm should have a linear runtime complexity. Could you implement i
//t without using extra memory? 
//
// Example 1: 
//
// 
//Input: [2,2,3,2]
//Output: 3
// 
//
// Example 2: 
//
// 
//Input: [0,1,0,1,0,1,99]
//Output: 99 
// Related Topics Bit Manipulation


package com.leetcode.editor.en;

public class SingleNumberIi{
    public static void main(String[] args) {
       Solution solution = new SingleNumberIi().new Solution();
       int[] nums = {2,2,2,1};
       solution.singleNumber(nums);
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //每个数都看作32bit, 将每个数的每个bit与1相与(即相加), 因为除了出现一次的, 其他都出现了三次, 所以每一bit与3求余数, 这样出现三次的数将被消除
    //将每个数相与的时候从右边开始, 所以右移; 最后返回的时候
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i = 0; i < 32; i++){
            int sum = 0;
            //将数组中每个数的这位bit相加: 通过移位将所求的那个bit和1做相与操作(不然的话没法单独取得bit相加）
            for(int j = 0; j < nums.length; j++){
                //因为从最右(最低位)开始算起，所以右移
                //if((nums[j] >> i & 1) == 1) sum++;
                sum += nums[j] >> i & 1;
            }
            //还原: 将这位bit进行余3操作, 因为先算了最低位, 随后进来的是更高位, 所以左移
            // |= 有1为1, 全0为0 等于 += 操作
            res |= (sum % 3) << i;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}