package dataStructureAndAlgorithm.graph;

import algs4.Bag;
import algs4.In;

import java.rmi.activation.ActivationGroup_Stub;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author hzk
 * 图的顶点叫什么名字不重要，一般使用0至V-1来表示一张含有V个顶点的图中的各个顶点，这样约定是为了访问数组的索引来高效访问各个顶点。
 * 可以用一张符号表来为各个顶点的名字和0到V-1建立一一对应关系
 */
public class Graph {
    //这里没有初始化就必须在每一个构造函数里初始化
    private int V;
    private int E;
    private List<Integer>[] adj;
    public Graph(int V) {
       /* if (V < 0) {
            throw new IllegalArgumentException("Number of vertices must be nonnegative");
        }*/
        this.V = V;
        this.E = 0;
        adj = (List<Integer>[]) new List[V];
        for (int v = 0; v < V; V++) {
            adj[v] = new ArrayList<>();
        }
    }
    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }

    public Graph(In in) {
        if (in == null) {
            throw new IllegalArgumentException("参数为空");
        }
        try {
            this.V = in.readInt();
            if (V < 0) {
                throw new IllegalArgumentException("输入的顶点数必须为正数");
            }
            adj = (List<Integer>[]) new List[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new ArrayList<>();
            }
            int E = in.readInt();
            if (E < 0) {
                throw new IllegalArgumentException("边的数目不能为负数");
            }
            for (int i = 0; i < E; i++) {
                int v = in.readInt();
                int w = in.readInt();
                addEdge(v, w);
            }
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("输入了无效的数据格式");
        }
    }

    public boolean validateVertex(int v) {
        if (v < 0 || v > V - 1) {
            throw new IllegalArgumentException("顶点" + v + "不在0到" + V + "-1的范围");
        }
        return true;
    }
    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }
    public Iterable<Integer> adj(int v){
        validateVertex(v);
        return adj[v];
    }
}
