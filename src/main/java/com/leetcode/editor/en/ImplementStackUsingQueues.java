//Implement the following operations of a stack using queues. 
//
// 
// push(x) -- Push element x onto stack. 
// pop() -- Removes the element on top of the stack. 
// top() -- Get the top element. 
// empty() -- Return whether the stack is empty. 
// 
//
// Example: 
//
// 
//MyStack stack = new MyStack();
//
//stack.push(1);
//stack.push(2);  
//stack.top();   // returns 2
//stack.pop();   // returns 2
//stack.empty(); // returns false 
//
// Notes: 
//
// 
// You must use only standard operations of a queue -- which means only push to 
//back, peek/pop from front, size, and is empty operations are valid. 
// Depending on your language, queue may not be supported natively. You may simu
//late a queue by using a list or deque (double-ended queue), as long as you use o
//nly standard operations of a queue. 
// You may assume that all operations are valid (for example, no pop or top oper
//ations will be called on an empty stack). 
// 
// Related Topics Stack Design


package com.leetcode.editor.en;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues{
    public static void main(String[] args) {
//       Solution solution = new ImplementStackUsingQueues().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class MyStack {
    Queue<Integer> q = new LinkedList<>();

    /** Initialize your data structure here. */
    public MyStack() {}
    
    /** Push element x onto stack. */
    public void push(int x) {
        q.add(x);
        for(int i = 0; i < q.size() - 1; i++){
            q.add(q.peek());
            q.poll();
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return q.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)


}