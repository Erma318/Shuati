import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class yelp01 {
    static class TimeRange{
        int start;
        int end;
        TimeRange(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public float calculate(TimeRange queryTimeRange, List<TimeRange> openHours) {
        float res = 0;
        if(queryTimeRange.start == queryTimeRange.end){
            return 0;
        }
        if(queryTimeRange.start < 0 || queryTimeRange.end > 24){
            return 0;
        }
        for(TimeRange time : openHours){
            float min = Math.max(queryTimeRange.start, time.start);
            float max = Math.min(queryTimeRange.end, time.end);
            if (max - min <= 0) {
                break;
            }
            res += max - min;
        }
        return res / (queryTimeRange.end - queryTimeRange.start);
    }

    public static void main(String[] args) {
        TimeRange query = new TimeRange(7,11);
        List<TimeRange> open = new ArrayList<>(Arrays.asList(new TimeRange(9,17), new TimeRange(18, 24)));
        yelp01 here = new yelp01();
        System.out.println(here.calculate(query, open));
    }

}
