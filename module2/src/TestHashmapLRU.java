import java.util.LinkedHashMap;
import java.util.Map;

public class TestHashmapLRU {
    public static void main(String[] args) {
        lruCache < Integer, String > cache = new lruCache < > (2);
        cache.put(1, "a");
        cache.put(2, "b");
        cache.put(3, "c");
        System.out.println(cache.keySet());
    }
}
class lruCache<K,V> extends LinkedHashMap<K,V>{
    private int capacity;
    public lruCache(int capacity){
        super(capacity,0.75f,true);
        this.capacity = capacity;
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest){
        return size()>capacity;
    }
}
