package past.Houzz;

import java.util.LinkedHashMap;

public class LRU {
    LinkedHashMap<Integer, Integer> map;
    int cap;
    public LRU(int capacity) {
        map = new LinkedHashMap<Integer, Integer>(10, (float) 0.75, true);
        cap = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int r = map.get(key);
            return r;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (cap <= 0) return;
        if (map.containsKey(key)) {
            map.put(key, value);
        } else {
            if (map.size() >= cap) {
                map.remove(map.entrySet().iterator().next().getKey());
            }
            map.put(key, value);
        }
    }
}
