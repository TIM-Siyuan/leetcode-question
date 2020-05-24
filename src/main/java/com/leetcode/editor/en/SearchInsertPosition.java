//Given a sorted array and a target value, return the index if the target is fou
//nd. If not, return the index where it would be if it were inserted in order. 
//
// You may assume no duplicates in the array. 
//
// Example 1: 
//
// 
//Input: [1,3,5,6], 5
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: [1,3,5,6], 2
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: [1,3,5,6], 7
//Output: 4
// 
//
// Example 4: 
//
// 
//Input: [1,3,5,6], 0
//Output: 0
// 
// Related Topics Array Binary Search


package com.leetcode.editor.en;

public class SearchInsertPosition{
    public static void main(String[] args) {
       Solution solution = new SearchInsertPosition().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) r = mid - 1;
            else if(nums[mid] < target) l = mid + 1;
        }
        //假如不存在这个数, 返回mid + 1 --> [1, 3] target = 2 插入 i == 1 位置
        return l;
    }*/

    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            //不断缩小右侧边界[left, mid)
            if(nums[mid] >= target) r = mid;
            else if(nums[mid] < target) l = mid + 1;
        }
        //寻找左侧边界; 即有多少元素小于target
        return l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}