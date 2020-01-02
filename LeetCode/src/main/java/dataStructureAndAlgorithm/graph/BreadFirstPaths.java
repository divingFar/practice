package dataStructureAndAlgorithm.graph;

import algs4.Queue;

import java.rmi.MarshalException;
import java.util.LinkedList;

/**
 * @author hzk
 */
public class BreadFirstPaths {
    //到达该顶点的最短路径已知吗
    private boolean[] marked;
    //到达该顶点的已知路径上的最后一个顶点
    private int[] edgeTo;
    //起点
    private int s;

    public BreadFirstPaths(Graph G, int s) {
        marked = new boolean[G.getV()];
        edgeTo = new int[G.getV()];
        this.s = s;
        bfs(G, s);
    }

    /**
     *
     * @param G
     * @param s 图的顶点
     */
    public void bfs(Graph G, int s) {
        Queue<Integer> queue = new Queue<Integer>();
        marked[s] = true;
        queue.enqueue(s);
        while (!queue.isEmpty()) {
            int v = queue.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[v]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.enqueue(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        return null;
    }
}