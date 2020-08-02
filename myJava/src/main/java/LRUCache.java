import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class LRUCache<K, V> extends LinkedHashMap {
    private int maxEntries;

    public LRUCache(int initialCapacity, float loadFactor, int maxEntries) {
        super(initialCapacity, loadFactor);
        this.maxEntries = maxEntries;

    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > maxEntries;
    }
}
