//Implement the following operations of a queue using stacks. 
//
// 
// push(x) -- Push element x to the back of queue. 
// pop() -- Removes the element from in front of queue. 
// peek() -- Get the front element. 
// empty() -- Return whether the queue is empty. 
// 
//
// Example: 
//
// 
//MyQueue queue = new MyQueue();
//
//queue.push(1);
//queue.push(2);  
//queue.peek();  // returns 1
//queue.pop();   // returns 1
//queue.empty(); // returns false 
//
// Notes: 
//
// 
// You must use only standard operations of a stack -- which means only push to 
//top, peek/pop from top, size, and is empty operations are valid. 
// Depending on your language, stack may not be supported natively. You may simu
//late a stack by using a list or deque (double-ended queue), as long as you use o
//nly standard operations of a stack. 
// You may assume that all operations are valid (for example, no pop or peek ope
//rations will be called on an empty queue). 
// 
// Related Topics Stack Design


package com.leetcode.editor.en;

import java.util.Stack;

public class ImplementQueueUsingStacks{
    public static void main(String[] args) {
//       Solution solution = new ImplementQueueUsingStacks().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class MyQueue {
    Stack<Integer> stk1 = new Stack<Integer>();
    Stack<Integer> stk2 = new Stack<Integer>();
    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stk1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!stk1.isEmpty()){
            stk2.push(stk1.pop());
        }
        int temp = stk2.pop();
        while (!stk2.isEmpty()){
            stk1.push(stk2.pop());
        }
        return temp;
    }
    
    /** Get the front element. */
    public int peek() {
        while (!stk1.isEmpty()){
            stk2.push(stk1.pop());
        }
        int temp = stk2.peek();
        while (!stk2.isEmpty()){
            stk1.push(stk2.pop());
        }
        return temp;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stk1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)


}