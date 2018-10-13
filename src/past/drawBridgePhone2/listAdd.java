package past.drawBridgePhone2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class listAdd {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        List<Integer> temp = new LinkedList<>();
        temp.add(1);
        temp.add(2);
        temp.add(3);
        list = new ArrayList<>(temp);
        temp.remove(0);

        //Collections.sort(in); illegal
        //list.addAll(in); illegal
        System.out.println(list);
    }
}
