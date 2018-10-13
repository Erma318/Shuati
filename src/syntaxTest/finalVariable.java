package syntaxTest;

import java.util.HashMap;
import java.util.HashSet;

public class finalVariable {
    private static final int a = 4;
    private static final HashSet<Integer> set = new HashSet<>();
    private static final HashMap<String, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        set.add(1);
        set.add(2);
        map.put("one", 1);
        System.out.println(map);
    }
}
