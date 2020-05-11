//Given an array nums of n integers, are there elements a, b, c in nums such tha
//t a + b + c = 0? Find all unique triplets in the array which gives the sum of ze
//ro. 
//
// Note: 
//
// The solution set must not contain duplicate triplets. 
//
// Example: 
//
// 
//Given array nums = [-1, 0, 1, 2, -1, -4],
//
//A solution set is:
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// Related Topics Array Two Pointers


package com.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeSum{
    public static void main(String[] args) {
       Solution solution = new ThreeSum().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            //法1: 防止重复元素, 因为固定同一个数得到的结果是重复的, 又确保i==0可进入判断; 法2: 一开始不处理, 结果存入Set去重;
            if(i == 0 || nums[i] != nums[i - 1]){
                //数组有序; 如果开头已经大于0, 后序不可能为0;
                if(nums[i] > 0) break;
                //l从i+1开始, 不重头开始是因为比l小的可能的结果, 已经在之前算过
                int l = i + 1, r = nums.length - 1, target = -nums[i];
                while (l < r){
                    if(nums[l] + nums[r] > target){
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        r--;
                    }
                    else if(nums[l] + nums[r] < target){
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        l++;
                    }
                    else {
                        res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++; r--;
                    }
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}