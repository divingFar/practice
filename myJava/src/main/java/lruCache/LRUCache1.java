package lruCache;


import java.util.*;

public class LRUCache1 {

    private HashMap<Integer, Node> map;

    private LinkedList<Node> cache;
    // 最⼤容量
    private int cap;

    public LRUCache1(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new LinkedList<>();
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        int val = map.get(key).val;
        // 利⽤put⽅法把该数据提前
        put(key, val);
        return val;
    }

    public void put(int key, int val) {
        // 先把新节点 x 做出来
        Node node = new Node(key, val);
        if (map.containsKey(key)) {
            // 删除旧的节点， 新的插到头部
            cache.remove(map.get(key));
        } else {
            if (cap == cache.size()) {
                // 删除链表最后⼀个数据
                Node tail = cache.removeLast();
                map.remove(tail.key);
            }
        }
        cache.addFirst(node);
        map.put(key, node);
    }

    public static void main(String[] args) {
//        LRUCache1 lruCache1 = new LRUCache1(3);
//        lruCache1.put(1,10);
//        lruCache1.put(2,20);
//        lruCache1.put(3,30);
//        lruCache1.put(4,40);
//        lruCache1.put(5,50);
//        lruCache1.get(4);
//        LinkedList<Node> cache = lruCache1.cache;
//        Iterator<Node> iterator = cache.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next().val);
//        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(5);
        for (int i = 1; i < 10; i++) {
            queue.offer(i);
            if (queue.size() > 5) {
                queue.poll();
            }
        }
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}