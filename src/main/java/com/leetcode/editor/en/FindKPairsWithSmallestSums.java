//You are given two integer arrays nums1 and nums2 sorted in ascending order and
// an integer k. 
//
// Define a pair (u,v) which consists of one element from the first array and on
//e element from the second array. 
//
// Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums. 
//
// Example 1: 
//
// 
//Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
//Output: [[1,2],[1,4],[1,6]] 
//Explanation: The first 3 pairs are returned from the sequence: 
//             [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6] 
//
// Example 2: 
//
// 
//Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
//Output: [1,1],[1,1]
//Explanation: The first 2 pairs are returned from the sequence: 
//             [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3] 
//
// Example 3: 
//
// 
//Input: nums1 = [1,2], nums2 = [3], k = 3
//Output: [1,3],[2,3]
//Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
// 
// Related Topics Heap


package com.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums{
    public static void main(String[] args) {
       Solution solution = new FindKPairsWithSmallestSums().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //法一: 放入了所有元素, 最后输出topK
    //改用int[]比list快一倍49ms -> 22ms 空间也小了一倍多 91.4MB -> 49MB
    /*public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        //PriorityQueue<List<Integer>> q = new PriorityQueue<>((a, b) ->a.get(0) + a.get(1) - b.get(0) - b.get(1));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
        int i = 0, j = 0;
        while (i < nums1.length){
            while (j < nums2.length){
                pq.offer(new int[]{nums1[i], nums2[j]});
                //q.offer(Arrays.asList(nums1[i], nums2[j]));
                j++;
            }
            i++;
            j = 0;
        }
        while (!q.isEmpty() && k-- > 0){
            int[] cur = pq.poll();
            res.add(Arrays.asList(cur[0], cur[1]));
            //res.add(q.poll());
        }
        return res;
    }*/

    //法二 O(KlogK) 因为数组有序, 参考距离原点最近, 维护topK
    /* merge K sorted list -> Add the head of the list into the heap and when a node is poll(), we just add the node.next.
    nums1(1, 7, 11, 16) nums2(2, 9, 10, 15) k = 3
    (1,2) -> (1,9) -> (1,10) -> (1,15)
    (7,2) -> (7,9) -> (7,10) -> (7,15)
    (11,2) -> (11,9) -> (11,10) -> (11,15)
    (16,2) -> (16,9) -> (16,10) -> (16,15)
    */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
        if(nums1.length == 0 || nums2.length == 0 || k == 0) return res;

        //放入topK元素, 数组1所有+数组2最小元素
        for(int i = 0; i < nums1.length && i < k; i++){
            //数组1元素, 数组二元素, 数组二index
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        }

        //维护topK
        while (!pq.isEmpty() && k-- > 0){
            int[] cur = pq.poll();
            res.add(Arrays.asList(cur[0], cur[1]));
            if(cur[2] == nums2.length - 1) continue;
            //when a node is poll(), add the node.next.
            pq.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}