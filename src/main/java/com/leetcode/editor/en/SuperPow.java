//Your task is to calculate ab mod 1337 where a is a positive integer and b is a
//n extremely large positive integer given in the form of an array. 
//
// Example 1: 
//
// 
// 
//Input: a = 2, b = [3]
//Output: 8
// 
//
// 
// Example 2: 
//
// 
//Input: a = 2, b = [1,0]
//Output: 1024
// 
// 
// Related Topics Math


package com.leetcode.editor.en;

public class SuperPow{
    public static void main(String[] args) {
       Solution solution = new SuperPow().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int base = 1337;
    public int superPow(int a, int[] b) {
        return superPowerSub(a, b, b.length - 1);
    }

    private int superPowerSub(int a, int[] b, int index){
        if(index == 0) return myPow(a, b[index]) % base;
        int pre = superPowerSub(a, b, index - 1);
        return (myPow(pre, 10) * myPow(a, b[index])) % base;
    }

//    //计算n的k次方的结果
//    private int myPow(int n, int k){
//        // 对因子求模
//        n %= base;
//        int res = 1;
//        for(int i = 0; i < k; i++){
//            res *= n;
//            // 对乘法结果求模
//            res %= base;
//        }
//        return res;
//    }

    // (a * b) % k = (a % k)(b % k) % k
    private int myPow(int n, int k){
        if(k == 0) return 1;
        n %= base;
        //k为奇数
        if(k % 2 == 1){
            return (n * myPow(n, k - 1)) % base;
        }
        else {
            int sub = myPow(n, k / 2);
            return (sub * sub) % base;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)


}