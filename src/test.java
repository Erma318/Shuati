import java.util.*;

public class test {
    static class RecordComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b){
            return a- b;
        }
    }
    public static void main(String[] args) {
        RecordComparator com = new RecordComparator();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(0);
        list.add(-1);
        Collections.sort(list, com);
        System.out.println(list.get(0));
    }
}
