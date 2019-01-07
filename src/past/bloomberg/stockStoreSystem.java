package past.bloomberg;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class stockStoreSystem {
    private static HashMap<String, Integer> map = new HashMap<>();
    public static boolean store(String data) {
        String[] d = data.split(", ");
        for (String x : d) {
            String[] xx = x.split(" ");
            map.put(xx[0], Integer.valueOf(xx[1]));
        }
        return true;
    }
    public static String top(int n) {
        System.out.println(map.size());
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(n, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() < o2.getValue()) {
                    return -1;
                } else if (o1.getValue() == o2.getValue()) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        int count= 0;
        for (Map.Entry<String, Integer> m : map.entrySet()) {
            if (count < n) {
                minHeap.add(m);
                count++;
            } else {
                if (m.getValue() > minHeap.peek().getValue()) {
                    minHeap.poll();
                    minHeap.add(m);
                }
            }
        }
        System.out.println(minHeap.size());
        Map.Entry<String, Integer>[] res = new Map.Entry[minHeap.size()];
        int i = minHeap.size() - 1;
        while(!minHeap.isEmpty()) {
            res[i--] = minHeap.poll();
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> t : res) {
            sb.append(t.getKey()).append(" ").append(t.getValue()).append(", ");
        }
        return sb.substring(0, sb.length() - 2);
    }

    public static void main(String[] args) {
        String in = "MCSF 100, BB 200, TSL 300, MCSF 500";
        store(in);
        System.out.println(top(6));
    }
}
