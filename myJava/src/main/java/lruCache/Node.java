package lruCache;

public class Node {
    public int key, val;
    public Node next, prev;

    /**
     *
     * @param k
     * @param v
     * 当缓存容量已满时，我们不仅仅要删除最后一个Node结点，还要把map中映射到该结点的key删除，这个key只能由Node得到
     */
    public Node(int k, int v) {
        this.key = k;
        this.val = v;
    }
}
