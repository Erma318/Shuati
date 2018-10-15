import java.util.*;




public class CodeReview {


     public class Interval {
            int start;
         int end;
            Interval() { start = 0; end = 0; }
         Interval(int s, int e) { start = s; end = e; }
     }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) return intervals;
        Comparator com = new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                if (a.start > b.start)
                    return 1;
                else if (a.start == b.start)
                    return 0;
                else
                    return -1;
            }
        };
        Collections.sort(intervals, com);
        List<Interval> res = new LinkedList<>();
        int prevS = intervals.get(0).start;
        int prevE = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start <= prevE) {
                if (intervals.get(i).end > prevE) {
                    prevE = intervals.get(i).end;
                }
            } else {
                res.add(new Interval(prevS, prevE));
                prevS = intervals.get(i).start;
                prevE = intervals.get(i).end;
            }
        }
        res.add(new Interval(prevS, prevE));
        return res;
    }
}
