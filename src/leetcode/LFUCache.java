package leetcode;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {
    HashMap<Integer, Integer> values;
    HashMap<Integer, LinkedHashSet<Integer>> minFreq;
    HashMap<Integer, Integer> freq;
    int min;
    int cap;

    public LFUCache(int capacity) {
        values = new HashMap<>();
        minFreq = new HashMap<>();
        freq = new HashMap<>();
        minFreq.put(1, new LinkedHashSet<>());
        min = 1;
        cap = capacity;

    }

    public int get(int key) {
        if (values.containsKey(key)) {
            int f = freq.get(key);
            freq.put(key, f + 1);
            minFreq.get(f).remove(key);
            if (f == min && minFreq.get(f).isEmpty()) {
                min++;
            }
            if (!minFreq.containsKey(f + 1)) {
                minFreq.put(f + 1, new LinkedHashSet<>());
            }
            minFreq.get(f + 1).add(key);
            return values.get(key);
        } else {
            return -1;
        }

    }

    public void put(int key, int value) {
        if (values.containsKey(key)) {
            values.put(key, value);
            get(key);
        } else {
            if (values.size() >= cap) {
                int del = minFreq.get(min).iterator().next();
                minFreq.get(min).remove(del);
                values.remove(del);
            }

            minFreq.get(1).add(key);
            freq.put(key, 1);
            values.put(key, value);
            min = 1;
        }
    }

    public static void main(String[] args) {
        LFUCache here = new LFUCache(2);
        here.put(1,1);
        here.put(2,2);
        System.out.println(here.get(1));
        here.put(3,3);
        System.out.println(here.get(2));
        System.out.println(here.get(3));
        here.put(4,4);
        System.out.println(here.get(1));
        System.out.println(here.get(3));
        //System.out.println(here.get(4));

    }
}
