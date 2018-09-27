package drawBridgePhone2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class listAdd {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();

        int[] in = {1,2,3};
        //Collections.sort(in); illegal
        //list.addAll(in); illegal
        System.out.println(list);
    }
}
