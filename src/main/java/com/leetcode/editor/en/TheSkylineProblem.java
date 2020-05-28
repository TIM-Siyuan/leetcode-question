//A city's skyline is the outer contour of the silhouette formed by all the buil
//dings in that city when viewed from a distance. Now suppose you are given the lo
//cations and height of all the buildings as shown on a cityscape photo (Figure A)
//, write a program to output the skyline formed by these buildings collectively (
//Figure B). 
// 
//
// The geometric information of each building is represented by a triplet of int
//egers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left and right 
//edge of the ith building, respectively, and Hi is its height. It is guaranteed t
//hat 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You may assume all 
//buildings are perfect rectangles grounded on an absolutely flat surface at heigh
//t 0. 
//
// For instance, the dimensions of all buildings in Figure A are recorded as: [ 
//[2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] . 
//
// The output is a list of "key points" (red dots in Figure B) in the format of 
//[ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key poin
//t is the left endpoint of a horizontal line segment. Note that the last key poin
//t, where the rightmost building ends, is merely used to mark the termination of 
//the skyline, and always has zero height. Also, the ground in between any two adj
//acent buildings should be considered part of the skyline contour. 
//
// For instance, the skyline in Figure B should be represented as:[ [2 10], [3 1
//5], [7 12], [12 0], [15 10], [20 8], [24, 0] ]. 
//
// Notes: 
//
// 
// The number of buildings in any input list is guaranteed to be in the range [0
//, 10000]. 
// The input list is already sorted in ascending order by the left x position Li
//. 
// The output list must be sorted by the x position. 
// There must be no consecutive horizontal lines of equal height in the output s
//kyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not accepta
//ble; the three lines of height 5 should be merged into one in the final output a
//s such: [...[2 3], [4 5], [12 7], ...] 
// 
// Related Topics Divide and Conquer Heap Binary Indexed Tree Segment Tree Line 
//Sweep


package com.leetcode.editor.en;

import java.util.*;

public class TheSkylineProblem{
    public static void main(String[] args) {
       Solution solution = new TheSkylineProblem().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //扫描线: 有高度差必有垂直点 -> 进入时扫描高的 / 离开时扫描第二高
    //维护一个maxHeight, 顶端为当前高点, 遇到低点假如更高的为离开, 即顶端存在则忽略; 遇到高点则加入重新排;
    //Two special cases: x轴相等时, 进入的时候高先扫, 离开的时候低先扫
/*    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> buildLines = new ArrayList<>();
        //初始化左右高度, 左边的高度值设为负值以便确定是进入还是离开 (Li, Ri) O(m * klgk)
        for(int[] points : buildings){
            buildLines.add(new int[]{points[0], -points[2]});
            buildLines.add(new int[]{points[1], points[2]});
        }
        //按x轴排序
        Collections.sort(buildLines, (a, b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            //特判的两种情况, x轴相等, 因为进入时高度为负, 离开时高度为正, 所以小的先扫
            else return a[1] - b[1];
        });
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.add(0);
        int preHighest = 0;
        for(int[] points : buildLines){
            if(points[1] < 0){
                //维护进入时的最大高度, 确保进入时顶端为最高值
                maxHeap.add(-points[1]);
            }
            else {
                //离开时去除当前最高值, 且第二大值变为当前最大值, 即离开时扫描第二高点
                maxHeap.remove(points[1]);
            }
            int curHeight = maxHeap.peek();
            //不相等说明有高度差, overlap的部分在heap中已经被处理, 加入最高点还存在未离开, 进入了下一个柱maxHeight不改变
            if(curHeight != preHighest){
                res.add(Arrays.asList(points[0], curHeight));
                preHighest = curHeight;
            }
        }
        return res;
    }*/

    //PQ remove的复杂度为O(n), TreeMap降为O(lgN); happygirlzt
    public List<List<Integer>> getSkyline(int[][] buildings) {
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        for(int[] b : buildings){
            map.putIfAbsent(b[0], new ArrayList<>());
            map.putIfAbsent(b[1], new ArrayList<>());
            map.get(b[0]).add(b);
            map.get(b[1]).add(b);
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        List<List<Integer>> res = new ArrayList<>();
        for(int a : map.keySet()){
            List<int[]> bs = map.get(a);

            for(int[] b : bs){
                if(b[0] == a){
                    maxHeap.offer(b);
                }
                else {
                    maxHeap.remove(b);
                }
            }
            if(maxHeap.size() == 0){
                List<Integer> tmp = new ArrayList<>();
                tmp.add(a);
                tmp.add(0);
                res.add(tmp);
            }else {
                int maxHeight = maxHeap.peek()[2];
                if(res.size() == 0 || res.get(res.size() - 1).get(1) != maxHeight){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(a);
                    tmp.add(maxHeight);
                    res.add(tmp);
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}