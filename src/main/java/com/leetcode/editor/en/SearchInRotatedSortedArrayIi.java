//Suppose an array sorted in ascending order is rotated at some pivot unknown to
// you beforehand. 
//
// (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]). 
//
// You are given a target value to search. If found in the array return true, ot
//herwise return false. 
//
// Example 1: 
//
// 
//Input: nums = [2,5,6,0,0,1,2], target = 0
//Output: true
// 
//
// Example 2: 
//
// 
//Input: nums = [2,5,6,0,0,1,2], target = 3
//Output: false 
//
// Follow up: 
//
// 
// This is a follow up problem to Search in Rotated Sorted Array, where nums may
// contain duplicates. 
// Would this affect the run-time complexity? How and why? 
// 
// Related Topics Array Binary Search


package com.leetcode.editor.en;

public class SearchInRotatedSortedArrayIi{
    public static void main(String[] args) {
       Solution solution = new SearchInRotatedSortedArrayIi().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return false;
        int left = 0, right = nums.length -1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
                return true;
            else if(nums[mid] < nums[right]){
                if(nums[mid] < target && nums[right] >= target)
                    left = mid + 1;
                else
                    right = mid - 1;
            }
            else if(nums[mid] > nums[right]){
                if(nums[mid] > target && nums[left] <= target)
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            // 因为有重复元素, I判断有序的方法无效, 所以right--, 直到找到不同元素
            else{ //nums[mid] == nums[right]
                right--;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}