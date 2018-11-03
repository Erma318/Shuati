package syntaxTest;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class iterator {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1); list.add(2);list.add(3);
        Iterator<Integer> it = list.iterator();
        Integer i = it.next();
        it.remove();
        System.out.println(list);

    }
}
