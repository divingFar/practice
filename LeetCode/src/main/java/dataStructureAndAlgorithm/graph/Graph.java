package dataStructureAndAlgorithm.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hzk
 * 图的顶点叫什么名字不重要，一般使用0至V-1来表示一张含有V个顶点的图中的各个顶点，这样约定是为了访问数组的索引来高效访问各个顶点。
 * 可以用一张符号表来为各个顶点的名字和0到V-1建立一一对应关系
 */
public class Graph {
    private final int V;
    private int E;
    private List<Integer>[] adj;

    public Graph(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
        this.V = V;
        this.E = 0;
        adj = (List<Integer>[]) new List[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<>();
        }
    }


}
