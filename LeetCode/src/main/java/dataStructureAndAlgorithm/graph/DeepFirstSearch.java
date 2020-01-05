package dataStructureAndAlgorithm.graph;

import algs4.WeightedQuickUnionUF;

/**
 * @author hzk
 */
public class DeepFirstSearch {
    private boolean[] marked;
    /**
     * count 已将访问的边的数目
     */
    private int count;

    public DeepFirstSearch(Graph G, int s) {
        marked = new boolean[G.getV()];
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        count++;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public boolean[] getMarked() {
        return marked;
    }

    public int getCount() {
        return count;
    }
}
