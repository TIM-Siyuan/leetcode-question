//Given an unsorted integer array, find the smallest missing positive integer. 
//
// Example 1: 
//
// 
//Input: [1,2,0]
//Output: 3
// 
//
// Example 2: 
//
// 
//Input: [3,4,-1,1]
//Output: 2
// 
//
// Example 3: 
//
// 
//Input: [7,8,9,11,12]
//Output: 1
// 
//
// Note: 
//
// Your algorithm should run in O(n) time and uses constant extra space. 
// Related Topics Array


package com.leetcode.editor.en;

import java.util.HashSet;

public class FirstMissingPositive{
    public static void main(String[] args) {
       Solution solution = new FirstMissingPositive().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //在数组index[0...n-1]中的正元素大小为[1...n], 假如数组有序遍历, 第一个nums[i]的值不等于i+1的则是结果; 假如1-n都满足, 返回n+1
    //目标: 验证无序数组的index与nums[i]匹配的问题-->因为index位置永远不变, 但指向的内容不匹配, 可能数组中有符合index与nums[i]关系的数字, 也可能没有;
    //题目: 寻找第一个不匹配index与nums[index]的正数;
    //在原数组进行操作常用交换或取负; 这样既对当前index做了标记, 但是又没有更改数组的内容

    //法一: 因为不能用排序, 所以使用set解决这个问题, set可以无序的匹配数字, 后序逻辑相同; 相当于另开一个数组, 将数字按序匹配排放再搜寻, 空间复杂度为O(n), 不符合题目条件
    //如果直接开数组浪费了很多空间[0,1,9,100]就要开101的空间, 然后[1, 1, 0, 0, 0...1......1], 会MLE
    /*public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        for(int j = 1; j <= nums.length; j++){
            if(!set.contains(j)) return j;
        }
        //数组长度为n, 但是因为从0计数, 所以元素大小为n-1; 所以假如数组满, 返回的是nums.length + 1;
        return nums.length + 1;
    }*/

   //法二: 直接在原数组上操作, 遍历到一个元素就将其与正确位置的元素交换, 这样遍历之后有位置的元素都位置正确, 找出第一个位置不正确的
   /*public int firstMissingPositive(int[] nums){
        int n = nums.length;
        for(int i = 0; i < n; i++){
            //一直循环到元素不符合条件为止, 再i++
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]){
                swap(nums, i, nums[i] - 1);
            }
        }
        for(int i = 0; i < n; i++){
            if(nums[i] != i + 1) return i + 1;
        }
        return n + 1;
   }

   private void swap(int[] nums, int a, int b){
       int temp = nums[a];
       nums[a] = nums[b];
       nums[b] = temp;
   }*/

    //法三: 直接在原数组上操作, 假如小于0或超出n的赋值为一个绝对不存在数组中的数, 符合条件的取负(这样是遍历到负的时还可以操作那个数, 没有改变数组指针)
    public int firstMissingPositive(int[] nums){
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] <= 0 || nums[i] > n){
                //假如Integer.MAX_VALUE原本就是数组元素则影响了判定, 所以目标是判定一个不存在的数
                nums[i] = n + 1;
            }
        }

        for(int i = 0; i < n; i++){
            //这里取绝对值是因为需要此元素的内容, 但是假如之前数组中有元素属于这个位置, 则此位置被设为负, 所以需要取绝对值获得元素
            int num = Math.abs(nums[i]);
            //遇到不应该存在于数组的数跳过
            if(num > n){
                continue;
            }
            //符合条件的数将其对应的位置标记(取负标记, 此处防止重复标记);
            //数字num对应下标num-1;
            if(nums[num - 1] > 0){
                nums[num - 1] = -1 * nums[num - 1];
            }
        }

        for(int i = 0; i < n; i++){
            //所有不为负数的说明index的位置缺少这个数, 返回此数对应的index(因为数组下标从0开始, 元素从1开始, 所以nums[i]对应的数字是i+1)
            if(nums[i] >= 0) return i + 1;
        }
        //元素[1...n]满返回n+1
        return n + 1;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


}