//Given an array with n objects colored red, white or blue, sort them in-place s
//o that objects of the same color are adjacent, with the colors in the order red,
// white and blue. 
//
// Here, we will use the integers 0, 1, and 2 to represent the color red, white,
// and blue respectively. 
//
// Note: You are not suppose to use the library's sort function for this problem
//. 
//
// Example: 
//
// 
//Input: [2,0,2,1,1,0]
//Output: [0,0,1,1,2,2] 
//
// Follow up: 
//
// 
// A rather straight forward solution is a two-pass algorithm using counting sor
//t. 
// First, iterate the array counting number of 0's, 1's, and 2's, then overwrite
// array with total number of 0's, then 1's and followed by 2's. 
// Could you come up with a one-pass algorithm using only constant space? 
// 
// Related Topics Array Two Pointers Sort


package com.leetcode.editor.en;

public class SortColors{
    public static void main(String[] args) {
       Solution solution = new SortColors().new Solution();
       
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void sortColors(int[] nums) {
        int zero = -1;         //nums[0...zero] == 0
        int two = nums.length; //nums[two...n-1] == 2
        for(int i = 0; i < two;){
            if (nums[i] == 1) {
                i++;
            }
            else if(nums[i] == 0){
                zero ++;
                int temp = nums[zero];
                nums[zero] = nums[i];
                nums[i] = temp;
                i++;
            }
            else if(nums[i] == 2){
                two--;
                int temp = nums[two];
                nums[two] = nums[i];
                nums[i] = temp;
            }

        }
    }
    }

//leetcode submit region end(Prohibit modification and deletion)


}