//You are playing the following Bulls and Cows game with your friend: You write 
//down a number and ask your friend to guess what the number is. Each time your fr
//iend makes a guess, you provide a hint that indicates how many digits in said gu
//ess match your secret number exactly in both digit and position (called "bulls")
// and how many digits match the secret number but locate in the wrong position (c
//alled "cows"). Your friend will use successive guesses and hints to eventually d
//erive the secret number. 
//
// Write a function to return a hint according to the secret number and friend's
// guess, use A to indicate the bulls and B to indicate the cows. 
//
// Please note that both secret number and friend's guess may contain duplicate 
//digits. 
//
// Example 1: 
//
// 
//Input: secret = "1807", guess = "7810"
//
//Output: "1A3B"
//
//Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7. 
//
// Example 2: 
//
// 
//Input: secret = "1123", guess = "0111"
//
//Output: "1A1B"
//
//Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
// 
//
// Note: You may assume that the secret number and your friend's guess only cont
//ain digits, and their lengths are always equal. Related Topics Hash Table


package com.leetcode.editor.en;

public class BullsAndCows{
    public static void main(String[] args) {
       Solution solution = new BullsAndCows().new Solution();
       solution.getHint("1122", "1222");
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //相等 -> 1. 数字位置一一对应
    //不相等 -> 1.位置错, 有正确数字对应  2. 位置错, 对应数字为多余数字(多余数也可能是正确数字)
    //example: s:"1122" g:"1222" 2是正确数字, 1st 2却是多余数字; 所以记录s正确数字个数, 判断是否是多余数字有误判
    /*public String getHint(String secret, String guess){
        if(secret == null || secret.length() == 0 || guess == null || guess.length() == 0) return "";
        int A = 0, B = 0, n = secret.length();
        int[] nums = new int[10];
        //先判断位置数字一一对应的, 并记录s中出现的位置却没对上的
        for(int i = 0; i < n; i++){
            if(secret.charAt(i) == guess.charAt(i)) A++;
            else nums[secret.charAt(i) - '0']++;
        }

        for(int j = 0; j < n; j++){
            //s中出现了, 如果g中也存在只是位置没对上则B++; 1. g需要判断是否存在这样的数字 / 2.需要判断是否是s中存在未判断的数字 两条件缺一不可
            if(secret.charAt(j) != guess.charAt(j) && nums[guess.charAt(j) - '0'] > 0){
                B++;
                nums[guess.charAt(j)]--;
            }
        }
        return new String(A + "A" + B + "B");
    }*/

    public String getHint(String secret, String guess) {
        if(secret == null || secret.length() == 0 || guess == null || guess.length() == 0) return "";
        int A = 0, B = 0, n = secret.length();
        int[] nums = new int[10];
        for(int j = 0; j < n; j++){
            int cs = secret.charAt(j) - '0';
            int cg = guess.charAt(j) - '0';
            if(cs == cg) A++;
            //不相等时不会立刻判错, 因为可能是属于多余数; 假如是多余数则后续A++, 假如是正数错位, 后续还会有不相等的因为正数个数是固定的, 前面多用了, 后续必然少了
            else{
                //s中出现的数字未对应上, 假如小于0说明g中之前出现了相同的数字, 满足两个条件
                if(nums[cs]++ < 0) B++;
                //g中出现的数字未对应上, 假如大于0说明s中之前出现了相同的数字, 满足两个条件
                if(nums[cg]-- > 0) B++;
            }
        }
        return new String(A + "A" + B + "B");
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}