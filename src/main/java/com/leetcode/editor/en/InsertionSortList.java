//Sort a linked list using insertion sort. 
//
// 
// 
//
// 
//A graphical example of insertion sort. The partial sorted list (black) initial
//ly contains only the first element in the list. 
//With each iteration one element (red) is removed from the input data and inser
//ted in-place into the sorted list 
// 
//
// 
// 
//
// Algorithm of Insertion Sort: 
//
// 
// Insertion sort iterates, consuming one input element each repetition, and gro
//wing a sorted output list. 
// At each iteration, insertion sort removes one element from the input data, fi
//nds the location it belongs within the sorted list, and inserts it there. 
// It repeats until no input elements remain. 
// 
//
// 
//Example 1: 
//
// 
//Input: 4->2->1->3
//Output: 1->2->3->4
// 
//
// Example 2: 
//
// 
//Input: -1->5->3->4->0
//Output: -1->0->3->4->5
// 
// Related Topics Linked List Sort


package com.leetcode.editor.en;

public class InsertionSortList{
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static void main(String[] args) {
       Solution solution = new InsertionSortList().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return null;
        //新建链, 新建一个point节点指向这条链, 相当于两个头节点, 通过一个头节点point进行链表操作, 这样链表操作完毕后, 还可以获取得到链表的头节点dummy.next
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode point = dummy;
        while (head != null){
            //因为新建的链是有序的, 所以假如新建链最大值都小于待插入的值, 则不需要从头扫描, 可直接继续插入; 只有待插入值处于新建链之间才需要从头扫描
            if(point.val > head.val)
                point = dummy;
            //因为新建链头是dummy, 从dummy.next开始, 寻找到需要插入的节点位置
            while (point.next != null && point.next.val <= head.val){
                point = point.next;
            }
            //暂存原链的next节点, 因为原链的此节点将插入到新链, 会失去与原链的联系
            ListNode node = head.next;
            //插入
            head.next = point.next;
            point.next = head;
            //继续遍历
            head = node;
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}