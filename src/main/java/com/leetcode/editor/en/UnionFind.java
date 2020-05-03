package com.leetcode.editor.en;

public class UnionFind {
    private int count;
    // 节点 x 的父节点是 parent[x]
    private int[] parent;
    // 记录树的“重量”
    private int[] size;

    /* 构造函数，n 为图的节点总数 */
    public UnionFind(int n){
        // 一开始互不连通
        this.count = n;
        // 父节点指针初始指向自己
        parent = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public void union(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ) return;

        // 小树接到大树下面，较平衡
        if(size[rootP] > size[rootQ]){
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }

        count--; //两个分量合二为一
    }

    public boolean connected(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    //找根
    private int find(int x){
        // 当没有自环, 说明没找到根, 继续循环
        while (parent[x] != x){
            //路径压缩 parent[x] == x
            //x从指向父节点 改为 x指向祖先节点 -> 将子节点接到祖先节点
            parent[x] = parent[parent[x]];
            //x等于其父节点 == x向上爬
            x = parent[x];
        }
        return x;
    }

    /* 返回当前的连通分量个数 */
    public int count(){
        return count;
    }
}
