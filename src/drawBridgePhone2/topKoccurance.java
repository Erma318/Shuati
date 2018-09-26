package drawBridgePhone2;

import java.util.*;

public class topKoccurance {
    public char[] findTopK(String in, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] mychar = in.toCharArray();
        for (char c : mychar) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        PriorityQueue<HashMap.Entry<Character, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<HashMap.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b) {
                return a.getValue().compareTo(b.getValue());
            }
        });
        int count = 0;
        for (HashMap.Entry<Character, Integer> entry : map.entrySet()) {
            if (count < k) {
                minHeap.add(entry);
                count++;
            } else {
                if (entry.getValue() > minHeap.peek().getValue()) {
                    minHeap.poll();
                    minHeap.add(entry);
                }
            }
        }
        char[] res = new char[minHeap.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = minHeap.poll().getKey();
        }
        return res;
    }

    public  static void main(String[] args) {
         String input = "tthhhhiiis";
         int k = 2;
         topKoccurance here = new topKoccurance();
         System.out.println(Arrays.toString(here.findTopK(input, k)));
    }

}
