package drawBridgePhone2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class mapIterate {
    public static void main(String[] args) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        map.put(1,1);
//        map.put(2,2);
//        map.put(3,3);
//        map.put(4,4);
//        for (Map.Entry<Integer, Integer> h :  map.entrySet()) {
//            System.out.println(h.getKey() + h.getValue());
//        }
//        Iterator it = map.entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry h = (Map.Entry) it.next();
//            System.out.println(h.getKey());
//
//        }
//
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        Iterator itr = set.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

    }
}
