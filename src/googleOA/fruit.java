package googleOA;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class fruit {
    public int totalFruit(int[] tree) {
        if (tree == null || tree.length == 0) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>(); // <num, most recent index>
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(); // <most recent index, num>
        int i = 0; // slow pointer
        for (int j = 0; j < tree.length; j++) {
            if (map.containsKey(tree[j])) {
                treeMap.remove(map.get(tree[j]));
            }
            map.put(tree[j], j);
            treeMap.put(j, tree[j]);
            while (map.size() > 2) {
                map.remove(treeMap.firstEntry().getValue());
                i = treeMap.firstKey();
                treeMap.remove(i);
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }



    public static void main(String[] args) {
        int[] tree = {3,3,3,1,2,1,1,2,3,3,4};
        fruit here = new fruit();
        System.out.println(here.totalFruit(tree));
    }

}
