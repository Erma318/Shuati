package Stripe;

import java.util.*;

public class Solution {

    static class RecordComparator implements Comparator<Map<String, Integer>> {
        String key;
        String dir;
        public RecordComparator(String key, String dir){
            this.key = key;
            this.dir = dir;
        }
        @Override
        public int compare(Map<String, Integer> left, Map<String, Integer> right){
            int l = left.getOrDefault(key, 0);
            int r = right.getOrDefault(key, 0);
            if (dir == "asc") {
                return l - r;
            } else {
                return r - l;
            }
        }
    }

    static class MultiComparator implements Comparator<Map<String, Integer>> {
        LinkedHashMap<String, String> sortedOrder;
        public MultiComparator(LinkedHashMap<String, String> sortedOrder){
            this.sortedOrder = sortedOrder;
        }
        @Override
        public int compare(Map<String, Integer> left, Map<String, Integer> right){
            for (Map.Entry<String,String> entry : sortedOrder.entrySet()) {
                int l = left.getOrDefault(entry.getKey(), 0);
                int r = right.getOrDefault(entry.getKey(), 0);
                if (l == r) {
                    continue;
                } else {
                    if (entry.getValue() == "asc") {
                        return l - r;
                    } else {
                        return r - l;
                    }
                }
            }
            return 0;
        }
    }
    public static void main(String[] args) {
        //testMinByKey();
        testFirstByKey();
    }
    public static Map<String, Integer> sortFirstByOrder(LinkedHashMap<String, String> sortedOrder, List<Map<String, Integer>> records){
        if (records == null || records.size() == 0) {
            return null;
        }
        List<Map<String, Integer>> records_copy = new ArrayList<>();
        for (Map<String, Integer> m: records) {
            Map<String, Integer> temp = new HashMap<>();
            temp.putAll(m);
            records_copy.add(temp);
        }
        // need to do the deep copy
        // putAll对于基本数据类型可以深度复制
        MultiComparator com = new MultiComparator(sortedOrder);
        Collections.sort(records_copy, com);
        return records_copy.get(0);

    }

