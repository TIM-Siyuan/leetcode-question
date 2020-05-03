//Equations are given in the format A / B = k, where A and B are variables repre
//sented as strings, and k is a real number (floating point number). Given some qu
//eries, return the answers. If the answer does not exist, return -1.0. 
//
// Example: 
//Given a / b = 2.0, b / c = 3.0. 
//queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? . 
//return [6.0, 0.5, -1.0, 1.0, -1.0 ]. 
//
// The input is: vector<pair<string, string>> equations, vector<double>& values,
// vector<pair<string, string>> queries , where equations.size() == values.size(),
// and the values are positive. This represents the equations. Return vector<doubl
//e>. 
//
// According to the example above: 
//
// 
//equations = [ ["a", "b"], ["b", "c"] ],
//values = [2.0, 3.0],
//queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
//
// 
//
// The input is always valid. You may assume that evaluating the queries will re
//sult in no division by zero and there is no contradiction. 
// Related Topics Union Find Graph


package com.leetcode.editor.en;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class EvaluateDivision{
    public static void main(String[] args) {
       Solution solution = new EvaluateDivision().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // parents["a"] = {"b", 2.0} -> a = 2.0 * b;
        // parents["b"] = {"c", 3.0} -> b = 3.0 * c;
        UF uf = new UF();
        for(int i = 0; i < values.length; i++){
            uf.union(equations.get(i).get(0), equations.get(i).get(1), values[i]);
        }
        double[] res = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++){
            res[i] = uf.get(queries.get(i).get(0), queries.get(i).get(1));
        }
        return res;
    }

    class UF{
        // Stores relation between two variables
        HashMap<String, String> p;
        // Stores the value of the relation
        HashMap<String, Double> r;
        UF(){
            p = new HashMap<>();
            r = new HashMap<>();
        }

        String find(String a){
            if(!p.containsKey(a)){
                p.put(a, a);
                r.put(a, 1.0);
                return a;
            }
            double val = r.get(a);
            String parent = a;
            while (p.get(parent) != parent){
                parent = p.get(parent);
                val *= r.get(parent);
            }
            p.put(a, parent);
            r.put(a, val);
            return parent;
        }

        void union(String a, String b, double v){
            String p1 = find(a);
            String p2 = find(b);
            if(p1 == p2) return;

            double r1 = r.get(a);
            double r2 = r.get(b);
            p.put(p2, p1);
            // a / b = 2.0 -> b = a /
            r.put(p2, r1 / r2 * v);
        }

        //判断, 得到结果
        double get(String a, String b){
            if(!p.containsKey(a) || !p.containsKey(b)){
                return -1.0;
            }
            String p1 = find(a);
            String p2 = find(b);
            if(p1 != p2) return -1.0;
            // p1 = a/b = 2
            // p2 = a/c = 6
            // p2/p1 = b/c = 6/2
            return r.get(b) / r.get(a);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}