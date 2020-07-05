//Given an Iterator class interface with methods: next() and hasNext(), design a
//nd implement a PeekingIterator that support the peek() operation -- it essential
//ly peek() at the element that will be returned by the next call to next(). 
//
// Example: 
//
// 
//Assume that the iterator is initialized to the beginning of the list: [1,2,3].
//
//
//Call next() gets you 1, the first element in the list.
//Now you call peek() and it returns 2, the next element. Calling next() after t
//hat still return 2. 
//You call next() the final time and it returns 3, the last element. 
//Calling hasNext() after that should return false.
// 
//
// Follow up: How would you extend your design to be generic and work with all t
//ypes, not just integer? 
// Related Topics Design 
// 👍 477 👎 366


package com.leetcode.editor.en;

import java.util.Iterator;

//public class PeekingIterator{
//    public static void main(String[] args) {
//       //Solution solution = new PeekingIterator().new Solution();
//
//    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
	private Integer next;
	private Iterator<Integer> itr;
	private boolean end = false;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
		itr = iterator;
	    if(iterator.hasNext()){
	    	next = itr.next();
		} else {
	    	end = true;
		}
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer res = next;
	    if(itr.hasNext()){
	    	next = itr.next();
		}else{
	    	next = null;
	    	end = true;
		}
	    return res;
	}
	
	@Override
	public boolean hasNext() {
	    return !end;
	}
}
//leetcode submit region end(Prohibit modification and deletion)


//}