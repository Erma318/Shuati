package linkedinOA;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class q2_1 {

    public static List<Integer> cutSticks(List<Integer> lengths) {
        // Write your code here
        List<Integer> res = new LinkedList<>();
        if (lengths == null || lengths.size() == 0) return res;
        Collections.sort(lengths);
        Queue<Integer> queue = new LinkedList<>();
        for (int i : lengths) {
            queue.offer(i);
        }
        while (!queue.isEmpty()) {
            res.add(queue.size());
            int t = queue.poll();
            int s = queue.size();
            for (int i = 0; i < s; i++) {
                int tt = queue.poll();
                if (tt != t) {
                    queue.offer(tt - t);
                }
            }

        }
        return res;
    }
}
