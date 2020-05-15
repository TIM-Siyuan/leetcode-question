//You are playing the following Nim Game with your friend: There is a heap of st
//ones on the table, each time one of you take turns to remove 1 to 3 stones. The 
//one who removes the last stone will be the winner. You will take the first turn 
//to remove the stones. 
//
// Both of you are very clever and have optimal strategies for the game. Write a
// function to determine whether you can win the game given the number of stones i
//n the heap. 
//
// Example: 
//
// 
//Input: 4
//Output: false 
//Explanation: If there are 4 stones in the heap, then you will never win the ga
//me;
//             No matter 1, 2, or 3 stones you remove, the last stone will alway
//s be 
//             removed by your friend. Related Topics Brainteaser Minimax


package com.leetcode.editor.en;

public class NimGame{
    public static void main(String[] args) {
       Solution solution = new NimGame().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}