//Design a stack that supports push, pop, top, and retrieving the minimum elemen
//t in constant time. 
//
// 
// push(x) -- Push element x onto stack. 
// pop() -- Removes the element on top of the stack. 
// top() -- Get the top element. 
// getMin() -- Retrieve the minimum element in the stack. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//Output
//[null,null,null,null,-3,null,0,-2]
//
//Explanation
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin(); // return -3
//minStack.pop();
//minStack.top();    // return 0
//minStack.getMin(); // return -2
// 
//
// 
// Constraints: 
//
// 
// Methods pop, top and getMin operations will always be called on non-empty sta
//cks. 
// 
// Related Topics Stack Design


package com.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

/*public class MinStack{
    public static void main(String[] args) {
       Solution solution = new MinStack().new Solution();
       
    }*/
   /* 1. ArrayList<int[]>
    2. PriorityQueue + Stack
    3. Stack + Stack
    4. Stack*/
    //leetcode submit region begin(Prohibit modification and deletion)
class MinStack {
    private List<int[]> s;
    private int min;
    /** initialize your data structure here. */
    public MinStack() {
        s = new ArrayList<int[]>();
    }
    
    public void push(int x) {
        int[] arr = new int[2];
        arr[0] = x;
        arr[1] = s.isEmpty() ? x : Math.min(x, min);
        min = arr[1];
        s.add(arr);
    }
    
    public void pop() {
        if(!s.isEmpty()){
            s.remove(s.size() - 1);
            min = s.isEmpty() ? 0 : s.get(s.size() - 1)[1];
        }
    }
    
    public int top() {
        return s.get(s.size() - 1)[0];
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)
//}