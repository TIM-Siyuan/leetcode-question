//Suppose an array sorted in ascending order is rotated at some pivot unknown to
// you beforehand. 
//
// (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]). 
//
// You are given a target value to search. If found in the array return its inde
//x, otherwise return -1. 
//
// You may assume no duplicate exists in the array. 
//
// Your algorithm's runtime complexity must be in the order of O(log n). 
//
// Example 1: 
//
// 
//Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
// 
//
// Example 2: 
//
// 
//Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1 
// Related Topics Array Binary Search


package com.leetcode.editor.en;

public class SearchInRotatedSortedArray{
    public static void main(String[] args) {
       Solution solution = new SearchInRotatedSortedArray().new Solution();

    }
    //start == target: 相等则返回下标;
    //法1: 一分为二, 一个一定有序，一个可能有序，可能部分有序; 根据首尾判断target在哪部分;
    //法2:
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*  用尾判断有序
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < nums[right]){ //右边有序
                // target > mid -> 可能左可能右;
                // 首尾确定target在哪边
                if(nums[mid] < target && nums[right] >= target)
                    left = mid + 1; //在右边
                else
                    right = mid - 1;
            }
            else if(nums[mid] >= nums[right]){ //左边有序
                if(nums[mid] > target && nums[left] <= target){
                    right = mid - 1;
                }
                else
                    left = mid + 1;
            }
        }
        return -1;
    }
*/

    //只有两个数的时候, 向下取整, nums[left]等于nums[mid], 但是nums[mid] != target;
    //所以相等时要放入右边 所以 nums[mid] >= left
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] >= nums[left]){ //左边有序
                if(nums[mid] > target && nums[left] <= target)
                    right = mid - 1; //在左侧
                else
                    left = mid + 1;
            }
            else if(nums[mid] < nums[left]){ //右边有序
                if(nums[mid] < target && nums[right] >= target) //在右侧
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}