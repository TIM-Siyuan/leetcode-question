//Given an array nums of n integers and an integer target, are there elements a,
// b, c, and d in nums such that a + b + c + d = target? Find all unique quadruple
//ts in the array which gives the sum of target. 
//
// Note: 
//
// The solution set must not contain duplicate quadruplets. 
//
// Example: 
//
// 
//Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
//
//A solution set is:
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics Array Hash Table Two Pointers


package com.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum{
    public static void main(String[] args) {
       Solution solution = new FourSum().new Solution();
       int[] nums = {0,4,-5,2,-2,4,2,-1,4};
       solution.fourSum(nums, 12);
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //因为target不一定为0, 所以3sum中第一个元素大于0则跳过的剪枝不能用
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length < 4) return res;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++){
            if(nums[i] * 4  > target) continue; //最小数还比target大; too big
            if(nums[i] + 3 * nums[nums.length - 1] < target) continue; //开头+最大数还比target小; too small
            if(i == 0 || nums[i] != nums[i - 1]){ //去重
                for(int j = i + 1; j < nums.length - 2; j++){
                    int l = j + 1, r = nums.length - 1, sum = target - nums[i] - nums[j];
                    if(nums[j] * 3 > target - nums[i]) continue; // too big;
                    if(nums[j] + 2 * nums[nums.length - 1] < target - nums[i]) continue; // too small
                    if(j == i + 1 || nums[j] != nums[j - 1]){
                        while (l < r){
                            if(nums[l] + nums[r] < sum){
                                while (l < r && nums[l] == nums[l + 1]) l++;
                                l++;
                            }
                            else if(nums[l] + nums[r] > sum){
                                while (l < r && nums[r] == nums[r - 1]) r--;
                                r--;
                            }
                            else {
                                res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                                while (l < r && nums[l] == nums[l + 1]) l++;
                                while (l < r && nums[r] == nums[r - 1]) r--;
                                l++;
                                r--;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}