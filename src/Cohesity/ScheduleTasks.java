package Cohesity;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ScheduleTasks {
    static public int schedule(String[] input, int k) {
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        int scheduleIndex = 0;
        for (String x : input) {
            if (map.containsKey(x)) {
                scheduleIndex = map.get(x) + k + 1;
            } else {
                scheduleIndex++;
            }
            queue.add(x);
            while (map.get(queue.peek()) != null && map.get(queue.peek()) < scheduleIndex  - k) {
                map.remove(queue.poll());
            }
            map.put(x, scheduleIndex);
        }
        return scheduleIndex;
    }

    public static void main(String[] args) {
        String[] sql = {"A","A","B","B","C","C"};
        System.out.print(schedule(sql,2));
    }
}
