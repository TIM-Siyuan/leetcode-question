//There are two sorted arrays nums1 and nums2 of size m and n respectively. 
//
// Find the median of the two sorted arrays. The overall run time complexity sho
//uld be O(log (m+n)). 
//
// You may assume nums1 and nums2 cannot be both empty. 
//
// Example 1: 
//
// 
//nums1 = [1, 3]
//nums2 = [2]
//
//The median is 2.0
// 
//
// Example 2: 
//
// 
//nums1 = [1, 2]
//nums2 = [3, 4]
//
//The median is (2 + 3)/2 = 2.5
// 
// Related Topics Array Binary Search Divide and Conquer


package com.leetcode.editor.en;

public class MedianOfTwoSortedArrays{
    public static void main(String[] args) {
       Solution solution = new MedianOfTwoSortedArrays().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //遍历数组时间复杂度O(m+n)
    /*public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArray = mergeTwosortedArray(nums1, nums2);
        int n = mergedArray.length;
        if(n % 2 == 0){
            return (mergedArray[(n - 1) / 2] + mergedArray[n / 2]) / 2.0;
        }
        else
            return mergedArray[n / 2];
    }

    private int[] mergeTwosortedArray(int[] A, int[] B){
        int[] merged = new int[A.length + B.length];
        int i = 0, j = 0, k = 0;
        while (i < A.length && j < B.length){
            merged[k++] = (A[i] < B[j]) ? A[i]++ : B[j++];
        }
        while (i < A.length){
            merged[k++] = A[i++];
        }
        while (j < B.length){
            merged[k++] = B[j++];
        }
        return merged;
    }*/

    //二分时间复杂度O(logm)
    //在两个分开的sorted数组二分查找, 实际上就是在短数组找割点-->属于左边的元素个数(割点是一个数组的左边元素的最大值, 右边元素的最小值)
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        int len1 = nums1.length, len2 = nums2.length;
        if(len1 > len2)  return findMedianSortedArrays(nums2, nums1);
        if(len1 == 0) return ((double)nums2[(len2 - 1) / 2] + (double)nums2[len2 / 2]) / 2;
        int len = len1 + len2;
        int start_1 = 0, end_1 = nums1.length;
        //左半边元素的个数
        int cut_1, cut_2;
        while (start_1 <= end_1){
            cut_1 = start_1 + (end_1 - start_1) / 2;
            //为奇数个的时候直接返回左半边元素; 所以需要分割的时候左半边元素更多--> len + 1
            //全部元素/2 求得左边元素 --> 减去短数组左边元素即长数组需要贡献的左边元素个数
            cut_2 = (len + 1) / 2 - cut_1;
            //特判分割点在边界的情况: 如果割点很小防止左边越界, 如果割点很大(cut_1 - 1)防止右边越界;
            //因为割点表示的的是左边元素个数, 个数 - 1 = index; 设计时左边元素更多, 所以左边界的index为割点-1, 右边为割点
            double L1 = (cut_1 == 0) ? Integer.MIN_VALUE : nums1[cut_1 - 1];
            double L2 = (cut_2 == 0) ? Integer.MIN_VALUE : nums2[cut_2 - 1];
            double R1 = (cut_1 == len1) ? Integer.MAX_VALUE : nums1[cut_1];
            double R2 = (cut_2 == len2) ? Integer.MAX_VALUE : nums2[cut_2];
            //如果割点左边元素多了,向左移动
            if (L1 > R2) {
                end_1 = cut_1 - 1;
            }
            else if(L2 > R1){
                start_1 = cut_1 + 1;
            }
            else { //L1 < R2 && L2 < R1 --> 左半边边界值 < 右半边边界值
                if(len % 2 == 0){
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
                }
                else {
                    return Math.max(L1, L2);
                }
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}