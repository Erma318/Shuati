package syntaxTest;

import java.util.HashMap;
import java.util.Map;

public class MapEntry {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            entry.getKey();
            entry.getValue();
        }
        for (int x : map.values()) {
            System.out.println(x);
        }
        for (String x : map.keySet()) {
            System.out.println(x);
        }
    }
}
