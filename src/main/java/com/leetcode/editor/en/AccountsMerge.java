//Given a list accounts, each element accounts[i] is a list of strings, where th
//e first element accounts[i][0] is a name, and the rest of the elements are email
//s representing emails of the account. 
//
// Now, we would like to merge these accounts. Two accounts definitely belong to
// the same person if there is some email that is common to both accounts. Note th
//at even if two accounts have the same name, they may belong to different people 
//as people could have the same name. A person can have any number of accounts ini
//tially, but all of their accounts definitely have the same name. 
//
// After merging the accounts, return the accounts in the following format: the 
//first element of each account is the name, and the rest of the elements are emai
//ls in sorted order. The accounts themselves can be returned in any order. 
//
// Example 1: 
// 
//Input: 
//accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnn
//ybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Ma
//ry", "mary@mail.com"]]
//Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.
//com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
//Explanation: 
//The first and third John's are the same person as they have the common email "
//johnsmith@mail.com".
//The second John and Mary are different people as none of their email addresses
// are used by other accounts.
//We could return these lists in any order, for example the answer [['Mary', 'ma
//ry@mail.com'], ['John', 'johnnybravo@mail.com'], 
//['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] wo
//uld still be accepted.
// 
// 
//
// Note:
// The length of accounts will be in the range [1, 1000]. 
// The length of accounts[i] will be in the range [1, 10]. 
// The length of accounts[i][j] will be in the range [1, 30]. 
// Related Topics Depth-first Search Union Find


package com.leetcode.editor.en;

import java.util.*;

public class AccountsMerge{
    public static void main(String[] args) {
       Solution solution = new AccountsMerge().new Solution();
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //法一: buildGraph + DFS 输出路径
    //原始想法: 新建一个Map<Name, Email List>遍历 ——> name相同则一一比对邮件list
    //问题: 比对邮件list复杂度高/ 读取list效率低/ name不唯一, 即key不唯一 ——> email做key / 建立两个Map
    /*public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        if(accounts == null || accounts.size() == 0) return res;
        //email, name
        HashMap<String, String> emailToName = new HashMap<>();
        //email, neighbor
        HashMap<String, Set<String>> graph = new HashMap<>();
        //放入所有email, 方便后续dfs遍历
        Set<String> emails = new HashSet<>();
        //String不是int, 用Set比用boolean方便
        Set<String> visited = new HashSet<>();
        for(List<String> list : accounts){
            String name = list.get(0);
            for(int i = 1; i < list.size(); i++){
                String email = list.get(i);
                emails.add(email);
                emailToName.put(email, name);
                graph.putIfAbsent(email, new HashSet<>());
                //无邻居无需加入
                if(i == 1) continue;
                //无向图, 邻居不包括自己; 加入包括自己visited会筛选但是浪费空间
                graph.get(email).add(list.get(i - 1));
                graph.get(list.get(i - 1)).add(email);
            }
        }
        //遍历graph
        for(String e : emails){
            if(!visited.contains(e)){
                visited.add(e);
                List<String> tmp = new ArrayList<>();
                tmp.add(e);
                //dfs取得所有相关联的emails
                dfs(e, tmp, graph, visited);
                Collections.sort(tmp); //sort
                tmp.add(0, emailToName.get(e));
                res.add(tmp);
            }
        }
        return res;
    }

    private void dfs(String email, List<String> tmp, HashMap<String, Set<String>> graph, Set<String> visited){
        //没有邻居的直接返回
        if(!graph.containsKey(email)){
            return;
        }
        //HashMap的key可以为空返回null, 不进入循环, 所以无需上面返回也可运行; 假如value为空则返回空指针错误
        for(String nei : graph.get(email)){
            if(!visited.contains(nei)){
                visited.add(nei);
                tmp.add(nei);
                dfs(nei, tmp, graph, visited);
            }
        }
    }*/


    /**
     * Solution: Union Find
     *
     * Use two hash map with union find class to solve the problem
     * @params mailToIndex: one to one mapping: mail string to its parent index mapping
     * @params disjointSet: one to many mapping: parent index to all emails that belong to same group mapping
     * */
    class UnionFind{
        int[] size;
        int[] parent;
        public UnionFind(int n){
            size = new int[n];
            parent = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY) return;
            if(size[rootX] > size[rootY]) {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
            else {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            }
        }

        public int find(int x){
            while (parent[x] != x){
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts){
        int n = accounts.size();
        UnionFind uf = new UnionFind(n);

        // emailToName
        // Step 1: traverse all emails except names, if we have not seen an email before, put it with its index into map.
        // Otherwise, union the email to its parent index.
        Map<String, Integer> mailToIndex = new HashMap<>();
        for(int i = 0; i < n; i++){
            for(int j = 1; j < accounts.get(i).size(); j++){
                String email = accounts.get(i).get(j);
                if(mailToIndex.containsKey(email)){
                    int preIndex = mailToIndex.get(email);
                    //连接
                    uf.union(preIndex, i);
                }
                else {
                    mailToIndex.put(email, i);
                }
            }
        }

        // graph
        // Step 2: traverse every email list, find the parent of current list index and put all emails into the set list
        // that belongs to key of its parent index
        Map<Integer, Set<String>> disjointSet = new HashMap<>();
        for(int i = 0; i < n; i++){
            // find parent index of current list index in parent array
            int parentIndex = uf.find(i);
            disjointSet.putIfAbsent(parentIndex, new HashSet<>());
            Set<String> curSet = disjointSet.get(parentIndex);
            for(int j = 1; j < accounts.get(i).size(); j++){
                curSet.add(accounts.get(i).get(j));
            }
            disjointSet.put(parentIndex, curSet);
        }

        // output
        // step 3: traverse ket set of disjoint set group, retrieve all emails from each parent index, and then SORT
        // them, as well as adding the name at index 0 of every sublist
        List<List<String>> res = new ArrayList<>();
        for(int index : disjointSet.keySet()){
            List<String> emails = new ArrayList<>();
            if(disjointSet.containsKey(index)){
                emails.addAll(disjointSet.get(index));
            }
            Collections.sort(emails);
            emails.add(0, accounts.get(index).get(0));
            res.add(emails);
        }
        return res;
    }

    //UnionFind 2
    /*public List<List<String>> accountsMerge(List<List<String>> accounts){
        List<List<String>> res = new ArrayList<>();
        HashMap<String, String> emailToName = new HashMap<>();
        HashMap<String, String> parent = new HashMap<>();
        HashMap<String, Set<String>> unions = new HashMap<>();
        //build
        for(List<String> a : accounts){
            String name = a.get(0);
            for(int i = 1; i < a.size(); i++){
                String email = a.get(i);
                emailToName.put(email, name);
                parent.put(email, email);
            }
        }
        //union
        for(List<String> a : accounts){
            String email = find(a.get(1), parent);
            for(int i = 2; i < a.size(); i++){
                parent.put(find(a.get(i), parent), email);
            }
        }

        for(List<String> a : accounts){
            String email = find(a.get(1), parent);
            unions.putIfAbsent(email, new TreeSet<>());
            for(int i = 1; i < a.size(); i++){
                unions.get(email).add(a.get(i));
            }
        }

        //output
        for(String email : unions.keySet()){
            List<String> emails = new ArrayList<>(unions.get(email));
            emails.add(0, emailToName.get(email));
            res.add(emails);
        }
        return res;
    }

    private String find(String s, HashMap<String, String> parent){
        return parent.get(s) == s ? s : find(parent.get(s), parent);
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)


}