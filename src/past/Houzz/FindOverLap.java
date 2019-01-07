package past.Houzz;

import java.util.*;

public class FindOverLap {
    static class Interval {
        int start;
        int end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public List<Interval> find(List<Interval> A, List<Interval> B) {
//        Comparator<Interval> com = new Comparator<Interval>() {
//            @Override
//            public int compare(Interval a, Interval b) {
//                return a.start - b.start;
//            }
//        };
//        Collections.sort(A, com);
//        Collections.sort(B, com);
//        int i = 0; int j = 0;
        List<Interval> res = new ArrayList<>();
        int[] start = new int[A.size() + B.size()];
        int[] end = new int[B.size() + A.size()];
        int index = 0;
        for (Interval x : A) {
            start[index] = x.start;
            end[index] = x.end;
            index++;
        }
        for (Interval x : B) {
            start[index] = x.start;
            end[index] = x.end;
            index++;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        for (int i = 0; i < start.length - 1; i++) {
            if (start[i + 1] < end[i]) {
                res.add(new Interval(start[i + 1], end[i]));
            }
        }
        return res;

    }

    public static void main(String[] args) {
        FindOverLap here = new FindOverLap();
        List<Interval> A = new LinkedList<>();
        A.add(new Interval(1, 3));
        A.add(new Interval(8, 10));
        List<Interval> B = new ArrayList<>();
        B.add(new Interval(2, 6));
        B.add(new Interval(9, 15));
        for (Interval x : here.find(A, B)) {
            System.out.print("[" + x.start + ", " + x.end + "], ");
        }
    }

}
