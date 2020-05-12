//Given an array nums of n integers and an integer target, find three integers i
//n nums such that the sum is closest to target. Return the sum of the three integ
//ers. You may assume that each input would have exactly one solution. 
//
// Example: 
//
// 
//Given array nums = [-1, 2, 1, -4], and target = 1.
//
//The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
// 
// Related Topics Array Two Pointers


package com.leetcode.editor.en;

import java.util.Arrays;

public class ThreeSumClosest{
    public static void main(String[] args) {
       Solution solution = new ThreeSumClosest().new Solution();
       int[] nums = {0, 1, 2};
       solution.threeSumClosest(nums, 0);
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < n - 2; i++ ){
            if(i == 0 || nums[i] != nums[i - 1]){
                int l = i + 1, r = n - 1;
                while (l < r){
                    int sum = nums[i] + nums[l] + nums[r];
                    if (target > sum) {
                        while(l < r && nums[l] == nums[l + 1]) l++;
                        l++;
                    }
                    else if(target < sum){
                        while(l < r && nums[r] == nums[r - 1]) r--;
                        r--;
                    }
                    else {
                        return sum;
                    }
                    //res 不能初始值为Integer.MIN_VALUE --> Math.abs(Integer.MIN_VALUE) 返回Integer.MIN_VALUE; 判断条件永远为false
                    //因为存在0, 所以加负号变正溢出; 负数取反是所有位取反+1; 所以变成了Integer.MAX_VALUE + 1 = Integer.MIN_VALUE;
                    //res 也不能初始值为Integer.MAX_VALUE --> 如果target为负数, 则变为很小的负数, 判断条件也为false
                    if(Math.abs(sum - target) < Math.abs(res - target)){
                        res = sum;
                    }
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}