    public static Map<String, Integer> firstByKey(String key, String direction, List<Map<String, Integer>> records) {
        if (records == null || records.size() == 0) {
            return null;
        }
        LinkedHashMap<String, String> sortedOrder = new LinkedHashMap<>();
        sortedOrder.put(key, direction);
        return sortFirstByOrder(sortedOrder, records);
    }

//    public static Map<String, Integer> firstByKey(String key, String direction, List<Map<String, Integer>> records) {
//        if (records == null || records.size() == 0) {
//            return null;
//        }
//        List<Map<String, Integer>> records_copy = records;
//        // need to do the deep copy
//        RecordComparator com = new RecordComparator(key, direction);
//        Collections.sort(records_copy, com);
//        return records_copy.get(0);
//    }

//    public static Map<String, Integer> firstByKey(String key, String direction, List<Map<String, Integer>> records) {
//        if (records == null || records.size() == 0) {
//            return null;
//        }
//        if (direction == "asc") {
//            int min_index = -1;
//            int min = Integer.MAX_VALUE;
//            for (int i = 0; i < records.size(); i++) {
//                int cur = records.get(i).getOrDefault(key, 0);
//                if (cur < min) {
//                    min_index = i;
//                    min = cur;
//                }
//            }
//            return records.get(min_index);
//        } else {
//            int max_index = -1;
//            int max = Integer.MIN_VALUE;
//            for (int i = 0; i < records.size(); i++) {
//                int cur = records.get(i).getOrDefault(key, 0);
//                if (cur > max) {
//                    max_index = i;
//                    max = cur;
//                }
//            }
//            return records.get(max_index);
//        }
//    }
    public static Map<String, Integer> minByKey(String key, List<Map<String, Integer>> records) {
        return firstByKey(key, "asc", records);
    }

//    public static Map<String, Integer> minByKey(String key, List<Map<String, Integer>> records) {
//        if (records == null || records.size() == 0) {
//            return null;
//        }
//        int min_index = -1;
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < records.size(); i++) {
//            int cur = records.get(i).getOrDefault(key, 0);
//            if (cur < min) {
//                min_index = i;
//                min = cur;
//            }
//        }
//        return records.get(min_index);
//    }

    public static <T> void assertEqual(T expected, T actual) {
        if (expected == null && actual == null || actual != null && actual.equals(expected)) {
            System.out.println("PASSED");
        } else {
            throw new AssertionError("Expected:\n  " + expected + "\nActual:\n  " + actual + "\n");
        }
    }

    public static void testFirstByKey() {
        List<Map<String, Integer>> example1 = Arrays.asList(Maps.of("a", 1));
        List<Map<String, Integer>> example2 = Arrays.asList(
                Maps.of("b", 1),
                Maps.of("b", -2),
                Maps.of("a", 10)
        );
        List<Map<String, Integer>> example3 = Arrays.asList(
                Maps.of(),
                Maps.of("a", 10, "b", -10),
                Maps.of(),
                Maps.of("a", 3, "c", 3)
        );

        System.out.println("firstByKey");
        assertEqual(example1.get(0), firstByKey("a", "asc", example1));
        assertEqual(example2.get(0), firstByKey("a", "asc", example2));  // example2.get(1) ok too
        assertEqual(example2.get(2), firstByKey("a", "desc", example2));
        assertEqual(example2.get(1), firstByKey("b", "asc", example2));
        assertEqual(example2.get(0), firstByKey("b", "desc", example2));
        assertEqual(example3.get(1), firstByKey("a", "desc", example3));
    }

    public static void testMinByKey() {
        List<Map<String, Integer>> example1 = Arrays.asList(
                Maps.of("a", 1, "b", 2),
                Maps.of("a", 2)
        );
        List<Map<String, Integer>> example2 = Arrays.asList(example1.get(1), example1.get(0));
        List<Map<String, Integer>> example3 = Arrays.asList(Maps.of());
        List<Map<String, Integer>> example4 = Arrays.asList(
                Maps.of("a", -1),
                Maps.of("b", -1)
        );

        System.out.println("minByKey");
        assertEqual(example1.get(0), minByKey("a", example1));
        assertEqual(example2.get(1), minByKey("a", example2));
        assertEqual(example1.get(1), minByKey("b", example1));
        assertEqual(example3.get(0), minByKey("a", example3));
        assertEqual(example4.get(1), minByKey("b", example4));
    }
}

class Maps {
    public static <K, V> Map<K, V> of() {
        return new HashMap<K, V>();
    }

    public static <K, V> Map<K, V> of(K k1, V v1) {
        Map<K, V> map = new HashMap<K, V>();
        map.put(k1, v1);
        return map;
    }

    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2) {
        Map<K, V> map = new HashMap<K, V>();
        map.put(k1, v1);
        map.put(k2, v2);
        return map;
    }

    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3) {
        Map<K, V> map = new HashMap<K, V>();
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        return map;
    }

    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
        Map<K, V> map = new HashMap<K, V>();
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        return map;
    }

    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        Map<K, V> map = new HashMap<K, V>();
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        return map;
    }

    public static <K, V> LinkedHashMap<K, V> ordered(K k1, V v1) {
        LinkedHashMap<K, V> map = new LinkedHashMap<K, V>();
        map.put(k1, v1);
        return map;
    }

    public static <K, V> LinkedHashMap<K, V> ordered(K k1, V v1, K k2, V v2) {
        LinkedHashMap<K, V> map = new LinkedHashMap<K, V>();
        map.put(k1, v1);
        map.put(k2, v2);
        return map;
    }

    public static <K, V> LinkedHashMap<K, V> ordered(K k1, V v1, K k2, V v2, K k3, V v3) {
        LinkedHashMap<K, V> map = new LinkedHashMap<K, V>();
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        return map;
    }
}