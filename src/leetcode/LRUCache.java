package leetcode;

import java.util.LinkedHashMap;

public class LRUCache {
    LinkedHashMap<Integer, Integer> map;
    int cap;
    public LRUCache(int capacity) {
        map = new LinkedHashMap<>();
        cap = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int r = map.get(key);
            map.remove(key);
            map.put(key, r);
            return r;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (cap <= 0) return;
        if (map.size() >= cap) {
            map.remove(map.entrySet().iterator().next().getKey());
        }
        map.put(key, value);
    }
}
