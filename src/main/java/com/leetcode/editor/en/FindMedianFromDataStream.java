//Median is the middle value in an ordered integer list. If the size of the list
// is even, there is no middle value. So the median is the mean of the two middle 
//value. 
//For example,
//
// [2,3,4], the median is 3 
//
// [2,3], the median is (2 + 3) / 2 = 2.5 
//
// Design a data structure that supports the following two operations: 
//
// 
// void addNum(int num) - Add a integer number from the data stream to the data 
//structure. 
// double findMedian() - Return the median of all elements so far. 
// 
//
// 
//
// Example: 
//
// 
//addNum(1)
//addNum(2)
//findMedian() -> 1.5
//addNum(3) 
//findMedian() -> 2
// 
//
// 
//
// Follow up: 
//
// 
// If all integer numbers from the stream are between 0 and 100, how would you o
//ptimize it? 
// If 99% of all integer numbers from the stream are between 0 and 100, how woul
//d you optimize it? 
// 
// Related Topics Heap Design


package com.leetcode.editor.en;

import java.util.PriorityQueue;

public class FindMedianFromDataStream{
    public static void main(String[] args) {
       //Solution solution = new FindMedianFromDataStream().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class MedianFinder {
    //如果数字很多, 排序效率慢 -> 参考二分思路 -> 设立 maxHeap/ minHeap 求中位数
    /** initialize your data structure here. */
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>((a, b) -> a - b);
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || num < maxHeap.peek()){
            maxHeap.add(num);
        }
        else {
            minHeap.add(num);
        }
        //始终维持maxHeap比minHeap size大一位; 这样中位始终在max上
        if(maxHeap.size() == minHeap.size() + 2){
            minHeap.add(maxHeap.poll());
        }
        if(minHeap.size() == maxHeap.size() + 1){
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(maxHeap.size() == minHeap.size()){
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        else {
            return maxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)


}