package syntaxTest;

import java.util.LinkedList;
import java.util.List;

public class useListtoCreateList {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        List<Integer> list2 = new LinkedList<>(list);
        list.remove(list.size() - 1);
        System.out.println(list2);
    }
}
