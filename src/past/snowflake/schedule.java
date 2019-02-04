import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class schedule {
    public static int schedule(int[] tasks, int n) {
        if (tasks == null || tasks.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        //update a allowable execute time for such task
        //maintain latest exc time of k tasks
        Queue<Integer> q = new LinkedList<>();
        //maintain order of k task. to update the map we need the queue
        // real goal is update map properly
        int executionTime = 0;
        for (int i = 0; i < tasks.length; i++) {
            if (map.containsKey(tasks[i])) {
                executionTime = map.get(tasks[i]) + n +1;
            } else {
                executionTime++;
            }
            // the exec time of curr task
            // which also mean a global curr time for updating the map
            q.offer(tasks[i]);
            while (map.get(q.peek()) != null && map.get(q.peek()) < executionTime - n) {
                int rmv = q.poll();
                map.remove(rmv);
            }
            map.put(tasks[i], executionTime);
        }
        return executionTime;
    }

    public static void main(String[] args) {
        int[] sql = new int[]{1, 2, 1, 1, 3, 4};
        System.out.print(schedule(sql,2));
    }
}
