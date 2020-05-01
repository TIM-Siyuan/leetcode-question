//Suppose an array sorted in ascending order is rotated at some pivot unknown to
// you beforehand. 
//
// (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]). 
//
// Find the minimum element. 
//
// You may assume no duplicate exists in the array. 
//
// Example 1: 
//
// 
//Input: [3,4,5,1,2] 
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: [4,5,6,7,0,1,2]
//Output: 0
// 
// Related Topics Array Binary Search


package com.leetcode.editor.en;

public class FindMinimumInRotatedSortedArray{
    public static void main(String[] args) {
       Solution solution = new FindMinimumInRotatedSortedArray().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //利用二分不断更新最小值; 左边有序则最小值一定在右边; 反之亦然
    /*public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        int res = Integer.MAX_VALUE;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] >= nums[right]){
                left = mid + 1;
            }
            else if(nums[mid] < nums[right]){
               right = mid - 1;
            }
            res = Math.min(res, nums[mid]);
        }
        return res;
    }*/


    //因为要用num[right]做对比, 所以right的范围必须可取;
    //因为没有mid, 所以必须有一边为mid, 到底哪边直接等于mid, 特殊考虑只剩下两个数的情况.
    //因为向下取整, 所以mid = left, 这时如果是{2, 1} 则需要left+1, 假如left=mid则死循环; 如果是{1, 2}, 则右往左移动一格; 所以只有right = mid
    //而且while条件left必须小于right, 如果相等的话, 因为有一方为mid, 则死循环
    //不用担心nums.length-1没法在循环中被考虑到; 因为返回的是一个数值, 而不是-1, 无论{2, 1}, {1, 2}, {1, 1}都能返回正确结果

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] <= nums[right]) {
                right = mid;
            }
        }
        return nums[right];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}