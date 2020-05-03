//Given an array equations of strings that represent relationships between varia
//bles, each string equations[i] has length 4 and takes one of two different forms
//: "a==b" or "a!=b". Here, a and b are lowercase letters (not necessarily differe
//nt) that represent one-letter variable names. 
//
// Return true if and only if it is possible to assign integers to variable name
//s so as to satisfy all the given equations. 
//
// 
//
// 
// 
//
// 
// Example 1: 
//
// 
//Input: ["a==b","b!=a"]
//Output: false
//Explanation: If we assign say, a = 1 and b = 1, then the first equation is sat
//isfied, but not the second.  There is no way to assign the variables to satisfy 
//both equations.
// 
//
// 
// Example 2: 
//
// 
//Input: ["b==a","a==b"]
//Output: true
//Explanation: We could assign a = 1 and b = 1 to satisfy both equations.
// 
//
// 
// Example 3: 
//
// 
//Input: ["a==b","b==c","a==c"]
//Output: true
// 
//
// 
// Example 4: 
//
// 
//Input: ["a==b","b!=c","c==a"]
//Output: false
// 
//
// 
// Example 5: 
//
// 
//Input: ["c==c","b==d","x!=z"]
//Output: true
// 
//
// 
//
// Note: 
//
// 
// 1 <= equations.length <= 500 
// equations[i].length == 4 
// equations[i][0] and equations[i][3] are lowercase letters 
// equations[i][1] is either '=' or '!' 
// equations[i][2] is '=' 
// 
// 
// 
// 
// 
// 
// Related Topics Union Find Graph


package com.leetcode.editor.en;

public class SatisfiabilityOfEqualityEquations{
    public static void main(String[] args) {
       Solution solution = new SatisfiabilityOfEqualityEquations().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean equationsPossible(String[] equations) {
        //26个字母的空间
        UnionFind uf = new UnionFind(26);
        for(String eq : equations){
            if(eq.charAt(1) == '='){
                char x = eq.charAt(0);
                char y = eq.charAt(3);
                uf.union(x - 'a', y - 'a');
            }
        }

        for(String eq : equations){
            if(eq.charAt(1) == '!'){
                char x = eq.charAt(0);
                char y = eq.charAt(3);
                if(uf.connected(x - 'a', y - 'a'))
                    return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}