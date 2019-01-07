package syntaxTest;

import java.util.ArrayList;
import java.util.List;

public class ListRemove {
    public static void main(String[] args) {
        // 观察remove时的数据的移动
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(0);
        System.out.println();
    }
}
